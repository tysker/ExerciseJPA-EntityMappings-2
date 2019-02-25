/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacades;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author oerte
 */
public class CustomerFacade {

    EntityManagerFactory emf;

    public CustomerFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private void editCustomer() {
        EntityManager em = getEntityManager();
        Customer customer = em.find(Customer.class, 3);
        try {
             em.getTransaction().begin();
             customer.setFirstName("Hans");
             em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    private void deleteCustomer(int id) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            Query q = em.createQuery("delete  from Customer c where c.id = :id");
            q.setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
            em.clear();

        } finally {
            em.close();
        }
    }

    private void addCustomer(Customer c1) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(c1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Customer getCustomer(int id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select c from Customer c where c.id = :id");
            return (Customer) q.setParameter("id", id).getSingleResult();

        } finally {
            em.close();
        }

    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade cf = new CustomerFacade(emf);
        Customer cust = new Customer();
        Customer c1 = new Customer("Joerg", "Oertel");
        Customer c2 = new Customer("Patrick", "Oertel");
        Customer c3 = new Customer("Michelle", "Oertel");
        cf.addCustomer(c1);
        cf.addCustomer(c2);
        cf.addCustomer(c3);
        cf.deleteCustomer(2);
        cf.editCustomer();

        System.out.println(cf.getCustomer(1));

    }

}
