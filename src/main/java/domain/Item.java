package domain;

import java.util.Date;

public class Item {


private Integer id;
private String name;
private Integer price;
private String image;
private String note;
private Date registered;
private Date updated;
private Integer categoryId;
private String categoryName;


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
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public Date getRegistered() {
	return registered;
}
public void setRegistered(Date registered) {
	this.registered = registered;
}
public Date getUpdated() {
	return updated;
}
public void setUpdated(Date updated) {
	this.updated = updated;
}
public Integer getCategoryId() {
	return categoryId;
}
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}



}