/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Address;
import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author oerte
 */
public class TesterOTMB {

//    public static void main(String[] args) {
//
//        Customer c1 = new Customer("Joerg", "Oertel");
//        Customer c2 = new Customer("Patrick", "Duus");
//
//        Address ad1 = new Address("Baunehøjvej 6", "Lyngby");
//        Address ad2 = new Address("Lyngvej 54", "Lyngby");
//        
//        c1.setAddresses(ad1);
//        c2.setAddresses(ad2);
//        ad1.setCustomer(c1);
//        ad2.setCustomer(c2);
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            em.persist(c1);
//            em.persist(c2);
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//    }

}
