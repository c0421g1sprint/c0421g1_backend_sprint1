package com.codegym.controller;

import com.codegym.dto.LoginRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasItems;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountController_loginAccount {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void loginAccount_0() throws  Exception {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setUsername("");
        loginRequestDto.setPassword("1234567");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                .content(this.objectMapper.writeValueAsString(loginRequestDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void loginAccount_1() throws Exception {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setUsername("admin");
        loginRequestDto.setPassword("");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                .content(this.objectMapper.writeValueAsString(loginRequestDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void loginAccount_3() throws Exception {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setUsername(null);
        loginRequestDto.setPassword("1254");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                .content(this.objectMapper.writeValueAsString(loginRequestDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void loginAccount_4() throws Exception {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setUsername("admin");
        loginRequestDto.setPassword(null);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                .content(this.objectMapper.writeValueAsString(loginRequestDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void loginAccount_5() throws Exception {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setUsername("quanvuluubiquanvuluubiquanvuluubiquanvuluubi");
        loginRequestDto.setPassword("12345214");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                .content(this.objectMapper.writeValueAsString(loginRequestDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void loginAccount_6() throws Exception {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setUsername("admin");
        loginRequestDto.setPassword("quanvuluubiquanvuluubiquanvuluubiquanvuluubi");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                .content(this.objectMapper.writeValueAsString(loginRequestDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
//    Tai khoan admin co 2 ROlE: ADMIN va USER
    public void loginAccount_7() throws Exception {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setUsername("admin");
        loginRequestDto.setPassword("123456");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                .content(this.objectMapper.writeValueAsString(loginRequestDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.username").value("admin"))
                .andExpect(jsonPath("$.roles", hasItems("ROLE_ADMIN")))
                .andExpect(jsonPath("$.roles", hasItems("ROLE_USER")));
    }
}
