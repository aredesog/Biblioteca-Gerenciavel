package library.manager.model;

// Aluno.java
public class Aluno extends Usuario {
    private String matricula;

    public Aluno(String nome, String email, String cpf, String matricula) {
        super(nome, email, cpf); // chama o construtor do pai
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override //sobrescreve o método abstrato da classe Usuario
    public String getTipo() {
        return "Aluno";
    }
}


