package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.OrderDao;
import dao.UserDao;
import domain.Order;
import domain.User;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 会員のIDの取得
		try {
			HttpSession session = request.getSession();
			Integer UserId = (Integer) session.getAttribute("userId");

		//	String strId = request.getParameter("id");
		//	Integer id = Integer.parseInt(strId);

			Integer id = UserId;
			
			// 会員データの取得
			UserDao userDao = DaoFactory.createUserDao();
			User user = userDao.findById(id);
			
			//ユーザー別注文リストの取得
			OrderDao orderDao = DaoFactory.createOrderDao();
			List<Order> userbyorderList = orderDao.userByOrder(id);
			
		

			request.setAttribute("name", user.getName());
			request.setAttribute("address", user.getAddress());
			request.setAttribute("tel", user.getTel());
			request.setAttribute("loginId", user.getLoginId());
			
	
		
			request.setAttribute("userbyorderList",  userbyorderList);
		
		
			
			//request.setAttribute("id", order.getId());
			//request.setAttribute("ordered", order.getOrdered());
			//request.setAttribute("itemName", order.getItemName());
			//request.setAttribute("itemPrice", order.getItemPrice());
			//request.setAttribute("itemImage", order.getItemImage());
			
			request.getRequestDispatcher("/WEB-INF/view/mypage.jsp").forward(request, response);
		
			
			//System.out.println(userbyorderList);
					
			
			
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
