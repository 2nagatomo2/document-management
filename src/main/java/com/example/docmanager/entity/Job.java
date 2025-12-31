package com.example.docmanager.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "job")
@Getter
@Setter
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String type;

    @Nonnull
    private String status;

    @Column(name = "document_id")
    private Long documentId;

    @Column(name = "version_id")
    private Long versionId;

    private String payload;  // JSONB型

    @Column(name = "sqs_message_id")
    private String sqsMessageId;

    @Nonnull
    private Integer attempts;

    @Column(name = "next_run_at")
    private LocalDateTime nextRunAt;

    @Nonnull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Nonnull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
