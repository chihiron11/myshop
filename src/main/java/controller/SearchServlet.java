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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String text=request.getParameter("search");
		request.setAttribute(text, text);
		ItemDao itemDao = DaoFactory.createItemDao();
		List<Item> itemList = itemDao.search(text);
			
			request.setAttribute("itemList", itemList);
			//request.setAttribute("id", item.getId());
			//request.setAttribute("name", item.getName());
			//request.setAttribute("price", item.getPrice());
			//request.setAttribute("image", item.getImage());
			request.getRequestDispatcher("/WEB-INF/view/search.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}
