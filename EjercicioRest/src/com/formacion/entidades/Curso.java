package com.formacion.entidades;

public class Curso {
	private Long id;
	private String nombre;
	private String identificador;
	private String numHoras;
	private String profesor;
	
	public Curso() {
		super();
	}

	public Curso(Long id, String nombre, String identificador, String numHoras, String profesor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.identificador = identificador;
		this.numHoras = numHoras;
		this.profesor = profesor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(String numHoras) {
		this.numHoras = numHoras;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numHoras == null) ? 0 : numHoras.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numHoras == null) {
			if (other.numHoras != null)
				return false;
		} else if (!numHoras.equals(other.numHoras))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", identificador=" + identificador + ", numHoras=" + numHoras
				+ ", profesor=" + profesor + "]";
	}
	
	
	
	
	
	
}
