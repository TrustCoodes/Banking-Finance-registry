package com.trustbycode.Controller;

import com.trustbycode.Entity.ClientInfo;
import com.trustbycode.Exception.ClientNotFoundException;
import com.trustbycode.Service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ClientControllerTest {
    @MockBean
    ClientService clientService;

    @Autowired
    MockMvc mockMvc;

    ClientInfo clientInfo;

    @BeforeEach
    void setUp() {
        clientInfo = ClientInfo.builder()
                .clientName("Grey Man")
                .accountNumber("303030448")
                .email("grey@gmail.com")
                .build();
    }

    @Test
    void saveClientInfo() throws Exception {
        ClientInfo info = ClientInfo.builder()
                .clientName("Grey Man")
                .accountNumber("303030448")
                .email("grey@gmail.com")
                .build();

        Mockito.when(clientService.saveClientInfo(clientInfo)).thenReturn(clientInfo);

        mockMvc.perform(post("/bank")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                "\t\"clientName\": \"GF\",\n" +
                "\t\"accountNumber\": \"402616171\",\n" +
                "\t\"email\": \"tolurinnie@durble.com\"\n" +
                "}"))
                .andExpect(status()
                        .isOk());
    }

    @Test
    void getClient_By_Id_If_Found() throws Exception {
        Mockito.when(clientService.getClientById(1L)).thenReturn(clientInfo);

        mockMvc.perform(get("/bank/1")).andExpect(status().isOk());
    }

    @Test
    void updateClient_found() throws Exception {
        Mockito.when(clientService.updateClient(1L, clientInfo)).thenReturn(clientInfo);


        mockMvc.perform(put("/bank/1").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "\t\"clientName\": \"goatham\",\n" +
                "\t\"accountNumber\": \"454555555555\",\n" +
                "\t\"email\": \"tolurinnie@durble.com\"\n" +
                "}")).andExpect(status().isOk());
    }
}