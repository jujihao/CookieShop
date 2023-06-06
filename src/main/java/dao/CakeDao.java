package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Cake;
import util.DruidUtil;

public class CakeDao {

	public static void main(String[] args) {
		System.out.println(new CakeDao().findAll());
	}
	
	//通过QueryRunner处理数据CRUD
	QueryRunner qr=new QueryRunner(DruidUtil.dataSource);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Cake> findAll(){
		try {
		    //2.编写SQL
		    String sql = "select * from Cake where 1=?";
		    //3.执行查询
		    List<Cake> data = qr.query(sql, new BeanListHandler<Cake>(Cake.class),1);
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
	public Cake getOne(int id) {
		try {
		    //2.编写SQL
		    String sql = "select * from Cake where CakeId=?";
		    //3.执行查询
		    List<Cake> data = qr.query(sql, new BeanListHandler<Cake>(Cake.class),id);
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
	public int add(Cake u) {		
		try {
			//2.编写 占位符方式 SQL
			String sql = "insert into Cake values(?,?,?,?,?,"
					+ "?,?,?,?,?,"
					+ "?,?,?,?,?,"
					+ "?,?)";
			//3.设置占位符的参数
//		    private String cakeName;
//		    private String cakeCover;
//		    private String cakeImage1;
//		    private String cakeImage2;
//		    private String cakeIntro;
//		    private String cakeFlavor;
//		    private String material;
//		    private Integer sweet;
//		    private String temprature;
//		    private Double cakePrice;
//		    private Integer cakeStock;
//		    private Byte isHot;
//		    private Byte isNew;
//		    private Byte isRecommend;
//		    private Byte status;
//		    private Integer typeId;
		    
			Object[] param = {
					null,
					u.getCakeName(),
					u.getCakeCover(),
					u.getCakeImage1(),
					u.getCakeImage2(),
					u.getCakeIntro(),
					u.getCakeFlavor(),
					u.getMaterial(),
					u.getSweet(),
					u.getTemprature(),
					u.getCakePrice(),
					u.getCakeStock(),
					u.getIsHot(),
					u.getIsNew(),
					u.getIsRecommend(),
					u.getStatus(),
					u.getTypeId()
					};
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
	public int update(Cake u) {		
		try {
			//2.编写 占位符方式 SQL
			String sql="update Cake set CakeName=? where CakeId=?";
			//3.设置占位符的参数
			Object[] param = {u.getCakeName(),u.getCakeId()};
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
//	public Cake login(String uName, String pwd) {
//		try {
//		    //2.编写SQL
//		    String sql = "select * from tb_Cake where CakeName = ? and pwd = ?";
//		    //3.执行查询
//		    List<Cake> Cakes = qr.query(sql, new BeanListHandler<Cake>(Cake.class),uName,pwd);
//		    return Cakes.get(0);
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
		    String sql = "delete from Cake where CakeId = ?";
		    //只有一个参数,不需要创建数组
		    return qr.update(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
