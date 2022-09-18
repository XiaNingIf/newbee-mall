package jit.txy.newbeemall.service.impl;

import jit.txy.newbeemall.common.ServiceResultEnum;
import jit.txy.newbeemall.dao.NewBeeMallGoodsMapper;
import jit.txy.newbeemall.entity.NewBeeMallGoods;
import jit.txy.newbeemall.service.NewBeeMallGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 唐星宇
 * @date 2022/9/18
 **/
@Service
public class NewBeeMallGoodsServiceImpl implements NewBeeMallGoodsService {

    @Autowired
    private NewBeeMallGoodsMapper goodsMapper;

    @Override
    public String saveNewBeeMallGoods(NewBeeMallGoods goods) {
        if (goodsMapper.insertSelective(goods) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }
}
