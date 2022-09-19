package jit.txy.newbeemall.dao;

import jit.txy.newbeemall.entity.NewBeeMallOrder;
import jit.txy.newbeemall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XiaNingIf
 * @date 2022/9/19
 */
public interface NewBeeMallOrderMapper {
    NewBeeMallOrder selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(NewBeeMallOrder record);

    List<NewBeeMallOrder> findNewBeeMallOrderList(PageQueryUtil pageUtil);

    int getTotalNewBeeMallOrders(PageQueryUtil pageUtil);

    List<NewBeeMallOrder> selectByPrimaryKeys(@Param("orderIds") List<Long> orderIds);

    int checkOut(@Param("orderIds") List<Long> orderIds);

    int closeOrder(@Param("orderIds") List<Long> orderIds, @Param("orderStatus") int orderStatus);

    int checkDone(@Param("orderIds") List<Long> asList);
}
