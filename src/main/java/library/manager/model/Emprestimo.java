package library.manager.model;

import java.time.LocalDate;

public class Emprestimo {

    private Usuario usuario;   // pode ser Aluno ou Funcionario
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private boolean ativo;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = LocalDate.now().plusDays(14);
        this.ativo = true;
        livro.setDisponivel(false); // já marca o livro como indisponível
    }

    public void devolver() {
        this.dataDevolucaoReal = LocalDate.now();
        this.ativo = false;
        livro.setDisponivel(true); // libera o livro
    }

    //Avisa do atraso
    public boolean isAtrasado() {
        if (ativo) {
            return LocalDate.now().isAfter(dataDevolucaoPrevista);
        }
        return dataDevolucaoReal.isAfter(dataDevolucaoPrevista);
    }
}