package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/adminLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String loginId = request.getParameter("loginId");
			String loginPass = request.getParameter("loginPass");

			request.setAttribute("loginId", loginId);
			
			//バリデーション
			boolean isError = false;
			if (loginId.isEmpty()) {
				request.setAttribute("loginIdError", "ログインIDが未入力です。");
				isError = true;
			}
			if (loginPass.isEmpty()) {
				request.setAttribute("loginPassError", "パスワードが未入力です。");
				isError = true;
			}
			// 入力に不備がある場合はフォームを再表示し、処理を中断
			if (isError == true) {
				request.getRequestDispatcher("/WEB-INF/view/adminLogin.jsp")
				.forward(request, response);
				return;
			}
			
			AdminDao adminDao = DaoFactory.createAdminDao();
			Admin admin = adminDao.findByLoginIdAndLoginPass(loginId, loginPass);
			
			if (admin != null) {
				request.getSession().setAttribute("adminName", admin.getName());
				// セッションにURLが保存されている場合は、そこにリダイレクト
				
				response.sendRedirect("listItem");
			} else {
				request.setAttribute("error", true);
				request.getRequestDispatcher("WEB-INF/view/adminlogin.jsp")
				.forward(request, response);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
