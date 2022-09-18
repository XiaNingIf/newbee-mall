package jit.txy.newbeemall.service;

import jit.txy.newbeemall.common.GoodsCategory;
import jit.txy.newbeemall.util.PageQueryUtil;
import jit.txy.newbeemall.util.PageResult;

import java.util.List;

/**
 * @author 唐星宇
 * @date 2022/9/18
 **/
public interface NewBeeMallCategoryService {
    String saveCategory(GoodsCategory goodsCategory);

    String updateGoodsCategory(GoodsCategory goodsCategory);

    GoodsCategory getGoodsCategoryById(Long id);

    Boolean deleteBatch(Long[] ids);

    PageResult getCategorisPage(PageQueryUtil pageUtil);

    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, int categoryLevel);
}
