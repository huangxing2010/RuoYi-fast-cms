package com.ruoyi.project.portal.article.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.portal.article.service.IPortalArticleService;
import com.ruoyi.project.portal.category.domain.PortalCategory;
import com.ruoyi.project.portal.category.service.IPortalCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章内容Controller
 * 
 * @author huangxing
 * @date 2024-04-05
 */
@Controller
@RequestMapping("/portal/taxonomy")
public class PortalTaxonomyController extends BaseController
{
    private String prefix = "portal/taxonomy";

    @Autowired
    private IPortalCategoryService portalCategoryService;

    @RequiresPermissions("portal:category:view")
    @GetMapping()
    public String taxonomy()
    {
        return prefix + "/list";
    }

    /**
     * 查询文章分类树列表
     */
    @RequiresPermissions("portal:category:list")
    @PostMapping("/taxonomylist")
    @ResponseBody
    public List<PortalCategory> list(PortalCategory portalCategory)
    {
        portalCategory.setCatType("2"); //2专题类型 0文章类型
        List<PortalCategory> list = portalCategoryService.selectPortalCategoryList(portalCategory);
        return list;
    }

    /**
     * 新增文章分类
     */
    @GetMapping(value = { "/add/{categoryId}", "/add/" })
    public String add(@PathVariable(value = "categoryId", required = false) Long categoryId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(categoryId))
        {
            mmap.put("portalCategory", portalCategoryService.selectPortalCategoryByCategoryId(categoryId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存文章分类
     */
    @RequiresPermissions("portal:category:add")
    @Log(title = "文章分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalCategory portalCategory)
    {
        portalCategory.setCatType("2"); //2专题类型 0文章类型
        return toAjax(portalCategoryService.insertPortalCategory(portalCategory));
//        return AjaxResult.success("oks");
    }

    /**
     * 修改文章分类
     */
    @RequiresPermissions("portal:category:edit")
    @GetMapping("/edit/{categoryId}")
    public String edit(@PathVariable("categoryId") Long categoryId, ModelMap mmap)
    {
        PortalCategory portalCategory = portalCategoryService.selectPortalCategoryByCategoryId(categoryId);
        System.out.println("category==" + portalCategory);

        if(portalCategory.getParentId() == 0 ){
            portalCategory.setParentName("顶级分类");
            mmap.put("portalCategory", portalCategory);
        }else {
            mmap.put("portalCategory", portalCategory);
        }

        return prefix + "/edit";
    }

    /**
     * 修改保存文章分类
     */
    @RequiresPermissions("portal:category:edit")
    @Log(title = "文章分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalCategory portalCategory)
    {
        return toAjax(portalCategoryService.updatePortalCategory(portalCategory));
    }

    /**
     * 选择文章分类树
     */
    @GetMapping(value = { "/selectCategoryTree/{categoryId}", "/selectCategoryTree/" })
    public String selectCategoryTree(@PathVariable(value = "categoryId", required = false) Long categoryId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(categoryId))
        {
            mmap.put("portalCategory", portalCategoryService.selectPortalCategoryByCategoryId(categoryId));
        }
        return prefix + "/tree";
    }
    /**
     * 加载文章分类树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData(PortalCategory portalCategory)
    {
        portalCategory.setCatType("2");//2专题类型 0文章类型
        List<Ztree> ztrees = portalCategoryService.selectPortalCategoryTree(portalCategory);
        return ztrees;
    }

    /**
     * 删除专题分类
     */
    @RequiresPermissions("portal:category:remove")
    @Log(title = "文章分类", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{categoryId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("categoryId") Long categoryId)
    {
        return toAjax(portalCategoryService.deletePortalCategoryByCategoryId(categoryId));
    }


}
