package com.cefet.godziny.api.usuario;

import com.cefet.godziny.api.curso.CursoRecuperarDto;
import com.cefet.godziny.constantes.usuario.EnumRecursos;
import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioRecuperarDto{
    @NotNull
    @Positive
    private Integer matricula;

    @Nullable
    private CursoRecuperarDto curso;
    
    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String senha;

    @NotNull
    private EnumRecursos tipo;
}
