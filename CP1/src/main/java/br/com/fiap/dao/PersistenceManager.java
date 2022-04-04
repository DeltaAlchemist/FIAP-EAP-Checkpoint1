package br.com.fiap.dao;

public class PersistenceManager {

    private static PersistenceManager instance = null;

    private EntityManagerFactory entityManagerFactory = null;

    private PersistenceManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("FIAP_PU");
    }

    public static PersistenceManager getInstance() {

        if (instance == null) {
            instance = new PersistenceManager();
        }

        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}