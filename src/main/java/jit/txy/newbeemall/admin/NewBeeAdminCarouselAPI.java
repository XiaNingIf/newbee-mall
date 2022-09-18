package jit.txy.newbeemall.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import jit.txy.newbeemall.admin.param.BatchIdParam;
import jit.txy.newbeemall.admin.param.CarouselAddParam;
import jit.txy.newbeemall.admin.param.CarouselEditParam;
import jit.txy.newbeemall.common.ServiceResultEnum;
import jit.txy.newbeemall.config.annotation.TokenToAdminUser;
import jit.txy.newbeemall.entity.AdminUserToken;
import jit.txy.newbeemall.entity.Carousel;
import jit.txy.newbeemall.service.NewBeeMallCarouselService;
import jit.txy.newbeemall.util.BeanUtil;
import jit.txy.newbeemall.util.PageQueryUtil;
import jit.txy.newbeemall.util.Result;
import jit.txy.newbeemall.util.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
@RestController
@Api(value = "v1", tags = "后台管理系统轮播图模块接口")
@RequestMapping("/manage-api/v1")
public class NewBeeAdminCarouselAPI {

    private static final Logger logger = LoggerFactory.getLogger(NewBeeAdminCarouselAPI.class);

    @Resource
    NewBeeMallCarouselService newBeeMallCarouselService;

    @RequestMapping(value = "/carousels",method = RequestMethod.GET)
    public Result list(@RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber,
                           @RequestParam(required = false) @ApiParam(value = "每页条数") Integer pageSize,
                           @TokenToAdminUser AdminUserToken adminUser){
        logger.info("adminUser:{}", adminUser.toString());
        if (pageNumber == null || pageNumber < 1 || pageSize == null || pageSize < 10) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Map params = new HashMap(4);
        params.put("page", pageNumber);
        params.put("limit", pageSize);
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(newBeeMallCarouselService.getCarouselPage(pageUtil));
    }

    @RequestMapping(value = "/carousels", method = RequestMethod.POST)
    public Result save(@RequestBody @Valid CarouselAddParam carouselAddParam, @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        if (StringUtils.isEmpty(carouselAddParam.getCarouselUrl())
                || Objects.isNull(carouselAddParam.getCarouselRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Carousel carousel = new Carousel();
        BeanUtil.copyProperties(carouselAddParam, carousel);
        String result = newBeeMallCarouselService.saveCarousel(carousel);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    @RequestMapping(value = "/carousels", method = RequestMethod.PUT)
    public Result update(@RequestBody CarouselEditParam carouselEditParam, @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        if (Objects.isNull(carouselEditParam.getCarouselId())
                || StringUtils.isEmpty(carouselEditParam.getCarouselUrl())
                || Objects.isNull(carouselEditParam.getCarouselRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Carousel carousel = new Carousel();
        BeanUtil.copyProperties(carouselEditParam, carousel);
        String result = newBeeMallCarouselService.updateCarousel(carousel);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    @RequestMapping(value = "/carousels/{id}", method = RequestMethod.GET)
    public Result info(@PathVariable("id") Integer id, @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        Carousel carousel = newBeeMallCarouselService.getCarouselById(id);
        if (carousel == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return ResultGenerator.genSuccessResult(carousel);
    }

    @RequestMapping(value = "/carousels", method = RequestMethod.DELETE)
    public Result delete(@RequestBody BatchIdParam batchIdParam, @TokenToAdminUser AdminUserToken adminUser) {
        logger.info("adminUser:{}", adminUser.toString());
        if (batchIdParam == null || batchIdParam.getIds().length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (newBeeMallCarouselService.deleteBatch(batchIdParam.getIds())) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }
}
