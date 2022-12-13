package dao;

import java.util.List;

import domain.Order;

public interface OrderDao {
	
public List<Order> findAll(String orderby, boolean isAsc) throws Exception;
	
	public Order findById(Integer id) throws Exception;
	public void insert(Order order) throws Exception;
	public void update(Order order) throws Exception;
	public void delete(Order order) throws Exception;
	public List<Order> userByOrder(Integer id) throws Exception;
	
	public List<Order> findOrdered() throws Exception;
	public List<Order> findUser() throws Exception;
	

}
