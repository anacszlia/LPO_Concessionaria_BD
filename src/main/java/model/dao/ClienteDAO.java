/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Cliente;
import model.Veiculo;

/**
 *
 * @author vanessalagomachado
 */
public class ClienteDAO extends PersistenciaJPA{
    
    @Override
    public void persist(Object o) throws Exception {
        if (o instanceof Cliente) {
            Cliente cliente = (Cliente) o;
            if (cliente.getcpf() != null && !cliente.validacpf(cliente.getcpf().replaceAll("[^0-9]", ""))) {
                throw new IllegalArgumentException("CPF inválido: " + cliente.getcpf());
            }
        }
        super.persist(o);
    }
    
    public List<Cliente> listaClientes(){
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Cliente> query
                    = em.createQuery("SELECT v FROM Cliente v", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
