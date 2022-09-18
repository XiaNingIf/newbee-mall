package jit.txy.newbeemall.service;

import jit.txy.newbeemall.entity.Carousel;
import jit.txy.newbeemall.util.PageQueryUtil;
import jit.txy.newbeemall.util.PageResult;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
public interface NewBeeMallCarouselService {
    PageResult getCarouselPage(PageQueryUtil pageUtil);

    String saveCarousel(Carousel carousel);

    String updateCarousel(Carousel carousel);

    Carousel getCarouselById(Integer id);

    Boolean deleteBatch(Long[] ids);
}
