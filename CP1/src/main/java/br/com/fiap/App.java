package br.com.fiap;

import br.com.fiap.entity.Livro;
import br.com.fiap.service.LivroServiceImpl;

public class App {

    public static void main(String[] args) {

        LivroServiceImpl livroService = LivroServiceImpl.getInstance();

        livroService.inserir(new Livro(
                "O dia que a internet da FIAP funcionou",
                "Henrique",
                "978-0-7334-2607-4",
                2)
        );
        livroService.inserir(new Livro(
                "Dias que a internet da FIAP não funcionou",
                "Benicio",
                "978-0-7334-2608-4",
                1)
        );
        livroService.inserir(new Livro(
                "Alguém me ajuda",
                "Douglas Adams",
                "978-0-7334-2609-4",
                1)
        );

        livroService.listar();

        livroService.remover(3L);

        livroService.atualizar((new Livro(
                "Dias que a internet da FIAP não funcionou",
                "Benicio",
                "978-0-7334-2608-4",
                3)
        ));

    }
}
