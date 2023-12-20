package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.ClientDto;
import org.acme.mapper.ClientMapper;
import org.acme.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClientService {
    private final ClientRepository clientRepository;

    @Inject
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<ClientDto> getAllClients(){
        return clientRepository.findAll().stream().map(ClientMapper::toDTO).collect(Collectors.toList());
    }

    public ClientDto saveClient(ClientDto clientDto) {
        return ClientMapper.toDTO(
                clientRepository.save(ClientMapper.toEntity(clientDto))
        );
    }
}
