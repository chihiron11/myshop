package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Category;

public class CategoryDaoImpl implements CategoryDao {

	private DataSource ds;

	public CategoryDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Category> findAll() throws Exception {
		List<Category> categoryList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM categorys";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				categoryList.add(mapToCategory(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return categoryList;
	}

	@Override
	public Category findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Category category) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void update(Category category) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(Category category) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	protected Category mapToCategory(ResultSet rs) throws Exception {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setName(rs.getString("name"));
		return category;
	}
}
