package com.formacion.entidades;

public class Resena {
	private Long id;
	private String resena;
	private int calificacion;
	private int id_alumno;
	private int id_imparticion;

	public Resena() {
		super();
	}

	public Resena(Long id, String resena, int calificacion, int id_alumno, int id_imparticion) {
		super();
		this.id = id;
		this.resena = resena;
		this.calificacion = calificacion;
		this.id_alumno = id_alumno;
		this.id_imparticion = id_imparticion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResena() {
		return resena;
	}

	public void setResena(String resena) {
		this.resena = resena;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public int getId_imparticion() {
		return id_imparticion;
	}

	public void setId_imparticion(int id_imparticion) {
		this.id_imparticion = id_imparticion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calificacion;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + id_alumno;
		result = prime * result + id_imparticion;
		result = prime * result + ((resena == null) ? 0 : resena.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resena other = (Resena) obj;
		if (calificacion != other.calificacion)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_alumno != other.id_alumno)
			return false;
		if (id_imparticion != other.id_imparticion)
			return false;
		if (resena == null) {
			if (other.resena != null)
				return false;
		} else if (!resena.equals(other.resena))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resena [id=" + id + ", resena=" + resena + ", calificacion=" + calificacion + ", id_alumno=" + id_alumno
				+ ", id_imparticion=" + id_imparticion + "]";
	}

}
