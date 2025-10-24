/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Venda;

/**
 *
 * @author vanessalagomachado
 */
public class VendaDAO extends PersistenciaJPA{
    public List<Venda> listaVendas(){
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Venda> query
                    = em.createQuery("SELECT v FROM Venda v", Venda.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public Optional<Venda> buscarPorId(int vendaId) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Venda> query = em.createQuery(
                    "SELECT v FROM Venda v WHERE v.id = :venda_id", Venda.class);
            query.setParameter("venda_id", vendaId);
            return query.getResultList().stream().findFirst();
        } finally {
            em.close();
        }
    }
}
