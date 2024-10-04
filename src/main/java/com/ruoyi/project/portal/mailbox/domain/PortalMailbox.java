package com.ruoyi.project.portal.mailbox.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 首长信箱对象 sys_portal_mailbox
 * 
 * @author huangxing
 * @date 2024-09-29
 */
public class PortalMailbox extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 信箱id */
    private Long mailboxId;

    /** 信件主题 */
    @Excel(name = "信件主题")
    private String mailTitle;

    /** 写信人姓名 */
    @Excel(name = "写信人姓名")
    private String writeName;

    /** 写信人电话 */
    @Excel(name = "写信人电话")
    private String phonenumber;

    /** 内容描述 */
    @Excel(name = "内容描述")
    private String description;

    /** 信箱类型 */
    @Excel(name = "信箱类型")
    private String mailType;

    /** 办理状态 */
    @Excel(name = "办理状态")
    private String mailStatus;

    /** 是否加密 */
    @Excel(name = "是否加密")
    private String isLock;

    /** 加密秘密 */
    @Excel(name = "加密秘密")
    private String password;

    public void setMailboxId(Long mailboxId) 
    {
        this.mailboxId = mailboxId;
    }

    public Long getMailboxId() 
    {
        return mailboxId;
    }

    public void setMailTitle(String mailTitle) 
    {
        this.mailTitle = mailTitle;
    }

    public String getMailTitle() 
    {
        return mailTitle;
    }

    public void setWriteName(String writeName) 
    {
        this.writeName = writeName;
    }

    public String getWriteName() 
    {
        return writeName;
    }

    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setMailType(String mailType) 
    {
        this.mailType = mailType;
    }

    public String getMailType() 
    {
        return mailType;
    }

    public void setMailStatus(String mailStatus) 
    {
        this.mailStatus = mailStatus;
    }

    public String getMailStatus() 
    {
        return mailStatus;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mailboxId", getMailboxId())
            .append("mailTitle", getMailTitle())
            .append("writeName", getWriteName())
            .append("phonenumber", getPhonenumber())
            .append("description", getDescription())
            .append("mailType", getMailType())
            .append("mailStatus", getMailStatus())
            .append("isLock", getIsLock())
            .append("password", getPassword())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
