package com.ruoyi.project.portal.browse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.AddressUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.shiro.web.filter.LogoutFilter;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.ruoyi.project.portal.browse.domain.PortalBrowse;
import com.ruoyi.project.portal.browse.service.IPortalBrowseService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 访问统计Controller
 * 
 * @author huangxing
 * @date 2024-10-11
 */
@Controller
@RequestMapping("/portal/browse")
public class PortalBrowseController extends BaseController
{
    private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);
    private String prefix = "portal/browse";

    @Autowired
    private IPortalBrowseService portalBrowseService;

    @RequiresPermissions("portal:browse:view")
    @GetMapping()
    public String browse()
    {
        return prefix + "/browse";
    }

    /**
     * 查询访问统计列表
     */
    @RequiresPermissions("portal:browse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalBrowse portalBrowse)
    {
        startPage();
        List<PortalBrowse> list = portalBrowseService.selectPortalBrowseList(portalBrowse);
        return getDataTable(list);
    }

    /**
     * 导出访问统计列表
     */
    @RequiresPermissions("portal:browse:export")
    @Log(title = "访问统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalBrowse portalBrowse)
    {
        List<PortalBrowse> list = portalBrowseService.selectPortalBrowseList(portalBrowse);
        ExcelUtil<PortalBrowse> util = new ExcelUtil<PortalBrowse>(PortalBrowse.class);
        return util.exportExcel(list, "访问统计数据");
    }

    /**
     * 新增访问统计
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存访问统计
     */
    @RequiresPermissions("portal:browse:add")
    @Log(title = "访问统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalBrowse portalBrowse)
    {
        return toAjax(portalBrowseService.insertPortalBrowse(portalBrowse));
    }

    /**
     * 修改访问统计
     */
    @RequiresPermissions("portal:browse:edit")
    @GetMapping("/edit/{browseId}")
    public String edit(@PathVariable("browseId") Long browseId, ModelMap mmap)
    {

            PortalBrowse portalBrowse = portalBrowseService.selectPortalBrowseByBrowseId(browseId);
            JSONArray objects = JSON.parseArray(portalBrowse.getBrowseJson());
            Map<String, Object> list = new HashMap<>();
            List<Object> browList = new ArrayList<>();
            for (int i = 0; i < objects.size(); i++) {
                JSONObject obj = objects.getJSONObject(i);
                Map<String, Object> numbers = new HashMap<>();


                Object ip = obj.get("ip");
                numbers.put("ip", ip);
                //String ipAdd = AddressUtils.getRealAddressByIP(obj.getString("ip"));
                //numbers.put("ipAdd", ipAdd == null || ipAdd == "XX XX" ? "未知" : ipAdd);
                Object number = obj.get("number");
                numbers.put("number", number);
                browList.add(numbers);
            }


            list.put("browList", browList);
            list.put("browseType", portalBrowse.getBrowseType());
            list.put("remark", portalBrowse.getRemark());
            list.put("createTime", portalBrowse.getCreateTime());
            list.put("ipCount", objects.size());


            mmap.put("portalBrowse", list);
            return prefix + "/edit";




    }

    /**
     * 修改保存访问统计
     */
    @RequiresPermissions("portal:browse:edit")
    @Log(title = "访问统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalBrowse portalBrowse)
    {
        return toAjax(portalBrowseService.updatePortalBrowse(portalBrowse));
    }

    /**
     * 删除访问统计
     */
    @RequiresPermissions("portal:browse:remove")
    @Log(title = "访问统计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalBrowseService.deletePortalBrowseByBrowseIds(ids));
    }
}
