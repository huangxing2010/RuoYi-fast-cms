package com.ruoyi.project.portal.category.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.portal.category.domain.PortalCategory;
import com.ruoyi.project.portal.category.mapper.PortalCategoryMapper;
import com.ruoyi.project.portal.category.service.IPortalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-05
 */
@Service
public class PortalCategoryServiceImpl implements IPortalCategoryService 
{
    @Autowired
    private PortalCategoryMapper portalCategoryMapper;

    /**
     * 查询文章分类
     * 
     * @param categoryId 文章分类主键
     * @return 文章分类
     */
    @Override
    public PortalCategory selectPortalCategoryByCategoryId(Long categoryId)
    {
        return portalCategoryMapper.selectPortalCategoryByCategoryId(categoryId);
    }

    /**
     * 查询文章分类列表
     * 
     * @param portalCategory 文章分类
     * @return 文章分类
     */
    @Override
    public List<PortalCategory> selectPortalCategoryList(PortalCategory portalCategory)
    {
        return portalCategoryMapper.selectPortalCategoryList(portalCategory);
    }

    /**
     * 新增文章分类
     * 
     * @param portalCategory 文章分类
     * @return 结果
     */
    @Override
    public int insertPortalCategory(PortalCategory portalCategory)
    {
        portalCategory.setCreateBy(ShiroUtils.getLoginName());
        portalCategory.setCreateTime(DateUtils.getNowDate());
        return portalCategoryMapper.insertPortalCategory(portalCategory);
    }

    /**
     * 修改文章分类
     * 
     * @param portalCategory 文章分类
     * @return 结果
     */
    @Override
    public int updatePortalCategory(PortalCategory portalCategory)
    {
        portalCategory.setUpdateBy(ShiroUtils.getLoginName());
        portalCategory.setUpdateTime(DateUtils.getNowDate());
        return portalCategoryMapper.updatePortalCategory(portalCategory);
    }

    /**
     * 批量删除文章分类
     * 
     * @param categoryIds 需要删除的文章分类主键
     * @return 结果
     */
    @Override
    public int deletePortalCategoryByCategoryIds(String categoryIds)
    {
        return portalCategoryMapper.deletePortalCategoryByCategoryIds(Convert.toStrArray(categoryIds));
    }

    /**
     * 删除文章分类信息
     * 
     * @param categoryId 文章分类主键
     * @return 结果
     */
    @Override
    public int deletePortalCategoryByCategoryId(Long categoryId)
    {
        return portalCategoryMapper.deletePortalCategoryByCategoryId(categoryId);
    }

    /**
     * 文章分类树，根据类型参数查询  0表示文章 1单页面 2专题
     * @param catType
     * @return
     */
    @Override
    public List<Map<String, Object>> selectCategoryToArticle(String catType){
        //查询分类信息
        PortalCategory portalCategory = new PortalCategory();
        //类型0表示文章
        portalCategory.setCatType(catType); //0表示文章 1单页面 2专题
        //父分类为0，表示顶级分类
        portalCategory.setParentId(0L);
        List<PortalCategory> allList = portalCategoryMapper.selectPortalCategoryList(portalCategory);
        List<Map<String, Object>> objects = new ArrayList<>();
        //遍历顶级分类
        allList.forEach(item -> {
            PortalCategory category = new PortalCategory();
            //根据顶级分类父id查询子分类
            category.setParentId(item.getCategoryId());
            category.setCatType(catType);
            List<PortalCategory> portalCategories = portalCategoryMapper.selectPortalCategoryList(category);
            //将子分类给chil的集合
            List<Object> chil = new ArrayList<>();
            portalCategories.forEach(v -> {
                Map<String, Object> ajaxChil = new HashMap<String, Object>();
                ajaxChil.put("id",v.getCategoryId());
                ajaxChil.put("pid",v.getParentId());
                ajaxChil.put("name",v.getCategoryName());
                chil.add(ajaxChil);
            });
            //将顶级分类给ajax集合，子分类是chil的集合
            Map<String, Object> ajax = new HashMap<String, Object>();
            ajax.put("id", item.getCategoryId());
            ajax.put("pid",item.getParentId());
            ajax.put("name",item.getCategoryName());
            ajax.put("children",chil);
            objects.add(ajax);
        });
        return objects;
    }

    /**
     * 查询文章分类树列表
     * 
     * @return 所有文章分类信息
     */
    @Override
    public List<Ztree> selectPortalCategoryTree(PortalCategory portalCategory)
    {
        List<PortalCategory> portalCategoryList = portalCategoryMapper.selectPortalCategoryList(portalCategory);
        List<Ztree> ztrees = new ArrayList<Ztree>();

        // 获取根节点数据,二级目录可修改为顶级目录
        Ztree tree = new Ztree();
        tree.setId(0L);
        tree.setName("顶级目录");
        tree.setOpen(true);
        ztrees.add(tree);
        for (PortalCategory category : portalCategoryList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(category.getCategoryId());
            ztree.setpId(category.getParentId());
            ztree.setName(category.getCategoryName());
            ztree.setTitle(category.getCategoryName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
