package fr.epsi.b3devc1;

import fr.epsi.b3devc1.bo.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Livre livre = em.find(Livre.class, 1);

        Livre livremodif = em.find(Livre.class, 2);
        livremodif.setAuteur("Auteur modifié");
        livremodif.setTitre("Titre modifié");

        em.getTransaction().commit();

        if (livre != null) {
            System.out.println("Livre trouvé : " + livre.getId() + ", Titre : " + livre.getTitre() + ", Auteur : " + livre.getAuteur());
            System.out.println("Livre modifié : " + livremodif.getId() + ", Titre : " + livremodif.getTitre() + ", Auteur : " + livremodif.getAuteur());
        } else {
            System.out.println("Livre non trouvé");
        }


        em.close();
        emf.close();
    }
}