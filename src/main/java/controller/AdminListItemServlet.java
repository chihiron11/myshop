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
 * Servlet implementation class ListItemServlet
 */
@WebServlet("/listItem")
public class AdminListItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ページ番号取得pになにも入っていないときは"1"をいれる
		try {
			String strP = request.getParameter("p");
			if(strP==null) {
				strP="1";
			}
			Integer p = Integer.parseInt(strP);
			// DAOによるデータの取得
			//(p-1)*10で何ページ目かを計算
			ItemDao itemDao = DaoFactory.createItemDao();
			List<Item> itemList = itemDao.pagenation((p-1)*10);
			request.setAttribute("itemList", itemList);

			// JSPへフォワード
			request.getRequestDispatcher("/WEB-INF/view/listItem.jsp")
			.forward(request, response);
			
		
			
	
			
			
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
		
	}
}
