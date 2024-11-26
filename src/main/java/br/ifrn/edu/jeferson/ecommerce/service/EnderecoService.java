package br.ifrn.edu.jeferson.ecommerce.service;

import br.ifrn.edu.jeferson.ecommerce.domain.Cliente;
import br.ifrn.edu.jeferson.ecommerce.domain.Endereco;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.Categoria.CategoriaRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.Endereco.EnderecoRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.Endereco.EnderecoResponseDTO;
import br.ifrn.edu.jeferson.ecommerce.exception.BusinessException;
import br.ifrn.edu.jeferson.ecommerce.mapper.EnderecoMapper;
import br.ifrn.edu.jeferson.ecommerce.repository.ClienteRepository;
import br.ifrn.edu.jeferson.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public EnderecoResponseDTO salvar(EnderecoRequestDTO enderecoDTO) {
        var endereco = enderecoMapper.toEntity(enderecoDTO);

        Cliente client = clienteRepository.findById(enderecoDTO.getClienteId())
                        .orElseThrow(() -> new BusinessException("Cliente com ID especificado não existe"));

        if(client.getEndereco() != null){
            throw new BusinessException("Cliente já possui endereço");
        }

        endereco.setCliente(client);

        clienteRepository.save(client);
        enderecoRepository.save(endereco);

        return enderecoMapper.toResponseDTO(endereco);
    }
}
