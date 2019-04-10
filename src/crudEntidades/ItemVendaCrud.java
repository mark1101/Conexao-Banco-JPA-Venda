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
import entidades.ItemVenda;
import conexaoBancoTeste.Conexao;
import crudEntidades.ProdutoCrud;

import javax.persistence.*;
import java.util.List;


public class ItemVendaCrud {
    EntityManagerFactory emf;
    EntityManager em;
    Conexao con;

    public ItemVendaCrud(Conexao conexao) { // ao criar um abj ja criamos ja iniciamos uma conexao
        this.emf = conexao.getEmf();
        this.em = conexao.getEm();
        con = conexao;
    }
    //CREATE ITEM VENDA
    public void cadastraVenda(ItemVenda item)// metodo responsavel por cadastrar uma venda dentro do sistema
    {
        ProdutoCrud produto = new ProdutoCrud(con);
        if(!produto.existeProd())
        {
            System.out.println("NAO TEMOS TENHUM PRODUTO CADASTRADO NO SISTEMA ! ");
            return;
        }
        EntityTransaction ad = em.getTransaction();
        ad.begin();
        em.persist(item);
        ad.commit(); 
    }
    //MOSTRA ITENS VENDA
    public void mostraItemVenda()
    {
        TypedQuery<ItemVenda> query = em.createQuery("SELECT iv FROM ItemVenda iv", ItemVenda.class);
        List<ItemVenda> results = query.getResultList();
        System.out.println("---- *ITENS VENDA * ---- ");
        for (ItemVenda iv : results)
        {
            System.out.println(iv);
        }
            
    }
   
}
