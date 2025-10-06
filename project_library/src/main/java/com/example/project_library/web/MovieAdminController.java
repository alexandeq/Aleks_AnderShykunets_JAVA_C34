package com.example.project_library.web;

import com.example.project_library.client.MovieClient;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie/admin")
public class MovieAdminController {

    private final MovieService service;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("movies", service.findAll());
        return "admin";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("movie", new MovieDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute MovieDto dto) {
        service.create(dto);
        return "redirect:/movie/admin";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/movie/admin";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("movie", service.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("movie") MovieDto dto) {
        service.update(dto.getId(), dto);
        return "redirect:/movie/admin";
    }
}
