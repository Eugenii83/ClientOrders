package ru.evggol.clientorders.clients;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/clients")
public class ClientController {

    @PostMapping
    public ResponseEntity<Client> createClient(
            @RequestBody Client createdClient
    ) {
        Client client = new Client();

        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
