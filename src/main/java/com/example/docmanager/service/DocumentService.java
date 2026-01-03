package com.example.docmanager.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.docmanager.dao.DocumentDetailDao;
import com.example.docmanager.dto.DocumentDetailResponse;
import com.example.docmanager.exception.ResourceNotFoundException;
import com.example.docmanager.model.DocumentDetailModel;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DocumentService {
    private final DocumentDetailDao documentDetailDao;

    @Transactional(readOnly = true)
    public DocumentDetailResponse getDetail(Long id) {
        // 1. ドキュメント・バージョン取得
        DocumentDetailModel documentDetailModel = documentDetailDao.findDocumentDetail(id)
            .orElseThrow(() -> new ResourceNotFoundException("resource not found: " + id));
        
        // 2. ドキュメントタグ取得
        List<String> documentTag = documentDetailDao.findTagNameByDocumentId(id);

        // 3. レスポンス
        DocumentDetailResponse response = new DocumentDetailResponse();
        BeanUtils.copyProperties(documentDetailModel, response);
        response.setUploadDate(documentDetailModel.getUploadedAt());
        response.setTags(documentTag);
        response.setFileUrl("/api/documents/" + id + "/download");
        response.setThumbnailUrl("/api/documents/" + id + "/thumbnail");
        return response;
    }
}
