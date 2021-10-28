package com.codegym.rest_controller;

import com.codegym.dto.EditPasswordAccountDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountController_editPassword {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void editPassword_19() throws Exception {
        EditPasswordAccountDto accountDto = new EditPasswordAccountDto();
        accountDto.setAccountPassword(null);
        accountDto.setConfirmPassword(null);
        accountDto.setAccountId(1);
        accountDto.setOldPassword("asd");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/editPass")
                .content(this.objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editPassword_20() throws Exception {
        EditPasswordAccountDto accountDto = new EditPasswordAccountDto();
        accountDto.setAccountPassword("");
        accountDto.setConfirmPassword("");
        accountDto.setAccountId(1);
        accountDto.setOldPassword("asd");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/editPass")
                .content(this.objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editPassword_21() throws Exception {
        EditPasswordAccountDto accountDto = new EditPasswordAccountDto();
        accountDto.setAccountPassword("      ");
        accountDto.setConfirmPassword("      ");
        accountDto.setAccountId(1);
        accountDto.setOldPassword("asd");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/editPass")
                .content(this.objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editPassword_22() throws Exception {
        EditPasswordAccountDto accountDto = new EditPasswordAccountDto();
        accountDto.setAccountPassword("aaa");
        accountDto.setConfirmPassword("aaa");
        accountDto.setAccountId(1);
        accountDto.setOldPassword("asd");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/editPass")
                .content(this.objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editPassword_23() throws Exception {
        EditPasswordAccountDto accountDto = new EditPasswordAccountDto();
        accountDto.setAccountPassword("sadddqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        accountDto.setConfirmPassword("sadddqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        accountDto.setAccountId(1);
        accountDto.setOldPassword("asd");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/editPass")
                .content(this.objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editPassword_24() throws Exception {
        EditPasswordAccountDto accountDto = new EditPasswordAccountDto();
        accountDto.setAccountPassword("7777777");
        accountDto.setConfirmPassword("7777777");
        accountDto.setAccountId(1);
        accountDto.setOldPassword("asd");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/public/editPass")
                .content(this.objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
