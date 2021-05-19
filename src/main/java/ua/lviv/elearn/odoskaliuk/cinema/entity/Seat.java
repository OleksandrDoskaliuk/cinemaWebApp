package ua.lviv.elearn.odoskaliuk.cinema.entity;

public class Seat {
	private int seatNumber;
	private int cinemaHallId;
	private int seatCatagoryId;
	
	public Seat() {}
	
	public Seat(int seatNumber, int cinemaHallId, int seatCatagoryId) {
		this.seatNumber = seatNumber;
		this.cinemaHallId = cinemaHallId;
		this.seatCatagoryId = seatCatagoryId;
	}
	
	public static Seat createSeat(int seatNumber, int cinemaHallId, int seatCatagoryId) {
		return new Seat(seatNumber, cinemaHallId, seatCatagoryId);
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getCinemaHallId() {
		return cinemaHallId;
	}

	public void setCinemaHallId(int cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}

	public int getSeatCatagoryId() {
		return seatCatagoryId;
	}

	public void setSeatCatagoryId(int seatCatagoryId) {
		this.seatCatagoryId = seatCatagoryId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cinemaHallId;
		result = prime * result + seatCatagoryId;
		result = prime * result + seatNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} 
		if (!(obj instanceof Seat)) {
			return false;
		}
		Seat seat = (Seat) obj;
		return seat.seatNumber == getSeatNumber();
	}
	
	
}
