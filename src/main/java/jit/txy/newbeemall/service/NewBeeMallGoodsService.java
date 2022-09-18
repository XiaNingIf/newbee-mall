package jit.txy.newbeemall.service;

import jit.txy.newbeemall.entity.NewBeeMallGoods;

/**
 * @author 唐星宇
 * @date 2022/9/18
 **/
public interface NewBeeMallGoodsService {

    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    String saveNewBeeMallGoods(NewBeeMallGoods goods);
}