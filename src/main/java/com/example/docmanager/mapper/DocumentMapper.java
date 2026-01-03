package com.example.docmanager.mapper;

import org.mapstruct.Mapper;

import com.example.docmanager.dto.DocumentDetailResponse;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    
    DocumentDetailResponse toResponse(DocumentDetailResponse documentDetail);
}
