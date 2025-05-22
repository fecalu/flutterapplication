package io.github.fecalu.backend.controllers;

import io.github.fecalu.backend.dto.ContatoCreateDTO;
import io.github.fecalu.backend.dto.ContatoResponseDTO;
import io.github.fecalu.backend.services.ContatoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static io.github.fecalu.backend.utils.UriGenerator.generateUri;

@RestController
@RequestMapping("/contatos")
@CrossOrigin("*")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> salvarContato(@Valid @RequestBody ContatoCreateDTO contatoCreateDTO) {
        ContatoResponseDTO contatoResponseDTO = contatoService.criarUsuario(contatoCreateDTO);
        URI location = generateUri(contatoResponseDTO);
        return ResponseEntity.created(location).body(contatoResponseDTO);
    }
}
