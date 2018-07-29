package library;

public class Member {
	
	private String id;
	private String name;
	private String address;
	private String dateOfMembership;
	private String membershipType; // V=VIP N=Normal
	
	
	public Member() {
	}

	public Member(String id, String name, String address,
			String dateOfMembership, String membershipType) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.dateOfMembership = dateOfMembership;
		this.membershipType = membershipType;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	public String[] toStringData()
	{
	
		String data[] = { id,name,address,dateOfMembership,membershipType};
		return data;
	}

}
