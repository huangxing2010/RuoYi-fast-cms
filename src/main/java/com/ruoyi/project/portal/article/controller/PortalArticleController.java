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

import java.util.*;

/**
 * 文章内容Controller
 * 
 * @author huangxing
 * @date 2024-04-05
 */
@Controller
@RequestMapping("/portal/article")
public class PortalArticleController extends BaseController
{
    private String prefix = "portal/article";

    @Autowired
    private IPortalArticleService portalArticleService;

    @Autowired
    private IPortalCategoryService portalCategoryService;

    @Autowired
    private IUserService userService;


    @RequiresPermissions("portal:article:view")
    @GetMapping()
    public String article(ModelMap modelMap){
        User user = userService.selectUserByLoginName(ShiroUtils.getLoginName());
        modelMap.put("deptID", user.getDeptId());
        modelMap.put("loginUserName", ShiroUtils.getLoginName());
        modelMap.put("categoryList", portalCategoryService.selectCategoryToArticle("0"));
        return prefix + "/article";
    }

    /**
     * 查询文章内容列表
     */
    @RequiresPermissions("portal:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalArticle portalArticle)
    {
        portalArticle.setArtType("0"); //0文章 1单页 2专题
        // startPage();
        List<PortalArticle> list = portalArticleService.selectPortalArticleList(portalArticle);
        return getDataTable(list);
    }

    /**
     * 文章列表里的分类
     */
    @GetMapping("/getCategory/{categoryId}")
    @ResponseBody
    public AjaxResult getCategoryInfo(@PathVariable(value = "categoryId", required = false) Long categoryId){
        PortalCategory category = portalCategoryService.selectPortalCategoryByCategoryId(categoryId);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("cname", category.getCategoryName());
        ajax.put("cid", category.getCategoryId());

        return ajax;
    }

    /**
     * 导出文章内容列表
     */
    @RequiresPermissions("portal:article:export")
    @Log(title = "文章内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalArticle portalArticle)
    {
        List<PortalArticle> list = portalArticleService.selectPortalArticleList(portalArticle);
        ExcelUtil<PortalArticle> util = new ExcelUtil<PortalArticle>(PortalArticle.class);
        return util.exportExcel(list, "文章内容数据");
    }

    /**
     * 新增文章内容
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        modelMap.put("categoryList", portalCategoryService.selectCategoryToArticle("0"));
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
        return toAjax(portalArticleService.insertPortalArticle(portalArticle));
    }

    /**
     * 审核文章内容
     */
    @RequiresPermissions("portal:article:edit")
    @GetMapping("/edit/check/{articleId}")
    public String check(@PathVariable("articleId") Long articleId, ModelMap mmap){
        //查询文章
        PortalArticle portalArticle = portalArticleService.selectPortalArticleByArticleId(articleId);
        //查询文章对应的分类
        PortalCategory category = portalCategoryService.selectPortalCategoryByCategoryId(portalArticle.getCategoryId());
        mmap.put("article", portalArticle);
        mmap.put("categoryName", category.getCategoryName());
        return prefix + "/check";
    }

    /**
     * 修改、发布、审核、保存文章内容
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
        mmap.put("categoryList", portalCategoryService.selectCategoryToArticle("0"));
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

        portalArticleService.updatePortalArticle(portalArticle);
        return toAjax(1);
    }

    /**
     * 获取分类列表
     * @return
     */
  /*  private List<Object> category(){

        return objects;
    }*/

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
    }
    
    /**
     * 选择文章分类树
     */
 /*   @GetMapping(value = { "/categoryTree/{categoryId}", "/categoryTree/" })
    public String categoryTree(@PathVariable(value = "categoryId", required = false) Long categoryId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(categoryId))
        {
            mmap.put("portalCategory", portalCategoryService.selectPortalCategoryByCategoryId(categoryId));
        }
        return prefix + "/tree";
    }*/
}
