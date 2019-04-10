package conexaoBancoTeste;


import javax.persistence.*;

/**
 *
 * @author mark_
 */
public class Conexao {
    EntityManagerFactory emf;
    EntityManager em;

    public void cria()
    {
        emf = Persistence.createEntityManagerFactory("bancoProjeto/db/Vendas.odb");
        em = emf.createEntityManager();
    }

    public void fecha()
    {
        em.close();
        emf.close();
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager getEm() {
        return em;
    }
}
