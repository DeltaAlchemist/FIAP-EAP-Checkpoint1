package br.com.fiap.dao.impl;

import br.com.fiap.entity.Aluno;

public class AlunoDAOImpl extends HibernateGenericDAO<Aluno, Long> {

    private static AlunoDAOImpl instance = null;

    public static AlunoDAOImpl getInstance() {
        if (instance == null) {
            instance = new AlunoDAOImpl();
        }

        return instance;
    }

    private AlunoDAOImpl() {
        super(Aluno.class);
    }

}