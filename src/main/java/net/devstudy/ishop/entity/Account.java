package net.devstudy.ishop.entity;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class Account extends AbstractEntity<Integer> {
	private static final long serialVersionUID = -3196229925974576545L;
	private String name;
	private String email;

	public Account() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Account [id=%s, name=%s, email=%s]", getId(), name, email);
	}
}
