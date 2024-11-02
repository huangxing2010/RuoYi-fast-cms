package com.ruoyi.project.portal.document.controller;

import java.util.List;
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
import com.ruoyi.project.portal.document.domain.PortalDocument;
import com.ruoyi.project.portal.document.service.IPortalDocumentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 文件下载Controller
 * 
 * @author huangxing
 * @date 2024-11-01
 */
@Controller
@RequestMapping("/portal/document")
public class PortalDocumentController extends BaseController
{
    private String prefix = "portal/document";

    @Autowired
    private IPortalDocumentService portalDocumentService;

    @RequiresPermissions("portal:document:view")
    @GetMapping()
    public String document()
    {
        return prefix + "/document";
    }

    /**
     * 查询文件下载列表
     */
    @RequiresPermissions("portal:document:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalDocument portalDocument)
    {
        startPage();
        List<PortalDocument> list = portalDocumentService.selectPortalDocumentList(portalDocument);
        return getDataTable(list);
    }

    /**
     * 导出文件下载列表
     */
    @RequiresPermissions("portal:document:export")
    @Log(title = "文件下载", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalDocument portalDocument)
    {
        List<PortalDocument> list = portalDocumentService.selectPortalDocumentList(portalDocument);
        ExcelUtil<PortalDocument> util = new ExcelUtil<PortalDocument>(PortalDocument.class);
        return util.exportExcel(list, "文件下载数据");
    }

    /**
     * 新增文件下载
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文件下载
     */
    @RequiresPermissions("portal:document:add")
    @Log(title = "文件下载", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalDocument portalDocument)
    {
        return toAjax(portalDocumentService.insertPortalDocument(portalDocument));
    }

    /**
     * 修改文件下载
     */
    @RequiresPermissions("portal:document:edit")
    @GetMapping("/edit/{docId}")
    public String edit(@PathVariable("docId") Long docId, ModelMap mmap)
    {
        PortalDocument portalDocument = portalDocumentService.selectPortalDocumentByDocId(docId);
        mmap.put("portalDocument", portalDocument);
        return prefix + "/edit";
    }

    /**
     * 修改保存文件下载
     */
    @RequiresPermissions("portal:document:edit")
    @Log(title = "文件下载", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalDocument portalDocument)
    {
        return toAjax(portalDocumentService.updatePortalDocument(portalDocument));
    }

    /**
     * 删除文件下载
     */
    @RequiresPermissions("portal:document:remove")
    @Log(title = "文件下载", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalDocumentService.deletePortalDocumentByDocIds(ids));
    }
}
