package com.ruoyi.project.portal.article.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.portal.article.domain.PortalArticle;
import com.ruoyi.project.portal.article.service.IPortalArticleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 文章内容Controller
 * 
 * @author huangxing
 * @date 2024-04-05
 */
@Controller
@RequestMapping("/portal/pages")
public class PortalPagesController extends BaseController
{
    private String prefix = "portal/pages";

    @Autowired
    private IPortalArticleService portalArticleService;

    @RequiresPermissions("portal:article:view")
    @GetMapping()
    public String article()
    {
        return prefix + "/list";
    }

    /**
     * 查询文章内容列表
     */
    @RequiresPermissions("portal:article:list")
    @PostMapping("/pagesList")
    @ResponseBody
    public TableDataInfo pagesList(PortalArticle portalArticle)
    {
        startPage();
        List<PortalArticle> list = portalArticleService.selectPortalPagesList(portalArticle);
        return getDataTable(list);
    }

    /**
     * 新增文章内容
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章内容
     */
    @RequiresPermissions("portal:article:add")
    @Log(title = "文章内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalArticle portalArticle)
    {
        portalArticle.setArtType("1");
        portalArticle.setCategoryId(101L); //设置了单页面分类ID
        return toAjax(portalArticleService.insertPortalArticle(portalArticle));
//        return toAjax(1);
    }

    /**
     * 修改文章内容
     */
    @RequiresPermissions("portal:article:edit")
    @GetMapping("/edit/{articleId}")
    public String edit(@PathVariable("articleId") Long articleId, ModelMap mmap)
    {
        PortalArticle portalArticle = portalArticleService.selectPortalArticleByArticleId(articleId);
        mmap.put("portalArticle", portalArticle);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章内容
     */
    @RequiresPermissions("portal:article:edit")
    @Log(title = "文章内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalArticle portalArticle)
    {
        return toAjax(portalArticleService.updatePortalArticle(portalArticle));
    }

    /**
     * 删除文章内容
     */
    @RequiresPermissions("portal:article:remove")
    @Log(title = "文章内容", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        String[] split = ids.split(",");
        Arrays.stream(split).forEach(item->{
            PortalArticle portalArticle = new PortalArticle();
            portalArticle.setArticleId(Long.parseLong(item));
            portalArticle.setShowStatus("1");
            portalArticleService.updatePortalArticle(portalArticle);
        });
        return success("操作成功");

//        return toAjax(portalArticleService.deletePortalArticleByArticleIds(ids));
    }
}
