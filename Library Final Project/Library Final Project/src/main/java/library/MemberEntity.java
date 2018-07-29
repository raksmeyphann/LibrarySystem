package library;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblmember")
public class MemberEntity {
	
	@Id
	@Column(name="id")
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="dom")
	private String dom;
	@Column(name="tom")
	private String tom;
	
	
	public MemberEntity() {
	
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getDom() {
		return dom;
	}



	public void setDom(String dom) {
		this.dom = dom;
	}



	public String getTom() {
		return tom;
	}



	public void setTom(String tom) {
		this.tom = tom;
	}



	public MemberEntity(String id, String name, String address, String dom, String tom) {
	
		this.id = id;
		this.name = name;
		this.address = address;
		this.dom = dom;
		this.tom = tom;
	} 
	
	public String[] toStringData()
	{
	
		String data[] = { id,name,address,dom,tom};
		return data;
	}

	

}
