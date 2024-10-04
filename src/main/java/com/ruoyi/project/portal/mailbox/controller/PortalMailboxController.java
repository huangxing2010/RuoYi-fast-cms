package com.ruoyi.project.portal.mailbox.controller;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.AESEncrypter;
import com.ruoyi.project.portal.category.domain.PortalCategory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.portal.mailbox.domain.PortalMailbox;
import com.ruoyi.project.portal.mailbox.service.IPortalMailboxService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 首长信箱Controller
 * 
 * @author huangxing
 * @date 2024-09-29
 */
@Controller
@RequestMapping("/portal/mailbox")
public class PortalMailboxController extends BaseController
{
    private String prefix = "portal/mailbox";

    @Autowired
    private IPortalMailboxService portalMailboxService;

    @Autowired
    private IPortalMailboxService mailboxService;

    @RequiresPermissions("portal:mailbox:view")
    @GetMapping()
    public String mailbox()
    {
        return prefix + "/mailbox";
    }

    /**
     * 查询首长信箱列表
     */
    @RequiresPermissions("portal:mailbox:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalMailbox portalMailbox)
    {
        startPage();
        List<PortalMailbox> list = portalMailboxService.selectPortalMailboxList(portalMailbox);
        return getDataTable(list);
    }

    /**
     * 导出首长信箱列表
     */
    @RequiresPermissions("portal:mailbox:export")
    @Log(title = "首长信箱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalMailbox portalMailbox)
    {
        List<PortalMailbox> list = portalMailboxService.selectPortalMailboxList(portalMailbox);
        ExcelUtil<PortalMailbox> util = new ExcelUtil<PortalMailbox>(PortalMailbox.class);
        return util.exportExcel(list, "首长信箱数据");
    }

    /**
     * 新增首长信箱
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首长信箱
     */
    @RequiresPermissions("portal:mailbox:add")
    @Log(title = "首长信箱", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalMailbox portalMailbox)
    {
        return toAjax(portalMailboxService.insertPortalMailbox(portalMailbox));
    }

    /**
     * 修改首长信箱
     */
    @RequiresPermissions("portal:mailbox:edit")
    @GetMapping("/edit/{mailboxId}")
    public String edit(@PathVariable("mailboxId") Long mailboxId, ModelMap mmap)
    {
        //解密
        try {
           /* PortalMailbox mailbox = mailboxService.selectPortalMailboxByMailboxId(mailboxId);

            AjaxResult ajax = AjaxResult.success();
            ajax.put("password", pass);
            ajax.put("mid", mailbox.getMailboxId());
            return ajax;*/

            PortalMailbox portalMailbox = portalMailboxService.selectPortalMailboxByMailboxId(mailboxId);
            String key = "abc@123#DEF45678"; // 16 bytes key for AES-128
            String pass = AESEncrypter.decrypt(key, portalMailbox.getPassword());
            portalMailbox.setPassword(pass);


            mmap.put("portalMailbox", portalMailbox);
            return prefix + "/edit";

        } catch (Exception e){
            e.getMessage();
            mmap.put("portalMailbox", null);
            return prefix + "/edit";
//            return AjaxResult.error("密码错误");
        }


    }

    /**
     * 修改保存首长信箱
     */
    @RequiresPermissions("portal:mailbox:edit")
    @Log(title = "首长信箱", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalMailbox portalMailbox)
    {
        return toAjax(portalMailboxService.updatePortalMailbox(portalMailbox));
    }

    /**
     * 文章列表里的分类
     */
    @RequiresPermissions("portal:mailbox:list")
    @GetMapping("/getMailboxPassword/{mailboxId}")
    @ResponseBody
    public AjaxResult getMailboxPassword(@PathVariable(value = "mailboxId", required = false) Long mailboxId){
        //解密
        try {
            PortalMailbox mailbox = mailboxService.selectPortalMailboxByMailboxId(mailboxId);
            String key = "abc@123#DEF45678"; // 16 bytes key for AES-128
            String pass = AESEncrypter.decrypt(key, mailbox.getPassword());
            AjaxResult ajax = AjaxResult.success();
            ajax.put("password", pass);
            ajax.put("mid", mailbox.getMailboxId());
            return ajax;
        } catch (Exception e){
            e.getMessage();
            return AjaxResult.error("密码错误");
        }

    }

    /**
     * 删除首长信箱
     */
    @RequiresPermissions("portal:mailbox:remove")
    @Log(title = "首长信箱", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalMailboxService.deletePortalMailboxByMailboxIds(ids));
    }
}
