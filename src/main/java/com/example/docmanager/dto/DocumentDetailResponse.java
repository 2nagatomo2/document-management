package com.example.docmanager.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DocumentDetailResponse {
    
    private Long id;

    private String title;

    private List<String> tags;

    private String uploadedBy;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime uploadDate;

    private Integer version;

    private String fileUrl;

    private String thumbnailUrl;

}
