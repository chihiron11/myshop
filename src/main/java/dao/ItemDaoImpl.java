package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Item;

public class ItemDaoImpl implements ItemDao {
	
	private DataSource ds;
	
	public ItemDaoImpl(DataSource ds) {
		this.ds =ds;

}

	@Override
	public List<Item> findAll() throws Exception {
		List<Item> itemList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
		String sql="SELECT * ,items.id, items.name, items.price, items.image, items.note FROM items";
		
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				itemList.add(mapToItem(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return itemList;
		}
	

	@Override
	public Item findById(Integer id) throws Exception {
		Item item =new Item();
		try (Connection con = ds.getConnection()) {
			String sql ="SELECT * ,items.id, items.name, items.price, items.image, items.note FROM items"
					+ " WHERE items.id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				item = mapToItem(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return item;
		
		
		
	}

	@Override
	public void insert(Item item) throws Exception {
		try(Connection con=ds.getConnection()){
			String sql = "INSERT INTO items (name, price,  note,image, registered,updated) VALUES (?, ?, ?,?, NOW(),NOW())";
			PreparedStatement stmt =con.prepareStatement(sql);
			stmt.setString(1, item.getName());
			stmt.setObject(2, item.getPrice(),Types.INTEGER);
			stmt.setString(3, item.getNote());
			stmt.setString(4, item.getImage());
			stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Item item) throws Exception {
		try(Connection con = ds.getConnection()) {
			String sql = "UPDATE items" + " SET name =?,price =?,image=?,note=?" + " WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, item.getName());
			stmt.setObject(2, item.getPrice(), Types.INTEGER);
			stmt.setString(3, item.getImage());
			stmt.setString(4, item.getNote());
			stmt.setObject(5, item.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Item item) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM items WHERE id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, item.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}
	private Item mapToItem(ResultSet rs)throws Exception{
	
		Item item = new Item();
		item.setId((Integer)rs.getObject("id"));
		item.setName(rs.getString("name"));
		item.setPrice((Integer) rs.getObject("price"));
		item.setImage(rs.getString("image"));
		item.setNote(rs.getString("note"));
		item.setRegistered(rs.getTimestamp("registered"));
		item.setUpdated(rs.getTimestamp("updated"));
		return item;
	
	}
}