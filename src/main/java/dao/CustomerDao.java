package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Customer;
import util.BaseDao;
import util.DruidUtil;

public class CustomerDao {

	public static void main(String[] args) {
		System.out.println(new CustomerDao().findAll());
	}
	
	//通过QueryRunner处理数据CRUD
	QueryRunner qr=new QueryRunner(DruidUtil.dataSource);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Customer> findAll(){
		try {
		    //2.编写SQL
		    String sql = "select * from Customer where 1=?";
		    //3.执行查询
		    List<Customer> data = qr.query(sql, new BeanListHandler<Customer>(Customer.class),1);
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
	public Customer getOne(int id) {
		try {
		    //2.编写SQL
		    String sql = "select * from Customer where CustomerId=?";
		    //3.执行查询
		    List<Customer> data = qr.query(sql, new BeanListHandler<Customer>(Customer.class),id);
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
	public int add(Customer u) {		
		try {
			//1. 先添加一条用户信息，再添加客户信息
			//这里因为要获取最近添加的数据，所以用JDBC原生
			String sqlU="insert into user values(null,?,'','111111','客户',?,?,0,0)";
			BaseDao bDao=new BaseDao();
			ResultSet rs=null;
			Connection con=bDao.open_db();
			PreparedStatement ps=con.prepareStatement(sqlU,PreparedStatement.RETURN_GENERATED_KEYS);			
			Object[] paramU = {
					u.getCustomerName(),
					u.getCustomerPhone(),
					u.getAddress()
					};	
			for (int i = 0; i < paramU.length; i++) {
				ps.setObject(i+1, paramU[i]);
			}
			System.out.println(ps.toString());
			boolean isAdded=ps.executeUpdate()>0;
			
			if (isAdded) {
				//取到新增的数据id
				rs=ps.getGeneratedKeys();
				int id=(int) (rs.next()?rs.getLong(1):-1);
				
				//2.编写 占位符方式 SQL
				String sqlC = "insert into Customer values(?,?,?,?,?)";		    
				Object[] paramC = {
						null,
						u.getCustomerName(),
						u.getCustomerPhone(),
						u.getAddress(),
						id
						};
				//执行 update方法
				return qr.update(sqlC, paramC);
			}
			return 0;						
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
	public int update(Customer u) {		
		try {
			//2.编写 占位符方式 SQL
			String sql="update Customer set "
					+ "CustomerName=?, "
					+ "CustomerPhone=?,"
					+ "address=?,"
					+ "userId=? "
					+ "where CustomerId=?";
			//3.设置占位符的参数
			Object[] param = {u.getCustomerName(),u.getCustomerPhone(),u.getAddress(),u.getUserId(),u.getCustomerId()};
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
	public Customer findById(int id) {
		try {
		    //2.编写SQL
		    String sql = "select * from Customer where customerId = ?";
		    //3.执行查询
		    List<Customer> Customers = qr.query(sql, new BeanListHandler<Customer>(Customer.class),id);
		    return Customers.get(0);
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
		int uId=findById(id).getUserId();
		try {
		    String sql = "delete from Customer where CustomerId = ?";
		    //只有一个参数,不需要创建数组
		    boolean isDeleted=qr.update(sql,id)>0;
		    //如果成功，级联删除用户信息表中相关数据
		    if (isDeleted) {
				String sqlU="delete from user where userId=?";
				return qr.update(sqlU,uId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
