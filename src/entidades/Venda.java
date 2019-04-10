/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author mark_
 */

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@SequenceGenerator(name = "sequencia_Venda", initialValue = 1, allocationSize = 50)
public class Venda {
    
    private Date dataVenda; 
    private double valorTotal; 
    private String status;
    private static final long serialVersionUID = 1;
    private List<ItemVenda> listaProdutos;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_Venda") // definindo chave primaria com geracao de seq
    @PrimaryKey
    long vendaId;
    
    @ManyToOne private Cliente cliente; // relacao entre a tabela venda com cliente * to one 
    @ManyToOne private Vendedor vendedor; // relacao entre a tabela venda com vendedor * to one
    @OneToMany private List<ItemVenda> listaProduto; // relacao da tabela venda com item venda, relacionado com uma lista 1 to *

    
    public Venda(Date dataVenda, double valorTotal, String status, Vendedor vendedor, Cliente cliente, List<ItemVenda> listaProdutos) {
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.status = status;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.listaProdutos = listaProdutos;
    }

    
    public long getId()
    {
        return serialVersionUID;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getVendaId() {
        return vendaId;
    }

    public void setVendaId(long vendaId) {
        this.vendaId = vendaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<ItemVenda> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<ItemVenda> listaProduto) {
        this.listaProduto = listaProduto;
    }

    @Override
    public String toString() {
        return "Venda{" + "dataVenda=" + dataVenda + ", valorTotal=" + valorTotal + ", status=" + status + ", listaProdutos=" + listaProdutos + ", vendaId=" + vendaId + ", cliente=" + cliente + ", vendedor=" + vendedor + ", listaProduto=" + listaProduto + '}';
    }
    
}
