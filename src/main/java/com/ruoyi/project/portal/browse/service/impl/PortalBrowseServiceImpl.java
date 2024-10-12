package com.ruoyi.project.portal.browse.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.portal.browse.mapper.PortalBrowseMapper;
import com.ruoyi.project.portal.browse.domain.PortalBrowse;
import com.ruoyi.project.portal.browse.service.IPortalBrowseService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 访问统计Service业务层处理
 * 
 * @author huangxing
 * @date 2024-10-11
 */
@Service
public class PortalBrowseServiceImpl implements IPortalBrowseService 
{
    @Autowired
    private PortalBrowseMapper portalBrowseMapper;

    /**
     * 查询访问统计
     * 
     * @param browseId 访问统计主键
     * @return 访问统计
     */
    @Override
    public PortalBrowse selectPortalBrowseByBrowseId(Long browseId)
    {
        return portalBrowseMapper.selectPortalBrowseByBrowseId(browseId);
    }

    /**
     * 查询访问统计列表
     * 
     * @param portalBrowse 访问统计
     * @return 访问统计
     */
    @Override
    public List<PortalBrowse> selectPortalBrowseList(PortalBrowse portalBrowse)
    {
        return portalBrowseMapper.selectPortalBrowseList(portalBrowse);
    }

    /**
     * 新增访问统计
     * 
     * @param portalBrowse 访问统计
     * @return 结果
     */
    @Override
    public int insertPortalBrowse(PortalBrowse portalBrowse)
    {
        portalBrowse.setCreateTime(DateUtils.getNowDate());
        return portalBrowseMapper.insertPortalBrowse(portalBrowse);
    }

    /**
     * 修改访问统计
     * 
     * @param portalBrowse 访问统计
     * @return 结果
     */
    @Override
    public int updatePortalBrowse(PortalBrowse portalBrowse)
    {
        return portalBrowseMapper.updatePortalBrowse(portalBrowse);
    }

    /**
     * 批量删除访问统计
     * 
     * @param browseIds 需要删除的访问统计主键
     * @return 结果
     */
    @Override
    public int deletePortalBrowseByBrowseIds(String browseIds)
    {
        return portalBrowseMapper.deletePortalBrowseByBrowseIds(Convert.toStrArray(browseIds));
    }

    /**
     * 删除访问统计信息
     * 
     * @param browseId 访问统计主键
     * @return 结果
     */
    @Override
    public int deletePortalBrowseByBrowseId(Long browseId)
    {
        return portalBrowseMapper.deletePortalBrowseByBrowseId(browseId);
    }
}
