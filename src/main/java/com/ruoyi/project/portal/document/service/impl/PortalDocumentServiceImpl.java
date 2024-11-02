package com.ruoyi.project.portal.document.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.AESEncrypter;
import com.ruoyi.common.utils.security.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.portal.document.mapper.PortalDocumentMapper;
import com.ruoyi.project.portal.document.domain.PortalDocument;
import com.ruoyi.project.portal.document.service.IPortalDocumentService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 文件下载Service业务层处理
 * 
 * @author huangxing
 * @date 2024-11-01
 */
@Service
public class PortalDocumentServiceImpl implements IPortalDocumentService 
{
    @Autowired
    private PortalDocumentMapper portalDocumentMapper;

    /**
     * 查询文件下载
     * 
     * @param docId 文件下载主键
     * @return 文件下载
     */
    @Override
    public PortalDocument selectPortalDocumentByDocId(Long docId)
    {
        PortalDocument portalDocument = portalDocumentMapper.selectPortalDocumentByDocId(docId);
        if(portalDocument.getIsLock().equals("1") && StringUtils.isNotEmpty(portalDocument.getPassword())) {
            //解密
            portalDocument.setPassword(decryptPassword(portalDocument.getPassword()));
        }
        return portalDocument;
    }

    /**
     * 查询文件下载列表
     * 
     * @param portalDocument 文件下载
     * @return 文件下载
     */
    @Override
    public List<PortalDocument> selectPortalDocumentList(PortalDocument portalDocument)
    {
        return portalDocumentMapper.selectPortalDocumentList(portalDocument);
    }

    /**
     * 新增文件下载
     * 
     * @param portalDocument 文件下载
     * @return 结果
     */
    @Override
    public int insertPortalDocument(PortalDocument portalDocument)
    {
        portalDocument.setCreateBy(ShiroUtils.getLoginName());
        portalDocument.setCreateTime(DateUtils.getNowDate());
        //加密算法必须放到 try catch 中
        if(portalDocument.getIsLock().equals("1") && StringUtils.isNotEmpty(portalDocument.getPassword())){
            portalDocument.setPassword(encryptPassword(portalDocument.getPassword()));
        }
        return portalDocumentMapper.insertPortalDocument(portalDocument);
    }

    /**
     * 修改文件下载
     * 
     * @param portalDocument 文件下载
     * @return 结果
     */
    @Override
    public int updatePortalDocument(PortalDocument portalDocument)
    {
        portalDocument.setUpdateTime(DateUtils.getNowDate());
        //加密算法必须放到 try catch 中
        if(portalDocument.getIsLock().equals("1") && StringUtils.isNotEmpty(portalDocument.getPassword())){
            portalDocument.setPassword(encryptPassword(portalDocument.getPassword()));
        }
        return portalDocumentMapper.updatePortalDocument(portalDocument);
    }

    /**
     * 加密算法
     * @param password
     * @return
     */
    private String encryptPassword(String password) {
            try {
                String key = "abc@321#DEF45676"; // 16 bytes key for AES-128
                return AESEncrypter.encrypt(key, password);
            } catch (Exception e){
                e.getMessage();
                return null;
            }
    }

    /**
     * 解密算法
     * @param password
     * @return
     */
    private String decryptPassword(String password) {
        try {
            String key = "abc@321#DEF45676"; // 16 bytes key for AES-128
            return AESEncrypter.decrypt(key, password);
        } catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    /**
     * 批量删除文件下载
     * 
     * @param docIds 需要删除的文件下载主键
     * @return 结果
     */
    @Override
    public int deletePortalDocumentByDocIds(String docIds)
    {
        return portalDocumentMapper.deletePortalDocumentByDocIds(Convert.toStrArray(docIds));
    }

    /**
     * 删除文件下载信息
     * 
     * @param docId 文件下载主键
     * @return 结果
     */
    @Override
    public int deletePortalDocumentByDocId(Long docId)
    {
        return portalDocumentMapper.deletePortalDocumentByDocId(docId);
    }
}
