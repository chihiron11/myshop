package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.ItemDao;
import dao.OrderDao;
import dao.UserDao;
import domain.Item;
import domain.Order;
import domain.User;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/itemDetail")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 商品のIDの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);

		try {
			// 商品データの取得
			ItemDao itemDao = DaoFactory.createItemDao();
			Item item = itemDao.findById(id);
	

			// 詳細ページの表示
			request.setAttribute("name", item.getName());
			request.setAttribute("price", item.getPrice());
			request.setAttribute("image", item.getImage());
			request.setAttribute("note", item.getNote());

			request.getRequestDispatcher("/WEB-INF/view/itemDetail.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインしていなければ、ログインページにリダイレクト
		
		// ログイン済みの場合
		try {
			String strId = request.getParameter("id");
			Integer id = Integer.parseInt(strId);

			// 商品データの取得
			ItemDao itemDao = DaoFactory.createItemDao();
			Item item = itemDao.findById(id);
			
			UserDao userDao =DaoFactory.createUserDao();
			User user = userDao.findById(id);
			
			//セッションに保存
			HttpSession session = request.getSession();
			session.setAttribute("id", item.getId());
			session.setAttribute("name", item.getName());
			session.setAttribute("price", item.getPrice());
			session.setAttribute("image", item.getImage());
			session.setAttribute("userName", user.getName());
			
			
			//セッションから取得
			String name=(String)session.getAttribute("name");
			Integer price=(Integer) session.getAttribute("price");
			String image=(String)session.getAttribute("image");
			String userName=(String)session.getAttribute("userName");		
			
			//データベースへ
			Order order=new Order();
			order.setName(name);
			order.setPrice(price);
			order.setImage(image);
			order.setUserName(userName);
			
			OrderDao orderDao=DaoFactory.createOrderDao();
			orderDao.insert(order);
			
			// 完了ページへフォワード	
			request.getRequestDispatcher("/WEB-INF/view/itemDone.jsp")
					.forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
 
	}

}
