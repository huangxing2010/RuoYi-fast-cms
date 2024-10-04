package com.ruoyi.project.portal.slide.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 幻灯管理对象 sys_portal_slide
 * 
 * @author huangxing
 * @date 2024-04-07
 */
public class PortalSlide extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 幻灯ID */
    private Long slideId;

    /** 幻灯名称 */
    @Excel(name = "幻灯名称")
    private String slideTitle;

    /** 类型 */
    @Excel(name = "类型")
    private String slideType;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumbnail;

    /** 链接地址 */
    @Excel(name = "链接地址")
    private String slideSkip;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer sortNum;

    /** 状态 */
    @Excel(name = "状态")
    private String slideStatus;

    public void setSlideId(Long slideId)
    {
        this.slideId = slideId;
    }

    public Long getSlideId()
    {
        return slideId;
    }
    public void setSlideTitle(String slideTitle)
    {
        this.slideTitle = slideTitle;
    }

    public String getSlideTitle()
    {
        return slideTitle;
    }
    public void setSlideType(String slideType)
    {
        this.slideType = slideType;
    }

    public String getSlideType()
    {
        return slideType;
    }
    public void setThumbnail(String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail()
    {
        return thumbnail;
    }
    public void setSlideSkip(String slideSkip)
    {
        this.slideSkip = slideSkip;
    }

    public String getSlideSkip()
    {
        return slideSkip;
    }
    public void setSortNum(Integer sortNum)
    {
        this.sortNum = sortNum;
    }

    public Integer getSortNum()
    {
        return sortNum;
    }
    public void setSlideStatus(String slideStatus)
    {
        this.slideStatus = slideStatus;
    }

    public String getSlideStatus()
    {
        return slideStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("slideId", getSlideId())
            .append("slideTitle", getSlideTitle())
            .append("slideType", getSlideType())
            .append("thumbnail", getThumbnail())
            .append("slideSkip", getSlideSkip())
            .append("sortNum", getSortNum())
            .append("slideStatus", getSlideStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
