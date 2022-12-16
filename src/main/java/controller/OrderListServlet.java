package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.OrderDao;
import domain.Order;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//DAOによるデータの取得
			//注文日順
			OrderDao orderDao=DaoFactory.createOrderDao();
			List<Order>orderList =orderDao.findOrdered();
			
			// JSPへフォワード
			request.setAttribute("orderList", orderList);
			request.getRequestDispatcher("/WEB-INF/view/orderList.jsp")
			.forward(request, response);
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
