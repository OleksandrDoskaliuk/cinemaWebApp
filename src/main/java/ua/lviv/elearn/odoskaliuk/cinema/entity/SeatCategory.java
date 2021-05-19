package ua.lviv.elearn.odoskaliuk.cinema.entity;

public class SeatCategory {
	private int seatCategoryId;
	private String name;
	
	public SeatCategory() {}

	public SeatCategory(int seatCategoryId, String name) {
		this.seatCategoryId = seatCategoryId;
		this.name = name;
	}
	
	public static SeatCategory createSeatCategory(int seatCategoryId, String name) {
		return new SeatCategory(seatCategoryId, name);
	}

	public int getSeatCategoryId() {
		return seatCategoryId;
	}

	public void setSeatCategoryId(int seatCategoryId) {
		this.seatCategoryId = seatCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SeatCategory [seatCategoryId=" + seatCategoryId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name.hashCode();
		result = prime * result + seatCategoryId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SeatCategory)) {
			return false;
		}
		SeatCategory seatCategory = (SeatCategory) obj;
		return seatCategory.name.equals(getName());
	}
	
	
}
