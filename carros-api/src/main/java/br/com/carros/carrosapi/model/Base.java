package br.com.carros.carrosapi.model;

import java.io.Serializable;

/**
 * Entity base para modelar entidades com id default
 * 
 * @author rogerio
 *
 */
abstract class Base implements Serializable, Comparable<Base> {

	private static final long serialVersionUID = 1L;

	private Long id;	
	
	public int compareTo(Base base) {
		return this.id.compareTo(base.getId());
	}
	
	@Override
	public String toString() {
		return "id=" + id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Base other = (Base) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
