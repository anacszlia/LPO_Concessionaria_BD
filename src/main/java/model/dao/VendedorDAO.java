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
