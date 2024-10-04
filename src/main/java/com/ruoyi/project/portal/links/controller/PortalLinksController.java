package com.ruoyi.project.portal.links.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.portal.links.domain.PortalLinks;
import com.ruoyi.project.portal.links.service.IPortalLinksService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 友情链接Controller
 * 
 * @author huangxing
 * @date 2024-04-07
 */
@Controller
@RequestMapping("/portal/links")
public class PortalLinksController extends BaseController
{
    private String prefix = "portal/links";

    @Autowired
    private IPortalLinksService portalLinksService;

    @RequiresPermissions("portal:links:view")
    @GetMapping()
    public String links()
    {
        return prefix + "/links";
    }

    /**
     * 查询友情链接列表
     */
    @RequiresPermissions("portal:links:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalLinks portalLinks)
    {
        startPage();
        List<PortalLinks> list = portalLinksService.selectPortalLinksList(portalLinks);
        return getDataTable(list);
    }

    /**
     * 导出友情链接列表
     */
    @RequiresPermissions("portal:links:export")
    @Log(title = "友情链接", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalLinks portalLinks)
    {
        List<PortalLinks> list = portalLinksService.selectPortalLinksList(portalLinks);
        ExcelUtil<PortalLinks> util = new ExcelUtil<PortalLinks>(PortalLinks.class);
        return util.exportExcel(list, "友情链接数据");
    }

    /**
     * 新增友情链接
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存友情链接
     */
    @RequiresPermissions("portal:links:add")
    @Log(title = "友情链接", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalLinks portalLinks)
    {
        return toAjax(portalLinksService.insertPortalLinks(portalLinks));
    }

    /**
     * 修改友情链接
     */
    @RequiresPermissions("portal:links:edit")
    @GetMapping("/edit/{linksId}")
    public String edit(@PathVariable("linksId") Long linksId, ModelMap mmap)
    {
        PortalLinks portalLinks = portalLinksService.selectPortalLinksByLinksId(linksId);
        mmap.put("portalLinks", portalLinks);
        return prefix + "/edit";
    }

    /**
     * 修改保存友情链接
     */
    @RequiresPermissions("portal:links:edit")
    @Log(title = "友情链接", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalLinks portalLinks)
    {
        return toAjax(portalLinksService.updatePortalLinks(portalLinks));
    }

    /**
     * 删除友情链接
     */
    @RequiresPermissions("portal:links:remove")
    @Log(title = "友情链接", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalLinksService.deletePortalLinksByLinksIds(ids));
    }
}
