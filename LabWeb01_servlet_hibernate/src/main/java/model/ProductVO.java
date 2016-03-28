package model;

public class ProductVO {
	private Integer id;
	private String name;
	private Integer price;
	private java.util.Date make;
	private Integer expire;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public java.util.Date getMake() {
		return make;
	}

	public void setMake(java.util.Date make) {
		this.make = make;
	}

	public Integer getExpire() {
		return expire;
	}

	public void setExpire(Integer expire) {
		this.expire = expire;
	}

	@Override
	public String toString() {
		return "CustomerDAO [id=" + id + ", name=" + name + ", price=" + price + ", make=" + make + ", expire=" + expire
				+ "]";
	}
}
