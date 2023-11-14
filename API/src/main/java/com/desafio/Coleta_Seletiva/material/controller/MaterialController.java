package com.desafio.Coleta_Seletiva.material.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.Coleta_Seletiva.material.dto.MaterialCreateDTO;
import com.desafio.Coleta_Seletiva.material.dto.MaterialDescriptionDTO;
import com.desafio.Coleta_Seletiva.material.dto.MaterialResponseDTO;
import com.desafio.Coleta_Seletiva.material.dto.mapper.MaterialMapper;
import com.desafio.Coleta_Seletiva.material.model.Cor;
import com.desafio.Coleta_Seletiva.material.model.Material;
import com.desafio.Coleta_Seletiva.material.services.MaterialService;
import com.desafio.Coleta_Seletiva.web.exception.ErrorMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Materiais", description = "Contém todas as operações possíveis de serem realizadas com a entidade Material.")
@RestController
@RequestMapping("api/materiais")
public class MaterialController {
  @Autowired
  private MaterialService materialService;

  public MaterialController(MaterialService materialService) {
    this.materialService = materialService;
  }

  @Operation(summary = "Criar um novo material", description = "Recurso para criar um novo material", responses = {
      @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponseDTO.class))),
      @ApiResponse(responseCode = "409", description = "Violação de integridade da entidade", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
      @ApiResponse(responseCode = "422", description = "Recurso não processado por dados de entrada inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @PostMapping
  public ResponseEntity<MaterialResponseDTO> create(@Valid @RequestBody MaterialCreateDTO materialDTO) {
    Material created = materialService.create(MaterialMapper.toMaterial(materialDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(MaterialMapper.toDTO(created));
  }

  @Operation(summary = "Buscar todas as cores", description = "Recurso para buscar todas as cores possíveis para um material", responses = {
      @ApiResponse(responseCode = "200", description = "Todos as cores recuperadas com sucesso", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Cor.class))))
  })
  @GetMapping("/cores")
  public ResponseEntity<List<Cor>> getAllColors() {
    return ResponseEntity.ok().body(List.of(Cor.class.getEnumConstants()));
  }

  @Operation(summary = "Buscar todos os materiais", description = "Recurso para buscar todos os materiais", responses = {
      @ApiResponse(responseCode = "200", description = "Todos os materiais recuperados com sucesso", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MaterialResponseDTO.class))))
  })
  @GetMapping
  public ResponseEntity<List<MaterialResponseDTO>> getAll() {
    List<Material> materials = materialService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(MaterialMapper.toListDTO(materials));
  }

  @Operation(summary = "Recuperar um material pelo id", description = "Recurso para recuperar um único material", responses = {
      @ApiResponse(responseCode = "200", description = "Material recuperado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponseDTO.class))),
      @ApiResponse(responseCode = "404", description = "Material não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })

  @GetMapping("/{id}")
  public ResponseEntity<MaterialResponseDTO> findById(@Valid @PathVariable long id) {
    Material material = materialService.findById(id);
    return ResponseEntity.ok().body(MaterialMapper.toDTO(material));
  }

  @Operation(summary = "Deletar um material", description = "Recurso para deletar um material", responses = {
      @ApiResponse(responseCode = "204", description = "Deleção realizada comm sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)))
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@Valid @PathVariable long id) {
    materialService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Atualizar descrição", description = "Recurso para atualizar a descrição de um material", responses = {
      @ApiResponse(responseCode = "200", description = "Descrição atualizada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponseDTO.class))),
      @ApiResponse(responseCode = "404", description = "Material não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
  })
  @PatchMapping("/{id}")
  public ResponseEntity<MaterialResponseDTO> updateDescription(@Valid @PathVariable long id,
      @Valid @RequestBody MaterialDescriptionDTO dto) {
    Material material = materialService.updateDescription(id, dto.getDescription());
    return ResponseEntity.ok().body(MaterialMapper.toDTO(material));
  }

}
