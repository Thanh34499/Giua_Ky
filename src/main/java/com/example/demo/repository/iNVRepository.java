package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iNVRepository extends JpaRepository<NhanVien, Long>{
}