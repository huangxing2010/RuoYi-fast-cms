package com.ruoyi.project.portal.special.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 专题管理对象 sys_portal_special
 * 
 * @author huangxing
 * @date 2024-04-07
 */
public class PortalSpecial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专题ID */
    private Long specialId;

    /** 专题名称 */
    @Excel(name = "专题名称")
    private String specialTitle;

    /** 类型 */
    @Excel(name = "类型")
    private String specialType;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumbnail;

    /** 跳转地址 */
    @Excel(name = "跳转地址")
    private String specialSkip;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer sortNum;

    /** 状态 */
    @Excel(name = "状态")
    private String lspecialStatus;

    public void setSpecialId(Long specialId)
    {
        this.specialId = specialId;
    }

    public Long getSpecialId()
    {
        return specialId;
    }
    public void setSpecialTitle(String specialTitle)
    {
        this.specialTitle = specialTitle;
    }

    public String getSpecialTitle()
    {
        return specialTitle;
    }
    public void setSpecialType(String specialType)
    {
        this.specialType = specialType;
    }

    public String getSpecialType()
    {
        return specialType;
    }
    public void setThumbnail(String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail()
    {
        return thumbnail;
    }
    public void setSpecialSkip(String specialSkip)
    {
        this.specialSkip = specialSkip;
    }

    public String getSpecialSkip()
    {
        return specialSkip;
    }
    public void setSortNum(Integer sortNum)
    {
        this.sortNum = sortNum;
    }

    public Integer getSortNum()
    {
        return sortNum;
    }
    public void setLspecialStatus(String lspecialStatus)
    {
        this.lspecialStatus = lspecialStatus;
    }

    public String getLspecialStatus()
    {
        return lspecialStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("specialId", getSpecialId())
            .append("specialTitle", getSpecialTitle())
            .append("specialType", getSpecialType())
            .append("thumbnail", getThumbnail())
            .append("specialSkip", getSpecialSkip())
            .append("sortNum", getSortNum())
            .append("lspecialStatus", getLspecialStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
