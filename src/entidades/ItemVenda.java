/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;



import javax.persistence.*;

/**
 *
 * @author mark_
 */

@Entity
public class ItemVenda {
    
    @ManyToOne 
    private Produto prod;
    private double quantidade;
    @Id @GeneratedValue
    int id;
    
    
    public ItemVenda(Produto prod, double quantidade)
    {
        this.prod = prod;
        this.quantidade = quantidade;
        
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "prod=" + prod + ", quantidade=" + quantidade + ", id=" + id + '}';
    }
    
    
}
