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
import domain.Item;

/**
 * Servlet implementation class OrderProcessServlet
 */
@WebServlet("/order/process")
public class OrderProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// itemDetailの注文完了ボタン押す処理ページ
		
		
			
		// ログインしていなければ、ログインページにリダイレクト
		HttpSession session =request.getSession();
		if(session.getAttribute("loginId") == null) {
			response.sendRedirect("/MyShop/login");
		//	return;
		
		//boolean login =(boolean)session.getAttribute("login");
	//	if(login != true) {
			//response.sendRedirect("/MyShop/login");
		//	return;
	//	}
		}

		// ログイン済みの場合
		if(session.getAttribute("loginId")!=null) {
			
		
			try {
			String strId = request.getParameter("id");
			Integer id = Integer.parseInt(strId);

			// 商品データの取得
			ItemDao itemDao = DaoFactory.createItemDao();
			Item item = itemDao.findById(id);

		//	HttpSession session =request.getSession();
			session.setAttribute("id", item.getId());
			session.setAttribute("name", item.getName());
			session.setAttribute("price", item.getPrice());
			session.setAttribute("image", item.getImage());
			session.setAttribute("note", item.getNote());
			response.sendRedirect("/order/done");
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	}
}
