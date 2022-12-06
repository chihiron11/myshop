package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Order;

public class OrderDaoImpl implements OrderDao {
	
	private DataSource ds;
	
	public OrderDaoImpl(DataSource ds) {
		this.ds =ds;
	

}

	@Override
	public List<Order> findAll() throws Exception {
		List<Order> orderList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
		String sql="SELECT * ,orders.id FROM orders  ";
		
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				orderList.add(mapToOrder(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return orderList;
		}
	
	
	

	@Override
	public Order findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Order order) throws Exception {
		try(Connection con=ds.getConnection()){
			String sql = "INSERT INTO orders (item_id,user_id,ordered) VALUES (?,?,NOW())";
			PreparedStatement stmt =con.prepareStatement(sql);
			stmt.setObject(1, order.getItemId(),Types.INTEGER);
			stmt.setObject(2, order.getUserId(),Types.INTEGER);			
			stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}
	
		
	}

	@Override
	public void update(Order order) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(Order order) throws Exception {
		
	}		
		
	private Order mapToOrder(ResultSet rs) throws Exception{
		Order order = new Order();
		order.setId((Integer)rs.getObject("id"));
		order.setItemId((Integer)rs.getObject("item_id"));
		order.setUserId((Integer) rs.getObject("user_id"));
		order.setOrdered(rs.getTimestamp("ordered"));
		
		return order;
	
	}
}