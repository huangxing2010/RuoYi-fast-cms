package com.ruoyi.project.portal.special.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.portal.special.domain.PortalSpecial;
import com.ruoyi.project.portal.special.service.IPortalSpecialService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专题管理Controller
 * 
 * @author huangxing
 * @date 2024-04-07
 */
@Controller
@RequestMapping("/portal/special")
public class PortalSpecialController extends BaseController
{
    private String prefix = "portal/special";

    @Autowired
    private IPortalSpecialService portalSpecialService;

    @RequiresPermissions("portal:special:view")
    @GetMapping()
    public String special()
    {
        return prefix + "/special";
    }

    /**
     * 查询专题管理列表
     */
    @RequiresPermissions("portal:special:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalSpecial portalSpecial)
    {
        startPage();
        List<PortalSpecial> list = portalSpecialService.selectPortalSpecialList(portalSpecial);
        return getDataTable(list);
    }

    /**
     * 导出专题管理列表
     */
    @RequiresPermissions("portal:special:export")
    @Log(title = "专题管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalSpecial portalSpecial)
    {
        List<PortalSpecial> list = portalSpecialService.selectPortalSpecialList(portalSpecial);
        ExcelUtil<PortalSpecial> util = new ExcelUtil<PortalSpecial>(PortalSpecial.class);
        return util.exportExcel(list, "专题管理数据");
    }

    /**
     * 新增专题管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专题管理
     */
    @RequiresPermissions("portal:special:add")
    @Log(title = "专题管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalSpecial portalSpecial)
    {
        return toAjax(portalSpecialService.insertPortalSpecial(portalSpecial));
    }

    /**
     * 修改专题管理
     */
    @RequiresPermissions("portal:special:edit")
    @GetMapping("/edit/{specialId}")
    public String edit(@PathVariable("specialId") Long specialId, ModelMap mmap)
    {
        PortalSpecial portalSpecial = portalSpecialService.selectPortalSpecialBySpecialId(specialId);
        mmap.put("portalSpecial", portalSpecial);
        return prefix + "/edit";
    }

    /**
     * 修改保存专题管理
     */
    @RequiresPermissions("portal:special:edit")
    @Log(title = "专题管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalSpecial portalSpecial)
    {
        return toAjax(portalSpecialService.updatePortalSpecial(portalSpecial));
    }

    /**
     * 删除专题管理
     */
    @RequiresPermissions("portal:special:remove")
    @Log(title = "专题管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalSpecialService.deletePortalSpecialBySpecialIds(ids));
    }
}
