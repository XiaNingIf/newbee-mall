package jit.txy.newbeemall.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
@Data
public class CarouselAddParam {

    @ApiModelProperty("轮播图URL地址")
    @NotEmpty(message = "轮播图URL不能为空")
    private String carouselUrl;

    @ApiModelProperty("轮播图跳转地址")
    @NotEmpty(message = "轮播图跳转地址不能为空")
    private String redirectUrl;

    @ApiModelProperty("轮播图跳转地址")
    @Min(1)
    @Max(200)
    private Integer carouselRank;
}