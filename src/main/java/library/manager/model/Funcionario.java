package library.manager.model;

public class Funcionario extends Usuario {

    private String cargo;

    public Funcionario(String nome, String email, String cpf, String cargo) {
        super(nome, email, cpf);
        this.cargo = cargo;
    }

    @Override
    public String getTipo() {
        return "Funcionario";
    }
}
