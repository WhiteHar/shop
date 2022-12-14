package vo;

public class Employee {
	private String id;
	private String pass;
	private String name;
	private String update_date;
	private String create_date;
	private String active;
	
	
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", pass=" + pass + ", name=" + name + ", update_date=" + update_date
				+ ", create_date=" + create_date + ", active=" + active + "]";
	}
	
	
	
}
