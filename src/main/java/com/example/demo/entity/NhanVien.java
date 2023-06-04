package com.example.demo.entity;

import com.example.demo.validator.annotation.ValidCategoryId;
import com.example.demo.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Tên nv")
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private String name;
    @Column(name = "Phai")
    private String phai;
    @Column(name = "Quê quán")
    private String que;
    @Column(name = "Luong")
    @NotNull(message = "Luong!?")
    private Double luong;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Ma PB")
    private PhongBan phongBan;
}
