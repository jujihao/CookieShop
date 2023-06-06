package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDao;
import entity.User;

@WebServlet("/user")
public class UserController extends HttpServlet{

	UserDao cDao=new UserDao();
	Gson gson=new Gson();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//获取到操作参数
		String op=req.getParameter("op");
		
		switch (op) {
		case "login":
			String uName=req.getParameter("uName");
			String pwd=req.getParameter("pwd");
			resp.getWriter().write(gson.toJson(cDao.login(uName,pwd)));
			break;
		case "reg":
			User userAdd=gson.fromJson(req.getParameter("data"), User.class);			
			boolean isAdded=cDao.add(userAdd)>0;
			System.out.println(isAdded);
			if (isAdded) {
				resp.getWriter().write("成功");
			}else {
				resp.getWriter().write("失败");			
			}
			break;
		default:
			break;
		}

		
	}
}










