package com.jonet.demo.entity;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "datarows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataRows {
	@Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;

    // Quan hệ Many-to-One: Nhiều dòng dữ liệu thuộc về 1 Batch
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    private BatchEntity batch;

    @Column(name = "employee_code", nullable = false, length = 20)
    private String employeeCode;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(name = "department", length = 50)
    private String department;

    @Column(name = "salary", precision = 15, scale = 2)
    private BigDecimal salary; // Dùng BigDecimal cho tiền tệ để tránh sai số

    @Column(name = "row_index")
    private Integer rowIndex; // Lưu lại số dòng trong Excel (ví dụ: dòng 2, dòng 3) để dễ trace lỗi
}
