package org.example.ensabillingservice.openfeign;


import org.example.ensabillingservice.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestClient {
    @GetMapping(path = "/api/clients/{id}")
    Client getClient(@PathVariable(name = "id") int id);
    @GetMapping(path = "/api/clients")
    List<Client> allClients();
}
