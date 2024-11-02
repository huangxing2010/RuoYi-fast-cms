package com.ruoyi.project.portal.document.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 文件下载对象 sys_portal_document
 * 
 * @author huangxing
 * @date 2024-11-01
 */
public class PortalDocument extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @Excel(name = "主键ID")
    private Long docId;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String docTitle;

    /** 文件描述 */
    @Excel(name = "文件描述")
    private String docDesc;

    /** 文件内容 */
    @Excel(name = "文件内容")
    private String docContent;

    /** 类型 */
    @Excel(name = "类型")
    private String docType;

    /** 是否加密 */
    @Excel(name = "是否加密")
    private String isLock;

    /** 加密密码 */
    @Excel(name = "加密密码")
    private String password;

    /** 附件 */
    private String accessory;

    public void setDocId(Long docId) 
    {
        this.docId = docId;
    }

    public Long getDocId() 
    {
        return docId;
    }

    public void setDocTitle(String docTitle) 
    {
        this.docTitle = docTitle;
    }

    public String getDocTitle() 
    {
        return docTitle;
    }

    public void setDocDesc(String docDesc) 
    {
        this.docDesc = docDesc;
    }

    public String getDocDesc() 
    {
        return docDesc;
    }

    public void setDocContent(String docContent) 
    {
        this.docContent = docContent;
    }

    public String getDocContent() 
    {
        return docContent;
    }

    public void setDocType(String docType) 
    {
        this.docType = docType;
    }

    public String getDocType() 
    {
        return docType;
    }

    public void setIsLock(String isLock) 
    {
        this.isLock = isLock;
    }

    public String getIsLock() 
    {
        return isLock;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setAccessory(String accessory) 
    {
        this.accessory = accessory;
    }

    public String getAccessory() 
    {
        return accessory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("docId", getDocId())
            .append("docTitle", getDocTitle())
            .append("docDesc", getDocDesc())
            .append("docContent", getDocContent())
            .append("docType", getDocType())
            .append("isLock", getIsLock())
            .append("password", getPassword())
            .append("accessory", getAccessory())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
