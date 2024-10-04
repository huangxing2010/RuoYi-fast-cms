package com.ruoyi.project.portal.article.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.portal.article.domain.PortalArticle;
import com.ruoyi.project.portal.article.service.IPortalArticleService;
import com.ruoyi.project.portal.category.domain.PortalCategory;
import com.ruoyi.project.portal.category.service.IPortalCategoryService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.IUserService;
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
@RequestMapping("/portal/specially")
public class PortalSpeciallyController extends BaseController
{
    private String prefix = "portal/specially";

    @Autowired
    private IPortalArticleService portalArticleService;

    @Autowired
    private IPortalCategoryService portalCategoryService;

    @Autowired
    private IUserService userService;

    @RequiresPermissions("portal:article:view")
    @GetMapping()
    public String specially(ModelMap modelMap){
        User user = userService.selectUserByLoginName(ShiroUtils.getLoginName());
        modelMap.put("deptID", user.getDeptId());
        modelMap.put("loginUserName", ShiroUtils.getLoginName());
        modelMap.put("categoryList", portalCategoryService.selectCategoryToArticle("2"));
        return prefix + "/list";
    }

    /**
     * 查询文章内容列表
     */
    @RequiresPermissions("portal:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo speciallyList(PortalArticle portalArticle)
    {
        portalArticle.setArtType("2"); //0文章 1单页 2专题
        List<PortalArticle> list = portalArticleService.selectPortalArticleList(portalArticle);
        return getDataTable(list);
    }

    /**
     * 新增文章内容
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        modelMap.put("categoryList", portalCategoryService.selectCategoryToArticle("2"));
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
        portalArticle.setArtType("2"); //0文章 1单页 2专题
        return toAjax(portalArticleService.insertPortalArticle(portalArticle));
    }

    /**
     * 修改文章内容
     */
    @RequiresPermissions("portal:article:edit")
    @GetMapping("/edit/{articleId}")
    public String edit(@PathVariable("articleId") Long articleId, ModelMap mmap)
    {
        //查询当前登录用户所在部门ID，用于只有县局具有发布权限
        User user = userService.selectUserByLoginName(ShiroUtils.getLoginName());
        mmap.put("deptID", user.getDeptId());
        //查询文章信息
        PortalArticle portalArticle = portalArticleService.selectPortalArticleByArticleId(articleId);
        mmap.put("portalArticle", portalArticle);
        mmap.put("categoryList", portalCategoryService.selectCategoryToArticle("2"));
        return prefix + "/edit";
    }

    /**
     * 修改、发布、审核、保存文章内容
     */
    @RequiresPermissions("portal:article:edit")
    @Log(title = "文章内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalArticle portalArticle)
    {
        //除管理员以外，只要编辑审核状态为0 即待审核
        User user = userService.selectUserByLoginName(ShiroUtils.getLoginName());
        //编辑重新审核和发布状态
        portalArticle.setCheckStatus(user.getDeptId() == 100 || user.getDeptId() == 101 ? portalArticle.getCheckStatus() : "0" );
        portalArticle.setIsIssue(user.getDeptId() == 100 || user.getDeptId() == 101 ? portalArticle.getIsIssue(): "0" );

        return toAjax(portalArticleService.updatePortalArticle(portalArticle));
    }

    /**
     * 文章发布
     */
    @RequiresPermissions("portal:article:edit")
    @GetMapping("/edit/publish/{articleId}")
    public String publish(@PathVariable("articleId") Long articleId, ModelMap mmap){
        //查询文章
        PortalArticle portalArticle = portalArticleService.selectPortalArticleByArticleId(articleId);
        //查询文章对应的分类
        PortalCategory category = portalCategoryService.selectPortalCategoryByCategoryId(portalArticle.getCategoryId());
        mmap.put("article", portalArticle);
        mmap.put("categoryName", category.getCategoryName());
        return prefix + "/publish";
    }


}
