package com.trustbycode.Repository;

import com.trustbycode.Entity.ClientInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClientRepositoryTest {
    @Autowired
    ClientRepository clientRepository;

    ClientInfo info;

    @BeforeEach
    void setUp() {
        info = ClientInfo.builder()
                .clientName("Fred")
                .accountNumber("337373737")
                .email("goboy@gmail.com")
                .build();
        clientRepository.save(info);
    }

    @Test
    public void ifClientName_then_found(){
        ClientInfo clientInfo = clientRepository.findByClientName("Fred");
        assertThat(clientInfo.getClientName()).isEqualTo(clientInfo.getClientName());
    }

    @Test
    public void ifClient_Not_Found(){
        ClientInfo clientInfo = clientRepository.findByClientName("Jimmy");
        assertThat(info.getClientName().isEmpty());
    }
}