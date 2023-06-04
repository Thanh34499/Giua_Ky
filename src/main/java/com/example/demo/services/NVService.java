package com.example.demo.services;

import com.example.demo.entity.Book;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.IBookRepository;
import com.example.demo.repository.iNVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NVService {
    @Autowired
    private iNVRepository iNVRepository;

    public List<NhanVien> getAllNV() {
        return iNVRepository.findAll();

    }

    public NhanVien getNVById(Long id) {
        return iNVRepository.findById(id).orElse(null);
    }

    public void addNV(NhanVien nhanVien) {
        iNVRepository.save(nhanVien);
    }

    public void deleteNV(Long id) {
        iNVRepository.deleteById(id);
    }

    public void updateNV(NhanVien nv) {
        iNVRepository.save(nv);
    }
}