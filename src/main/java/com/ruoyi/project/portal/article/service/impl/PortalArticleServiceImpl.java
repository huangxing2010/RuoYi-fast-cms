package com.ruoyi.project.portal.article.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.portal.article.domain.PortalArticle;
import com.ruoyi.project.portal.article.mapper.PortalArticleMapper;
import com.ruoyi.project.portal.article.service.IPortalArticleService;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.dept.mapper.DeptMapper;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章内容Service业务层处理
 * 
 * @author huangxing
 * @date 2024-04-05
 */
@Service
public class PortalArticleServiceImpl implements IPortalArticleService 
{
    @Autowired
    private PortalArticleMapper portalArticleMapper;

    @Autowired
    private IUserService userService;


    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询文章内容
     * 
     * @param articleId 文章内容主键
     * @return 文章内容
     */
    @Override
    public PortalArticle selectPortalArticleByArticleId(Long articleId)
    {
        return portalArticleMapper.selectPortalArticleByArticleId(articleId);
    }

    /**
     * 查询文章内容列表
     * 
     * @param portalArticle 文章内容
     * @return 文章内容
     */
    @Override
    public List<PortalArticle> selectPortalArticleList(PortalArticle portalArticle)
    {
        //根据当前用户查询所在部门
        User user = userService.selectUserByLoginName(ShiroUtils.getLoginName());
        //查询是否有子部门，=0表示无，>0表示有
        int i = deptMapper.selectNormalChildrenDeptById(user.getDeptId());
        if(i == 0){
            portalArticle.setDeptId(user.getDeptId());
            portalArticle.setShowStatus("0");
            PageUtils.startPage();
            return portalArticleMapper.selectPortalArticleList(portalArticle);
        }else {
            portalArticle.setShowStatus("0");
            PageUtils.startPage();
            return portalArticleMapper.selectPortalArticleList(portalArticle);
        }

    }

    /**
     * 查询全部文章内容列表
     *
     * @param portalArticle 文章内容
     * @return 文章内容
     */
    @Override
    public List<PortalArticle> selectPortalArticleAll(PortalArticle portalArticle)
    {return portalArticleMapper.selectPortalArticleList(portalArticle);}

    /**
     * 递归得到子部门ID数组
     * @param depts
     * @param myDeptId
     * @return
     */
    private Long[] deptIds(List<Dept> depts,Long myDeptId){
        //遍历得到子部门id数组
        List<Long> deptIds = new ArrayList<>();
        //请勿忽略自己所在部门
        deptIds.add(myDeptId);
        depts.forEach( item -> {
            deptIds.add(item.getDeptId());
        });
        //List<Long>转Long[]
        Long[] array = deptIds.toArray(new Long[deptIds.size()]);
        return array;
    }

    /**
     * 查询单页内容列表
     *
     * @param portalArticle 文章内容
     * @return 文章内容
     */
    @Override
    public List<PortalArticle> selectPortalPagesList(PortalArticle portalArticle)
    {
        portalArticle.setArtType("1");//0表示文章 1单页面 2专题
        portalArticle.setShowStatus("0");
        return portalArticleMapper.selectPortalArticleList(portalArticle);
    }



    /**
     * 新增文章内容
     * 
     * @param portalArticle 文章内容
     * @return 结果
     */
    @Override
    public int insertPortalArticle(PortalArticle portalArticle)
    {
        User user = userService.selectUserByLoginName(ShiroUtils.getLoginName());
        portalArticle.setDeptId(user.getDeptId());
        portalArticle.setCreateBy(ShiroUtils.getLoginName());
        portalArticle.setCreateTime(DateUtils.getNowDate());
        if(user.getDeptId() == 100 || user.getDeptId() == 101){
            portalArticle.setCheckStatus("1");
        }else {
            portalArticle.setCheckStatus("0");
        }
        return portalArticleMapper.insertPortalArticle(portalArticle);
    }

    /**
     * 修改文章内容
     * 
     * @param portalArticle 文章内容
     * @return 结果
     */
    @Override
    public int updatePortalArticle(PortalArticle portalArticle)
    {
        portalArticle.setUpdateBy(ShiroUtils.getLoginName());
        portalArticle.setUpdateTime(DateUtils.getNowDate());
        return portalArticleMapper.updatePortalArticle(portalArticle);
    }

    /**
     * 批量删除文章内容
     * 
     * @param articleIds 需要删除的文章内容主键
     * @return 结果
     */
    @Override
    public int deletePortalArticleByArticleIds(String articleIds)
    {
        return portalArticleMapper.deletePortalArticleByArticleIds(Convert.toStrArray(articleIds));
    }

    /**
     * 删除文章内容信息
     * 
     * @param articleId 文章内容主键
     * @return 结果
     */
    @Override
    public int deletePortalArticleByArticleId(Long articleId)
    {
        return portalArticleMapper.deletePortalArticleByArticleId(articleId);
    }
}
