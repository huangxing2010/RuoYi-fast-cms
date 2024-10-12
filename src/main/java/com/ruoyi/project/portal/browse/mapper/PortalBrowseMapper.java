package com.ruoyi.project.portal.browse.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.portal.browse.domain.PortalBrowse;

/**
 * 访问统计Mapper接口
 * 
 * @author huangxing
 * @date 2024-10-11
 */
public interface PortalBrowseMapper 
{
    /**
     * 查询访问统计
     * 
     * @param browseId 访问统计主键
     * @return 访问统计
     */
    public PortalBrowse selectPortalBrowseByBrowseId(Long browseId);

    /**
     * 查询访问统计列表
     * 
     * @param portalBrowse 访问统计
     * @return 访问统计集合
     */
    public List<PortalBrowse> selectPortalBrowseList(PortalBrowse portalBrowse);

    public List<PortalBrowse> selectPortalBrowseByParam(Map paramMap);

    /**
     * 新增访问统计
     * 
     * @param portalBrowse 访问统计
     * @return 结果
     */
    public int insertPortalBrowse(PortalBrowse portalBrowse);

    /**
     * 修改访问统计
     * 
     * @param portalBrowse 访问统计
     * @return 结果
     */
    public int updatePortalBrowse(PortalBrowse portalBrowse);

    /**
     * 删除访问统计
     * 
     * @param browseId 访问统计主键
     * @return 结果
     */
    public int deletePortalBrowseByBrowseId(Long browseId);

    /**
     * 批量删除访问统计
     * 
     * @param browseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalBrowseByBrowseIds(String[] browseIds);
}
