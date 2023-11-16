package com.vita.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_citas")
public class Citas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cita")
	private Integer codigo;
	@Column(name = "fecha")
	private String fecha;
	@Column(name = "costo_cita")
	private Double costo;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "id_medico")
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "id_horario")
	private Horario horario;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	@OneToMany(mappedBy = "cita")
	@JsonIgnore
	private List<Boleta> listaBoletas;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Boleta> getListaBoletas() {
		return listaBoletas;
	}

	public void setListaBoletas(List<Boleta> listaBoletas) {
		this.listaBoletas = listaBoletas;
	}

}
