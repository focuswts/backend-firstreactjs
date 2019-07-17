//package br.com.bgt.firstsystem.entities;
//
//public class Parking {
//
//	private Long id;
//	private String parkingName;
//	private String parkingLocation;
//	private String parkingTelNumber;
//
//	public Parking(Long id, String parkingName, String parkingLocation, String parkingTelNumber) {
//		super();
//		this.id = id;
//		this.parkingName = parkingName;
//		this.parkingLocation = parkingLocation;
//		this.parkingTelNumber = parkingTelNumber;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getParkingName() {
//		return parkingName;
//	}
//
//	public void setParkingName(String parkingName) {
//		this.parkingName = parkingName;
//	}
//
//	public String getParkingLocation() {
//		return parkingLocation;
//	}
//
//	public void setParkingLocation(String parkingLocation) {
//		this.parkingLocation = parkingLocation;
//	}
//
//	public String getParkingTelNumber() {
//		return parkingTelNumber;
//	}
//
//	public void setParkingTelNumber(String parkingTelNumber) {
//		this.parkingTelNumber = parkingTelNumber;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((parkingLocation == null) ? 0 : parkingLocation.hashCode());
//		result = prime * result + ((parkingName == null) ? 0 : parkingName.hashCode());
//		result = prime * result + ((parkingTelNumber == null) ? 0 : parkingTelNumber.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Parking other = (Parking) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (parkingLocation == null) {
//			if (other.parkingLocation != null)
//				return false;
//		} else if (!parkingLocation.equals(other.parkingLocation))
//			return false;
//		if (parkingName == null) {
//			if (other.parkingName != null)
//				return false;
//		} else if (!parkingName.equals(other.parkingName))
//			return false;
//		if (parkingTelNumber == null) {
//			if (other.parkingTelNumber != null)
//				return false;
//		} else if (!parkingTelNumber.equals(other.parkingTelNumber))
//			return false;
//		return true;
//	}
//
//}
