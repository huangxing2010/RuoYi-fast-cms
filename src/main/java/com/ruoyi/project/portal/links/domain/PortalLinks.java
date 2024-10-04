package com.ruoyi.project.portal.links.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 友情链接对象 sys_portal_links
 * 
 * @author huangxing
 * @date 2024-04-07
 */
public class PortalLinks extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 友链ID */
    private Long linksId;

    /** 友链名称 */
    @Excel(name = "友链名称")
    private String linksTitle;

    /** 类型 */
    @Excel(name = "类型")
    private String linksType;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumbnail;

    /** 跳转地址 */
    @Excel(name = "跳转地址")
    private String linksSkip;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer sortNum;

    /** 状态 */
    @Excel(name = "状态")
    private String linksStatus;

    public void setLinksId(Long linksId)
    {
        this.linksId = linksId;
    }

    public Long getLinksId()
    {
        return linksId;
    }
    public void setLinksTitle(String linksTitle)
    {
        this.linksTitle = linksTitle;
    }

    public String getLinksTitle()
    {
        return linksTitle;
    }
    public void setLinksType(String linksType)
    {
        this.linksType = linksType;
    }

    public String getLinksType()
    {
        return linksType;
    }
    public void setThumbnail(String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail()
    {
        return thumbnail;
    }
    public void setLinksSkip(String linksSkip)
    {
        this.linksSkip = linksSkip;
    }

    public String getLinksSkip()
    {
        return linksSkip;
    }
    public void setSortNum(Integer sortNum)
    {
        this.sortNum = sortNum;
    }

    public Integer getSortNum()
    {
        return sortNum;
    }
    public void setLinksStatus(String linksStatus)
    {
        this.linksStatus = linksStatus;
    }

    public String getLinksStatus()
    {
        return linksStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("linksId", getLinksId())
            .append("linksTitle", getLinksTitle())
            .append("linksType", getLinksType())
            .append("thumbnail", getThumbnail())
            .append("linksSkip", getLinksSkip())
            .append("sortNum", getSortNum())
            .append("linksStatus", getLinksStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
