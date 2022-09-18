package jit.txy.newbeemall.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
@Data
public class CarouselEditParam {

    @ApiModelProperty("待修改轮播图id")
    @NotNull(message = "轮播图id不能为空")
    @Min(1)
    private Integer carouselId;

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
