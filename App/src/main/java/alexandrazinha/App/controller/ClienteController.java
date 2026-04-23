package alexandrazinha.App.controller;

import alexandrazinha.App.domain.ClienteDTO;
import alexandrazinha.App.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable @Valid Long id){
        return ResponseEntity.ok(service.pegarById(id));
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> saveCliente(@RequestBody @Valid ClienteDTO dto, UriComponentsBuilder builder){

        ClienteDTO dtosalvo = service.salvarCliente(dto);
        URI uri = builder.path("/cliente/{id}").buildAndExpand(dtosalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(dtosalvo);
    }

}
