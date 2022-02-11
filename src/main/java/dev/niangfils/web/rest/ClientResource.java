package dev.niangfils.web.rest;

import dev.niangfils.domain.Client;
import dev.niangfils.repository.ClientRepository;
import dev.niangfils.security.AuthoritiesConstants;
import dev.niangfils.service.ClientService;
import dev.niangfils.service.dto.ClientDTO;
import dev.niangfils.service.impl.ClientServiceImpl;
import dev.niangfils.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link dev.niangfils.domain.Client}.
 */
@RestController
@RequestMapping("/api")
public class ClientResource {

    private final Logger log = LoggerFactory.getLogger(ClientResource.class);

    private static final String ENTITY_NAME = "client";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ClientServiceImpl clientService;

    public ClientResource(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    @Secured({ AuthoritiesConstants.ADMIN })
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client result = clientService.save(client);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/clients/{id}")
    @Secured({ AuthoritiesConstants.ADMIN })
    public ResponseEntity<Client> updateClient(@RequestBody Client client) throws URISyntaxException {
        Client newCli = clientService.save(client);
        return new ResponseEntity<>(newCli, HttpStatus.OK);
    }

    @GetMapping("/clients")
    @Secured({ AuthoritiesConstants.USER })
    public ResponseEntity<List<Client>> getAllClients() {
        log.debug("REST request to get all Clients");
        List<Client> list = clientService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/clients/{id}")
    @Secured({ AuthoritiesConstants.ADMIN })
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
