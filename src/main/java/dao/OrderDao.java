package dao;

import java.util.List;

import domain.Order;

public interface OrderDao {
	
public List<Order> findAll() throws Exception;
	
	public Order findById(Integer id) throws Exception;
	public void insert(Order order) throws Exception;
	public void update(Order order) throws Exception;
	public void delete(Order order) throws Exception;

}
