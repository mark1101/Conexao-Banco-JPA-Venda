/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaoBancoTeste;

import crudEntidades.ClienteCrud;
import crudEntidades.ItemVendaCrud;
import crudEntidades.ProdutoCrud;
import crudEntidades.VendaCrud;
import crudEntidades.VendedorCrud;
import entidades.Cliente;
import entidades.ItemVenda;
import entidades.Produto;
import entidades.Venda;
import entidades.Vendedor;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mark_
 */
public class Main {

    public static void main(String[] args) {
        Conexao conexao = new Conexao(); // INICIALIZA MEU BANCO DE DADOS 
        conexao.cria();

        int opcao = -1;
        Scanner scr = new Scanner(System.in);
        while (opcao != 0) {
            System.out.println("");
            System.out.println("1 - ADICIONA CLIENTE");
            System.out.println("2 - VE TODOS CLIENTES");
            System.out.println("3 - APAGAR TODOS CLIENTES");
            System.out.println("4 - APAGAR SOMENTE UM CLIENTE ");
            System.out.println("5 - ADICIONA VENDEDOR");
            System.out.println("6 - VE TODOS VENDEDORES");
            System.out.println("7 - APAGA TODOS VENDEDORES");
            System.out.println("8 - APAGA SOMENTE UM VENDEDOR");
            System.out.println("9 - ADICIONA PRODUTO (automatico)");
            System.out.println("10 - VE TODOS PRODUTOS");
            System.out.println("11 - APAGA TODOS PRODUTOS");
            System.out.println("12 - APAGA SOMENTE UM PRODUTO");
            System.out.println("16 - ATUALIZA PRODUTO");
            System.out.println("13 - CADASTRA ITEM VENDA - (venda automatica)");
            System.out.println("14 - MOSTRA ITEM VENDA");
            System.out.println("15 - MOSTRA VENDA");

            System.out.println("SAIR DO SISTEMA DIGITE 0");
            do {
                opcao = scr.nextInt();
            } while (opcao < -1 || opcao > 16);
            switch (opcao) {
                case 1:
                    String nome,
                     endereco,
                     bairro,
                     cep,
                     cidade,
                     telefone;
                    Date dataCadastro;
                    Date data = new Date();
                    Scanner c = new Scanner(System.in);
                    System.out.print("NOME : ");
                    nome = c.nextLine();
                    System.out.println("");
                    System.out.print("ENDERECO : ");
                    endereco = c.nextLine();
                    System.out.println("");
                    System.out.print("BAIRRO : ");
                    bairro = c.nextLine();
                    System.out.println("");
                    System.out.print("CEP : ");
                    cep = c.nextLine();
                    System.out.println("");
                    System.out.print("CIDADE : ");
                    cidade = c.nextLine();
                    System.out.println("");
                    System.out.print("TELEFONE : ");
                    telefone = c.nextLine();
                    System.out.println("");
                    Cliente cliente = new Cliente(nome, endereco, bairro, cep, cidade, data, telefone);
                    ClienteCrud crudCliente = new ClienteCrud(conexao);
                    crudCliente.Adiciona(cliente);

                    break;
                case 2:
                    ClienteCrud ve = new ClienteCrud(conexao);
                    ve.printCliente();
                    break;
                case 3:
                    ClienteCrud delete = new ClienteCrud(conexao);
                    delete.apagaTodosClientes();
                    break;
                case 4:
                    ClienteCrud delete1 = new ClienteCrud(conexao);
                    System.out.print("DIGITE CLIENTE DE DELETE : ");
                    int idCliente = 0;
                    idCliente = scr.nextInt();
                    delete1.apagaClienteUn(idCliente);
                    break;
                case 5:
                    //CADASTRO DE UM CLIENTE PASSO A PASSO 
                    String nomev,
                     enderecov,
                     bairrov,
                     cepv,
                     cidadev,
                     telefonev;
                    Date dataNascimento,
                     dataContratacao;
                    Scanner v = new Scanner(System.in);

                    System.out.print("NOME : ");
                    nomev = v.nextLine();
                    System.out.println("");
                    System.out.print("ENDERECO : ");
                    enderecov = v.nextLine();
                    System.out.println("");
                    System.out.print("BAIRRO : ");
                    bairrov = v.nextLine();
                    System.out.println("");
                    System.out.print("CEP : ");
                    cepv = v.nextLine();
                    System.out.println("");
                    System.out.print("CIDADE : ");
                    cidadev = v.nextLine();
                    System.out.println("");
                    System.out.print("TELEFONE : ");
                    telefonev = v.nextLine();
                    System.out.println("");
                    Date d = new Date();
                    Vendedor ven = new Vendedor(nomev, d, enderecov, bairrov, cepv, cidadev, telefonev, d);
                    VendedorCrud vendedorc = new VendedorCrud(conexao);
                    vendedorc.adicionaVendedor(ven);

                    break;
                case 6:
                    VendedorCrud vee = new VendedorCrud(conexao);
                    vee.mostraVendedores();
                    break;
                case 7:
                    vee = new VendedorCrud(conexao);
                    vee.deletaVendedores();
                    break;
                case 8:
                    vee = new VendedorCrud(conexao);
                    System.out.print("DIGITE O ID DO VENDEDOR : ");
                    int idVendedor = scr.nextInt();
                    vee.deletaVendedor(idVendedor);
                    break;
                case 9:
                    //CADASTRO DE PRODUTOS DE FORMA AUTOMATICA
                    Produto p = new Produto("macarrao", "pacote", 10.0, "KG", 10.90);
                    Produto p2 = new Produto("feijao", "pacote", 10.0, "KG", 5.90);
                    Produto p3 = new Produto("milho", "sei la", 10.0, "UN", 2.00);
                    Produto p4 = new Produto("carne", "tururu", 10.0, "KG", 15.90);
                    Produto p5 = new Produto("cerveja lata", "paps", 10.0, "UN", 1.86);
                    ProdutoCrud prodCrud = new ProdutoCrud(conexao);
                    prodCrud.insereProduto(p);
                    prodCrud.insereProduto(p2);
                    prodCrud.insereProduto(p3);
                    prodCrud.insereProduto(p4);
                    prodCrud.insereProduto(p5);
                    break;
                case 10:
                    prodCrud = new ProdutoCrud(conexao);
                    prodCrud.printProduto();
                    break;
                case 11:
                    prodCrud = new ProdutoCrud(conexao);
                    prodCrud.deletaProdutos();
                    break;
                case 12:
                    prodCrud = new ProdutoCrud(conexao);
                    System.out.print("DIGITE O ID DO PRODUTO : ");
                    int idP = scr.nextInt();
                    prodCrud.deleteProdutoId(idP);
                    break;
                    //VENDA AUTOMATICA
                case 13:
                    List<ItemVenda> iv = new LinkedList<>();
                    prodCrud = new ProdutoCrud(conexao);

                    Produto produt = new Produto("tenis", "par", 2, "CAIXA", 109.99);
                    prodCrud.insereProduto(produt);

                    ItemVenda itemVenda = new ItemVenda(produt, 2);
                    ItemVendaCrud ivC = new ItemVendaCrud(conexao);
                    ivC.cadastraVenda(itemVenda);
                    iv.add(itemVenda);

                    produt = new Produto("meiao", "par", 2, "PCT", 29);
                    prodCrud.insereProduto(produt);

                    itemVenda = new ItemVenda(produt, 4);
                    ivC.cadastraVenda(itemVenda);
                    iv.add(itemVenda);
                    Date da = new Date();

                    Cliente cTeste = new Cliente("Mark", "Valera de Sá 1000", "Monte", "42343242", "Botucatu", da, "32030203");
                    ClienteCrud crudClientea = new ClienteCrud(conexao);
                    crudClientea.Adiciona(cTeste);

                    Vendedor vTeste = new Vendedor("Carlo", da, "Guaira 22", "Terra", "5543543", "Quartel", "43432324", da);
                    VendedorCrud vTeste1 = new VendedorCrud(conexao);
                    vTeste1.adicionaVendedor(vTeste);

                    Venda vv = new Venda(da, 190, "fin", vTeste, cTeste, iv);
                    VendaCrud vendaa = new VendaCrud(conexao);
                    vendaa.addVenda(vv);
                    break;
                case 14:
                    ItemVendaCrud i = new ItemVendaCrud(conexao);
                    i.mostraItemVenda();
                    break;

                case 15:
                    VendaCrud venda = new VendaCrud(conexao);
                    venda.printVenda();
                    break;
                    // CASO TESTE PARA UPDATE AUTOMATICO 
                case 16:
                    prodCrud = new ProdutoCrud(conexao);
                    System.out.print("DIGITE O COD DO PRODUTO : ");
                    int idatt = scr.nextInt();
                    
                    
                   
                    Produto produt12 = new Produto("carrinho", "so", 5, "UN", 45);
               
                    prodCrud.atualizaProd(idatt, produt12);
                    break;
            }
        }
    }
}
