package com.ruoyi.project.portal.browse.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.portal.browse.mapper.PortalBrowseMapper;
import com.ruoyi.project.portal.browse.domain.PortalBrowse;
import com.ruoyi.project.portal.browse.service.IPortalBrowseService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 访问统计Service业务层处理
 *
 * @author huangxing
 * @date 2024-10-11
 */
@Service
public class PortalBrowseServiceImpl implements IPortalBrowseService {
    @Autowired
    private PortalBrowseMapper portalBrowseMapper;

    /**
     * 查询访问统计
     *
     * @param browseId 访问统计主键
     * @return 访问统计
     */
    @Override
    public PortalBrowse selectPortalBrowseByBrowseId(Long browseId) {
        return portalBrowseMapper.selectPortalBrowseByBrowseId(browseId);
    }

    /**
     * 查询访问统计列表
     *
     * @param portalBrowse 访问统计
     * @return 访问统计
     */
    @Override
    public List<PortalBrowse> selectPortalBrowseList(PortalBrowse portalBrowse) {
        List<PortalBrowse> portalBrowses = portalBrowseMapper.selectPortalBrowseList(portalBrowse);

        //json访问量转字符串
        List<PortalBrowse> browsesList = new ArrayList<>();
        portalBrowses.forEach(item -> {
            PortalBrowse pb = new PortalBrowse();
            pb.setBrowseId(item.getBrowseId());
            pb.setBrowseType(item.getBrowseType());
            pb.setCreateTime(item.getCreateTime());
            pb.setRemark(item.getRemark());
            //字符串转 json数组
            JSONArray objects = JSON.parseArray(item.getBrowseJson());
            List<Integer> numbers = new ArrayList<>();
            //遍历数组获取 pv ip访问量
            for (int i = 0; i < objects.size(); i++) {
                JSONObject obj = objects.getJSONObject(i);
                numbers.add(obj.getInteger("number"));
            }
            if(numbers.size() > 0){
                int sum = numbers.stream().mapToInt(Integer::intValue).sum();
                String count = "IP数：" + objects.size() + "，访问量：" + sum;
                pb.setBrowseJson(count);
            }else {
                String count = "IP数：0，访问量：0";
                pb.setBrowseJson(count);
            }
            browsesList.add(pb);

        });

        return browsesList;
//        return portalBrowseMapper.selectPortalBrowseList(portalBrowse);
    }

    /**
     * 新增访问统计
     *
     * @param portalBrowse 访问统计
     * @return 结果
     */
    @Override
    public int insertPortalBrowse(PortalBrowse portalBrowse) {
        portalBrowse.setCreateTime(DateUtils.getNowDate());
        return portalBrowseMapper.insertPortalBrowse(portalBrowse);
    }

    /**
     * 修改访问统计
     *
     * @param portalBrowse 访问统计
     * @return 结果
     */
    @Override
    public int updatePortalBrowse(PortalBrowse portalBrowse) {
        return portalBrowseMapper.updatePortalBrowse(portalBrowse);
    }

    /**
     * 批量删除访问统计
     *
     * @param browseIds 需要删除的访问统计主键
     * @return 结果
     */
    @Override
    public int deletePortalBrowseByBrowseIds(String browseIds) {
        return portalBrowseMapper.deletePortalBrowseByBrowseIds(Convert.toStrArray(browseIds));
    }

    /**
     * 删除访问统计信息
     *
     * @param browseId 访问统计主键
     * @return 结果
     */
    @Override
    public int deletePortalBrowseByBrowseId(Long browseId) {
        return portalBrowseMapper.deletePortalBrowseByBrowseId(browseId);
    }
}
