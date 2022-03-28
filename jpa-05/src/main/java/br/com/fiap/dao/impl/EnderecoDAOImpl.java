package br.com.fiap.dao.impl;

import br.com.fiap.entity.Endereco;

public class EnderecoDAOImpl extends HibernateGenericDAO<Endereco, Long> {

    private static EnderecoDAOImpl instance = null;

    private EnderecoDAOImpl() {
        super(Endereco.class);
    }

    public static EnderecoDAOImpl getInstance() {
        return instance == null ? instance = new EnderecoDAOImpl() : instance;
    }

}
