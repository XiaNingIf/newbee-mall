package jit.txy.newbeemall.dao;

import jit.txy.newbeemall.entity.NewBeeMallGoods;

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
}