package com.ruoyi.project.portal.slide.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.portal.slide.domain.PortalSlide;
import com.ruoyi.project.portal.slide.service.IPortalSlideService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 幻灯管理Controller
 * 
 * @author huangxing
 * @date 2024-04-07
 */
@Controller
@RequestMapping("/portal/slide")
public class PortalSlideController extends BaseController
{
    private String prefix = "portal/slide";

    @Autowired
    private IPortalSlideService portalSlideService;

    @RequiresPermissions("portal:slide:view")
    @GetMapping()
    public String slide()
    {
        return prefix + "/slide";
    }

    /**
     * 查询幻灯管理列表
     */
    @RequiresPermissions("portal:slide:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalSlide portalSlide)
    {
        startPage();
        List<PortalSlide> list = portalSlideService.selectPortalSlideList(portalSlide);
        return getDataTable(list);
    }

    /**
     * 导出幻灯管理列表
     */
    @RequiresPermissions("portal:slide:export")
    @Log(title = "幻灯管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalSlide portalSlide)
    {
        List<PortalSlide> list = portalSlideService.selectPortalSlideList(portalSlide);
        ExcelUtil<PortalSlide> util = new ExcelUtil<PortalSlide>(PortalSlide.class);
        return util.exportExcel(list, "幻灯管理数据");
    }

    /**
     * 新增幻灯管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存幻灯管理
     */
    @RequiresPermissions("portal:slide:add")
    @Log(title = "幻灯管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalSlide portalSlide)
    {
        return toAjax(portalSlideService.insertPortalSlide(portalSlide));
    }

    /**
     * 修改幻灯管理
     */
    @RequiresPermissions("portal:slide:edit")
    @GetMapping("/edit/{slideId}")
    public String edit(@PathVariable("slideId") Long slideId, ModelMap mmap)
    {
        PortalSlide portalSlide = portalSlideService.selectPortalSlideBySlideId(slideId);
        mmap.put("portalSlide", portalSlide);
        return prefix + "/edit";
    }

    /**
     * 修改保存幻灯管理
     */
    @RequiresPermissions("portal:slide:edit")
    @Log(title = "幻灯管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalSlide portalSlide)
    {
        return toAjax(portalSlideService.updatePortalSlide(portalSlide));
    }

    /**
     * 删除幻灯管理
     */
    @RequiresPermissions("portal:slide:remove")
    @Log(title = "幻灯管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalSlideService.deletePortalSlideBySlideIds(ids));
    }
}
