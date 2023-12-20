package org.acme.mapper;

import org.acme.dao.Client;
import org.acme.dto.ClientDto;

public class ClientMapper {
    public static Client toEntity(ClientDto clientDto){
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setCity(clientDto.getCity());
        client.setCompany(clientDto.getCompany());
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        return client;
    }

    public static ClientDto toDTO(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setCity(client.getCity());
        clientDto.setCompany(client.getCompany());
        clientDto.setName(client.getName());
        clientDto.setEmail(client.getEmail());
        return clientDto;
    }
}
