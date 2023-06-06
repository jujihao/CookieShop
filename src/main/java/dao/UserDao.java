package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Cake;
import entity.User;
import util.DruidUtil;

public class UserDao {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new UserDao().findAll());
	}
	
	//通过QueryRunner处理数据CRUD
	QueryRunner qr=new QueryRunner(DruidUtil.dataSource);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<User> findAll(){
		try {
		    //2.编写SQL
		    String sql = "select * from user where 1=?";
		    //3.执行查询
		    List<User> data = qr.query(sql, new BeanListHandler<User>(User.class),1);
		    return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过Id查询单条数据
	 * @param id
	 * @return
	 */
	public User getOne(int id) {
		try {
		    //2.编写SQL
		    String sql = "select * from user where userId=?";
		    //3.执行查询
		    List<User> data = qr.query(sql, new BeanListHandler<User>(User.class),id);
		    return data.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param u
	 * @return
	 */
	public int add(User u) {		
		try {
			//2.编写 占位符方式 SQL
			String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";
			//3.设置占位符的参数
//			    private String pwd;
//			    private String name;
//			    private String phone;
//			    private String address;
//			    private Boolean admin;
//			    private Boolean status;
			Object[] param = {null,
					u.getUserName(),
					u.getEmail(),
					u.getPwd(),
					u.getName(),
					u.getPhone(),
					u.getAddress(),
					false,
					false};
			//4.执行 update方法
			return qr.update(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 修改
	 * @param u
	 * @return
	 */
	public int update(User u) {		
		try {
			//2.编写 占位符方式 SQL
			String sql="update user set"
					+ " userName=?,"
					+ " Email=?,"
					+ " pwd=?,"
					+ " name=?,"
					+ " phone=?,"
					+ " address=?"
					+ " where userId=?";
			//3.设置占位符的参数
			Object[] param = {
					u.getUserName(),
					u.getEmail(),
					u.getPwd(),
					u.getName(),
					u.getPhone(),
					u.getAddress(),
					u.getUserId()
					};
			//4.执行 update方法
			return qr.update(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 条件查询，多个查询参数，返回单条数据
	 * @param uName
	 * @param pwd
	 * @return
	 */
	public User login(String uName, String pwd) {
		try {
		    //2.编写SQL
		    String sql = "select * from user where userName = ? and pwd = ?";
		    //3.执行查询
		    List<User> data = qr.query(sql, new BeanListHandler<User>(User.class),uName,pwd);
		    return data.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		try {
		    String sql = "delete from user where userId = ?";
		    //只有一个参数,不需要创建数组
		    return qr.update(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
