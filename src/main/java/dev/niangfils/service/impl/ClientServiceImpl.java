package dev.niangfils.service.impl;

import dev.niangfils.domain.Client;
import dev.niangfils.repository.ClientRepository;
import dev.niangfils.service.ClientService;
import dev.niangfils.service.dto.ClientDTO;
import dev.niangfils.service.mapper.ClientMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Client}.
 */
@Service
@Transactional
public class ClientServiceImpl {

    private final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client updateClient(Client client) {
        Optional<Client> newClient = clientRepository.findById(client.getId());
        newClient.get().setEmail(client.getEmail());
        newClient.get().setJobTitle(client.getJobTitle());
        newClient.get().setName(client.getName());
        newClient.get().setPhone(client.getPhone());
        return clientRepository.save(newClient.get());
    }

    public void deleteClient(Long clientID) {
        clientRepository.deleteById(clientID);
    }
}
