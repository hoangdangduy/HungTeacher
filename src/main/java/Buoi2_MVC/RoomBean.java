package Buoi2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RoomBean {
	private String id;
	private String name;
	private String type;
	private float displayPrice;
	private String description;

	public RoomBean() {
		super();
	}

	public RoomBean(String id, String name, String type, float DisplayPrice, String description, float displayPrice) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.displayPrice = displayPrice;
		this.description = description;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getDisplayPrice() {
		return displayPrice;
	}

	public void setDisplayPrice(float displayPrice) {
		this.displayPrice = displayPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addRoom() {
		String dbUrl = "jdbc:mysql://localhost/hotel";
		String dbClass = "com.mysql.jdbc.Driver";
		String sql = "INSERT INTO tblRoom(id, name, type, displayPrice, description) VALUES(?,?,?,?,?)";
		try {
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection(dbUrl, "root", "");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, getId());
			ps.setString(2, getName());
			ps.setString(3, getType());
			ps.setFloat(4, getDisplayPrice());
			ps.setString(5, getDescription());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
