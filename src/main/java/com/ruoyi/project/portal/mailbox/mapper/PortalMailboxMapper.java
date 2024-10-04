package com.ruoyi.project.portal.mailbox.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.portal.mailbox.domain.PortalMailbox;

/**
 * 首长信箱Mapper接口
 * 
 * @author huangxing
 * @date 2024-09-29
 */
public interface PortalMailboxMapper 
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
     * 首页信箱查询
     * @param params
     * @return
     */
    public List<PortalMailbox> selectHomeMailboxList(Map params);

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
     * 删除首长信箱
     * 
     * @param mailboxId 首长信箱主键
     * @return 结果
     */
    public int deletePortalMailboxByMailboxId(Long mailboxId);

    /**
     * 批量删除首长信箱
     * 
     * @param mailboxIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalMailboxByMailboxIds(String[] mailboxIds);
}
