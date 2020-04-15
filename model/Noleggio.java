package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the noleggio database table.
 * 
 */
@Entity
@Table(name="noleggio")
@NamedQuery(name="Noleggio.findAll", query="SELECT n FROM Noleggio n")
public class Noleggio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_noleggio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNoleggio;

	@Column(name="data_fine")
	private String dataFine;

	@Column(name="data_inizio")
	private String dataInizio;

	private byte stato;

	//bi-directional many-to-one association to Auto
	@ManyToOne
	@JoinColumn(name="id_auto")
	private Auto auto;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Noleggio() {
	}

	public int getIdNoleggio() {
		return this.idNoleggio;
	}

	public void setIdNoleggio(int idNoleggio) {
		this.idNoleggio = idNoleggio;
	}

	public String getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public byte getStato() {
		return this.stato;
	}

	public void setStato(byte stato) {
		this.stato = stato;
	}

	public Auto getAuto() {
		return this.auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}