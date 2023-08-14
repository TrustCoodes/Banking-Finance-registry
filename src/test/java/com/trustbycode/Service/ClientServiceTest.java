package com.trustbycode.Service;

import com.trustbycode.Entity.ClientInfo;
import com.trustbycode.Repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceTest {
    @Autowired
    ClientService clientService;

    @MockBean
    ClientRepository clientRepository;

    ClientInfo clientInfo;

    @BeforeEach
    void setUp() {
        clientInfo = ClientInfo.builder()
                .id(1L)
                .clientName("Thomas")
                .accountNumber("1010101010")
                .email("getlost@gmail.com")
                .build();

        Mockito.when(clientRepository
                .findByClientNameIgnoreCase("Thomas"))
                .thenReturn(clientInfo);
    }

    @Test
    public void whenClientInfo_Valid_then(){
        String clientName = "Thomas";
        ClientInfo clientInfoValid = clientService
                .fetchClientByName(clientName);
        assertEquals(clientName, clientInfoValid.getClientName());
    }
}