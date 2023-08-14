package com.trustbycode.Controller;

import com.trustbycode.Entity.ClientInfo;
import com.trustbycode.Exception.ClientNotFoundException;
import com.trustbycode.Service.ClientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    Logger logger = LoggerFactory.getLogger(ClientInfo.class);

    @PostMapping("/bank")
    public ClientInfo saveClientInfo(@Valid @RequestBody ClientInfo clientInfo){
        logger.info("Save to DB");
        return clientService.saveClientInfo(clientInfo);
    }

    @GetMapping("/bank")
    public List<ClientInfo> getAllClient(){
        logger.info("Clients Details Gotten From DB");
        return clientService.getAllClient();
    }

    @GetMapping("/bank/{id}")
    public ClientInfo getClientById(@PathVariable(name = "id") Long id) throws ClientNotFoundException {
        logger.info("Entry gotten by Id from DB");
        return clientService.getClientById(id);
    }

    @DeleteMapping("/bank/{id}")
    public String deleteById(@PathVariable(name = "id") Long id){
        logger.info("Deleted from DB");
        clientService.deleteById(id);
        return "Deleted Successfully";
    }

    @PutMapping("/bank/{id}")
    public ClientInfo updateClient(@PathVariable(name = "id") Long id,
                                   @RequestBody ClientInfo clientInfo){
        logger.info("Client Entry Updated");
        return clientService.updateClient(id, clientInfo);
    }

    @GetMapping("/bank/name/{name}")
    public ClientInfo fetchClientByName(@PathVariable(name = "name") String clientName){
        logger.info("Client Entry Gotten With Name");
        return clientService.fetchClientByName(clientName);
    }
}
