package com.ruoyi.project.portal.category.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文章分类对象 sys_portal_category
 * 
 * @author ruoyi
 * @date 2024-04-05
 */
public class PortalCategory extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 分类ID */
    private Long categoryId;

    /** 栏目名称 */
    @Excel(name = "栏目名称")
    private String categoryName;

    /** 类型 */
    @Excel(name = "类型")
    private String catType;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer sortNum;

    /** 状态 */
    @Excel(name = "状态")
    private String catStatus;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumbnail;

    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName()
    {
        return categoryName;
    }
    public void setCatType(String catType)
    {
        this.catType = catType;
    }

    public String getCatType()
    {
        return catType;
    }
    public void setSortNum(Integer sortNum)
    {
        this.sortNum = sortNum;
    }

    public Integer getSortNum()
    {
        return sortNum;
    }
    public void setCatStatus(String catStatus)
    {
        this.catStatus = catStatus;
    }

    public String getCatStatus()
    {
        return catStatus;
    }
    public void setThumbnail(String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail()
    {
        return thumbnail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("categoryId", getCategoryId())
            .append("parentId", getParentId())
            .append("categoryName", getCategoryName())
            .append("catType", getCatType())
            .append("sortNum", getSortNum())
            .append("catStatus", getCatStatus())
            .append("thumbnail", getThumbnail())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
