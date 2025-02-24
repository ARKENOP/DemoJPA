package fr.epsi.b3devc1;

import fr.epsi.b3devc1.bo.Client;
import fr.epsi.b3devc1.bo.Emprunt;
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

//        Livre livremodif = em.find(Livre.class, 2);
//        livremodif.setAuteur("Auteur modifié");
//        livremodif.setTitre("Titre modifié");


        if (livre != null) {
            System.out.println("Livre trouvé : " + livre.getId() + ", Titre : " + livre.getTitre() + ", Auteur : " + livre.getAuteur());
//            System.out.println("Livre modifié : " + livremodif.getId() + ", Titre : " + livremodif.getTitre() + ", Auteur : " + livremodif.getAuteur());
        } else {
            System.out.println("Livre non trouvé");
        }

        Emprunt emprunt = em.find(Emprunt.class, 1);

        if (emprunt != null) {
            System.out.println("Emprunt ID: " + emprunt.getId());
            System.out.println("Livres associés : ");
            for (Livre unLivre : emprunt.getLivres()) {
                System.out.println("- " + unLivre.getTitre() + " de " + unLivre.getAuteur());
            }
        } else {
            System.out.println("Aucun emprunt trouvé avec cet ID.");
        }


        Client client = em.find(Client.class, 1);

        if (client != null) {
            System.out.println("Client: " + client.getNom() + " " + client.getPrenom());
            System.out.println("Emprunts :");
            for (Emprunt emp : client.getEmprunts()) {
                System.out.println("- Emprunt ID: " + emp.getId() + ", Date de début: " + emp.getDateDebut() + ", Date de fin: " + emp.getDateFin() + ", Delai: " + emp.getDelai());
            }
        } else {
            System.out.println("Aucun client trouvé avec cet ID.");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}