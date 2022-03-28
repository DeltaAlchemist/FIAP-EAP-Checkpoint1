package br.com.fiap.service;

import br.com.fiap.dao.impl.DisciplinaDAOImpl;
import br.com.fiap.entity.Disciplina;

import java.util.List;

public class DisciplinaServiceImpl extends GenericService<Disciplina, Long> {

    private static DisciplinaServiceImpl instance = null;

    private DisciplinaDAOImpl disciplinaDAO;

    public DisciplinaServiceImpl() {
        disciplinaDAO = DisciplinaDAOImpl.getInstance();
    }

    public static DisciplinaServiceImpl getInstance() {
        return instance == null ? instance = new DisciplinaServiceImpl() : instance;
    }

    @Override
    public void inserir(Disciplina instance) {
        try {
            disciplinaDAO.salvar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Disciplina instance) {
        try {
            disciplinaDAO.atualizar(instance, getEntityManager());
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
            disciplinaDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public Disciplina obter(Long id) {
        Disciplina disciplina = null;
        try {
            disciplina = disciplinaDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return disciplina;
    }

    @Override
    public List<Disciplina> listar() {
        List<Disciplina> disciplinas = null;
        try {
            disciplinas = disciplinaDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return disciplinas;
    }
}
