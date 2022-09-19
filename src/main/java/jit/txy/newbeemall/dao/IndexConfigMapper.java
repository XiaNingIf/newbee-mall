package jit.txy.newbeemall.dao;

import jit.txy.newbeemall.entity.IndexConfig;
import jit.txy.newbeemall.util.PageQueryUtil;

import java.util.List;

/**
 * @author XiaNingIf
 * @date 2022/9/19
 */
public interface IndexConfigMapper {

    /**
     * 删除一条记录
     * @param configId
     * @return
     */
    int deleteByPrimaryKey(Long configId);

    /**
     * 保存一条新记录
     * @param record
     * @return
     */
    int insert(IndexConfig record);

    /**
     * 保存一条新记录
     * @param record
     * @return
     */
    int insertSelective(IndexConfig record);

    /**
     * 根据主键查询记录
     * @param configId
     * @return
     */
    IndexConfig selectByPrimaryKey(Long configId);

    /**
     * 修改记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(IndexConfig record);

    /**
     * 修改记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(IndexConfig record);

    /**
     * 查询分页数据
     * @param pageUtil
     * @return
     */
    List<IndexConfig> findIndexConfigList(PageQueryUtil pageUtil);

    /**
     * 查询总数
     * @param pageUtil
     * @return
     */
    int getTotalIndexConfigs(PageQueryUtil pageUtil);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteBatch(Long[] ids);
}
