package com.ruoyi.project.portal.navbar.service;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.portal.navbar.domain.PortalNavbar;

import java.util.List;

/**
 * 导航管理Service接口
 * 
 * @author huangxing
 * @date 2024-05-18
 */
public interface IPortalNavbarService 
{
    /**
     * 查询导航管理
     * 
     * @param navId 导航管理主键
     * @return 导航管理
     */
    public PortalNavbar selectPortalNavbarByNavId(Long navId);

    /**
     * 根据分类ID查询导航信息
     * @param categoryId
     * @return
     */
    public PortalNavbar selectPortalNavbarByCategoryId(Long categoryId);

    /**
     * 查询导航管理列表
     * 
     * @param portalNavbar 导航管理
     * @return 导航管理集合
     */
    public List<PortalNavbar> selectPortalNavbarList(PortalNavbar portalNavbar);

    /**
     * 新增导航管理
     * 
     * @param portalNavbar 导航管理
     * @return 结果
     */
    public int insertPortalNavbar(PortalNavbar portalNavbar);

    /**
     * 修改导航管理
     * 
     * @param portalNavbar 导航管理
     * @return 结果
     */
    public int updatePortalNavbar(PortalNavbar portalNavbar);

    /**
     * 批量删除导航管理
     * 
     * @param navIds 需要删除的导航管理主键集合
     * @return 结果
     */
    public int deletePortalNavbarByNavIds(String navIds);

    /**
     * 删除导航管理信息
     * 
     * @param navId 导航管理主键
     * @return 结果
     */
    public int deletePortalNavbarByNavId(Long navId);

    /**
     * 查询导航管理树列表
     * 
     * @return 所有导航管理信息
     */
    public List<Ztree> selectPortalNavbarTree();
}
