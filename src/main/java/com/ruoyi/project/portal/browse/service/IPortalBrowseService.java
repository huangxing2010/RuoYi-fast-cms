package com.ruoyi.project.portal.browse.service;

import java.util.List;
import com.ruoyi.project.portal.browse.domain.PortalBrowse;

/**
 * 访问统计Service接口
 * 
 * @author huangxing
 * @date 2024-10-11
 */
public interface IPortalBrowseService 
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
     * 批量删除访问统计
     * 
     * @param browseIds 需要删除的访问统计主键集合
     * @return 结果
     */
    public int deletePortalBrowseByBrowseIds(String browseIds);

    /**
     * 删除访问统计信息
     * 
     * @param browseId 访问统计主键
     * @return 结果
     */
    public int deletePortalBrowseByBrowseId(Long browseId);
}
