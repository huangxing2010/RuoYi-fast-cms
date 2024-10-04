package com.ruoyi.project.portal.links.mapper;

import com.ruoyi.project.portal.links.domain.PortalLinks;

import java.util.List;

/**
 * 友情链接Mapper接口
 * 
 * @author huangxing
 * @date 2024-04-07
 */
public interface PortalLinksMapper 
{
    /**
     * 查询友情链接
     * 
     * @param linksId 友情链接主键
     * @return 友情链接
     */
    public PortalLinks selectPortalLinksByLinksId(Long linksId);

    /**
     * 查询友情链接列表
     * 
     * @param portalLinks 友情链接
     * @return 友情链接集合
     */
    public List<PortalLinks> selectPortalLinksList(PortalLinks portalLinks);

    /**
     * 新增友情链接
     * 
     * @param portalLinks 友情链接
     * @return 结果
     */
    public int insertPortalLinks(PortalLinks portalLinks);

    /**
     * 修改友情链接
     * 
     * @param portalLinks 友情链接
     * @return 结果
     */
    public int updatePortalLinks(PortalLinks portalLinks);

    /**
     * 删除友情链接
     * 
     * @param linksId 友情链接主键
     * @return 结果
     */
    public int deletePortalLinksByLinksId(Long linksId);

    /**
     * 批量删除友情链接
     * 
     * @param linksIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalLinksByLinksIds(String[] linksIds);
}
