package com.ruoyi.project.portal.browse.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 访问统计对象 sys_portal_browse
 * 
 * @author huangxing
 * @date 2024-10-11
 */
public class PortalBrowse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 浏览id */
    private Long browseId;

    /** 站点类型 */
    @Excel(name = "站点类型")
    private String browseType;

    /** 浏览统计 */
    @Excel(name = "浏览统计")
    private String browseJson;

    public void setBrowseId(Long browseId) 
    {
        this.browseId = browseId;
    }

    public Long getBrowseId() 
    {
        return browseId;
    }

    public void setBrowseType(String browseType) 
    {
        this.browseType = browseType;
    }

    public String getBrowseType() 
    {
        return browseType;
    }

    public void setBrowseJson(String browseJson) 
    {
        this.browseJson = browseJson;
    }

    public String getBrowseJson() 
    {
        return browseJson;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("browseId", getBrowseId())
            .append("browseType", getBrowseType())
            .append("browseJson", getBrowseJson())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .toString();
    }
}
