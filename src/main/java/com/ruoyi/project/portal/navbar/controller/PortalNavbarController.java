package com.ruoyi.project.portal.navbar.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.portal.article.domain.PortalArticle;
import com.ruoyi.project.portal.article.service.IPortalArticleService;
import com.ruoyi.project.portal.category.domain.PortalCategory;
import com.ruoyi.project.portal.category.service.IPortalCategoryService;
import com.ruoyi.project.portal.navbar.domain.PortalNavbar;
import com.ruoyi.project.portal.navbar.service.IPortalNavbarService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 导航管理Controller
 * 
 * @author huangxing
 * @date 2024-05-18
 */
@Controller
@RequestMapping("/portal/navbar")
public class PortalNavbarController extends BaseController
{
    private String prefix = "portal/navbar";

    @Autowired
    private IPortalNavbarService portalNavbarService;

    @Autowired
    private IPortalCategoryService portalCategoryService;

    @Autowired
    private IPortalArticleService portalArticleService;

    @RequiresPermissions("portal:navbar:view")
    @GetMapping()
    public String navbar()
    {
        return prefix + "/navbar";
    }

    /**
     * 查询导航管理树列表
     */
    @RequiresPermissions("portal:navbar:list")
    @PostMapping("/list")
    @ResponseBody
    public List<PortalNavbar> list(PortalNavbar portalNavbar)
    {
        List<PortalNavbar> list = portalNavbarService.selectPortalNavbarList(portalNavbar);
        return list;
    }

    /**
     * 导出导航管理列表
     */
    @RequiresPermissions("portal:navbar:export")
    @Log(title = "导航管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalNavbar portalNavbar)
    {
        List<PortalNavbar> list = portalNavbarService.selectPortalNavbarList(portalNavbar);
        ExcelUtil<PortalNavbar> util = new ExcelUtil<PortalNavbar>(PortalNavbar.class);
        return util.exportExcel(list, "导航管理数据");
    }

    /**
     * 新增导航管理
     */
    @GetMapping(value = { "/add/{navId}", "/add/" })
    public String add(@PathVariable(value = "navId", required = false) Long navId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(navId))
        {
            mmap.put("portalNavbar", portalNavbarService.selectPortalNavbarByNavId(navId));
        }
        mmap.put("categoryList", this.category());




        return prefix + "/add";
    }

    /**
     * 新增保存导航管理
     */
    @RequiresPermissions("portal:navbar:add")
    @Log(title = "导航管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalNavbar portalNavbar)
    {
        return toAjax(portalNavbarService.insertPortalNavbar(portalNavbar));
    }

    /**
     * 修改导航管理
     */
    @RequiresPermissions("portal:navbar:edit")
    @GetMapping("/edit/{navId}")
    public String edit(@PathVariable("navId") Long navId, ModelMap mmap)
    {
        PortalNavbar portalNavbar = portalNavbarService.selectPortalNavbarByNavId(navId);
        if(portalNavbar.getParentId() == 0){
            portalNavbar.setParentName("顶级导航");
            mmap.put("portalNavbar", portalNavbar);
        }else {
            mmap.put("portalNavbar", portalNavbar);
        }
        mmap.put("categoryList", this.category());
        return prefix + "/edit";
    }

    /**
     * 修改保存导航管理
     */
    @RequiresPermissions("portal:navbar:edit")
    @Log(title = "导航管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalNavbar portalNavbar)
    {
        return toAjax(portalNavbarService.updatePortalNavbar(portalNavbar));
    }

    /**
     * 删除
     */
    @RequiresPermissions("portal:navbar:remove")
    @Log(title = "导航管理", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{navId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("navId") Long navId)
    {
        return toAjax(portalNavbarService.deletePortalNavbarByNavId(navId));
    }

    /**
     * 获取分类列表
     * @return
     */
    private List<Map<String, Object>> category(){
        //查询分类信息
        PortalCategory portalCategory = new PortalCategory();
        //类型0表示文章
//        portalCategory.setCatType("0");
        portalCategory.setCatStatus("0"); //0显示 1隐藏
        //父分类为0，表示顶级分类
        portalCategory.setParentId(0L);
        List<PortalCategory> allList = portalCategoryService.selectPortalCategoryList(portalCategory);
        List<Map<String, Object>> objects = new ArrayList<>();

        //添加外链类型
        Map<String, Object> ajaxLink = new HashMap<String, Object>();
        ajaxLink.put("id", 100); //分类ID固定值100
        ajaxLink.put("type", "3"); //类型3表示外链，对应字典单文章类型
        ajaxLink.put("name", "自定义栏目");
        ajaxLink.put("children",null);
        objects.add(ajaxLink);

        //遍历顶级分类
        allList.forEach(item -> {
            PortalCategory category = new PortalCategory();
            //根据顶级分类父id查询子分类
            category.setParentId(item.getCategoryId());
            category.setCatStatus("0"); //0显示 1隐藏
//            category.setCatType("0");
            List<PortalCategory> portalCategories = portalCategoryService.selectPortalCategoryList(category);
            //将子分类给chil的集合
            List<Object> chil = new ArrayList<>();
            portalCategories.forEach(v -> {
                Map<String, Object> ajaxChil = new HashMap<String, Object>();
                ajaxChil.put("id",v.getCategoryId()); //分类ID对应栏目分类ID
                ajaxChil.put("type", v.getCatType()); //类型0表示文章 对应字典单文章类型
                ajaxChil.put("name",v.getCategoryName()); //名称使用栏目分类名称
                ajaxChil.put("children",null); //无三级分类
                chil.add(ajaxChil);
            });
            //将顶级分类给ajax集合，子分类是chil的集合
            Map<String, Object> ajax = new HashMap<String, Object>();
            ajax.put("id", item.getCategoryId()); //分类ID对应栏目分类ID
            ajax.put("type", item.getCatType());  //类型0表示文章 对应字典单文章类型
            ajax.put("name",item.getCategoryName());  //名称使用栏目分类名称
            ajax.put("children",chil.size() == 0 ? null : chil); //有二级分类赋值该分类
            objects.add(ajax);
        });

        //获取单页
        PortalArticle portalArticle = new PortalArticle();
        portalArticle.setCategoryId(101L); //固定了分类值
        portalArticle.setArtType("1");  //单页类型
        portalArticle.setShowStatus("0");  // 不删除单状态
        List<PortalArticle> portalArticles = portalArticleService.selectPortalArticleAll(portalArticle);
        portalArticles.forEach(item -> {
            Map<String, Object> ajaxArt = new HashMap<String, Object>();
            ajaxArt.put("id", item.getArticleId());  //单页分类ID使用文章ID
            ajaxArt.put("type", "1"); //类型字典值为1 对应字典单文章类型
            ajaxArt.put("name",item.getArticleTitle()); //单页名称
            ajaxArt.put("children",null); //单页无子集分类
            objects.add(ajaxArt);
        });
        System.out.println("obj===" + objects);

        return objects;
    }

    /**
     * 选择导航管理树
     */
    @GetMapping(value = { "/selectNavbarTree/{navId}", "/selectNavbarTree/" })
    public String selectNavbarTree(@PathVariable(value = "navId", required = false) Long navId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(navId))
        {
            mmap.put("portalNavbar", portalNavbarService.selectPortalNavbarByNavId(navId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载导航管理树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = portalNavbarService.selectPortalNavbarTree();
        return ztrees;
    }
}
