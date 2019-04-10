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
import entidades.Produto;

import java.util.List;

import javax.persistence.*;

public class ProdutoCrud {

    EntityManagerFactory emf;
    EntityManager em;

    public ProdutoCrud(Conexao conexao) {
        this.emf = conexao.getEmf();
        this.em = conexao.getEm();
    }

    //INSERT
    public void insereProduto(Produto produto) // metodo responsavel por adicionar um produto dentro do banco de dados
    {
        EntityTransaction ad = em.getTransaction();
        ad.begin();
        em.persist(produto);
        ad.commit();
    }

    //EXISTE
    public boolean existeProd() // metodo que retorna se existe ou nao um produto dentro do banco 
    {
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
        List<Produto> results = query.getResultList();

        if (results.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    //SELECT *
    public void printProduto() {
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
        List<Produto> results = query.getResultList();
        System.out.println("---- * TODOS OS PRODUTOS DENTRO DO BANCO DE DADOS * ----");
        for (Produto p : results) {
            System.out.println(p);
        }
    }

    //SELECT UNIQUE
    public Produto retornaProduto(int id) // metodo retorna um unico produto do banco pelo seu id
    {
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p ", Produto.class);
        List<Produto> resul = query.getResultList();
        for (Produto p : resul)
        {
            if (p.getProdutoId() == id)
            {
                return p;
            }
        }
        return null;
    }

    //UPDATE
    public void atualizaProd(int id, Produto pro) // metod responsavel por modificar determinado produto pelo seu id
    {
        EntityTransaction at = em.getTransaction();
        at.begin();
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
        List<Produto> resul = query.getResultList();
        for (Produto p : resul) {
            if (p.getProdutoId() == id) {
                p.setDescricao(pro.getDescricao());
                p.setEmbalagem(pro.getEmbalagem());
                p.setEstoqueMinimo(pro.getEstoqueMinimo());
                p.setPrecoVenda(pro.getPrecoVenda());
                p.setUnidadeMedida(pro.getUnidadeMedida());
            }
        }
        at.commit();
    }

    //DELETE ALL
    public void deletaProdutos() { // metodo que apaga todos os produtos dentro do banco
        EntityTransaction de = em.getTransaction();
        de.begin();

        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
      
        for (Produto p : query.getResultList()) {
            em.remove(p);
        }
        de.commit();
    }

    //DELETE UNIQUE
    public void deleteProdutoId(int id) {
        EntityTransaction de = em.getTransaction();
        de.begin();

        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p ", Produto.class);
        List<Produto> list = query.getResultList();
        for (Produto p : list) {
            if (p.getProdutoId() == id) {
                em.remove(p);
                System.out.println("PRODUTO REMOVIDO COM SUCESSO");
            }
        }
        de.commit();
    }
}
