package jit.txy.newbeemall.dao;

import jit.txy.newbeemall.entity.AdminUserToken;

/**
 * @author 唐星宇
 * @date 2022/9/15
 **/
public interface NewBeeAdminUserTokenMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(AdminUserToken record);

    int insertSelective(AdminUserToken record);

    AdminUserToken selectByPrimaryKey(Long userId);

    AdminUserToken selectByToken(String token);

    int updateByPrimaryKeySelective(AdminUserToken record);

    int updateByPrimaryKey(AdminUserToken record);
}