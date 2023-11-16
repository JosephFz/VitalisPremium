package com.vita.entity;

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
@Table(name = "tb_medico")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medico")
	private Integer codigo;

	@Column(name = "nom_medico")
	private String nombre;

	@Column(name = "ape_medico")
	private String apellido;

	@Column(name = "email_medico")
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_especialidad")
	private Especialidad especialidad;

	@ManyToOne
	@JoinColumn(name = "id_horario")
	private Horario horario;

	@OneToMany(mappedBy = "medico")
	@JsonIgnore
	private List<Citas> listaCitas;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public List<Citas> getListaCitas() {
		return listaCitas;
	}

	public void setListaCitas(List<Citas> listaCitas) {
		this.listaCitas = listaCitas;
	}

}
