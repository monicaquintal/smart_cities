package br.com.fiap.calorias.controller;

import br.com.fiap.calorias.dto.AlimentoCadastroDTO;
import br.com.fiap.calorias.dto.AlimentoExibicaoDTO;
import br.com.fiap.calorias.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @PostMapping("/alimentos")
    @ResponseStatus(HttpStatus.CREATED)
    public AlimentoExibicaoDTO salvar(
            @RequestBody AlimentoCadastroDTO alimento){
        return alimentoService.salvarAlimento(alimento);
    }

    @RequestMapping(value = "/alimentos", params = {"caloriasMinima", "caloriasMaxima"})
    @ResponseStatus(HttpStatus.OK)
    public List<AlimentoExibicaoDTO> litarAlimentosPorFaixaDeCalorias(
            @RequestParam Double caloriasMinima,
            @RequestParam Double caloriasMaxima
    ){
        return alimentoService.listarAlimentosPorFaixaDeCalorias(caloriasMinima, caloriasMaxima);
    }

    @RequestMapping(value = "/alimentos", params = "caloriasMenorQue")
    @ResponseStatus(HttpStatus.OK)
    public List<AlimentoExibicaoDTO> litarTotalCaloriasMenorQue(
            @RequestParam Double caloriasMenorQue
    ){
        return alimentoService.listarTotalCaloriasMenorQue(caloriasMenorQue);
    }

    @GetMapping("/alimentos")
    @ResponseStatus(HttpStatus.OK)
    public Page<AlimentoExibicaoDTO> litarTodos(
            @PageableDefault(size = 2, page = 0) Pageable paginacao
    ){
        return alimentoService.listarTodos(paginacao);
    }

    @GetMapping("/alimentos/{alimentoId}")
    public ResponseEntity<AlimentoExibicaoDTO> buscarPorId(
            @PathVariable Long alimentoId){
        try {
            return ResponseEntity
                    .ok(alimentoService.buscarPorId(alimentoId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/alimentos", params = "nome")
    public ResponseEntity<AlimentoExibicaoDTO> buscarPorNome(
            @RequestParam String nome){
        try {
            return ResponseEntity
                    .ok(alimentoService.buscarPorNome(nome));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/alimentos/{alimentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long alimentoId){
        alimentoService.excluir(alimentoId);
    }

    @PutMapping("/alimentos")
    public ResponseEntity<AlimentoExibicaoDTO> atualizar(
            @RequestBody AlimentoCadastroDTO alimentoDTO){
        try {
            AlimentoExibicaoDTO alimentoExibicaoDTO =
                    alimentoService.atualizar(alimentoDTO);
            return ResponseEntity.ok(alimentoExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}