package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory {

	public static ItemDao createItemDao() {
		return new ItemDaoImpl(getDataSource());
	}

	public static UserDao createUserDao() {
		return new UserDaoImpl(getDataSource());
	}
	
	public static AdminDao createAdminDao() {
		return new AdminDaoImpl(getDataSource());
	}
	
	public static OrderDao createOrderDao() {
		return new OrderDaoImpl(getDataSource());
	}
	
	public static CategoryDao createCategoryDao() {
		return new CategoryDaoImpl(getDataSource());
	}

	private static DataSource getDataSource() {
		InitialContext ctx = null;
		DataSource ds = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myshopdb");
		} catch (NamingException e) {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e1) {
					throw new RuntimeException(e1);
				}
			}
			throw new RuntimeException(e);
		}
		return ds;
	}
}
