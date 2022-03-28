package br.com.fiap;

import java.time.LocalDate;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Endereco;
import br.com.fiap.service.AlunoServiceImpl;
import br.com.fiap.service.DisciplinaServiceImpl;

public class App {

    public static void main(String[] args) {

        AlunoServiceImpl alunoService = AlunoServiceImpl.getInstance();
        DisciplinaServiceImpl disciplinaService = DisciplinaServiceImpl.getInstance();

        Aluno aluno3 = new Aluno("Aluno3", "33333", "333.333.333-33", LocalDate.of(1980, 1, 1));
        alunoService.inserir(new Aluno("Aluno1", "11111", "111.111.111-11", LocalDate.of(1980, 1, 1)));
        alunoService.inserir(new Aluno("Aluno2", "22222", "222.222.222-22", LocalDate.of(1980, 1, 1)));
        alunoService.inserir(aluno3);

        Endereco endereco = new Endereco("Av. Paulista", 777, "5 andar", "Bela Vista",
                "São Paulo", "SP", "04566-333");

        Disciplina disciplina3 = new Disciplina("Matemática", 5000);
        disciplinaService.inserir(new Disciplina("História", 4000));
        disciplinaService.inserir(new Disciplina("Física", 3000));
        disciplinaService.inserir(disciplina3);
    }
}