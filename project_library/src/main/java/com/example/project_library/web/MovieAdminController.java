package com.example.project_library.web;

import com.example.project_library.dto.MovieDto;
import com.example.project_library.dto.PosterDto;
import com.example.project_library.service.MovieAdminService;
import com.example.project_library.service.MovieUserService;
import com.example.project_library.service.PosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie/admin")
public class MovieAdminController {

    private final MovieAdminService service;
    private final MovieUserService userService;
    private final PosterService posterService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("movies", userService.findAll());
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


    @PostMapping("/{id}/poster")
    public String uploadPoster(@PathVariable UUID id, @RequestParam("poster") MultipartFile poster, Model model) throws IOException {
        PosterDto savedPoster = posterService.addPoster(id, poster);
        model.addAttribute("posterUrl", "/movie/admin/" + id + "/poster");
        model.addAttribute("movieId", id);
        model.addAttribute("message", "Постер успешно загружен!");
        return "poster";
    }


    @GetMapping("/{id}/poster")
    public String poster(@PathVariable UUID id, Model model) {
        model.addAttribute("movieId", id);
        return "poster";
    }


}



