package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ItemDao;
import domain.Item;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// カテゴリIDの取得
				String strId = request.getParameter("id");
				Integer id = Integer.parseInt(strId);
	try {
		//DAOによるデータの取得
		ItemDao itemDao=DaoFactory.createItemDao();
		List<Item>itemList =itemDao.category(id);
		// JSPへフォワード
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("/WEB-INF/view/category.jsp")
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
