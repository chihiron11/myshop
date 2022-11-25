package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/view/login.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String loginId = request.getParameter("loginId");
			String loginPass = request.getParameter("loginPass");
			
			request.setAttribute("loginId", loginId);
			
			boolean isError=false;
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
					request.getRequestDispatcher("/WEB-INF/view/login.jsp")
					.forward(request, response);
					return;
				}
				
				
					UserDao userDao = DaoFactory.createUserDao();
					User user = userDao.findByLoginIdAndLoginPass(loginId, loginPass);
					if (user != null) {
						request.getSession().setAttribute("userName", user.getName());
						response.sendRedirect("top");
					} else {
						request.setAttribute("error", true);
						request.getRequestDispatcher("WEB-INF/view/login.jsp")
						.forward(request, response);
					}
				} catch (Exception e) {
					throw new ServletException(e);
				}

			
		}

}
