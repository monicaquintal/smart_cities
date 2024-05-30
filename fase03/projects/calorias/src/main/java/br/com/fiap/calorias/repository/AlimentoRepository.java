package br.com.fiap.calorias.repository;

import br.com.fiap.calorias.dto.AlimentoExibicaoDTO;
import br.com.fiap.calorias.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

    @Query("SELECT a FROM Alimento a WHERE a.nome = :nome")
    Optional<Alimento> buscarPorNome(@Param("nome") String nome);

    @Query("SELECT a FROM Alimento a WHERE a.totalCalorias BETWEEN :minimo AND :maximo ORDER BY a.totalCalorias DESC")
    List<Alimento> listarAlimentosPorFaixaDeCalorias(
            @Param("minimo") Double minino,
            @Param("maximo") Double maximo
    );

    List<AlimentoExibicaoDTO> findByTotalCaloriasLessThan(Double caloria);

}