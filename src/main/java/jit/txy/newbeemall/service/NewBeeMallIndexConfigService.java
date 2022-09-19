package jit.txy.newbeemall.service;

import jit.txy.newbeemall.entity.IndexConfig;
import jit.txy.newbeemall.util.PageQueryUtil;
import jit.txy.newbeemall.util.PageResult;

/**
 * @author XiaNingIf
 * @date 2022/9/19
 */
public interface NewBeeMallIndexConfigService {

    /**
     * 查询后台管理系统首页配置分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getConfigsPage(PageQueryUtil pageUtil);

    /**
     * 新增一条首页配置记录
     *
     * @param indexConfig
     * @return
     */
    String saveIndexConfig(IndexConfig indexConfig);

    /**
     * 修改一条首页配置记录
     *
     * @param indexConfig
     * @return
     */
    String updateIndexConfig(IndexConfig indexConfig);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    Boolean deleteBatch(Long[] ids);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    IndexConfig getIndexConfigById(Long id);
}