package ua.lviv.elearn.odoskaliuk.cinema.entity;

public class User {
	private int userId;
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private int roleId;
	
	public User() {};
	
	public User(int userId, String firstname, String lastname, String login, String password, int roleId) {
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.login = login;
		this.password = password;
		this.roleId = roleId;
	}
	
	public static User createUser(String firstname, String lastname, String login, String password, int roleId) {
		return new User(0, firstname, lastname, login, password, roleId);
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + firstname.hashCode();
		result = prime * result + userId;
		result = prime * result + lastname.hashCode();
		result = prime * result + login.hashCode();
		result = prime * result + password.hashCode();
		result = prime * result + roleId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User user = (User) obj;
		return user.login.equals(getLogin());
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", login=" + login
				+ ", password=" + password + ", roleId=" + roleId + "]";
	}
}
