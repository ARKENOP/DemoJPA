package fr.epsi.b3devc1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
        System.out.println("Entity manager factory created");

        EntityManager em = emf.createEntityManager();
        System.out.println("Entity manager created");

        em.getTransaction().begin();
        em.getTransaction().commit();
        System.out.println("Connexion à la base de données réussie");

        em.close();
        emf.close();
    }
}