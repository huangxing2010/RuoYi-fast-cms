package com.ruoyi.project.portal.article.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.portal.category.domain.PortalCategory;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文章内容对象 sys_portal_article
 * 
 * @author huangxing
 * @date 2024-04-05
 */
public class PortalArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章ID */
    private Long articleId;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String articleTitle;

    /** 副标题 */
    @Excel(name = "副标题")
    private String subhead;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

    /** 栏目分类 */
    @Excel(name = "栏目分类")
    private Long categoryId;

    /** 文章来源 */
    @Excel(name = "文章来源")
    private String source;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumbnail;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 类型 */
    @Excel(name = "类型")
    private String artType;

    /** 跳转地址 */
    @Excel(name = "跳转地址")
    private String artSkip;

    /** 访问次数 */
    @Excel(name = "访问次数")
    private Long degreeNum;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private String isPush;

    /** 是否幻灯 */
    @Excel(name = "是否幻灯")
    private String isSlide;

    /** 是否置顶 */
    @Excel(name = "是否置顶")
    private String isTop;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String checkStatus;

    /** 发布状态 */
    @Excel(name = "发布状态")
    private String isIssue;

    /** 显示状态 */
    @Excel(name = "显示状态")
    private String showStatus;

    /** 是否签发 */
    @Excel(name = "是否签发")
    private String isGrant;

    /** 签发ID */
    private Long grantId;

    /**
     * 关联栏目
     */
    private PortalCategory portalCategory;

    public void setArticleId(Long articleId)
    {
        this.articleId = articleId;
    }

    public Long getArticleId()
    {
        return articleId;
    }
    public void setArticleTitle(String articleTitle)
    {
        this.articleTitle = articleTitle;
    }

    public String getArticleTitle()
    {
        return articleTitle;
    }
    public void setSubhead(String subhead)
    {
        this.subhead = subhead;
    }

    public String getSubhead()
    {
        return subhead;
    }

    public Long getDeptId() { return deptId; }

    public void setDeptId(Long deptId) { this.deptId = deptId; }

    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }
    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setThumbnail(String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail()
    {
        return thumbnail;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setArtType(String artType)
    {
        this.artType = artType;
    }

    public String getArtType()
    {
        return artType;
    }
    public void setArtSkip(String artSkip)
    {
        this.artSkip = artSkip;
    }

    public String getArtSkip()
    {
        return artSkip;
    }
    public void setDegreeNum(Long degreeNum)
    {
        this.degreeNum = degreeNum;
    }

    public Long getDegreeNum()
    {
        return degreeNum;
    }
    public void setIsPush(String isPush)
    {
        this.isPush = isPush;
    }

    public String getIsPush()
    {
        return isPush;
    }
    public void setIsSlide(String isSlide)
    {
        this.isSlide = isSlide;
    }

    public String getIsSlide()
    {
        return isSlide;
    }
    public void setIsTop(String isTop)
    {
        this.isTop = isTop;
    }

    public String getIsTop()
    {
        return isTop;
    }
    public void setCheckStatus(String checkStatus)
    {
        this.checkStatus = checkStatus;
    }

    public String getCheckStatus()
    {
        return checkStatus;
    }

    public String getIsIssue() { return isIssue; }

    public void setIsIssue(String isIssue) { this.isIssue = isIssue; }

    public void setShowStatus(String showStatus)
    {
        this.showStatus = showStatus;
    }

    public String getShowStatus()
    {
        return showStatus;
    }
    public void setIsGrant(String isGrant)
    {
        this.isGrant = isGrant;
    }

    public String getIsGrant()
    {
        return isGrant;
    }
    public void setGrantId(Long grantId)
    {
        this.grantId = grantId;
    }

    public Long getGrantId()
    {
        return grantId;
    }

    public PortalCategory getPortalCategory() {
        return portalCategory;
    }

    public void setPortalCategory(PortalCategory portalCategory) {
        this.portalCategory = portalCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("articleId", getArticleId())
            .append("articleTitle", getArticleTitle())
            .append("subhead", getSubhead())
            .append("deptId", getDeptId())
            .append("categoryId", getCategoryId())
            .append("source", getSource())
            .append("description", getDescription())
            .append("thumbnail", getThumbnail())
            .append("content", getContent())
            .append("artType", getArtType())
            .append("artSkip", getArtSkip())
            .append("degreeNum", getDegreeNum())
            .append("isPush", getIsPush())
            .append("isSlide", getIsSlide())
            .append("isTop", getIsTop())
            .append("checkStatus", getCheckStatus())
            .append("isIssue", getIsIssue())
            .append("showStatus", getShowStatus())
            .append("isGrant", getIsGrant())
            .append("grantId", getGrantId())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
                .append("portalCategory", getPortalCategory())
            .toString();
    }
}
