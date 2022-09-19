package jit.txy.newbeemall.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import jit.txy.newbeemall.admin.param.BatchIdParam;
import jit.txy.newbeemall.admin.param.IndexConfigAddParam;
import jit.txy.newbeemall.admin.param.IndexConfigEditParam;
import jit.txy.newbeemall.common.IndexConfigTypeEnum;
import jit.txy.newbeemall.common.ServiceResultEnum;
import jit.txy.newbeemall.config.annotation.TokenToAdminUser;
import jit.txy.newbeemall.entity.AdminUserToken;
import jit.txy.newbeemall.entity.IndexConfig;
import jit.txy.newbeemall.service.NewBeeMallIndexConfigService;
import jit.txy.newbeemall.util.BeanUtil;
import jit.txy.newbeemall.util.PageQueryUtil;
import jit.txy.newbeemall.util.Result;
import jit.txy.newbeemall.util.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaNingIf
 * @date 2022/9/19
 */
@RestController
@Api(value = "v1", tags = "后台管理系统首页配置模块接口")
@RequestMapping("/manage-api/v1")
public class NewBeeAdminIndexConfigAPI {

    private static final Logger logger = LoggerFactory.getLogger(NewBeeAdminIndexConfigAPI.class);

    @Resource
    private NewBeeMallIndexConfigService newBeeMallIndexConfigService;

    /**
     * 列表
     */
    @RequestMapping(value = "/indexConfigs", method = RequestMethod.GET)
    public Result list(@RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber,
                       @RequestParam(required = false) @ApiParam(value = "每页条数") Integer pageSize,
                       @RequestParam(required = false) @ApiParam(value = "1-搜索框热搜 2-搜索下拉框热搜 3-(首页)热销商品 4-(首页)新品上线 5-(首页)为你推荐") Integer configType,
                       @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        if (pageNumber == null || pageNumber < 1 || pageSize == null || pageSize < 10) {
            return ResultGenerator.genFailResult("分页参数异常！");
        }
        IndexConfigTypeEnum indexConfigTypeEnum = IndexConfigTypeEnum.getIndexConfigTypeEnumByType(configType);
        if (indexConfigTypeEnum.equals(IndexConfigTypeEnum.DEFAULT)) {
            return ResultGenerator.genFailResult("非法参数！");
        }
        Map params = new HashMap(8);
        params.put("page", pageNumber);
        params.put("limit", pageSize);
        params.put("configType", configType);
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(newBeeMallIndexConfigService.getConfigsPage(pageUtil));
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/indexConfigs", method = RequestMethod.POST)
    public Result save(@RequestBody @Valid IndexConfigAddParam indexConfigAddParam, @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        IndexConfig indexConfig = new IndexConfig();
        BeanUtil.copyProperties(indexConfigAddParam, indexConfig);
        String result = newBeeMallIndexConfigService.saveIndexConfig(indexConfig);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }


    /**
     * 修改
     */
    @RequestMapping(value = "/indexConfigs", method = RequestMethod.PUT)
    public Result update(@RequestBody @Valid IndexConfigEditParam indexConfigEditParam, @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        IndexConfig indexConfig = new IndexConfig();
        BeanUtil.copyProperties(indexConfigEditParam, indexConfig);
        String result = newBeeMallIndexConfigService.updateIndexConfig(indexConfig);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/indexConfigs/{id}", method = RequestMethod.GET)
    public Result info(@PathVariable("id") Long id, @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        IndexConfig config = newBeeMallIndexConfigService.getIndexConfigById(id);
        if (config == null) {
            return ResultGenerator.genFailResult("未查询到数据");
        }
        return ResultGenerator.genSuccessResult(config);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/indexConfigs", method = RequestMethod.DELETE)
    public Result delete(@RequestBody BatchIdParam batchIdParam, @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        if (batchIdParam == null || batchIdParam.getIds().length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (newBeeMallIndexConfigService.deleteBatch(batchIdParam.getIds())) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

}