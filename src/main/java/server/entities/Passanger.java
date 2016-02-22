package server.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Passanger implements Serializable {

	private int id;
	private String pib;
	private String passport;
	private int organizationId;

	public Passanger(int id, String pib, String passport, int organizationId) {
		this.id = id;
		this.pib = pib;
		this.passport = passport;
		this.organizationId = organizationId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + organizationId;
		result = prime * result + ((passport == null) ? 0 : passport.hashCode());
		result = prime * result + ((pib == null) ? 0 : pib.hashCode());
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
		Passanger other = (Passanger) obj;
		if (id != other.id)
			return false;
		if (organizationId != other.organizationId)
			return false;
		if (passport == null) {
			if (other.passport != null)
				return false;
		} else if (!passport.equals(other.passport))
			return false;
		if (pib == null) {
			if (other.pib != null)
				return false;
		} else if (!pib.equals(other.pib))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passanger [id=" + id + ", pib=" + pib + ", passport=" + passport + ", organizationId=" + organizationId
				+ "]";
	}
}
