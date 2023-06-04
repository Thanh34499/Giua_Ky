package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPBRepository extends JpaRepository<PhongBan, Long>{
}