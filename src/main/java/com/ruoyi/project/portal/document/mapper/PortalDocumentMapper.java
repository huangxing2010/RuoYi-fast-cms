package com.ruoyi.project.portal.document.mapper;

import java.util.List;
import com.ruoyi.project.portal.document.domain.PortalDocument;

/**
 * 文件下载Mapper接口
 * 
 * @author huangxing
 * @date 2024-11-01
 */
public interface PortalDocumentMapper 
{
    /**
     * 查询文件下载
     * 
     * @param docId 文件下载主键
     * @return 文件下载
     */
    public PortalDocument selectPortalDocumentByDocId(Long docId);

    /**
     * 查询文件下载列表
     * 
     * @param portalDocument 文件下载
     * @return 文件下载集合
     */
    public List<PortalDocument> selectPortalDocumentList(PortalDocument portalDocument);

    /**
     * 新增文件下载
     * 
     * @param portalDocument 文件下载
     * @return 结果
     */
    public int insertPortalDocument(PortalDocument portalDocument);

    /**
     * 修改文件下载
     * 
     * @param portalDocument 文件下载
     * @return 结果
     */
    public int updatePortalDocument(PortalDocument portalDocument);

    /**
     * 删除文件下载
     * 
     * @param docId 文件下载主键
     * @return 结果
     */
    public int deletePortalDocumentByDocId(Long docId);

    /**
     * 批量删除文件下载
     * 
     * @param docIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalDocumentByDocIds(String[] docIds);
}
