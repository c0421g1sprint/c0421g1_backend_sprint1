package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_getInfoAccount {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfoAccount_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/accounts/detailAccount/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getInfoAccount_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/detailAccount/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getInfoStudent_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/detail/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.accountUsername").value("name1234"))
                .andExpect(jsonPath("$.accountPassword").value("N1234234"))
                .andExpect(jsonPath("$.accountEmail").value("duv@gmail.com"));
    }

}
