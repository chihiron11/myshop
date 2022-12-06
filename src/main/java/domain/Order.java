package domain;

import java.util.Date;

public class Order {
	private Integer id;
	private Integer itemId;
	private Integer userId;
	private Date ordered;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getOrdered() {
		return ordered;
	}
	public void setOrdered(Date ordered) {
		this.ordered = ordered;
	}
	


}
