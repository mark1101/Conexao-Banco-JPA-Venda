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
import conexaoBancoTeste.Conexao;
import entidades.Cliente;

import javax.persistence.*;
import java.util.List;

public class ClienteCrud {
    
    EntityManagerFactory emf;
    EntityManager em; 
    
    public ClienteCrud(Conexao conexao) // inicia uma conexao com o banco 
    {
        this.emf = conexao.getEmf();
        this.em = conexao.getEm();
    }
    
    public void Adiciona(Cliente cliente) // metodo responsavel por adicionar um cliente no banco 
    {
        EntityTransaction ad = em.getTransaction();
        ad.begin();
        em.persist(cliente);
        ad.commit();
    }
     public boolean verificaCliente ( ) // metodo que verifica a existencia ou nao de um cliente dentro do banco de dados
    {
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        List<Cliente> results = query.getResultList();

        if(results.isEmpty())
        {
            return false;
        }
        else{
            return true;
        }
    }
    public void printCliente(){ // metodo que retorna todos os clientes cadastrados dentro do banco de dados
        TypedQuery<Cliente> queryy = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        List<Cliente> results = queryy.getResultList();
        System.out.println("----- * TODOS CLIENTES DENTRO DO BANCO DE DADOS * -----");
        for (Cliente p : results) {
           System.out.println(p);
        }
       
       
     
    }
    public Cliente retornaClienteId (int id) // metodo que retorna determinado cliente pelo seu id 
    {
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        query.setParameter("id", id);
        
        return query.getSingleResult(); // retorna um unico resutado de pesquisa 
        
    }
    public void updateCliente(int id, Cliente cliente) // metodo que modifica um cliente dentro do banco pelo seu id 
    {
        EntityTransaction at = em.getTransaction();
        at.begin();
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c ", Cliente.class);
        List<Cliente> resul = query.getResultList();
        for (Cliente c : resul)
        {
            if (c.getClienteId() == id){
            c.setCep(cliente.getCep());
            c.setBairro(cliente.getBairro());
            c.setCidade(cliente.getCidade());
            c.setEndereco(cliente.getEndereco());
            c.setTelefone(cliente.getTelefone());
            }
        }
        at.commit();
        
    }
    public void apagaTodosClientes() // metodo responsavel por apagar todos os clientes dentro do banco de dados
    {
        EntityTransaction de = em.getTransaction();
        de.begin(); // inicia uma transacao com o banco de dados
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        for (Cliente c :  query.getResultList()) // dentro do result list fica todos os meus cliente 
        {
            em.remove(c); // dou um delete para apagar diretamente o objeto 
        }
        de.commit(); // salva as modificacoes dentro do banco de dados
    }
    public void apagaClienteUn(int id)
    {
        EntityTransaction de = em.getTransaction(); // inicia uma transacao com o banco 
        de.begin();
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c ", Cliente.class);
        List<Cliente> resul = query.getResultList();
        for (Cliente c : resul)
        {
            if(c.getClienteId() == id)
            {
                em.remove(c);
            }
        }
        de.commit(); // salva alteracoes dentro do banco
    }
}
