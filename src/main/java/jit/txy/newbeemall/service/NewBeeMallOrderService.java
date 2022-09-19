package jit.txy.newbeemall.service;

import jit.txy.newbeemall.admin.vo.NewBeeMallOrderDetailVO;
import jit.txy.newbeemall.util.PageQueryUtil;
import jit.txy.newbeemall.util.PageResult;

/**
 * @author XiaNingIf
 * @date 2022/9/19
 */
public interface NewBeeMallOrderService {

    /**
     * 获取订单详情
     *
     * @param orderId
     * @return
     */
    NewBeeMallOrderDetailVO getOrderDetailByOrderId(Long orderId);

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getNewBeeMallOrdersPage(PageQueryUtil pageUtil);

    /**
     * 配货
     *
     * @param ids
     * @return
     */
    String checkDone(Long[] ids);

    /**
     * 出库
     *
     * @param ids
     * @return
     */
    String checkOut(Long[] ids);

    /**
     * 关闭订单
     *
     * @param ids
     * @return
     */
    String closeOrder(Long[] ids);
}
