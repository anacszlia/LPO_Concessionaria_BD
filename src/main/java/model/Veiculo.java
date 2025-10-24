/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author vanessalagomachado
 */
@Entity
@Table(name = "veiculos")
public class Veiculo implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "vei_id")
    private int id;
    
    @Column(name = "vei_placa", length = 7, unique = true, nullable = false)
    private String placa;
    
    @Column(name = "vei_cor")
    private String cor;
    
    @Column(name = "vei_ano_fabricacao")
    private int anoFabricacao;
    
    @Column(name = "vei_ano_modelo")
    private int anoModelo;
    
    @Column(name = "vei_valor")
    private double valor;
    
    @Column(name = "vei_marca")
    private Marca marca;
    
    @Column(name = "vei_modelo")
    private Modelo modelo;
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return placa;
    }
    
    public String exibirDados(){
        String aux = "Veiculo cadastrado:\n";
        aux += "Placa: "+placa+"\n";
        aux += "Cor: "+cor+"\n";
        aux += "Ano de Fabricação: "+anoFabricacao+"\n";
        aux += "Ano do Modelo: "+anoModelo+"\n";
        aux += "Modelo: "+modelo+"\n";
        aux += "Marca: "+marca+"\n";
        aux += "Valor: R$"+valor+"\n";

        return aux;
    }
    
    
     // 1 veiculo -> várias vendas
    @OneToMany(mappedBy = "veiculo")
    private List<Venda> vendas;
    
    public List<Venda> getVendas() { return vendas; }
    public void setVendas(List<Venda> vendas) { this.vendas = vendas; }

    
}
