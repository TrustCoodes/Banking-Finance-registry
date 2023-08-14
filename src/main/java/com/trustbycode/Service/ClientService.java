package com.trustbycode.Service;

import com.trustbycode.Entity.ClientInfo;
import com.trustbycode.Exception.ClientNotFoundException;

import java.util.List;

public interface ClientService {
   public ClientInfo saveClientInfo(ClientInfo clientInfo);

   List<ClientInfo> getAllClient();

   ClientInfo getClientById(Long id) throws ClientNotFoundException;

   void deleteById(Long id);

   ClientInfo updateClient(Long id, ClientInfo clientInfo);

   ClientInfo fetchClientByName(String clientName);
}
