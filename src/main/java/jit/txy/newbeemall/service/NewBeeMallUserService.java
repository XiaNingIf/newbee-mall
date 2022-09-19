package jit.txy.newbeemall.service;

import jit.txy.newbeemall.util.PageQueryUtil;
import jit.txy.newbeemall.util.PageResult;

/**
 * @author XiaNingIf
 * @date 2022/9/19
 */
public interface NewBeeMallUserService {
    /**
     * 用户禁用与解除禁用(0-未锁定 1-已锁定)
     *
     * @param ids
     * @param lockStatus
     * @return
     */
    Boolean lockUsers(Long[] ids, int lockStatus);

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getNewBeeMallUsersPage(PageQueryUtil pageUtil);
}
