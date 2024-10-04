package com.ruoyi.project.portal.article.service;

import com.ruoyi.project.portal.article.domain.PortalArticle;

import java.util.List;

/**
 * 文章内容Service接口
 * 
 * @author huangxing
 * @date 2024-04-05
 */
public interface IPortalArticleService 
{
    /**
     * 查询文章内容
     * 
     * @param articleId 文章内容主键
     * @return 文章内容
     */
    public PortalArticle selectPortalArticleByArticleId(Long articleId);

    /**
     * 查询文章内容列表
     * 
     * @param portalArticle 文章内容
     * @return 文章内容集合
     */
    public List<PortalArticle> selectPortalArticleList(PortalArticle portalArticle);

    /**
     * 查询全部文章内容列表
     *
     * @param portalArticle 文章内容
     * @return 文章内容
     */
    public List<PortalArticle> selectPortalArticleAll(PortalArticle portalArticle);

    /**
     * 查询单页内容列表
     *
     * @param portalArticle 文章内容
     * @return 单页内容集合
     */
    public List<PortalArticle> selectPortalPagesList(PortalArticle portalArticle);

    /**
     * 新增文章内容
     * 
     * @param portalArticle 文章内容
     * @return 结果
     */
    public int insertPortalArticle(PortalArticle portalArticle);

    /**
     * 修改文章内容
     * 
     * @param portalArticle 文章内容
     * @return 结果
     */
    public int updatePortalArticle(PortalArticle portalArticle);

    /**
     * 批量删除文章内容
     * 
     * @param articleIds 需要删除的文章内容主键集合
     * @return 结果
     */
    public int deletePortalArticleByArticleIds(String articleIds);

    /**
     * 删除文章内容信息
     * 
     * @param articleId 文章内容主键
     * @return 结果
     */
    public int deletePortalArticleByArticleId(Long articleId);
}
