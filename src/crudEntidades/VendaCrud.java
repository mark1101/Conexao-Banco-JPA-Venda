/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudEntidades;

/**
 *
 * @author mark_
 */

import javax.persistence.*;
import java.util.List;
import conexaoBancoTeste.Conexao;
import entidades.Venda;



public class VendaCrud {
    
    EntityManagerFactory emf;
    EntityManager em;

    Conexao conexao;
    //CONST CONECCTION 
    public VendaCrud(Conexao conexao) {
        this.emf = conexao.getEmf();
        this.em = conexao.getEm();
        this.conexao = conexao;
    }
    
    //ADICIONA UMA VENDA
    public void addVenda(Venda venda) // metodo responsavel para adicionar uma venda no banco
    {
        // nao podemos cadastrar uma venda sem ter um cliente ou um vendedor dentro do sistema
        EntityTransaction ad = em.getTransaction();
        ad.begin();
        
        ClienteCrud cliente = new ClienteCrud(conexao);
        VendedorCrud vendedor = new VendedorCrud(conexao);
        
        if (!cliente.verificaCliente())
        {
            System.out.println("ERRO, NAO TEMOS NO SISTEMA UM CLIENTE CADASTRADO");
        }
        if (!vendedor.existeVendedor())
        {
            System.out.println("ERRO, NAO TEMOS NO SISTEMA UM VENDEDOR CADASTRADO");
        }
        
        em.persist(venda);
        ad.commit();
    }
    
    // PRINT VENDA ALL 
    public void printVenda()
    {
        TypedQuery<Venda> query = em.createQuery("SELECT v FROM Venda v", Venda.class);
        List<Venda> results = query.getResultList();
        System.out.println("---- * VENDAS CADASTRADAS * ----");
        for (Venda v : results)
        {
            System.out.println(v);
        } 
    }
    
    // PRINT UNIQUE
    public Venda prinVendaUn(int id)
    {
        TypedQuery<Venda> query = em.createQuery("SELECT v FROM Venda v WHERE v.vendaId = :id", Venda.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    
    // MODIFICA VENDA
    public void attVenda(int id, Venda venda)
    {
        EntityTransaction att = em.getTransaction();
        att.begin();
        TypedQuery<Venda> query = em.createQuery("SELECT v FROM Venda v WHERE v.vendaId = :id", Venda.class);
        query.setParameter("id", id);
        for (Venda p : query.getResultList())
        {
            p.setCliente(venda.getCliente());
            p.setStatus(venda.getStatus());
            p.setValorTotal(venda.getValorTotal());
            p.setVendedor(venda.getVendedor());
        }
        att.commit();
    }

    //DELETE VENDA UNIQUE
    public void excluirVenda(int id)
    {
        EntityTransaction de = em.getTransaction();
        de.begin();

        TypedQuery<Venda> query = em.createQuery("SELECT v FROM Venda v WHERE v.vendaId = :id", Venda.class);
        query.setParameter("id", id);
        for (Venda p : query.getResultList())
        {
            em.remove(p);
        }
        de.commit();
    }

    //DELETE ALL 
    public void excluirVendas()
    {
        EntityTransaction de = em.getTransaction();
        de.begin();
        TypedQuery<Venda> query = em.createQuery("SELECT p FROM Venda p", Venda.class);
        for (Venda p : query.getResultList())
        {
            em.remove(p);
        }
        de.commit();
    }
    

}
