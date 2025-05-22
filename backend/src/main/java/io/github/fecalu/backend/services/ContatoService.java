package io.github.fecalu.backend.services;

import io.github.fecalu.backend.dto.ContatoCreateDTO;
import io.github.fecalu.backend.dto.ContatoResponseDTO;
import io.github.fecalu.backend.dto.ContatoUpdateDTO;
import io.github.fecalu.backend.exceptions.ContatoJaCadastradoException;
import io.github.fecalu.backend.exceptions.ContatoNaoEncontradoException;
import io.github.fecalu.backend.exceptions.EmailJaCadastradoException;
import io.github.fecalu.backend.model.Contato;
import io.github.fecalu.backend.repositories.ContatoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    @Transactional(readOnly = true)
    public Page<ContatoResponseDTO> listarContatos(String descricao, int pageSize, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Contato> contatos = contatoRepository.findContatosByDescricao(descricao, pageable);
        return contatos.map(contato -> modelMapper.map(contato, ContatoResponseDTO.class));
    }

    @Transactional
    public void atualizarContato(ContatoUpdateDTO dto) {

        Contato contatoExistente = contatoRepository.findById(dto.getId())
                .orElseThrow(() -> new ContatoNaoEncontradoException("Contato não encontrado com ID: " + dto.getId()));

        if (StringUtils.hasText(dto.getNumeroTelefone()) &&
                !dto.getNumeroTelefone().equals(contatoExistente.getNumeroTelefone()) &&
                contatoRepository.existsByNumeroTelefone(dto.getNumeroTelefone())) {
            throw new ContatoJaCadastradoException("Número de telefone já cadastrado");
        }

        if (StringUtils.hasText(dto.getEmail()) &&
                (contatoExistente.getEmail() == null || !dto.getEmail().equals(contatoExistente.getEmail())) &&
                contatoRepository.existsByEmail(dto.getEmail())) {
            throw new EmailJaCadastradoException("E-mail já cadastrado");
        }

        if (StringUtils.hasText(dto.getNome())) {
            contatoExistente.setNome(dto.getNome());
        }

        if (StringUtils.hasText(dto.getSobrenome())) {
            contatoExistente.setSobrenome(dto.getSobrenome());
        }

        if (dto.getDataNascimento() != null) {
            contatoExistente.setDataNascimento(dto.getDataNascimento());
        }

        if (StringUtils.hasText(dto.getNumeroTelefone())) {
            contatoExistente.setNumeroTelefone(dto.getNumeroTelefone());
        }

        if (StringUtils.hasText(dto.getEmail())) {
            contatoExistente.setEmail(dto.getEmail());
        }

        if (dto.getIsFamilia() != null) {
            contatoExistente.setFamilia(dto.getIsFamilia());
        }

        contatoRepository.save(contatoExistente);
    }

    private void validarDTO(ContatoCreateDTO contatoCreateDTO) {
        if (contatoRepository.existsByNumeroTelefone(contatoCreateDTO.getNumeroTelefone())) {
            throw new ContatoJaCadastradoException("Número de telefone já cadastrado");
        }
        if (contatoRepository.existsByEmail(contatoCreateDTO.getEmail())) {
            throw new EmailJaCadastradoException("E-mail já cadastrado");
        }
    }

}
