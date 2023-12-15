package com.Modulo5.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table
public class Pacote {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPacote;

    @Column(nullable = false) 
    private String periodo;

    @Column(nullable = false) 
    private String destino;

    @Column(nullable = false) 
    private Float preco;

	public Long getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(Long idPacote) {
		this.idPacote = idPacote;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Pacote() {
		super();
	}

	public Pacote(Long idPacote, String periodo, String destino, Float preco) {
		super();
		this.idPacote = idPacote;
		this.periodo = periodo;
		this.destino = destino;
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, idPacote, periodo, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacote other = (Pacote) obj;
		return Objects.equals(destino, other.destino) && Objects.equals(idPacote, other.idPacote)
				&& Objects.equals(periodo, other.periodo) && Objects.equals(preco, other.preco);
	}
       
}