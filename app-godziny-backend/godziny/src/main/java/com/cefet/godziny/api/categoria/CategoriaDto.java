package com.cefet.godziny.api.categoria;

import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Setter
public class CategoriaDto {

    private UUID id;
    
    @NotNull
    private String cursoSigla;
    
    @NotNull
    private String nome;

    @NotNull
    private float porcentagemHorasMaximas;

    @NotNull
    private float horasMultiplicador;

    @NotNull
    private String descricao;
}
