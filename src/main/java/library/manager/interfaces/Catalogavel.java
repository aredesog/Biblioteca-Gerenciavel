package library.manager.interfaces;

import library.manager.model.Livro;

public interface Catalogavel {

    Livro getTitulo();
    String getAutor();
    boolean isDisponivel();
}
