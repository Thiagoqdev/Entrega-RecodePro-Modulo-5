package com.Modulo5.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table
public class Compra {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private long idCompra;

    @Column(nullable=false)
    private String data;

    @ManyToOne
    @JoinColumn (name= "idPacote", nullable=false)
    private Pacote fk_pacote_idPacote;
    
    @ManyToOne
    @JoinColumn (name= "id", nullable=false)
    private Cliente fk_cliente_id;

	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Pacote getFk_pacote_idPacote() {
		return fk_pacote_idPacote;
	}

	public void setFk_pacote_idPacote(Pacote fk_pacote_idPacote) {
		this.fk_pacote_idPacote = fk_pacote_idPacote;
	}

	public Cliente getFk_cliente_id() {
		return fk_cliente_id;
	}

	public void setFk_cliente_id(Cliente fk_cliente_id) {
		this.fk_cliente_id = fk_cliente_id;
	}

	public Compra() {
		super();
	}

	public Compra(long idCompra, String data, Pacote fk_pacote_idPacote, Cliente fk_cliente_id) {
		super();
		this.idCompra = idCompra;
		this.data = data;
		this.fk_pacote_idPacote = fk_pacote_idPacote;
		this.fk_cliente_id = fk_cliente_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, fk_cliente_id, fk_pacote_idPacote, idCompra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(data, other.data) && Objects.equals(fk_cliente_id, other.fk_cliente_id)
				&& Objects.equals(fk_pacote_idPacote, other.fk_pacote_idPacote) && idCompra == other.idCompra;
	}

    
}
