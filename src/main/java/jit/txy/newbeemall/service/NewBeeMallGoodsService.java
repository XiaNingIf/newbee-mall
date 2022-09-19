package jit.txy.newbeemall.service;

import jit.txy.newbeemall.entity.NewBeeMallGoods;
import jit.txy.newbeemall.util.PageQueryUtil;
import jit.txy.newbeemall.util.PageResult;

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

    /**
     * 修改商品信息
     *
     * @param goods
     * @return
     */
    String updateNewBeeMallGoods(NewBeeMallGoods goods);

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    NewBeeMallGoods getNewBeeMallGoodsById(Long id);

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getNewBeeMallGoodsPage(PageQueryUtil pageUtil);

    /**
     * 批量修改销售状态(上架下架)
     *
     * @param ids
     * @return
     */
    Boolean batchUpdateSellStatus(Long[] ids,int sellStatus);
}