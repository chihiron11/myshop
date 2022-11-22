package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DaoFactory;
import dao.ItemDao;
import domain.Item;

/**
 * Servlet implementation class UpdateItemServlet
 */
@WebServlet("/updateItem")
@MultipartConfig(location="C:/Users/zd3L10/temp")
public class UpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ファイルアップロード
		File filePath = getUploadedDirectory(request);
		File[] fileList = filePath.listFiles();
		request.setAttribute("fileList", fileList);

		if (fileList != null) {
			for (File file : fileList) {
				System.out.println(file.getPath());
			}
		}
			// 編集する商品のIDの取得
			String strId = request.getParameter("id");
			Integer id = Integer.parseInt(strId);

			try {
				// 編集する商品データの取得
				ItemDao itemDao = DaoFactory.createItemDao();
				Item item = itemDao.findById(id);

				// 編集ページの表示
				request.setAttribute("name", item.getName());
				request.setAttribute("price", item.getPrice());
				request.setAttribute("image", item.getImage());
				request.setAttribute("note", item.getNote());

				request.getRequestDispatcher("/WEB-INF/view/updateItem.jsp").forward(request, response);
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
		// 編集する商品のIDの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);

		String name = request.getParameter("name");
		String strPrice = request.getParameter("price");
		Integer price = null;
		String note = request.getParameter("note");

		Part part = request.getPart("upfile");
		String fileName = part.getSubmittedFileName();
		File filePath = getUploadedDirectory(request);
		part.write(filePath + "/" + fileName);

		// 再表示用
		request.setAttribute("name", name);
		request.setAttribute("price", strPrice);
		request.setAttribute("note", note);
		request.setAttribute("fileName", fileName);
		
		// バリデーション
		boolean isError = false;

		if (name.isEmpty()) {
			isError = true;
			request.setAttribute("nameError", "品名が未入力です");
		}
		if (name.length() > 50) {
			isError = true;
			request.setAttribute("nameError", "50文字以下で入力してください");
		}
		if (strPrice.isEmpty()) {
			isError = true;
			request.setAttribute("priceError", "金額が未入力です");
		} else {
			try {
				price = Integer.parseInt(strPrice);
				if (price < 0) {
					isError = true;
					request.setAttribute("priceError", "0以上の数を入力してください");
				}
			} catch (NumberFormatException e) {
				isError = true;
				request.setAttribute("priceError", "整数を入力してください");
			}
		}

		// 入力に不備がある場合は、フォームを再表示し処理を中断
		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/updateItem.jsp").forward(request, response);
			return;
		}

		try {
			// 入力に不備がなければデータを更新
			Item item = new Item();
			item.setId(id);
			item.setName(name);
			item.setPrice(price);
			item.setNote(note);
			item.setImage(fileName);

			// データの更新
			ItemDao itemDao = DaoFactory.createItemDao();
			itemDao.update(item);

			// 更新完了ページの表示
			request.getRequestDispatcher("/WEB-INF/view/updateItemDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);

		}
	}

	private File getUploadedDirectory(HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/uploads");
		return new File(path);
	}

}
