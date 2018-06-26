package tp4et5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.banque.Adresse;
import dev.banque.AssuranceVie;
import dev.banque.Client;
import dev.banque.Compte;
import dev.banque.LivretA;
import dev.banque.Operation;
import dev.banque.Virement;

public class TestJPABanque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		/*
		* insérer un compte associé à 2 clients
		*/
		Compte compte1 = new Compte();
		Client client1 = new Client();
		Client client2 = new Client();
		Adresse adresse = new Adresse();
		LocalDate date = LocalDate.of(1800, 01, 01);
		
		adresse.setNumero(42);
		adresse.setCodePostal(424242);
		adresse.setVille("Pierre Paul Jacque");
		adresse.setRue("We don't know");
		
		client1.setNom("Does");
		client1.setPrenom("John");
		client1.setAdresse(adresse);
		client1.setDateNaissance(date);
		
		em.persist(client1);
		System.out.println("Insertion du premier client");
		
		client2.setNom("Nono");
		client2.setPrenom("Bobo");
		client2.setAdresse(adresse);
		client2.setDateNaissance(date);
		
		em.persist(client2);
		System.out.println("Insertion du deuxième client");
		
		HashSet<Client> clients = new HashSet<Client>();
		clients.add(client1);
		clients.add(client2);
		
		compte1.setClient(clients);
		compte1.setNumero("42");
		compte1.setSolde(10000);

		em.persist(compte1);
		System.out.println("Insertion du premier compte");
		
		/*
		 * insérer un client avec plusieurs comptes:
		 * 1 compte de type assurance vie
		 * 1 compte de type livret A
		 */
		Client leFou = new Client();
		AssuranceVie assuranceContreLaMort = new AssuranceVie();
		LivretA livretMaudit = new LivretA();
		

		leFou.setNom("Mad");
		leFou.setPrenom("Batou");
		leFou.setAdresse(adresse);
		leFou.setDateNaissance(date);
		
		em.persist(leFou);
		System.out.println("Insertion du troisième client");
		
		
		assuranceContreLaMort.setSolde(666);
		assuranceContreLaMort.setDateFin(LocalDate.of(2012, 12, 14));
		assuranceContreLaMort.setTaux(13);
		assuranceContreLaMort.getClients().add(leFou);
		assuranceContreLaMort.setNumero("666");
		
		em.persist(assuranceContreLaMort);
		System.out.println("Insertion du premier assurance vie");
		
		livretMaudit.setNumero("13");
		livretMaudit.setSolde(13);
		livretMaudit.setTaux(1313131313);
		livretMaudit.getClients().add(leFou);
		
		em.persist(livretMaudit);
		System.out.println("Insertion du premier LivretA");
		
		
		
		/*
		 * insérer des opérations de type virements sur un compte
		 */
		Virement virement = new Virement();
		virement.setBeneficiaire("Le mal qui fait mal !");
		virement.setDate(LocalDateTime.of(2018, 06, 26, 0, 0));
		virement.setMontant(666);
		virement.setMotif("Petit pois vert");
		virement.setCompte(compte1);
		
		em.persist(virement);
		System.out.println("Insertion du premier virement");

		/*
		 * insérer des opérations de type opérations sur un compte
		 */
		
		Operation operation = new Operation();
		operation.setCompte(assuranceContreLaMort);
		operation.setDate(LocalDateTime.of(2018, 06, 26,0,0));
		operation.setMontant(10000000);
		operation.setMotif("À carreaux rouge");
		
		em.persist(operation);
		System.out.println("Insertion de la première opération");
		
		et.commit();
		em.close();
		entityManagerFactory.close();

	}

}
