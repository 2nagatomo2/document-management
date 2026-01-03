package com.example.docmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.docmanager.dto.DocumentDetailResponse;
import com.example.docmanager.entity.Document;
import com.example.docmanager.service.DocumentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/documents")
@AllArgsConstructor
public class DocumentController {
    private DocumentService documentService;

    @PostMapping()
    public DocumentDetailResponse postDocument(@Valid Document document) {
        return new DocumentDetailResponse();
    }

    @GetMapping("/{id}")
    public DocumentDetailResponse getDocument(@PathVariable(name = "id") Long id) {
        return documentService.getDetail(id);
    }

    @PutMapping("/{id}")
    public DocumentDetailResponse putDocument(@PathVariable(name = "id") Long id) {
        return new DocumentDetailResponse();
    }
}
