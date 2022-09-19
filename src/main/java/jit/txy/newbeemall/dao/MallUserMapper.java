package jit.txy.newbeemall.dao;

import jit.txy.newbeemall.entity.MallUser;
import jit.txy.newbeemall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XiaNingIf
 * @date 2022/9/19
 */
public interface MallUserMapper {
    List<MallUser> findMallUserList(PageQueryUtil pageUtil);

    int getTotalMallUsers(PageQueryUtil pageUtil);

    int lockUserBatch(@Param("ids") Long[] ids, @Param("lockStatus") int lockStatus);
}
