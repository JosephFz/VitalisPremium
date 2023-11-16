package com.vita.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_boleta")
public class Boleta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_boleta")
	private Integer codigo;
	@Column(name = "rzon_social")
	private String razon;
	@Column(name = "ruc")
	private String ruc;
	@Column(name = "fec_boleta")
	private LocalDate fecha;
	@Column(name = "descripcion")
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "id_cita")
	private Citas cita;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Citas getCita() {
		return cita;
	}

	public void setCita(Citas cita) {
		this.cita = cita;
	}

}
