package ua.lviv.elearn.odoskaliuk.cinema.entity;

public class Ticket {
	private int ticketId;
	private int userId;
	private int sessionId;
	private int seatNumberId;
	
	public Ticket() {}

	public Ticket(int ticketId, int userId, int sessionId, int seatNumberId) {
		this.ticketId = ticketId;
		this.userId = userId;
		this.sessionId = sessionId;
		this.seatNumberId = seatNumberId;
	}
	
	public static Ticket createTicket(int ticketId, int userId, int sessionId, int seatNumberId) {
		return new Ticket(ticketId, userId, sessionId, seatNumberId);
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getSeatNumberId() {
		return seatNumberId;
	}

	public void setSeatNumberId(int seatNumberId) {
		this.seatNumberId = seatNumberId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seatNumberId;
		result = prime * result + sessionId;
		result = prime * result + ticketId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Ticket)) {
			return false;
		}
		Ticket ticket = (Ticket) obj;
		return ticket.seatNumberId == getSeatNumberId() &&
				ticket.seatNumberId == getSessionId();
	}
	
}
