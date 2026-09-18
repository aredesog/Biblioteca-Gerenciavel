package library.manager.exception;

public class LivroNaoEncontrado extends RuntimeException {
    public LivroNaoEncontrado(String titulo) {
        super("Livro não encontrado: " + titulo);
    }

    public LivroNaoEncontrado(Long id) {
        super("Livro não encontrado com id: " + id);
    }
}
