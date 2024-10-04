package com.ruoyi.project.portal.category.service;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.portal.category.domain.PortalCategory;

import java.util.List;
import java.util.Map;

/**
 * 文章分类Service接口
 * 
 * @author ruoyi
 * @date 2024-04-05
 */
public interface IPortalCategoryService 
{
    /**
     * 查询文章分类
     * 
     * @param categoryId 文章分类主键
     * @return 文章分类
     */
    public PortalCategory selectPortalCategoryByCategoryId(Long categoryId);

    /**
     * 查询文章分类列表
     * 
     * @param portalCategory 文章分类
     * @return 文章分类集合
     */
    public List<PortalCategory> selectPortalCategoryList(PortalCategory portalCategory);

    /**
     * 新增文章分类
     * 
     * @param portalCategory 文章分类
     * @return 结果
     */
    public int insertPortalCategory(PortalCategory portalCategory);

    /**
     * 修改文章分类
     * 
     * @param portalCategory 文章分类
     * @return 结果
     */
    public int updatePortalCategory(PortalCategory portalCategory);

    /**
     * 批量删除文章分类
     * 
     * @param categoryIds 需要删除的文章分类主键集合
     * @return 结果
     */
    public int deletePortalCategoryByCategoryIds(String categoryIds);

    /**
     * 删除文章分类信息
     * 
     * @param categoryId 文章分类主键
     * @return 结果
     */
    public int deletePortalCategoryByCategoryId(Long categoryId);

    /**
     * 查询文章分类树列表
     * 
     * @return 所有文章分类信息
     */
    public List<Ztree> selectPortalCategoryTree(PortalCategory portalCategory);

    /**
     * 文章分类树，根据类型参数查询  0表示文章 1单页面 2专题
     * @param catType
     * @return
     */
    public List<Map<String, Object>> selectCategoryToArticle(String catType);
}
