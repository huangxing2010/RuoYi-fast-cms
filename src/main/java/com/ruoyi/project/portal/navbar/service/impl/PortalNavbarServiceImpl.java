package com.ruoyi.project.portal.navbar.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.portal.navbar.domain.PortalNavbar;
import com.ruoyi.project.portal.navbar.mapper.PortalNavbarMapper;
import com.ruoyi.project.portal.navbar.service.IPortalNavbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 导航管理Service业务层处理
 * 
 * @author huangxing
 * @date 2024-05-18
 */
@Service
public class PortalNavbarServiceImpl implements IPortalNavbarService 
{
    @Autowired
    private PortalNavbarMapper portalNavbarMapper;

    /**
     * 查询导航管理
     * 
     * @param navId 导航管理主键
     * @return 导航管理
     */
    @Override
    public PortalNavbar selectPortalNavbarByNavId(Long navId)
    {
        return portalNavbarMapper.selectPortalNavbarByNavId(navId);
    }

    /**
     * 根据分类ID查询导航信息
     * @param categoryId
     * @return
     */
    @Override
    public PortalNavbar selectPortalNavbarByCategoryId(Long categoryId)
    {
        return portalNavbarMapper.selectPortalNavbarByCategoryId(categoryId);
    }

    /**
     * 查询导航管理列表
     * 
     * @param portalNavbar 导航管理
     * @return 导航管理
     */
    @Override
    public List<PortalNavbar> selectPortalNavbarList(PortalNavbar portalNavbar)
    {
        return portalNavbarMapper.selectPortalNavbarList(portalNavbar);
    }

    /**
     * 新增导航管理
     * 
     * @param portalNavbar 导航管理
     * @return 结果
     */
    @Override
    public int insertPortalNavbar(PortalNavbar portalNavbar)
    {
        portalNavbar.setCreateBy(ShiroUtils.getLoginName());
        portalNavbar.setCreateTime(DateUtils.getNowDate());
        return portalNavbarMapper.insertPortalNavbar(portalNavbar);
    }

    /**
     * 修改导航管理
     * 
     * @param portalNavbar 导航管理
     * @return 结果
     */
    @Override
    public int updatePortalNavbar(PortalNavbar portalNavbar)
    {
        portalNavbar.setUpdateTime(DateUtils.getNowDate());
        return portalNavbarMapper.updatePortalNavbar(portalNavbar);
    }

    /**
     * 批量删除导航管理
     * 
     * @param navIds 需要删除的导航管理主键
     * @return 结果
     */
    @Override
    public int deletePortalNavbarByNavIds(String navIds)
    {
        return portalNavbarMapper.deletePortalNavbarByNavIds(Convert.toStrArray(navIds));
    }

    /**
     * 删除导航管理信息
     * 
     * @param navId 导航管理主键
     * @return 结果
     */
    @Override
    public int deletePortalNavbarByNavId(Long navId)
    {
        return portalNavbarMapper.deletePortalNavbarByNavId(navId);
    }

    /**
     * 查询导航管理树列表
     * 
     * @return 所有导航管理信息
     */
    @Override
    public List<Ztree> selectPortalNavbarTree()
    {
        List<PortalNavbar> portalNavbarList = portalNavbarMapper.selectPortalNavbarList(new PortalNavbar());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        // 获取根节点数据,二级目录可修改为顶级目录
        Ztree tree = new Ztree();
        tree.setId(0L);
        tree.setName("顶级导航");
        tree.setOpen(true);
        ztrees.add(tree);

        for (PortalNavbar portalNavbar : portalNavbarList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(portalNavbar.getNavId());
            ztree.setpId(portalNavbar.getParentId());
            ztree.setName(portalNavbar.getNavName());
            ztree.setTitle(portalNavbar.getNavName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

}
