package library.manager.principal;

import library.manager.model.*;

public class Principal {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Usuario aluno1 = new Aluno("João Silva", "blabla","123", "123456" );
        Livro Pequeno_Principe = new Livro("Antoine de Saint-Exupéry", "O Pequeno Príncipe", 123456, 1943);

//        Emprestimo emprestimoUm = new Emprestimo(aluno1, Pequeno_Principe);
//
//        System.out.println("Livro está disponivel: " + Pequeno_Principe.isDisponivel());
//
//        emprestimoUm.devolver();
//        System.out.println("Livro está disponivel: " + Pequeno_Principe.isDisponivel());

        // cadastrando livros
        Livro l1 = new Livro("Joshua Bloch", "Effective Java", 11, 2018);
        Livro l2 = new Livro("Robert Martin", "Código Limpo", 12, 2008);
        Livro l3 = new Livro("Joshua Bloch", "Java Puzzlers", 13, 2005);

        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);
        biblioteca.adicionarLivro(l3);

        // cadastrando usuários
        Aluno aluno = new Aluno("Guilherme", "gui@email.com", "123.456.789-00", "MAT001");
        Funcionario func = new Funcionario("Carlos", "carlos@email.com", "987.654.321-00", "Bibliotecário");

        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(func);

        // testando os streams
        System.out.println("=== Títulos disponíveis ===");
        biblioteca.listarDisponiveis().forEach(livro -> System.out.println(livro.getTitulo()));


    }
}
