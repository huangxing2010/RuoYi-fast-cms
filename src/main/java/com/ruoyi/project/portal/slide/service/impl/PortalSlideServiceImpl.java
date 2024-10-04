package com.ruoyi.project.portal.slide.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.portal.slide.domain.PortalSlide;
import com.ruoyi.project.portal.slide.mapper.PortalSlideMapper;
import com.ruoyi.project.portal.slide.service.IPortalSlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 幻灯管理Service业务层处理
 * 
 * @author huangxing
 * @date 2024-04-07
 */
@Service
public class PortalSlideServiceImpl implements IPortalSlideService 
{
    @Autowired
    private PortalSlideMapper portalSlideMapper;

    /**
     * 查询幻灯管理
     * 
     * @param slideId 幻灯管理主键
     * @return 幻灯管理
     */
    @Override
    public PortalSlide selectPortalSlideBySlideId(Long slideId)
    {
        return portalSlideMapper.selectPortalSlideBySlideId(slideId);
    }

    /**
     * 查询幻灯管理列表
     * 
     * @param portalSlide 幻灯管理
     * @return 幻灯管理
     */
    @Override
    public List<PortalSlide> selectPortalSlideList(PortalSlide portalSlide)
    {
        return portalSlideMapper.selectPortalSlideList(portalSlide);
    }

    /**
     * 新增幻灯管理
     * 
     * @param portalSlide 幻灯管理
     * @return 结果
     */
    @Override
    public int insertPortalSlide(PortalSlide portalSlide)
    {
        portalSlide.setCreateTime(DateUtils.getNowDate());
        return portalSlideMapper.insertPortalSlide(portalSlide);
    }

    /**
     * 修改幻灯管理
     * 
     * @param portalSlide 幻灯管理
     * @return 结果
     */
    @Override
    public int updatePortalSlide(PortalSlide portalSlide)
    {
        portalSlide.setUpdateTime(DateUtils.getNowDate());
        return portalSlideMapper.updatePortalSlide(portalSlide);
    }

    /**
     * 批量删除幻灯管理
     * 
     * @param slideIds 需要删除的幻灯管理主键
     * @return 结果
     */
    @Override
    public int deletePortalSlideBySlideIds(String slideIds)
    {
        return portalSlideMapper.deletePortalSlideBySlideIds(Convert.toStrArray(slideIds));
    }

    /**
     * 删除幻灯管理信息
     * 
     * @param slideId 幻灯管理主键
     * @return 结果
     */
    @Override
    public int deletePortalSlideBySlideId(Long slideId)
    {
        return portalSlideMapper.deletePortalSlideBySlideId(slideId);
    }
}
