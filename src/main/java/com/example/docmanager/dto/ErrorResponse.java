package com.example.docmanager.dto;

public record ErrorResponse(
    String error,
    String message
) {}