package ua.lviv.elearn.odoskaliuk.cinema.entity;

public class CinemaHall {
	private int cinemaHallId;
	private String name;
	private int numberOfSeats;
	
	public CinemaHall() {}
	
	public CinemaHall(int cinemaHallId, String name, int numberOfSeats) {
		this.cinemaHallId = cinemaHallId;
		this.name = name;
		this.numberOfSeats = numberOfSeats;
	}
	
	public static CinemaHall createCinemaHall(int cinemaHallId, String name, int numberOfSeats) {
		return new CinemaHall(cinemaHallId, name, numberOfSeats);
	}
	
	public int getCinemaHallId() {
		return cinemaHallId;
	}
	public void setCinemaHallId(int cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cinemaHallId;
		result = prime * result + name.hashCode();
		result = prime * result + numberOfSeats;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CinemaHall)) {
			return false;
		}
		
		CinemaHall cinemaHall = (CinemaHall) obj;
		return cinemaHall.name.equals(getName());
		
	}

	@Override
	public String toString() {
		return "CinemaHall [cinemaHallId=" + cinemaHallId + ", name=" + name + ", numberOfSeats=" + numberOfSeats + "]";
	}
	
}
