package br.ifrn.edu.jeferson.ecommerce.mapper;

import br.ifrn.edu.jeferson.ecommerce.domain.Endereco;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.Endereco.EnderecoRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.Endereco.EnderecoResponseDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target="id", ignore=true)
    @Mapping(target="cliente", ignore = true)
    Endereco toEntity(EnderecoRequestDTO enderecoDTO);

    EnderecoResponseDTO toResponseDTO(Endereco endereco);
}
