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
		this.ds = ds;

	}

	@Override
	public List<Order> findAll(String orderby, boolean isAsc) throws Exception {
		List<Order> orderList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT "
					+ "items.name AS item_name, items.price AS item_price, items.image AS item_image ,orders.id,orders.ordered, users.name AS user_name ,item_id, user_id"
					+ " FROM orders" + " JOIN items" + " ON orders.item_id = items.id" + " JOIN users"
					+ " ON orders.user_id = users.id" + " ORDER BY ?";
			if (!isAsc) {
				sql += " DESC";
			}
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, orderby);
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
		Order order = new Order();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT "
					+ "items.name AS item_name, items.price AS item_price, items.image AS item_image ,orders.id,orders.ordered, users.name AS user_name ,item_id, user_id"
					+ " FROM orders" + " JOIN items" + " ON orders.item_id = items.id" + " JOIN users"
					+ " ON orders.user_id = users.id" + " WHERE users.id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				order = mapToOrder(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return order;
	}

	@Override
	public void insert(Order order) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO orders (item_id,user_id,ordered) VALUES (?,?,NOW())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, order.getItemId(), Types.INTEGER);
			stmt.setObject(2, order.getUserId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
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

	private Order mapToOrder(ResultSet rs) throws Exception {
		Order order = new Order();
		order.setId((Integer) rs.getObject("id"));
		order.setItemId((Integer) rs.getObject("item_id"));
		order.setUserId((Integer) rs.getObject("user_id"));
		order.setOrdered(rs.getTimestamp("ordered"));
		order.setUserName(rs.getString("user_name"));
		order.setItemName(rs.getString("item_name"));
		order.setItemPrice(rs.getString("item_price"));
		order.setItemImage(rs.getString("item_image"));
		return order;

	}

	@Override
	public List<Order> userByOrder(Integer id) throws Exception {
		List<Order> userbyorderList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT "
					+ "items.name AS item_name, items.price AS item_price, items.image AS item_image ,orders.id,orders.ordered, users.name AS user_name ,item_id, user_id"
					+ " FROM orders" + " JOIN items" + " ON orders.item_id = items.id" + " JOIN users"
					+ " ON orders.user_id = users.id" + " WHERE users.id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				userbyorderList.add(mapToOrder(rs));
			}
			
		} catch (Exception e) {
			throw e;
		}
		return userbyorderList;
		
	}

	//注文日順
	@Override
	public List<Order> findOrdered() throws Exception {
		List<Order> orderList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT "
					+ "items.name AS item_name, items.price AS item_price, items.image AS item_image ,orders.id,orders.ordered, users.name AS user_name ,item_id, user_id"
					+ " FROM orders" + " JOIN items" + " ON orders.item_id = items.id" + " JOIN users"
					+ " ON orders.user_id = users.id" + " ORDER BY ordered";
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
	

	//注文者順
	@Override
	public List<Order> findUser() throws Exception {
		List<Order> orderList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT "
					+ "items.name AS item_name, items.price AS item_price, items.image AS item_image ,orders.id,orders.ordered, users.name AS user_name ,item_id, user_id"
					+ " FROM orders" + " JOIN items" + " ON orders.item_id = items.id" + " JOIN users"
					+ " ON orders.user_id = users.id" + " ORDER BY user_id";
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
}