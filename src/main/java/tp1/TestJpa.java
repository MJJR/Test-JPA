package tp1;


import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dev.biblio.Emprunt;
import dev.biblio.Livre;

public class TestJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		
		//Chercher un livre par son identifiant
		Livre l = em.find(Livre.class, 1);
		if (l != null){
		//traitement
			System.out.println("Le livre id 1 est : [ "+l.getTitre()+" , "+l.getAuteur()+" ]");
		}
		
		//Requete d'un livre en cherchant son nom
		Query query = em.createQuery(" select l from Livre l where l.titre = 'Germinal' ");
		l = (Livre) query.getResultList().get(0);
		System.out.println("Le livre dont le titre est Germinal est : [ "+l.getTitre()+" , "+l.getAuteur()+" ]");
		
		//Requete pour extraire tous les emprunts d'un client donné
		TypedQuery<Emprunt> querySecond = em.createQuery(" select e from Emprunt e where e.client.id = 1 ", Emprunt.class);
		List<Emprunt> emprunts =  querySecond.getResultList();
		
		for(Emprunt e : emprunts){
			System.out.println("[ id = "+e.getId()+" | Date debut : "+e.getDateDebut()+" | Date Fin : "+ e.getDateFin() +" ]");
		}
		
		
		//Requete pour extraire un emprunt et tous ses livres associés
		Emprunt emp = em.find(Emprunt.class,1);
		Set<Livre> livres = emp.getLivres();
		for(Livre livre : livres){
			System.out.println("[ id = "+livre.getId()+" | Titre : "+livre.getTitre()+" | Auteur : "+ livre.getAuteur() +" ]");
		}
		
		em.close();
		entityManagerFactory.close();
		

	}

}
