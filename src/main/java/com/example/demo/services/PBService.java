package com.example.demo.services;

import com.example.demo.entity.Category;
import com.example.demo.entity.PhongBan;
import com.example.demo.repository.ICategotyRepository;
import com.example.demo.repository.IPBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PBService {
    @Autowired
    private IPBRepository ipbRepository;
    public List<PhongBan> getALLPB() {
        return ipbRepository.findAll();
    }
}
