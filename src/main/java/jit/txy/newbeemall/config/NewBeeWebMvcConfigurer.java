package jit.txy.newbeemall.config;

import jit.txy.newbeemall.config.handler.TokenToAdminUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
@Configuration
public class NewBeeWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    private TokenToAdminUserMethodArgumentResolver tokenToAdminUserMethodArgumentResolver;

    /**
     * @param argumentResolvers
     * @tip @TokenToAdminUser 注解处理方法
     */
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(tokenToAdminUserMethodArgumentResolver);
    }

}
