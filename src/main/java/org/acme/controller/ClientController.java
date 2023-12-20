package org.acme.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.ClientDto;
import org.acme.service.ClientService;

import java.util.List;

@Path("/v1/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ClientController {

    private final ClientService clientService;

    @Inject
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GET
    public List<ClientDto> getAllClients(){
        return clientService.getAllClients();
    }

    @POST
    public ClientDto saveClient(ClientDto clientDto){
        return clientService.saveClient(clientDto);
    }
}
