package com.cefet.godziny.infraestrutura.rest.usuario;

import lombok.NoArgsConstructor;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import com.cefet.godziny.api.curso.CursoDto;
import com.cefet.godziny.api.usuario.UsuarioDto;
import com.cefet.godziny.api.usuario.UsuarioRecuperarDto;
import com.cefet.godziny.domain.casouso.usuario.AtualizarUsuarioCasoUso;
import com.cefet.godziny.domain.casouso.usuario.CriarUsuarioCasoUso;
import com.cefet.godziny.infraestrutura.exceptions.usuario.UsuarioNaoEncontradoException;
import com.cefet.godziny.infraestrutura.persistencia.curso.CursoEntidade;
import com.cefet.godziny.infraestrutura.persistencia.curso.CursoRepositorioJpa;
import com.cefet.godziny.infraestrutura.persistencia.usuario.UsuarioEntidade;
import com.cefet.godziny.infraestrutura.persistencia.usuario.UsuarioRepositorioJpa;
import lombok.AccessLevel;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioRestConverter {
    public static UsuarioEntidade OptionalToUsuarioEntidade(Optional<UsuarioEntidade> optional) throws Exception {
        if(!optional.isPresent()){
            throw new UsuarioNaoEncontradoException();
        }
        var usuarioEntidade = new UsuarioEntidade();
        BeanUtils.copyProperties(optional.get(), usuarioEntidade);
        return usuarioEntidade;
    }

    public static UsuarioRecuperarDto EntidadeToUsuarioRecuperarDto(UsuarioEntidade usuarioEntidade, CursoDto cursoDto){
        return UsuarioRecuperarDto.builder()
        .matricula(usuarioEntidade.getMatricula())
        .curso(cursoDto)
        .nome(usuarioEntidade.getNome())
        .email(usuarioEntidade.getEmail())
        .senha(usuarioEntidade.getSenha())
        .tipo(usuarioEntidade.getTipo())
        .build();
    }

    public static UsuarioEntidade DtoToEntidadeJpa (UsuarioDto dto, CursoEntidade cursoEntidade){
        return UsuarioEntidade.builder()
        .matricula(dto.getMatricula())
        .curso(cursoEntidade)
        .nome(dto.getNome())
        .email(dto.getEmail())
        .senha(dto.getSenha())
        .tipo(dto.getTipo())
        .build();
    }

    public static CriarUsuarioCasoUso DtoToCriarUsuarioCasoUso(UsuarioDto dto, UsuarioRepositorioJpa usuarioRepositorioJpa, CursoRepositorioJpa cursoRepositorioJpa){
        return CriarUsuarioCasoUso.builder()
        .nome(dto.getNome())
        .email(dto.getEmail())
        .senha(dto.getSenha())
        .usuarioRepositorioJpa(usuarioRepositorioJpa)
        .cursoRepositorioJpa(cursoRepositorioJpa)
        .build();
    }

    
    public static AtualizarUsuarioCasoUso DtoToUpdateCursoCasoUso(UsuarioDto dto, UsuarioRepositorioJpa usuarioRepositorioJpa, CursoRepositorioJpa cursoRepositorioJpa){
        return AtualizarUsuarioCasoUso.builder()
        .matricula(dto.getMatricula())
        .nome(dto.getNome())
        .email(dto.getEmail())
        .senha(dto.getSenha())
        .usuarioRepositorioJpa(usuarioRepositorioJpa)
        .cursoRepositorioJpa(cursoRepositorioJpa)
        .build();
    }
}

