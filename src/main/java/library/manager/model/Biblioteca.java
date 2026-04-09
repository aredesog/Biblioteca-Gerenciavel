package library.manager.model;

import library.manager.exception.LivroNaoEncontrado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    //Uso de streams
    public List<Livro> listarDisponiveis() {
        return livros.stream()
                .filter(livro -> livro.isDisponivel())
                .collect(Collectors.toList());
    }

    public List<Livro> buscarPorAutor(String autor) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }

    public Livro buscarPorTitulo(String titulo) {
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new LivroNaoEncontrado(titulo));
    }

    public long contarEmprestimosAtivos(Usuario usuario) {
        return emprestimos.stream()
                .filter(emp -> emp.getUsuario().getNome().equals(usuario.getNome()))

                .filter(emp -> emp.isAtivo())
                .count();
    }

    public boolean livroEstaEmprestado(Livro livro) {
        return emprestimos.stream()
                .anyMatch(emp -> emp.getLivro().equals(livro) && emp.isAtivo());
    }
}

