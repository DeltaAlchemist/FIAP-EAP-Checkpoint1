package br.com.fiap.service;


import br.com.fiap.dao.impl.AlunoDAOImpl;
import br.com.fiap.entity.Aluno;

import java.util.List;

public class AlunoServiceImpl extends GenericService<Aluno, Long> {

    private static AlunoServiceImpl instance = null;

    private AlunoDAOImpl alunoDAO;

    public AlunoServiceImpl() {
        alunoDAO = AlunoDAOImpl.getInstance();
    }

    public static AlunoServiceImpl getInstance() {
        return instance == null ? instance = new AlunoServiceImpl() : instance;
    }

    @Override
    public void inserir(Aluno instance) {
        try {
            alunoDAO.salvar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Aluno instance) {
        try {
            alunoDAO.atualizar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try {
            alunoDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public Aluno obter(Long id) {
        Aluno aluno = null;
        try {
            aluno = alunoDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return aluno;
    }

    @Override
    public List<Aluno> listar() {
        List<Aluno> alunos = null;
        try {
            alunos = alunoDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return alunos;
    }
}
