package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.EvaluationTask1Bean;
import model.dao.BookDAO;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		EvaluationTask1Bean EvaluationTask1 = new EvaluationTask1Bean();
		BookDAO bDao = new BookDAO();
		List<EvaluationTask1Bean> EvaluationTask1List = new ArrayList<>();
		
		try {
			EvaluationTask1List = bDao.getAllEvaluationTask1();
			session.setAttribute("EvaluationTask1List", EvaluationTask1List);
		}catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMessage","");
			response.sendRedirect("error.jsp");
			return;
	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/list.jsp");
		dispatcher.forward(request, response);



}
}