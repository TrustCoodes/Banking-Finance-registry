package com.trustbycode.Repository;

import com.trustbycode.Entity.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository
        extends JpaRepository<ClientInfo, Long> {
    public ClientInfo findByClientName(String clientName);
    public ClientInfo findByClientNameIgnoreCase(String clientName);
}
