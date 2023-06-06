package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.CustomerDao;
import entity.Customer;

@WebServlet("/customer")
public class CustomerController extends HttpServlet{

	CustomerDao cDao=new CustomerDao();
	Gson gson=new Gson();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//获取到操作参数
		String op=req.getParameter("op");

		//根据操作参数进行不同操作
		switch (op) {
		case "all":
			resp.getWriter().write(gson.toJson(cDao.findAll()));
			break;
		case "add":
			String dataStrAdd=req.getParameter("data");
			Customer dataAdd=gson.fromJson(dataStrAdd, Customer.class);
			if (cDao.add(dataAdd)>0) {
				resp.getWriter().write("成功");
			}else {
				resp.getWriter().write("失败");
			}
			break;
		case "update":
			String dataStrUpdate=req.getParameter("data");
			Customer dataUpdate=gson.fromJson(dataStrUpdate, Customer.class);
			if (cDao.update(dataUpdate)>0) {
				resp.getWriter().write("成功");
			}else {
				resp.getWriter().write("失败");
			}
			break;
		case "del":
			int idDel=Integer.parseInt(req.getParameter("data"));
			if (cDao.delete(idDel)>0) {
				resp.getWriter().write("成功");
			}else {
				resp.getWriter().write("失败");			
			}
			break;
		}
	}
	
	
}










