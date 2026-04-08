package library.manager.exception;

public class LivroNaoEncontrado extends RuntimeException {
    public LivroNaoEncontrado(String titulo) {
        super("Livro não encontrado: " + titulo);
    }
}
