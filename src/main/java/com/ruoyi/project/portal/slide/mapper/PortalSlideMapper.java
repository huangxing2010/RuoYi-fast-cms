package com.ruoyi.project.portal.slide.mapper;

import com.ruoyi.project.portal.slide.domain.PortalSlide;

import java.util.List;

/**
 * 幻灯管理Mapper接口
 * 
 * @author huangxing
 * @date 2024-04-07
 */
public interface PortalSlideMapper 
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
     * 删除幻灯管理
     * 
     * @param slideId 幻灯管理主键
     * @return 结果
     */
    public int deletePortalSlideBySlideId(Long slideId);

    /**
     * 批量删除幻灯管理
     * 
     * @param slideIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalSlideBySlideIds(String[] slideIds);
}
