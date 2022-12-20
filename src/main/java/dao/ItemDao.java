package dao;

import java.util.List;

import domain.Item;

public interface ItemDao {

	public List<Item> findAll() throws Exception;
	
	public Item findById(Integer id) throws Exception;
	public void insert(Item item) throws Exception;
	public void update(Item item) throws Exception;
	public void delete(Item item) throws Exception;
	public List<Item> search(String text)throws Exception;
	public List<Item> category(Integer id)throws Exception;
	public Item count() throws Exception;
	public List<Item> pagenation(Integer p) throws Exception;
}
