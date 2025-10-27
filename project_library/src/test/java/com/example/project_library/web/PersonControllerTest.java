package com.example.project_library.web;

import com.example.project_library.dto.PersonDto;
import com.example.project_library.service.MovieUserService;
import com.example.project_library.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonController.class)
@AutoConfigureMockMvc(addFilters = false)
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    private PersonService service;


    @Test
    @DisplayName("тест проверяет, что при успешной регистрации пользователь получает сообщение о успехе")
    void registerShouldReturnSuccessPageWhenValid() throws Exception {
        // given
        PersonDto dto = new PersonDto();
        dto.setUsername("john");
        dto.setPassword("pass1");
        dto.setAuthority("USER");

        given(service.register(any(PersonDto.class))).willReturn(dto);

        // when then
        mockMvc.perform(post("/register")
                        .flashAttr("user", dto))
                .andExpect(status().isOk())
                .andExpect(view().name("success"))
                .andExpect(model().attributeExists("message"));
    }



    @Test
    @DisplayName("тест проверяет, что логин прошел успешно")
    void loginPage_ShouldReturnLoginView() throws Exception {

        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

}