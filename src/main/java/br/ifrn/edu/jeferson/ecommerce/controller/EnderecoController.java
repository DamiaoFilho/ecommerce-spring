package br.ifrn.edu.jeferson.ecommerce.controller;

import br.ifrn.edu.jeferson.ecommerce.domain.dtos.Endereco.EnderecoRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.Endereco.EnderecoResponseDTO;
import br.ifrn.edu.jeferson.ecommerce.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/enderecos")
@Tag(name = "Endereços", description = "API de gerenciamento de endereços dos clientes")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Operation(summary = "Criar novo endereço")
    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> salvar(@RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        return ResponseEntity.ok(enderecoService.salvar(enderecoRequestDTO));
    }
}
