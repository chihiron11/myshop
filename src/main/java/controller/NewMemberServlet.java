package controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class NewMemberServlet
 */
@WebServlet("/newMember")
public class NewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/newMember.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 入力値の取得
		try {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			// Integer tel = Integer.parseInt(request.getParameter("tel"));
			String tel = request.getParameter("tel");
			

			String loginId = request.getParameter("loginId");
			String loginPass = request.getParameter("loginPass");

			// パスワードをハッシュ値に変換
			loginPass = BCrypt.hashpw(loginPass, BCrypt.gensalt());

			// 再表示用
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("tel", tel);
			request.setAttribute("loginId", loginId);
			request.setAttribute("loginPass", loginPass);

			// バリデーション
			boolean isError = false;
			// 名前
			if (name.isEmpty()) {
				isError = true;
				request.setAttribute("nameError", "名前が未入力です");
			}
			if (name.length() > 50) {
				isError = true;
				request.setAttribute("nameError", "50文字以下で入力してください");
			}
			// メールアドレス
			if (address.isEmpty()) {
				isError = true;
				request.setAttribute("addressError", "メールアドレスが未入力です");
			}else {
				Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$");
				Matcher matcher = pattern.matcher(address);
				if (!matcher.matches()) {
					request.setAttribute("addressError", "メールアドレス不明");
					
				}
			}
			// TEL
			if (tel.isEmpty()) {
				isError = true;
				request.setAttribute("telError", "TELが未入力です");

			} else {
				Pattern pattern = Pattern.compile("^0[789]0\\d{8}$");
				Matcher matcher = pattern.matcher(tel);
				if (!matcher.matches()) {
					request.setAttribute("telError", "ハイフンなしで入力してください");
				}
			}

			// ログインID
			if (loginId.isEmpty()) {
				isError = true;
				request.setAttribute("loginIdError", "ログインIDが未入力です");
			}

			// パスワード
			if (loginPass.isEmpty()) {
				isError = true;
				request.setAttribute("loginPassError", "パスワードが未入力です");
			}

			if (isError) {
				request.getRequestDispatcher("/WEB-INF/view/newMember.jsp").forward(request, response);
				return;
			}

			User user = new User();
			user.setName(name);
			user.setAddress(address);
			user.setTel(tel);
			user.setLoginId(loginId);
			user.setLoginPass(loginPass);

			UserDao userDao = DaoFactory.createUserDao();
			userDao.insert(user);
			request.getRequestDispatcher("/WEB-INF/view/newMemberDone.jsp").forward(request, response);
		}
		catch(SQLIntegrityConstraintViolationException e) {
			request.setAttribute("loginIdError", "ログインIDが重複");
			request.getRequestDispatcher("/WEB-INF/view/newMember.jsp").forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
