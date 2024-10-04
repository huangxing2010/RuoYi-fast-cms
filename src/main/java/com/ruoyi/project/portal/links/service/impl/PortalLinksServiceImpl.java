package com.ruoyi.project.portal.links.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.portal.links.domain.PortalLinks;
import com.ruoyi.project.portal.links.mapper.PortalLinksMapper;
import com.ruoyi.project.portal.links.service.IPortalLinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友情链接Service业务层处理
 * 
 * @author huangxing
 * @date 2024-04-07
 */
@Service
public class PortalLinksServiceImpl implements IPortalLinksService 
{
    @Autowired
    private PortalLinksMapper portalLinksMapper;

    /**
     * 查询友情链接
     * 
     * @param linksId 友情链接主键
     * @return 友情链接
     */
    @Override
    public PortalLinks selectPortalLinksByLinksId(Long linksId)
    {
        return portalLinksMapper.selectPortalLinksByLinksId(linksId);
    }

    /**
     * 查询友情链接列表
     * 
     * @param portalLinks 友情链接
     * @return 友情链接
     */
    @Override
    public List<PortalLinks> selectPortalLinksList(PortalLinks portalLinks)
    {
        return portalLinksMapper.selectPortalLinksList(portalLinks);
    }

    /**
     * 新增友情链接
     * 
     * @param portalLinks 友情链接
     * @return 结果
     */
    @Override
    public int insertPortalLinks(PortalLinks portalLinks)
    {
        portalLinks.setCreateTime(DateUtils.getNowDate());
        return portalLinksMapper.insertPortalLinks(portalLinks);
    }

    /**
     * 修改友情链接
     * 
     * @param portalLinks 友情链接
     * @return 结果
     */
    @Override
    public int updatePortalLinks(PortalLinks portalLinks)
    {
        portalLinks.setUpdateTime(DateUtils.getNowDate());
        return portalLinksMapper.updatePortalLinks(portalLinks);
    }

    /**
     * 批量删除友情链接
     * 
     * @param linksIds 需要删除的友情链接主键
     * @return 结果
     */
    @Override
    public int deletePortalLinksByLinksIds(String linksIds)
    {
        return portalLinksMapper.deletePortalLinksByLinksIds(Convert.toStrArray(linksIds));
    }

    /**
     * 删除友情链接信息
     * 
     * @param linksId 友情链接主键
     * @return 结果
     */
    @Override
    public int deletePortalLinksByLinksId(Long linksId)
    {
        return portalLinksMapper.deletePortalLinksByLinksId(linksId);
    }
}
