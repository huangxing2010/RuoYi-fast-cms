package com.ruoyi.project.portal.article.mapper;

import com.ruoyi.project.portal.article.domain.PortalArticle;
import com.ruoyi.project.portal.special.domain.PortalSpecial;

import java.util.List;
import java.util.Map;

/**
 * 文章内容Mapper接口
 * 
 * @author huangxing
 * @date 2024-04-05
 */
public interface PortalArticleMapper 
{
    /**
     * 查询文章内容
     * 
     * @param articleId 文章内容主键
     * @return 文章内容
     */
    public PortalArticle selectPortalArticleByArticleId(Long articleId);

    /**
     * 首页多栏目文章查询
     * @param params
     * @return
     */
    public List<PortalArticle> selectHomeArticleLists(Map params);



    /**
     * 查询文章内容列表
     * 
     * @param portalArticle 文章内容
     * @return 文章内容集合
     */
    public List<PortalArticle> selectPortalArticleList(PortalArticle portalArticle);


    /**
     * 首页栏目文章查询
     * @param params
     * @return
     */
    public List<PortalArticle> selectHomeArticleList(Map params);

    /**
     * 列表栏目文章查询
     * @param params
     * @return
     */
    public List<PortalArticle> selectListArticleByCategoryId(Map params);

    /**
     * 部门文章查询
     * @param params
     * @return
     */
    public List<PortalArticle> selectDeptArticleList(Map params);

    /**
     * 查询文章总数
     * @param params
     * @return
     */
    public Integer selectArticleCount(Map params);



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
     * 删除文章内容
     * 
     * @param articleId 文章内容主键
     * @return 结果
     */
    public int deletePortalArticleByArticleId(Long articleId);

    /**
     * 批量删除文章内容
     * 
     * @param articleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalArticleByArticleIds(String[] articleIds);

    /**
     * 前端文章搜索
     *
     * @param params 文章内容
     * @return 文章内容集合
     */
    public List<PortalArticle> searchPortalArticleList(Map params);
}
