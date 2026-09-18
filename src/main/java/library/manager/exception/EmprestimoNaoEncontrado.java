package library.manager.exception;

public class EmprestimoNaoEncontrado extends RuntimeException {
    public EmprestimoNaoEncontrado(Long id) {
        super("Empréstimo não encontrado com id: " + id);
    }
}
