package jit.txy.newbeemall.dao;

import jit.txy.newbeemall.entity.Carousel;
import jit.txy.newbeemall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
public interface CarouselMapper {
    int deleteByPrimaryKey(Integer carouselId);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectByPrimaryKey(Integer carouselId);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);

    List<Carousel> findCarouselList(PageQueryUtil pageUtil);

    int getTotalCarousels(PageQueryUtil pageUtil);

    int deleteBatch(Long[] ids);

    List<Carousel> findCarouselsByNum(@Param("number") int number);
}
