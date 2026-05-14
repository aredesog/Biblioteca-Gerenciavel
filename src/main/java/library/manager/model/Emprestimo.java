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

    public double calcularMulta() {
        if (isAtrasado()) {
            long diasAtraso = LocalDate.now().toEpochDay() - dataDevolucaoPrevista.toEpochDay();
            return diasAtraso * 0.5; // Exemplo: R$0,50 por dia de atraso
        }
        else{
            return 0;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}