package com.cefet.godziny.domain.casouso.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.cefet.godziny.infraestrutura.exceptions.curso.RemoverCursoComUsuariosException;
import com.cefet.godziny.infraestrutura.persistencia.curso.CursoEntidade;
import com.cefet.godziny.infraestrutura.persistencia.curso.CursoRepositorioJpa;
import com.cefet.godziny.infraestrutura.persistencia.usuario.UsuarioEntidade;
import com.cefet.godziny.infraestrutura.persistencia.usuario.UsuarioRepositorioJpa;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Setter
public class RemoverCursoCasoUso {

    @Autowired
    private final CursoRepositorioJpa cursoRepositorioJpa;

    @Autowired
    private final UsuarioRepositorioJpa usuarioRepositorioJpa;

    @NotNull(message = "A sigla do curso é obrigatória")
    private String sigla;

    public void validarRemocao() throws Exception {
        CursoEntidade curso = cursoRepositorioJpa.findBySigla(this.sigla);
        Pageable pageable = PageRequest.of(0, 1);
        Page<UsuarioEntidade> usuariosDoCurso = usuarioRepositorioJpa.listUsuariosByCurso(pageable, curso);
        if(!usuariosDoCurso.isEmpty()){
            throw new RemoverCursoComUsuariosException();
        }
    }

     public void removerCurso() throws Exception {
        cursoRepositorioJpa.deleteCurso(this.sigla);
    }
}
