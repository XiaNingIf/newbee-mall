package jit.txy.newbeemall.dao;

import jit.txy.newbeemall.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author 唐星宇
 * @date 2022/9/15
 **/
public interface AdminUserMapper {
    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    /**
     * 登陆方法
     *
     * @param userName
     * @param password
     * @return
     */
    AdminUser login(@Param("userName") String userName, @Param("password") String password);

    AdminUser selectByPrimaryKey(Long adminUserId);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}