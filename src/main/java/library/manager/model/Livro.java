package library.manager.model;

public class Livro {
    private String autor;
    private String titulo;
    private int ISBN; //numeroq ue identifica o livro
    private int anoPublicacao;

    public Livro(String autor, String titulo, int ISBN, int anoPublicacao) {
        this.autor = autor;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
