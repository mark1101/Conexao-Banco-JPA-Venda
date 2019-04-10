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
import entidades.Vendedor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class VendedorCrud {

    EntityManagerFactory emf;
    EntityManager em;

    public VendedorCrud(Conexao conexao) {
        this.emf = conexao.getEmf();
        this.em = conexao.getEm();
    }

    //CREATE VENDEDOR
    public void adicionaVendedor(Vendedor vendedor)// meotodo que adiciona um vendedor dentro do banco
    {
        EntityTransaction ad = em.getTransaction();
        ad.begin();
        em.persist(vendedor);
        ad.commit();
    }

    // SELECT VENDEDOR ALL 
    public void mostraVendedores() {
        TypedQuery<Vendedor> query = em.createQuery("SELECT v FROM Vendedor v", Vendedor.class);
        List<Vendedor> results = query.getResultList();
        System.out.println("---- * VENDEDORES DENTRO DO BANCO DE DADOS * ---- ");
        for (Vendedor v : results) {
            System.out.println(v);
        }
    }

    //SELECT VENDEDOR UNIQUE
    public Vendedor mostraVendedor(int id) {
        TypedQuery<Vendedor> query = em.createQuery("SELECT v FROM Vendedor v", Vendedor.class);
        List<Vendedor> resul = query.getResultList();
        for (Vendedor v : resul) {
            if (v.getVendedorId() == id) {
                return v;
            }
        }
        return null;
    }

    // EXISTE VENDEDOR ? 
    public boolean existeVendedor()//retorna true se existe pelo menos um vendedor no banco
    {
        TypedQuery<Vendedor> query = em.createQuery("SELECT v FROM Vendedor v", Vendedor.class);
        List<Vendedor> results = query.getResultList();
        if (results.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    // UPDADE VENDEDOR
    public void atualizaVendedor(int id, Vendedor vendedor)//metodo atualiza o vendedor pelo seu id 
    {
        EntityTransaction att = em.getTransaction();
        att.begin();
        TypedQuery<Vendedor> query = em.createQuery("SELECT v FROM Vendedor v", Vendedor.class);
        //query.setParameter("id", id);
        List<Vendedor> lista = query.getResultList();
        for (Vendedor p : lista) {
            if (p.getVendedorId() == id) {
                p.setBairro(vendedor.getBairro());
                p.setCep(vendedor.getCep());
                p.setCidade(vendedor.getCidade());
                p.setDataNascimento(vendedor.getDataNascimento());
                p.setEndereco(vendedor.getEndereco());
                p.setNome(vendedor.getNome());
                p.setTelefone(vendedor.getTelefone());
            }
        }
        att.commit();
    }

    // DELETE UNIQUE 
    public void deletaVendedor(int id) {
        EntityTransaction de = em.getTransaction();
        de.begin();
        TypedQuery<Vendedor> query = em.createQuery("SELECT v FROM Vendedor v", Vendedor.class);
        //query.setParameter("id", id);
        List<Vendedor> vende = query.getResultList();
        for (Vendedor p : vende) {
            if (p.getId() == id)
            {
                em.remove(p);
            }
        }
        de.commit();
    }

    //DELETE ALL
    public void deletaVendedores() {
        EntityTransaction de = em.getTransaction();
        de.begin();
        TypedQuery<Vendedor> query = em.createQuery("SELECT v FROM Vendedor v", Vendedor.class);
        List<Vendedor> results = query.getResultList();
        for (Vendedor v : results) {
            em.remove(v);
        }
        de.commit();
    }
}
