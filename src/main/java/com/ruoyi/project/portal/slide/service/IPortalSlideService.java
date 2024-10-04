package com.ruoyi.project.portal.slide.service;

import com.ruoyi.project.portal.slide.domain.PortalSlide;

import java.util.List;

/**
 * 幻灯管理Service接口
 * 
 * @author huangxing
 * @date 2024-04-07
 */
public interface IPortalSlideService 
{
    /**
     * 查询幻灯管理
     * 
     * @param slideId 幻灯管理主键
     * @return 幻灯管理
     */
    public PortalSlide selectPortalSlideBySlideId(Long slideId);

    /**
     * 查询幻灯管理列表
     * 
     * @param portalSlide 幻灯管理
     * @return 幻灯管理集合
     */
    public List<PortalSlide> selectPortalSlideList(PortalSlide portalSlide);

    /**
     * 新增幻灯管理
     * 
     * @param portalSlide 幻灯管理
     * @return 结果
     */
    public int insertPortalSlide(PortalSlide portalSlide);

    /**
     * 修改幻灯管理
     * 
     * @param portalSlide 幻灯管理
     * @return 结果
     */
    public int updatePortalSlide(PortalSlide portalSlide);

    /**
     * 批量删除幻灯管理
     * 
     * @param slideIds 需要删除的幻灯管理主键集合
     * @return 结果
     */
    public int deletePortalSlideBySlideIds(String slideIds);

    /**
     * 删除幻灯管理信息
     * 
     * @param slideId 幻灯管理主键
     * @return 结果
     */
    public int deletePortalSlideBySlideId(Long slideId);
}
