package database;

import model.Utente;
import model.Auto;
import model.Categoria;
import model.Cliente;
import model.Noleggio;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoNoleggio");
	EntityManager em = emf.createEntityManager();

	private Database() {

	}

	private static Database instance = new Database();

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

	public boolean updateNoleggio(Noleggio n) {
		em.getTransaction().begin();
		em.merge(n);
		em.getTransaction().commit();
		return true;
	}

	public List<Cliente> getListaClienti() {
		Query q = em.createNamedQuery("Cliente.findAll");
		List<Cliente> listaClienti = q.getResultList();
		return listaClienti;
	}

	public List<Auto> getListaAuto() {
		Query q = em.createNamedQuery("Auto.findAll");
		List<Auto> listaAuto = q.getResultList();
		return listaAuto;
	}

	public List<Utente> getListaUtenti() {
		Query q = em.createNamedQuery("Utente.findAll");
		List<Utente> listaUtenti = q.getResultList();
		return listaUtenti;
	}

	public Cliente getCliente(String email, String password) {
		Query q = em.createQuery("SELECT c FROM Cliente c WHERE c.email=:email AND c.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		try {
			Cliente cliente = (Cliente) q.getSingleResult();
			return cliente;
		} catch (Exception e) {
			return null;
		}
	}

	public Cliente getCliente(String email) {
		Query q = em.createQuery("SELECT c FROM Cliente c WHERE c.email=:email");
		q.setParameter("email", email);
		try {
			Cliente cliente = (Cliente) q.getSingleResult();
			return cliente;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Utente getUtente(String email) {
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.email=:email");
		q.setParameter("email", email);
		try {
			Utente utente = (Utente) q.getSingleResult();
			return utente;
		} catch (Exception e) {
			return null;
		}
	}


	public Utente getUtente(String email, String password) {
		Query q = em.createQuery("SELECT u FROM Utente u WHERE c.email=:email AND u.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		try {
			Utente utente = (Utente) q.getSingleResult();
			return utente;
		} catch (Exception e) {
			return null;
		}
	}

	public Cliente getClienteById(int id) {
		em.getTransaction().begin();
		Cliente c = em.find(Cliente.class, id);
		em.getTransaction().commit();
		return c;
	}

	public Utente getUtenteById(int id) {
		em.getTransaction().begin();
		Utente u = em.find(Utente.class, id);
		em.getTransaction().commit();
		return u;
	}

	public Categoria getCategoria(String categoria) {
		Query q = em.createQuery("SELECT c FROM Categoria c WHERE c.nome=:categoria");
		q.setParameter("categoria", categoria);
		Categoria nomeCategoria = (Categoria) q.getSingleResult();
		return nomeCategoria;

	}

	public Categoria getCategoriaById(int id) {
		em.getTransaction().begin();
		Categoria c = em.find(Categoria.class, id);
		em.getTransaction().commit();
		return c;
	}

	public Noleggio getNoleggioById(int id) {
		em.getTransaction().begin();
		Noleggio n = em.find(Noleggio.class, id);
		em.getTransaction().commit();
		return n;
	}

	public Auto getAutoById(int id) {
		em.getTransaction().begin();
		Auto a = em.find(Auto.class, id);
		em.getTransaction().commit();
		return a;
	}

	public List<Noleggio> getListaNoleggi() {
		Query q = em.createNamedQuery("Nolleggio.findAll");
		List<Noleggio> listaNoleggi = q.getResultList();
		return listaNoleggi;
	}

	public List<Noleggio> getListaNoleggi(Cliente cliente) {
		Query q = em.createQuery("SELECT n FROM Noleggio n WHERE n.id_cliente=:id_cliente");
		q.setParameter("id_cliente", cliente.getIdCliente());
		List<Noleggio> listaNoleggi = q.getResultList();
		return listaNoleggi;
	}

	public List<Auto> getAutoDisponibili() {
		Query q = em.createQuery("SELECT a FROM Noleggio a WHERE a.disponibilita=1");
		List<Auto> autoDisponibili = q.getResultList();
		return autoDisponibili;
	}

}
