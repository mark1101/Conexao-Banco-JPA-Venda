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
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.*;


@SequenceGenerator(name = "seq_Produto", initialValue = 1, allocationSize = 1)
@Entity
public class Produto {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Produto")  
    @PrimaryKey 
    private long ProdutoId;
    
    private String descricao;
    private String embalagem;
    private double estoqueMinimo;
    private String unidadeMedida;
    private double precoVenda;
    private static final long serialVersionUID = 1;
    
    public Produto (String d, String e, double es, String u, double p)
    {
        this.descricao = d;
        this.embalagem = e; 
        this.estoqueMinimo = es;
        this.unidadeMedida = u;
        this.precoVenda = p;
    }
    
    public long getId()
    {
        return serialVersionUID;
        
    }

    public long getProdutoId() {
        return ProdutoId;
    }

    public void setProdutoId(long ProdutoId) {
        this.ProdutoId = ProdutoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    @Override
    public String toString() {
        return "Produto{" + "ProdutoId=" + ProdutoId + ", descricao=" + descricao + ", embalagem=" + embalagem + ", estoqueMinimo=" + estoqueMinimo + ", unidadeMedida=" + unidadeMedida + ", precoVenda=" + precoVenda + '}';
    }
    
    
    
    
}
