package com.example.project_library.web;

import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.MovieAdminService;
import com.example.project_library.service.MovieUserService;
import com.example.project_library.service.PosterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieAdminController.class)
@AutoConfigureMockMvc(addFilters = false)
class MovieAdminControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    MovieUserService userService;
    @MockitoBean
    private MovieAdminService service;
    @MockitoBean
    private PosterService posterService;


    @Test
    @DisplayName("тест проверяет, что getAll возврвщает страницу админа со списком всех фильмов")
    void getAllShouldReturnAdminPageWithMovies() throws Exception {

        // given
        List<MovieDto> fakeMovies = List.of(new MovieDto());
        when(userService.findAll()).thenReturn(fakeMovies);

        // when / then
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/admin"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin"))
                .andExpect(MockMvcResultMatchers.model().attribute("movies", fakeMovies));

    }


    @Test
    @DisplayName("тест проверяет, что после удаления фильма происходит редирект и что удаление происходит 1 раз")
    void deleteShouldCallServiceAndRedirect() throws Exception {

        // given
        UUID id = UUID.randomUUID();

        // when then
        mockMvc.perform(post("/movie/admin/delete/{id}", id))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/movie/admin"));

        verify(service, times(1)).delete(id);
    }

    @Test
    @DisplayName(("тест проверяет, что после создания фильма вызывается редирект и что создание фильма выполняется 1 раз "))
    void createShouldCallServiceAndRedirect() throws Exception {

        // given
        String title = "Inception";
        int year = 2010;
        double rating = 9.0;

        // when then
        mockMvc.perform(post("/movie/admin/create")
                                .param("title", title)
                                .param("year", Integer.toString(year))
                                .param("rating", Double.toString(rating))
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/movie/admin"));

        verify(service, times(1)).create(any());

    }
}