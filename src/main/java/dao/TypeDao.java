package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Type;
import util.DruidUtil;

public class TypeDao {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new TypeDao().findAll());
	}
	
	//通过QueryRunner处理数据CRUD
	QueryRunner qr=new QueryRunner(DruidUtil.dataSource);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Type> findAll(){
		try {
		    //2.编写SQL
		    String sql = "select * from Type where 1=?";
		    //3.执行查询
		    List<Type> data = qr.query(sql, new BeanListHandler<Type>(Type.class),1);
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
	public Type getOne(int id) {
		try {
		    //2.编写SQL
		    String sql = "select * from type where typeId=?";
		    //3.执行查询
		    List<Type> data = qr.query(sql, new BeanListHandler<Type>(Type.class),id);
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
	public int add(Type u) {		
		try {
			//2.编写 占位符方式 SQL
			String sql = "insert into Type values(?,?)";
			//3.设置占位符的参数
			Object[] param = {null,u.getTypeName()};
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
	public int update(Type u) {		
		try {
			//2.编写 占位符方式 SQL
			String sql="update Type set typeName=? where TypeId=?";
			//3.设置占位符的参数
			Object[] param = {u.getTypeName(),u.getTypeId()};
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
//	public Type login(String uName, String pwd) {
//		try {
//		    //2.编写SQL
//		    String sql = "select * from tb_Type where TypeName = ? and pwd = ?";
//		    //3.执行查询
//		    List<Type> Types = qr.query(sql, new BeanListHandler<Type>(Type.class),uName,pwd);
//		    return Types.get(0);
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
		    String sql = "delete from type where TypeId = ?";
		    //只有一个参数,不需要创建数组
		    return qr.update(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
