/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author vanessalagomachado
 */
@MappedSuperclass
public class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    
    private String email;
    private String endereco;
    private int codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        if(!validacpf(cpf)){
            System.out.println("CPF INVÁLIDO");
        }
        else {
            this.cpf = imprimecpf(cpf);
        }
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean validacpf(String cpf){
        cpf=cpf.trim();
         if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
            cpf.equals("12345678901") ||
            (cpf.length() < 11))
            return(false);
        else{
            //garante que so tenha numeros
            String c="";
            for(int i=0;i<cpf.length();++i){
                if(Character.isDigit(cpf.charAt(i)))c+=cpf.charAt(i);
            }
            //valida agora os dois digitos verificadores
            int dg=10;
            int sum=0;
            for(int i=0;i<9;++i){
                sum+=(c.charAt(i)-'0')*dg;
                dg--;
            }
            int digit10=11-(sum %11);
            if(digit10==10 || digit10==11)digit10=0;
            c+=(char)digit10;
            dg=11;
            sum=0;
            for(int i=0;i<10;++i){
                sum+=(c.charAt(i)-'0')*dg;
                dg--;
            }
            int digit11=11-(sum %11);
            if(digit11==10 || digit11==11)digit11=0;  
            
            //se os valores calculados conferem com os informados
            return (digit10 == (c.charAt(9) - '0')) && (digit11 == (c.charAt(10) - '0'));
        }
        
    }
    
   
    public static String imprimecpf(String cpf) {
            return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
            cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
        }
    
    @Override
    public String toString() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String exibirDados(){
        // Define o mesmo formatador usado para a criação da string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String aux = "Pessoa cadastrada: \n";
        aux += "Nome: " + nome+ "\n";
        aux += "cpf: " + cpf + "\n";
        aux += "Telefone: "+telefone+"\n";
        aux += "Data Nascimento: "+dataNascimento.format(formatter)+"\n";
    
        return aux;
    }
            
}
