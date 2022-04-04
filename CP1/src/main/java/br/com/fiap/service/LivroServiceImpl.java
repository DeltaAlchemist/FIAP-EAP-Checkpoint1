package br.com.fiap.service;

import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Livro;

import java.util.List;

public class LivroServiceImpl extends GenericService<Livro, Long> {

    private static LivroServiceImpl instance = null;

    private LivroDAOImpl livroDAO;

    public LivroServiceImpl() {
        livroDAO = LivroDAOImpl.getInstance();
    }

    public static LivroServiceImpl getInstance() {
        return instance == null ? instance = new LivroServiceImpl() : instance;
    }

    @Override
    public void inserir(Livro instance) {
        try {
            livroDAO.salvar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    public void inserirComEndereco(Livro aluno) {
        try {
            livroDAO.salvar(aluno, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Livro instance) {
        try {
            livroDAO.atualizar(instance, getEntityManager());
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
            livroDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public Livro obter(Long id) {
        Livro livro = null;
        try {
            livro = livroDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return livro;
    }

    @Override
    public List<Livro> listar() {
        List<Livro> livros = null;
        try {
            livros = livroDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return livros;
    }
}