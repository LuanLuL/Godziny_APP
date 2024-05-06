package com.cefet.godziny.infraestrutura.exceptions.curso;

public class RemoverCursoComUsuariosException extends RuntimeException{

    public RemoverCursoComUsuariosException() {super("Não é possível excluir um curso que possuí usuários matriculados");}

    public RemoverCursoComUsuariosException(String mensagem) {super(mensagem);}
}
