package com.example.docmanager.model;

import java.time.LocalDateTime;

import org.seasar.doma.Entity;

import lombok.Data;

@Entity
@Data
public class DocumentDetailModel {
        
    private Long id;

    private String title;

    private String uploadedBy;

    private LocalDateTime uploadedAt;

    private Integer version;

}
