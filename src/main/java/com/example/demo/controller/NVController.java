package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.NhanVien;
import com.example.demo.services.BookService;
import com.example.demo.services.CategoryService;
import com.example.demo.services.NVService;
import com.example.demo.services.PBService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Nhanvien")
public class NVController {
    @Autowired
    private NVService nvService;
    @Autowired
    private PBService pbService;
    @GetMapping
    public String showAll(Model model){
        List<NhanVien> nv = nvService.getAllNV();
        model.addAttribute("nvs", nv);
        return "Nhanvien/index";
    }
    @GetMapping("/add")
    public String addNVForm(Model model) {
        model.addAttribute("nv", new NhanVien());
        model.addAttribute("pb", pbService.getALLPB());
        return "Nhanvien/add";
    }
    @PostMapping("/add")
    public String addNV(@ModelAttribute("nhanvien") NhanVien nv){
        nvService.addNV(nv);
        return "redirect:/Nhanvien";
    }
    @PostMapping("/delete/{id}")
    public String deleteNV(@PathVariable("id") long id){
        nvService.deleteNV(id);
        return "redirect:/nvs";
    }
    @GetMapping("/edit/{id}")
    public String editNVForm(@PathVariable("id") long id, Model model){
        NhanVien nv = nvService.getNVById(id);
        if(nv != null){
            model.addAttribute("nv", nv);
            model.addAttribute("pb", pbService.getALLPB());
            return "index";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editNV(@Valid @ModelAttribute("nv")NhanVien updateNV, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("pb", pbService.getALLPB());
            return "index";
        }
        nvService.getAllNV().stream()
                .filter(book -> book.getId() == updateNV.getId())
                .findFirst()
                .ifPresent(book -> {

                    nvService.updateNV(updateNV);
                });
        return "redirect:/nvs";
    }
}
