package jit.txy.newbeemall.config.handler;

import jit.txy.newbeemall.common.Constants;
import jit.txy.newbeemall.common.NewBeeMallException;
import jit.txy.newbeemall.common.ServiceResultEnum;
import jit.txy.newbeemall.config.annotation.TokenToAdminUser;
import jit.txy.newbeemall.dao.NewBeeAdminUserTokenMapper;
import jit.txy.newbeemall.entity.AdminUserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
@Component
public class TokenToAdminUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private NewBeeAdminUserTokenMapper newBeeAdminUserTokenMapper;

    public TokenToAdminUserMethodArgumentResolver() {
    }

    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(TokenToAdminUser.class)) {
            return true;
        }
        return false;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        if (parameter.getParameterAnnotation(TokenToAdminUser.class) instanceof TokenToAdminUser) {
            String token = webRequest.getHeader("token");
            if (null != token && !"".equals(token) && token.length() == Constants.TOKEN_LENGTH) {
                AdminUserToken adminUserToken = newBeeAdminUserTokenMapper.selectByToken(token);
                if (adminUserToken == null) {
                    NewBeeMallException.fail(ServiceResultEnum.ADMIN_NOT_LOGIN_ERROR.getResult());
                } else if (adminUserToken.getExpireTime().getTime() <= System.currentTimeMillis()) {
                    NewBeeMallException.fail(ServiceResultEnum.ADMIN_TOKEN_EXPIRE_ERROR.getResult());
                }
                return adminUserToken;
            } else {
                NewBeeMallException.fail(ServiceResultEnum.ADMIN_NOT_LOGIN_ERROR.getResult());
            }
        }
        return null;
    }

}