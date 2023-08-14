package com.trustbycode.Service.Implement;

import com.trustbycode.Entity.ClientInfo;
import com.trustbycode.Exception.ClientNotFoundException;
import com.trustbycode.Repository.ClientRepository;
import com.trustbycode.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientInfo saveClientInfo(ClientInfo clientInfo) {
        return clientRepository.save(clientInfo);
    }

    @Override
    public List<ClientInfo> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public ClientInfo getClientById(Long id) throws ClientNotFoundException {
        Optional<ClientInfo> clientInfo = clientRepository.findById(id);
        if (!clientInfo.isPresent()){
            throw new ClientNotFoundException("Client Not Found");
        }else {
            return clientInfo.get();
        }
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientInfo updateClient(Long id, ClientInfo clientInfo) {
        ClientInfo info = clientRepository.findById(id).get();
        info.setClientName(clientInfo.getClientName());
        info.setAccountNumber(clientInfo.getAccountNumber());
        info.setEmail(clientInfo.getEmail());
        return clientRepository.save(info);
    }

    @Override
    public ClientInfo fetchClientByName(String clientName) {
        return clientRepository.findByClientNameIgnoreCase(clientName);
    }


}