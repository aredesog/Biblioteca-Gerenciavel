package library.manager.model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    //lista de livros, usuários e empréstimos
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Emprestimo realizarEmprestimo(Usuario usuario, Livro livro) {
        if (!livro.isDisponivel()) {
            System.out.println("Livro indisponível!");
            return null;
        }
        Emprestimo emp = new Emprestimo(usuario, livro);
        emprestimos.add(emp);
        return emp;
    }
}
