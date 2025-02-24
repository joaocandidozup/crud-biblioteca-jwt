package br.com.biblioteca.services;

import br.com.biblioteca.dtos.LivroRequestDTO;
import br.com.biblioteca.dtos.LivroResponseDTO;

import java.util.List;

public interface LivroService {

    LivroResponseDTO cadastraLivro(LivroRequestDTO livroDTO);

    List<LivroResponseDTO> listarLivros();

    LivroResponseDTO atualizarLivros(Long id, LivroRequestDTO livroDTO);

    void deletar(Long id);
}