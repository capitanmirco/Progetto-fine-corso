package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the auto database table.
 * 
 */
@Entity
@Table(name="auto")
@NamedQuery(name="Auto.findAll", query="SELECT a FROM Auto a")
public class Auto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_auto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAuto;

	private double cilindrata;

	private String colore;

	private byte disponibilita;

	private String marca;

	private String modello;

	private String targa;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Noleggio
	@OneToMany(mappedBy="auto")
	private List<Noleggio> noleggios;

	public Auto() {
	}

	public int getIdAuto() {
		return this.idAuto;
	}

	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}

	public double getCilindrata() {
		return this.cilindrata;
	}

	public void setCilindrata(double cilindrata) {
		this.cilindrata = cilindrata;
	}

	public String getColore() {
		return this.colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public byte getDisponibilita() {
		return this.disponibilita;
	}

	public void setDisponibilita(byte disponibilita) {
		this.disponibilita = disponibilita;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return this.modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return this.targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Noleggio> getNoleggios() {
		return this.noleggios;
	}

	public void setNoleggios(List<Noleggio> noleggios) {
		this.noleggios = noleggios;
	}

	public Noleggio addNoleggio(Noleggio noleggio) {
		getNoleggios().add(noleggio);
		noleggio.setAuto(this);

		return noleggio;
	}

	public Noleggio removeNoleggio(Noleggio noleggio) {
		getNoleggios().remove(noleggio);
		noleggio.setAuto(null);

		return noleggio;
	}

}
