package vo;

public class Customer {
	private String id;
	private String pass;
	private String name;
	private String address;
	private String phone;
	private String update_date;
	private String create_date;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", pass=" + pass + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", update_date=" + update_date + ", create_date=" + create_date + "]";
	}
	
	
	
	
}
