package library.manager.principal;

import library.manager.model.Aluno;
import library.manager.model.Emprestimo;
import library.manager.model.Livro;
import library.manager.model.Usuario;

public class principal {
    public static void main(String[] args) {

        Usuario aluno1 = new Aluno("João Silva", "blabla","123", "123456" );
        Livro Pequeno_Principe = new Livro("Antoine de Saint-Exupéry", "O Pequeno Príncipe", 123456, 1943);

        Emprestimo emprestimoUm = new Emprestimo(aluno1, Pequeno_Principe);

        System.out.println("Livro está disponivel: " + Pequeno_Principe.isDisponivel());

        emprestimoUm.devolver();
        System.out.println("Livro está disponivel: " + Pequeno_Principe.isDisponivel());
    }
}
