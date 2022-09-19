package jit.txy.newbeemall.dao;

import jit.txy.newbeemall.entity.NewBeeMallOrderItem;

import java.util.List;

/**
 * @author XiaNingIf
 * @date 2022/9/19
 */
public interface NewBeeMallOrderItemMapper {
    /**
     * 根据订单id获取订单项列表
     *
     * @param orderId
     * @return
     */
    List<NewBeeMallOrderItem> selectByOrderId(Long orderId);
}

