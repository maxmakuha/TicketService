package server.entities;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Passage implements Serializable {

	private int id;
	private int routeId;
	private Date startTime;
	private Date endTime;
	private int freePlaces;
	private int stopsAmount;

	public Passage(int id, int routeId, Date startTime, Date endTime, int freePlaces, int stopsAmount) {
		this.id = id;
		this.routeId = routeId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.freePlaces = freePlaces;
		this.stopsAmount = stopsAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getFreePlaces() {
		return freePlaces;
	}

	public void setFreePlaces(int freePlaces) {
		this.freePlaces = freePlaces;
	}

	public int getStopsAmount() {
		return stopsAmount;
	}

	public void setStopsAmount(int stopsAmount) {
		this.stopsAmount = stopsAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + freePlaces;
		result = prime * result + id;
		result = prime * result + routeId;
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + stopsAmount;
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
		Passage other = (Passage) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (freePlaces != other.freePlaces)
			return false;
		if (id != other.id)
			return false;
		if (routeId != other.routeId)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (stopsAmount != other.stopsAmount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passage [id=" + id + ", routeId=" + routeId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", freePlaces=" + freePlaces + ", stopsAmount=" + stopsAmount + "]";
	}
}
