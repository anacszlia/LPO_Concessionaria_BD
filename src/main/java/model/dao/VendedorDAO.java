/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Cliente;
import model.Vendedor;

/**
 *
 * @author vanessalagomachado
 */
public class VendedorDAO extends PersistenciaJPA{
    
    @Override
    public void persist(Object o) throws Exception {
        if (o instanceof Vendedor) {
            Vendedor vendedor = (Vendedor) o;
            if (vendedor.getcpf() != null && !vendedor.validacpf(vendedor.getcpf().replaceAll("[^0-9]", ""))) {
                throw new IllegalArgumentException("CPF inválido: " + vendedor.getcpf());
            }
        }
        super.persist(o);
    }
    
    public List<Vendedor> listaVendedores(){
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Vendedor> query
                    = em.createQuery("SELECT v FROM Vendedor v", Vendedor.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
