package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.CakeDao;

@WebServlet("/cake")
public class CakeController extends HttpServlet{

	CakeDao cDao=new CakeDao();
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
		case "getOne":
			int id=Integer.parseInt(req.getParameter("id"));
			resp.getWriter().write(gson.toJson(cDao.getOne(id)));
			break;			
		case "del":
			int idDel=Integer.parseInt(req.getParameter("data"));
			boolean isDeleted=cDao.delete(idDel)>0;
			if (isDeleted) {
				resp.getWriter().write("成功");
			}else {
				resp.getWriter().write("失败");			
			}
			break;
		}
	}
}










