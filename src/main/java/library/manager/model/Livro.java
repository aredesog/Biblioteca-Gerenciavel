package library.manager.model;

import library.manager.interfaces.Catalogavel;

public class Livro implements Catalogavel {
    private String autor;
    private String titulo;
    private String ISBN; //numeroq ue identifica o livro
    private int anoPublicacao;
    private boolean disponivel;


    public Livro(String autor, String titulo, String ISBN, int anoPublicacao) {
        this.autor = autor;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true; //Já comeca disponivel
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Livro getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    //Coloca disponivel (metodo auxiliar)
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    //Verifica disponibilidade
    @Override //vem da catalogavel
    public boolean isDisponivel() {
        return disponivel;
    }
}
