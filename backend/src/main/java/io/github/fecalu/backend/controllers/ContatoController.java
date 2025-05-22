package io.github.fecalu.backend.controllers;

import io.github.fecalu.backend.dto.ContatoCreateDTO;
import io.github.fecalu.backend.dto.ContatoResponseDTO;
import io.github.fecalu.backend.services.ContatoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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

    @GetMapping
    public ResponseEntity<Page<ContatoResponseDTO>> listarContatos(
            @RequestParam(name = "descricao", defaultValue = "", required = false) String descricao,
            @RequestParam(name = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "20", required = false) int pageSize
    ) {
        Page<ContatoResponseDTO> contatos = contatoService.listarContatos(descricao, pageSize, pageNumber);
        return ResponseEntity.ok(contatos);
    }


}
