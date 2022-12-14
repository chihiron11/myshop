package dao;

import java.util.List;

import domain.Category;


public interface CategoryDao {
	
	List<Category> findAll() throws Exception;
	
	Category findById(Integer id) throws Exception;

	void insert(Category category) throws Exception;

	void update(Category category) throws Exception;

	void delete(Category category) throws Exception;

}
