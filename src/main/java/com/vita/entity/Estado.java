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
@Table(name = "tb_estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	private Integer codigo;
	@Column(name = "nom_estado")
	private String nombre;

	@OneToMany(mappedBy = "estado")
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

	public List<Citas> getListaCitas() {
		return listaCitas;
	}

	public void setListaCitas(List<Citas> listaCitas) {
		this.listaCitas = listaCitas;
	}

}
