package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "Phongban")
public class PhongBan {
    @Id
    private String id;
    @Column(name = "Ma PB")
    private String name;
    @OneToMany(mappedBy = "phongBan" , fetch = FetchType.LAZY)
    private List<NhanVien> nhanVienList;
}
