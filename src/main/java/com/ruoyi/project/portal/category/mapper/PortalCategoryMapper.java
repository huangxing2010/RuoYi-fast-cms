package com.ruoyi.project.portal.category.mapper;

import com.ruoyi.project.portal.category.domain.PortalCategory;

import java.util.List;

/**
 * 文章分类Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-05
 */
public interface PortalCategoryMapper 
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
     * 删除文章分类
     * 
     * @param categoryId 文章分类主键
     * @return 结果
     */
    public int deletePortalCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除文章分类
     * 
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalCategoryByCategoryIds(String[] categoryIds);
}
