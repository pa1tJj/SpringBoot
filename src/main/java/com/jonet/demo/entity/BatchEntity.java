package com.jonet.demo.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "batch")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchEntity {
	@Id
	@GeneratedValue
	@UuidGenerator
    private UUID id;

    @Column(name = "batch_code", nullable = false, unique = true, length = 50)
    private String batchCode;

    @Column(name = "imported_by", length = 100)
    private String importedBy;

    @Column(name = "imported_at")
    private LocalDateTime importedAt;

    @Column(name = "status", length = 20)
    private String status = "PENDING"; // Mặc định là chờ duyệt

    // Quan hệ One-to-Many: 1 Batch có nhiều Data Rows
    // mappedBy trỏ đến tên biến "testBatch" nằm bên class TestDataRow
    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DataRows> dataRows;

    // Tự động gán thời gian hiện tại trước khi lưu vào DB
    @PrePersist
    protected void onCreate() {
        this.importedAt = LocalDateTime.now();
    }
}
