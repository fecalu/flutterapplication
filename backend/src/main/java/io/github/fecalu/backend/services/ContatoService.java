package io.github.fecalu.backend.services;

import io.github.fecalu.backend.repositories.ContatoRepository;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }
}
