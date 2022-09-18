package jit.txy.newbeemall.admin;

import io.swagger.annotations.Api;
import jit.txy.newbeemall.admin.param.GoodsAddParam;
import jit.txy.newbeemall.common.ServiceResultEnum;
import jit.txy.newbeemall.config.annotation.TokenToAdminUser;
import jit.txy.newbeemall.entity.AdminUserToken;
import jit.txy.newbeemall.entity.NewBeeMallGoods;
import jit.txy.newbeemall.service.NewBeeMallGoodsService;
import jit.txy.newbeemall.util.BeanUtil;
import jit.txy.newbeemall.util.Result;
import jit.txy.newbeemall.util.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 唐星宇
 * @date 2022/9/18
 **/
@RestController
@Api(value = "v1", tags = "后台管理系统商品管理模块接口")
@RequestMapping("/manage-api/v1")
public class NewBeeAdminGoodsInfoAPI {

    private static final Logger logger = LoggerFactory.getLogger(NewBeeAdminGoodsCategoryAPI.class);

    @Resource
    NewBeeMallGoodsService newBeeMallGoodsService;

    /**
     * 添加
     */
    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    public Result save(@RequestBody @Valid GoodsAddParam goodsAddParam, @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        NewBeeMallGoods newBeeMallGoods = new NewBeeMallGoods();
        BeanUtil.copyProperties(goodsAddParam, newBeeMallGoods);
        String result = newBeeMallGoodsService.saveNewBeeMallGoods(newBeeMallGoods);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }
}
