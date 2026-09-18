package library.manager.service;

import library.manager.exception.EmprestimoNaoEncontrado;
import library.manager.exception.LivroIndisponivelException;
import library.manager.exception.LivroNaoEncontrado;
import library.manager.exception.UsuarioNaoEncontrado;
import library.manager.model.Emprestimo;
import library.manager.model.Livro;
import library.manager.model.Usuario;
import library.manager.repository.EmprestimoRepository;
import library.manager.repository.LivroRepository;
import library.manager.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class EmprestimoService {

    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(LivroRepository livroRepository,
                              UsuarioRepository usuarioRepository,
                              EmprestimoRepository emprestimoRepository) {
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    @Transactional
    public Emprestimo emprestar(Long livroId, Long usuarioId) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new LivroNaoEncontrado(livroId));
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontrado(usuarioId));

        if (!livro.isDisponivel()) {
            throw new LivroIndisponivelException(livro.getTitulo());
        }

        livro.setDisponivel(false);
        livroRepository.save(livro);

        Emprestimo emprestimo = new Emprestimo(livro, usuario, LocalDate.now());
        return emprestimoRepository.save(emprestimo);
    }

    @Transactional
    public Emprestimo devolver(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new EmprestimoNaoEncontrado(emprestimoId));

        emprestimo.setDataDevolucao(LocalDate.now());

        Livro livro = emprestimo.getLivro();
        livro.setDisponivel(true);
        livroRepository.save(livro);

        return emprestimoRepository.save(emprestimo);
    }
}
