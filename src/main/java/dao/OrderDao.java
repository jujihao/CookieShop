package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Order;
import util.DruidUtil;

public class OrderDao {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new OrderDao().findAll());
	}
	
	//通过QueryRunner处理数据CRUD
	QueryRunner qr=new QueryRunner(DruidUtil.dataSource);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Order> findAll(){
		try {
		    //2.编写SQL
		    String sql = "SELECT * FROM `order` where 1=?";
		    //3.执行查询
		    List<Order> data = qr.query(sql, new BeanListHandler<Order>(Order.class),1);
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
	public Order getOne(int id) {
		try {
		    //2.编写SQL
		    String sql = "select * from Order where OrderId=?";
		    //3.执行查询
		    List<Order> data = qr.query(sql, new BeanListHandler<Order>(Order.class),id);
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
	public int add(Order u) {		
		try {
			//2.编写 占位符方式 SQL
			String sql = "insert into Order values(?,?,?,?,?,?)";
			//3.设置占位符的参数
			Object[] param = {null,
					u.getOrderTime(),
					u.getPayType(),
					u.getPayStatus(),
					u.getStatus(),
					u.getCustomerId()};
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
	public int update(Order u) {		
		try {
			//2.编写 占位符方式 SQL
			String sql="update Order set"
					+ " OrderName=?,"
					+ " Email=?,"
					+ " pwd=?,"
					+ " name=?,"
					+ " phone=?,"
					+ " address=?"
					+ " where OrderId=?";
			//3.设置占位符的参数
			Object[] param = {};
			//4.执行 update方法
			return qr.update(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
//	/**
//	 * 条件查询，多个查询参数，返回单条数据
//	 * @param uName
//	 * @param pwd
//	 * @return
//	 */
//	public Order login(String uName, String pwd) {
//		try {
//		    //2.编写SQL
//		    String sql = "select * from Order where OrderName = ? and pwd = ?";
//		    //3.执行查询
//		    List<Order> data = qr.query(sql, new BeanListHandler<Order>(Order.class),uName,pwd);
//		    return data.get(0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		try {
		    String sql = "delete from Order where OrderId = ?";
		    //只有一个参数,不需要创建数组
		    return qr.update(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
