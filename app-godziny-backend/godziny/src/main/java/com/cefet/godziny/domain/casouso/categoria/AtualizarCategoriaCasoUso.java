package com.cefet.godziny.domain.casouso.categoria;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import com.cefet.godziny.api.categoria.CategoriaDto;
import com.cefet.godziny.infraestrutura.exceptions.CampoRepetidoNoBancoException;
import com.cefet.godziny.infraestrutura.exceptions.categoria.CriarCategoriaInconpletaException;
import com.cefet.godziny.infraestrutura.persistencia.categoria.CategoriaEntidade;
import com.cefet.godziny.infraestrutura.persistencia.categoria.CategoriaRepositorioJpa;
import com.cefet.godziny.infraestrutura.persistencia.curso.CursoEntidade;
import com.cefet.godziny.infraestrutura.persistencia.curso.CursoRepositorioJpa;
import com.cefet.godziny.infraestrutura.rest.categoria.CategoriaRestConverter;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@Setter
public class AtualizarCategoriaCasoUso {
    @Autowired
    private final CategoriaRepositorioJpa categoriaRepositorioJpa;

    @Autowired
    private final CursoRepositorioJpa cursoRepositorioJpa;

    @NotNull(message = "O id da categoria é obrigatório")
    private UUID categoriaId;

    @NotNull(message = "A sigla do curso é obrigatória")
    private String cursoSigla;

    @NotNull(message = "O nome da categoria é obrigatório")
    private String nome;

    @NotNull(message = "O número de horas máximas da categoria é obrigatório")
    private float porcentagemHorasMaximas;

    @NotNull(message = "O multiplicador por horas da categoria é obrigatório")
    private float horasMultiplicador;

    @NotNull(message = "A descrição da categoria é obrigatória")
    private String descricao;
        

    public CursoEntidade validarAtualizacao() throws Exception {
        if (cursoSigla.length() < 3 || cursoSigla.length() > 20) {
            throw new CriarCategoriaInconpletaException("A sigla do curso na categoria deve ter entre 3 e 20 caracteres");
        }
        if (nome.length() < 3 || nome.length() > 250) {
            throw new CriarCategoriaInconpletaException("O nome da categoria deve ter entre 3 e 250 caracteres");
        }
        if (porcentagemHorasMaximas <= 0) {
            throw new CriarCategoriaInconpletaException("A porcentagem de horas máximas da categoria deve ser maior que zero");
        }
        if (horasMultiplicador <= 0) {
            throw new CriarCategoriaInconpletaException("O multiplicador por horas da categoria deve ser maior que zero");
        }
        if (descricao.length() < 10) {
            throw new CriarCategoriaInconpletaException("A descrição da categoria deve ter no mínimo 10 caracteres");
        }
        CursoEntidade cursoEntidade = cursoRepositorioJpa.findBySigla(this.cursoSigla);
        List<CategoriaEntidade> listCategoria = categoriaRepositorioJpa.findByCursoAndNome(cursoEntidade, this.nome);
        if(!listCategoria.isEmpty() && !listCategoria.stream().anyMatch(element -> element.getId().equals(this.categoriaId))){
            throw new CampoRepetidoNoBancoException("Já existe uma categoria com este nome no curso selecionado");
        }
        return cursoEntidade;
    }

    public UUID atualizarCategoria(CategoriaDto dto, CursoEntidade cursoEntidade) throws Exception{
        return categoriaRepositorioJpa.updateCategoria(CategoriaRestConverter.DtoToEntidadeJpa(dto, cursoEntidade));
    }
}
