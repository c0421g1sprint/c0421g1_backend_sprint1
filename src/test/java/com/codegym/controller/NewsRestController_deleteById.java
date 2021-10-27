package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NewsRestController_deleteById {

    @Autowired
    private MockMvc mockMvc;

    // Test null
    @Test
    public void deleteById_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/news/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test rỗng
    @Test
    public void deleteById_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/news/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test id không tồn tại trong DB
    @Test
    public void deleteById_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/news/delete/{id}", "8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test id tồn tại trong DB
    @Test
    public void deleteById_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/news/delete/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
