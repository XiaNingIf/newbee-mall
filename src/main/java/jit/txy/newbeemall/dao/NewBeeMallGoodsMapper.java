package jit.txy.newbeemall.dao;

import jit.txy.newbeemall.entity.NewBeeMallGoods;
import jit.txy.newbeemall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 唐星宇
 * @date 2022/9/18
 **/
public interface NewBeeMallGoodsMapper {

    /**
     * 保存一条新记录
     * @param record
     * @return
     */
    int insertSelective(NewBeeMallGoods record);

    /**
     * 根据主键id获取记录
     * @param goodsId
     * @return
     */
    NewBeeMallGoods selectByPrimaryKey(Long goodsId);

    /**
     * 修改一条记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(NewBeeMallGoods record);

    /**
     * 查询分页数据
     * @param pageUtil
     * @return
     */
    List<NewBeeMallGoods> findNewBeeMallGoodsList(PageQueryUtil pageUtil);

    /**
     * 查询总数
     * @param pageUtil
     * @return
     */
    int getTotalNewBeeMallGoods(PageQueryUtil pageUtil);

    /**
     * 批量修改记录
     * @param goodsIds
     * @param sellStatus
     * @return
     */
    int batchUpdateSellStatus(@Param("goodsIds")Long[] goodsIds, @Param("sellStatus") int sellStatus);

}