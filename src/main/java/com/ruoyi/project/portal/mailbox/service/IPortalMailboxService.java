package com.ruoyi.project.portal.mailbox.service;

import java.util.List;
import com.ruoyi.project.portal.mailbox.domain.PortalMailbox;

/**
 * 首长信箱Service接口
 * 
 * @author huangxing
 * @date 2024-09-29
 */
public interface IPortalMailboxService 
{
    /**
     * 查询首长信箱
     * 
     * @param mailboxId 首长信箱主键
     * @return 首长信箱
     */
    public PortalMailbox selectPortalMailboxByMailboxId(Long mailboxId);

    /**
     * 查询首长信箱列表
     * 
     * @param portalMailbox 首长信箱
     * @return 首长信箱集合
     */
    public List<PortalMailbox> selectPortalMailboxList(PortalMailbox portalMailbox);

    /**
     * 新增首长信箱
     * 
     * @param portalMailbox 首长信箱
     * @return 结果
     */
    public int insertPortalMailbox(PortalMailbox portalMailbox);

    /**
     * 修改首长信箱
     * 
     * @param portalMailbox 首长信箱
     * @return 结果
     */
    public int updatePortalMailbox(PortalMailbox portalMailbox);

    /**
     * 批量删除首长信箱
     * 
     * @param mailboxIds 需要删除的首长信箱主键集合
     * @return 结果
     */
    public int deletePortalMailboxByMailboxIds(String mailboxIds);

    /**
     * 删除首长信箱信息
     * 
     * @param mailboxId 首长信箱主键
     * @return 结果
     */
    public int deletePortalMailboxByMailboxId(Long mailboxId);
}
