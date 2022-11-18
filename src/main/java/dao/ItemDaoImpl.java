package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Item item) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void update(Item item) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(Item item) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
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