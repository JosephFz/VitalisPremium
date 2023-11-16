package com.vita.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente")
	private Integer codigo;

	@Column(name = "nom_paciente")
	private String nombre;

	@Column(name = "ape_paciente")
	private String apellido;

	@Column(name = "dni_paciente")
	private String dni;

	@Column(name = "telf_paciente")
	private String telefono;

	@Column(name = "direc_paciente")
	private String direccion;

	@Column(name = "gen_paciente")
	private String genero;

	@OneToMany(mappedBy = "paciente")
	@JsonIgnore
	private List<Citas> listaCitas;

	@OneToMany(mappedBy = "paciente")
	@JsonIgnore
	private List<Historial> listaHistorial;

	@OneToMany(mappedBy = "paciente")
	@JsonIgnore
	private List<Boleta> listaBoletas;

	@OneToMany(mappedBy = "paciente")
	@JsonIgnore
	private List<Resultados> listaResultados;

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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Citas> getListaCitas() {
		return listaCitas;
	}

	public void setListaCitas(List<Citas> listaCitas) {
		this.listaCitas = listaCitas;
	}

	public List<Historial> getListaHistorial() {
		return listaHistorial;
	}

	public void setListaHistorial(List<Historial> listaHistorial) {
		this.listaHistorial = listaHistorial;
	}

	public List<Boleta> getListaBoletas() {
		return listaBoletas;
	}

	public void setListaBoletas(List<Boleta> listaBoletas) {
		this.listaBoletas = listaBoletas;
	}

	public List<Resultados> getListaResultados() {
		return listaResultados;
	}

	public void setListaResultados(List<Resultados> listaResultados) {
		this.listaResultados = listaResultados;
	}
	
	
}
