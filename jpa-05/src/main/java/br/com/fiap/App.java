package br.com.fiap;

import java.time.LocalDate;

import br.com.fiap.entity.Aluno;
import br.com.fiap.service.AlunoServiceImpl;

public class App {

    public static void main(String[] args) {

        AlunoServiceImpl alunoService = AlunoServiceImpl.getInstance();

        Aluno aluno3 = new Aluno("Aluno3", "33333", "333.333.333-33", LocalDate.of(1980, 1, 1));
        alunoService.inserir(new Aluno("Aluno1", "11111", "111.111.111-11", LocalDate.of(1980, 1, 1)));
        alunoService.inserir(new Aluno("Aluno2", "22222", "222.222.222-22", LocalDate.of(1980, 1, 1)));
        alunoService.inserir(aluno3);
    }
}