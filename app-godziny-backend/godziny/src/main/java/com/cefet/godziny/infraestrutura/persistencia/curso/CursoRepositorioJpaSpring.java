package com.cefet.godziny.infraestrutura.persistencia.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositorioJpaSpring extends JpaRepository<CursoEntidade, String> {

    void deleteById(@SuppressWarnings("null") String id);

    @Modifying
    @Query("UPDATE CursoEntidade c SET c.sigla = :newId, c.carga_horaria_complementar = :newCargaHorariaComplementar, c.nome = :newNome WHERE c.sigla = :id")
    void updateCursoById(
        @Param("id") String id,
        @Param("newId") String newId,
        @Param("newCargaHorariaComplementar") int newCargaHorariaComplementar,
        @Param("newNome") String newNome
    );

}
