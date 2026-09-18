package library.manager.exception;

public class LivroIndisponivelException extends RuntimeException {
    public LivroIndisponivelException(String titulo) {
        super("Livro indisponível para empréstimo: " + titulo);
    }
}
