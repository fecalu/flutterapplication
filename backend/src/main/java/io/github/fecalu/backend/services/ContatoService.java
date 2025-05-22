package io.github.fecalu.backend.services;

import io.github.fecalu.backend.dto.ContatoCreateDTO;
import io.github.fecalu.backend.dto.ContatoResponseDTO;
import io.github.fecalu.backend.exceptions.ContatoJaCadastradoException;
import io.github.fecalu.backend.exceptions.EmailJaCadastradoException;
import io.github.fecalu.backend.model.Contato;
import io.github.fecalu.backend.repositories.ContatoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final ModelMapper modelMapper;

    public ContatoService(ContatoRepository contatoRepository, ModelMapper modelMapper) {
        this.contatoRepository = contatoRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public ContatoResponseDTO criarUsuario(ContatoCreateDTO contatoCreateDTO) {
        validarDTO(contatoCreateDTO);
        Contato contato = modelMapper.map(contatoCreateDTO, Contato.class);
        Contato contatoSalvo = contatoRepository.save(contato);
        return modelMapper.map(contatoSalvo, ContatoResponseDTO.class);
    }

    private void validarDTO(ContatoCreateDTO contatoCreateDTO) {
        if(contatoRepository.existsByNumeroTelefone(contatoCreateDTO.getNumeroTelefone())) {
            throw new ContatoJaCadastradoException("Número de telefone já cadastrado");
        }
        if(contatoRepository.existsByEmail(contatoCreateDTO.getEmail())) {
            throw new EmailJaCadastradoException("E-mail já cadastrado");
        }
    }

}
