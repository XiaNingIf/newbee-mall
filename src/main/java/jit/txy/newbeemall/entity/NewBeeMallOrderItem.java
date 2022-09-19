package jit.txy.newbeemall.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author XiaNingIf
 * @date 2022/9/19
 */
@Data
public class NewBeeMallOrderItem {
    private Long orderItemId;

    private Long orderId;

    private Long goodsId;

    private String goodsName;

    private String goodsCoverImg;

    private Integer sellingPrice;

    private Integer goodsCount;

    private Date createTime;
}