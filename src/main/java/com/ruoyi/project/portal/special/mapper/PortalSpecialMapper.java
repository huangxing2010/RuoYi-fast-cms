package com.ruoyi.project.portal.special.mapper;

import com.ruoyi.project.portal.special.domain.PortalSpecial;

import java.util.List;
import java.util.Map;

/**
 * 专题管理Mapper接口
 * 
 * @author huangxing
 * @date 2024-04-07
 */
public interface PortalSpecialMapper 
{
    /**
     * 查询专题管理
     * 
     * @param specialId 专题管理主键
     * @return 专题管理
     */
    public PortalSpecial selectPortalSpecialBySpecialId(Long specialId);

    /**
     * 查询专题管理列表
     * 
     * @param portalSpecial 专题管理
     * @return 专题管理集合
     */
    public List<PortalSpecial> selectPortalSpecialList(PortalSpecial portalSpecial);

    /**
     * 新增专题管理
     * 
     * @param portalSpecial 专题管理
     * @return 结果
     */
    public int insertPortalSpecial(PortalSpecial portalSpecial);

    /**
     * 修改专题管理
     * 
     * @param portalSpecial 专题管理
     * @return 结果
     */
    public int updatePortalSpecial(PortalSpecial portalSpecial);

    /**
     * 删除专题管理
     * 
     * @param specialId 专题管理主键
     * @return 结果
     */
    public int deletePortalSpecialBySpecialId(Long specialId);

    /**
     * 批量删除专题管理
     * 
     * @param specialIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalSpecialBySpecialIds(String[] specialIds);

    /**
     * 首页快捷导航列表
     *
     * @param params 快捷导航
     * @return 专题管理集合
     */
    public List<PortalSpecial> selectHomeSpecialList(Map params);
}
