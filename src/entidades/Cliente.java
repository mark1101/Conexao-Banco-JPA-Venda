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
import java.util.Date;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;
import javax.persistence.*;

@Entity
public class Cliente {
    
    private String nome; 
    private String endereco;
    private String bairro;
    private String cep;
    private String cidade;
    private Date dataCadastro;
    private String telefone;
    private static final long serialVersionUID = 1;

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKey
    long clienteId;

    public Long getId()
    {
        return serialVersionUID;
    }

    public Cliente(String nome, String endereco, String bairro, String cep, String cidade, Date dataCadastro, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.dataCadastro = dataCadastro;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", dataCadastro=" + dataCadastro + ", telefone=" + telefone + ", clienteId=" + clienteId + '}';
    }
   
    
    
    
}
