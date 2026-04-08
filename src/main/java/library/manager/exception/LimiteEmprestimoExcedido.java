package library.manager.exception;

public class LimiteEmprestimoExcedido extends RuntimeException {

    //RunTimeException é uma classe de exceção não verificada, não é necessário declarar throws para ela, nao tem necessidade do uso do try Catch para lidar com essa exceção
    public LimiteEmprestimoExcedido(String nomeUsuario) {
        super("Usuário " + nomeUsuario + " atingiu o limite de empréstimos.");
    }
}
