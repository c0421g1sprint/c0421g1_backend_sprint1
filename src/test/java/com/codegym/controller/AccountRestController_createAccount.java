package com.codegym.controller;
import com.codegym.entity.about_account.AccountDto;
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
public class AccountRestController_createAccount {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createAccount_accountName_13() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountUsername(null);
        accountDto.setAccountPassword("123123");
        accountDto.setAccountEmail("duc@gmail.com");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/createAccount")
                .content(this.objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createAccount_accountName_14() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountUsername("");
        accountDto.setAccountPassword("123123");
        accountDto.setAccountEmail("duc@gmail.com");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/createAccount")
                .content(this.objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createAccount_accountName_18() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountUsername("Hà");

        accountDto.setAccountPassword("12345");
        accountDto.setAccountEmail("Duc@gmail.com");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/createAccount")
                .content(this.objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
