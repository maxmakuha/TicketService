package server.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bus implements Serializable {

	private int id;
	private String mark;
	private String owner;
	private String clas;
	private int placesAmount;

	public Bus(int id, String mark, String owner, String clas, int placesAmount) {
		this.id = id;
		this.mark = mark;
		this.owner = owner;
		this.clas = clas;
		this.placesAmount = placesAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public int getPlacesAmount() {
		return placesAmount;
	}

	public void setPlacesAmount(int placesAmount) {
		this.placesAmount = placesAmount;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (clas == null) {
			if (other.clas != null)
				return false;
		} else if (!clas.equals(other.clas))
			return false;
		if (id != other.id)
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (placesAmount != other.placesAmount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", mark=" + mark + ", owner=" + owner + ", clas=" + clas + ", placesAmount="
				+ placesAmount + "]";
	}
}
