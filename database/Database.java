package database;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Auto;
import model.Categoria;
import model.Cliente;
import model.Noleggio;
import model.Utente;

public class Database {

	private static Database instance=new Database();
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("AutoNoleggio");
	EntityManager em=emf.createEntityManager();
	
	private Database(){
		
	}
	
	public static Database getInstance() {
		return instance;
	}
	public boolean addUtente(Utente u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		return true;
		
	}
	public boolean addCliente(Cliente c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		return true;
		
	}
	public boolean addAuto(Auto a) {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		return true;
		
	}
	public boolean addNoleggio(Noleggio n) {
		em.getTransaction().begin();
		em.persist(n);
		em.getTransaction().commit();
		return true;
		
	}
	public boolean updateAuto(Auto a) {
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		return true;
	}
	public boolean updateCliente(Cliente c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		return true;
	}
	public boolean updateUtente(Utente u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		return true;
	}
	public List<Cliente> getListaClienti(){
		Query q=em.createNamedQuery("Cliente.findAll");
		List<Cliente>listaClienti=q.getResultList();
		return listaClienti;		
	}
	public List<Utente> getListaUtenti(){
		Query q=em.createNamedQuery("Utente.findAll");
		List<Utente>listaUtenti=q.getResultList();
		return listaUtenti;		
	}
	public List<Auto> getListaAuto(){
		Query q=em.createNamedQuery("Auto.findAll");
		List<Auto>listaAuto=q.getResultList();
		return listaAuto;		
	}
	public List<Noleggio> getListaNoleggi(Cliente cliente) {
		Query q = em.createQuery("SELECT n FROM Noleggio n WHERE n.id_cliente=:id.cliente");
		q.setParameter("id_cliente", cliente.getIdCliente());
		List<Noleggio> listaNoleggi= q.getResultList();
		return listaNoleggi;
	}
	public List<Noleggio> getListaNoleggi(){
		Query q=em.createNamedQuery("Noleggio.findAll");
		List<Noleggio>listaNoleggi=q.getResultList();
		return listaNoleggi;		
	}
	public Cliente getCliente(String email,String password) {
		Query q = em.createQuery("SELECT c FROM Cliente c WHERE c.email=:email AND c.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		
		Cliente cliente=(Cliente) q.getSingleResult();
		return cliente;
	}
	public Utente getUtente(String email,String password) {
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.email=:email AND u.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		Utente utente=(Utente) q.getSingleResult();
		return utente;
	}
	
	public Categoria getCategoria(String categoria) {
		Query q = em.createQuery("SELECT c FROM Categoria c WHERE c.nome=:categoria");
		q.setParameter("categoria", categoria);
		Categoria nomeCategoria=(Categoria) q.getSingleResult();
		return nomeCategoria;
	}
	public List<Auto> getAutoDisponibili() {
		Query q = em.createQuery("SELECT n FROM Auto a WHERE a.disponibilita=1");
		List<Auto> autoDisponibili= q.getResultList();
		return autoDisponibili;
	}
	public Utente getUtenteById(int id) {
		em.getTransaction().begin();
		Utente u= em.find(Utente.class, id);
		em.getTransaction().commit();
		return u;
	}
	public Auto getAutoById(int id) {
		em.getTransaction().begin();
		Auto a= em.find(Auto.class, id);
		em.getTransaction().commit();
		return a;
	}
	public Cliente getClienteById(int id) {
		em.getTransaction().begin();
		Cliente c= em.find(Cliente.class, id);
		em.getTransaction().commit();
		return c;
	}
	public Noleggio getNoleggioById(int id) {
		em.getTransaction().begin();
		Noleggio n= em.find(Noleggio.class, id);
		em.getTransaction().commit();
		return n;
	}
	public Categoria getCategoriaById(int id) {
		em.getTransaction().begin();
		Categoria c= em.find(Categoria.class, id);
		em.getTransaction().commit();
		return c;
	}
}
