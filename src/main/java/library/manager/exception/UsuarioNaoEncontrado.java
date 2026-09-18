package library.manager.exception;

public class UsuarioNaoEncontrado extends RuntimeException {
    public UsuarioNaoEncontrado(Long id) {
        super("Usuário não encontrado com id: " + id);
    }
}
