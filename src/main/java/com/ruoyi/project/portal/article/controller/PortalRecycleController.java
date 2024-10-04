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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 文章内容Controller
 * 
 * @author huangxing
 * @date 2024-04-05
 */
@Controller
@RequestMapping("/portal/recycle")
public class PortalRecycleController extends BaseController
{
    private String prefix = "portal/recycle";

    @Autowired
    private IPortalArticleService portalArticleService;

    @RequiresPermissions("portal:article:view")
    @GetMapping()
    public String recycle()
    {
        return prefix + "/list";
    }

    /**
     * 查询文章内容列表
     */
    @RequiresPermissions("portal:article:list")
    @PostMapping("/recycleList")
    @ResponseBody
    public TableDataInfo recycleList(PortalArticle portalArticle)
    {
        portalArticle.setShowStatus("1");

        startPage();
        List<PortalArticle> list = portalArticleService.selectPortalArticleAll(portalArticle);
        return getDataTable(list);
    }

    /**
     * 撤回修改保存文章内容
     */
    @RequiresPermissions("portal:article:edit")
    @Log(title = "文章内容", businessType = BusinessType.UPDATE)
    @PostMapping("/change")
    @ResponseBody
    public AjaxResult changeSave(PortalArticle portalArticle)
    {
        System.out.println("article====" + portalArticle);
        return toAjax(portalArticleService.updatePortalArticle(portalArticle));

    }


    /**
     * 彻底删除文章内容
     */
    @RequiresPermissions("portal:article:remove")
    @Log(title = "文章内容", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalArticleService.deletePortalArticleByArticleIds(ids));
    }
}
