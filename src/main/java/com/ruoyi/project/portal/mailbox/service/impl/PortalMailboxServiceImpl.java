package com.ruoyi.project.portal.mailbox.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.portal.mailbox.mapper.PortalMailboxMapper;
import com.ruoyi.project.portal.mailbox.domain.PortalMailbox;
import com.ruoyi.project.portal.mailbox.service.IPortalMailboxService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 首长信箱Service业务层处理
 * 
 * @author huangxing
 * @date 2024-09-29
 */
@Service
public class PortalMailboxServiceImpl implements IPortalMailboxService 
{
    @Autowired
    private PortalMailboxMapper portalMailboxMapper;

    /**
     * 查询首长信箱
     * 
     * @param mailboxId 首长信箱主键
     * @return 首长信箱
     */
    @Override
    public PortalMailbox selectPortalMailboxByMailboxId(Long mailboxId)
    {
        return portalMailboxMapper.selectPortalMailboxByMailboxId(mailboxId);
    }

    /**
     * 查询首长信箱列表
     * 
     * @param portalMailbox 首长信箱
     * @return 首长信箱
     */
    @Override
    public List<PortalMailbox> selectPortalMailboxList(PortalMailbox portalMailbox)
    {
        return portalMailboxMapper.selectPortalMailboxList(portalMailbox);
    }

    /**
     * 新增首长信箱
     * 
     * @param portalMailbox 首长信箱
     * @return 结果
     */
    @Override
    public int insertPortalMailbox(PortalMailbox portalMailbox)
    {
        portalMailbox.setCreateTime(DateUtils.getNowDate());
        return portalMailboxMapper.insertPortalMailbox(portalMailbox);
    }

    /**
     * 修改首长信箱
     * 
     * @param portalMailbox 首长信箱
     * @return 结果
     */
    @Override
    public int updatePortalMailbox(PortalMailbox portalMailbox)
    {
        portalMailbox.setUpdateTime(DateUtils.getNowDate());
        return portalMailboxMapper.updatePortalMailbox(portalMailbox);
    }

    /**
     * 批量删除首长信箱
     * 
     * @param mailboxIds 需要删除的首长信箱主键
     * @return 结果
     */
    @Override
    public int deletePortalMailboxByMailboxIds(String mailboxIds)
    {
        return portalMailboxMapper.deletePortalMailboxByMailboxIds(Convert.toStrArray(mailboxIds));
    }

    /**
     * 删除首长信箱信息
     * 
     * @param mailboxId 首长信箱主键
     * @return 结果
     */
    @Override
    public int deletePortalMailboxByMailboxId(Long mailboxId)
    {
        return portalMailboxMapper.deletePortalMailboxByMailboxId(mailboxId);
    }
}
