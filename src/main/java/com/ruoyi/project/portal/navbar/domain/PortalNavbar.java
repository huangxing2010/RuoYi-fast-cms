package com.ruoyi.project.portal.navbar.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 导航管理对象 sys_portal_navbar
 * 
 * @author huangxing
 * @date 2024-05-18
 */
public class PortalNavbar extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 导航ID */
    private Long navId;

    /** 文章标识 */
    @Excel(name = "文章标识")
    private Long categoryId;

    /** 导航名称 */
    @Excel(name = "导航名称")
    private String navName;

    /** 文章类型 */
    @Excel(name = "文章类型")
    private String articleType;

    /** 导航类型 */
    @Excel(name = "导航类型")
    private String navType;

    /** 图标 */
    @Excel(name = "图标")
    private String navIcon;

    /** 跳转地址 */
    @Excel(name = "跳转地址")
    private String navSkip;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer sortNav;

    /** 状态 */
    @Excel(name = "状态")
    private String navStatus;

    public void setNavId(Long navId)
    {
        this.navId = navId;
    }

    public Long getNavId()
    {
        return navId;
    }
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }
    public void setNavName(String navName)
    {
        this.navName = navName;
    }

    public String getNavName()
    {
        return navName;
    }
    public void setArticleType(String articleType)
    {
        this.articleType = articleType;
    }

    public String getArticleType()
    {
        return articleType;
    }
    public void setNavType(String navType)
    {
        this.navType = navType;
    }

    public String getNavType()
    {
        return navType;
    }
    public void setNavIcon(String navIcon)
    {
        this.navIcon = navIcon;
    }

    public String getNavIcon()
    {
        return navIcon;
    }
    public void setNavSkip(String navSkip)
    {
        this.navSkip = navSkip;
    }

    public String getNavSkip()
    {
        return navSkip;
    }
    public void setSortNav(Integer sortNav)
    {
        this.sortNav = sortNav;
    }

    public Integer getSortNav()
    {
        return sortNav;
    }
    public void setNavStatus(String navStatus)
    {
        this.navStatus = navStatus;
    }

    public String getNavStatus()
    {
        return navStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("navId", getNavId())
            .append("parentId", getParentId())
            .append("categoryId", getCategoryId())
            .append("navName", getNavName())
            .append("articleType", getArticleType())
            .append("navType", getNavType())
            .append("navIcon", getNavIcon())
            .append("navSkip", getNavSkip())
            .append("sortNav", getSortNav())
            .append("navStatus", getNavStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
