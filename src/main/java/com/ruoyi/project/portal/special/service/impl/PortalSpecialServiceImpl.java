package com.ruoyi.project.portal.special.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.portal.special.domain.PortalSpecial;
import com.ruoyi.project.portal.special.mapper.PortalSpecialMapper;
import com.ruoyi.project.portal.special.service.IPortalSpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专题管理Service业务层处理
 * 
 * @author huangxing
 * @date 2024-04-07
 */
@Service
public class PortalSpecialServiceImpl implements IPortalSpecialService 
{
    @Autowired
    private PortalSpecialMapper portalSpecialMapper;

    /**
     * 查询专题管理
     * 
     * @param specialId 专题管理主键
     * @return 专题管理
     */
    @Override
    public PortalSpecial selectPortalSpecialBySpecialId(Long specialId)
    {
        return portalSpecialMapper.selectPortalSpecialBySpecialId(specialId);
    }

    /**
     * 查询专题管理列表
     * 
     * @param portalSpecial 专题管理
     * @return 专题管理
     */
    @Override
    public List<PortalSpecial> selectPortalSpecialList(PortalSpecial portalSpecial)
    {
        return portalSpecialMapper.selectPortalSpecialList(portalSpecial);
    }

    /**
     * 新增专题管理
     * 
     * @param portalSpecial 专题管理
     * @return 结果
     */
    @Override
    public int insertPortalSpecial(PortalSpecial portalSpecial)
    {
        portalSpecial.setCreateTime(DateUtils.getNowDate());
        return portalSpecialMapper.insertPortalSpecial(portalSpecial);
    }

    /**
     * 修改专题管理
     * 
     * @param portalSpecial 专题管理
     * @return 结果
     */
    @Override
    public int updatePortalSpecial(PortalSpecial portalSpecial)
    {
        portalSpecial.setUpdateTime(DateUtils.getNowDate());
        return portalSpecialMapper.updatePortalSpecial(portalSpecial);
    }

    /**
     * 批量删除专题管理
     * 
     * @param specialIds 需要删除的专题管理主键
     * @return 结果
     */
    @Override
    public int deletePortalSpecialBySpecialIds(String specialIds)
    {
        return portalSpecialMapper.deletePortalSpecialBySpecialIds(Convert.toStrArray(specialIds));
    }

    /**
     * 删除专题管理信息
     * 
     * @param specialId 专题管理主键
     * @return 结果
     */
    @Override
    public int deletePortalSpecialBySpecialId(Long specialId)
    {
        return portalSpecialMapper.deletePortalSpecialBySpecialId(specialId);
    }
}
