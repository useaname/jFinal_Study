package demo.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class User extends Model<User> {
	
	public static final User dao = new User();
	
	/*分页用户查询*/
	public Page<User> getUser(int pageNumber,int pageSize){
		Page<User> page = dao.paginate(pageNumber, pageSize, "select *", "from user");
		return page;
	}
	
	/*增加用户*/
	public int addUser(){
		this.save();
		return this.get("id");
	}
	
	/*更新用户信息*/
	public int updateUser(){
		this.update();
		return this.get("id");
	}
	
	/*删除用户*/
	public boolean  delete(){
		boolean res = dao.deleteById(this.get("id"));
		return res;
	}
	
	/*查询用户1*/
	public User findById(){
		String sql = "select * from user where id=?";
		User user = dao.findFirst(sql, this.get("id"));
		return user;
	}
	
	/*查询用户2*/
	public User findUserById(){
		User user = dao.findById(this.get("id"));
		return user;
	}
	
	/*查询用户3*/
	public User findUserById(int id){
		String sql = "select * from user where id="+id;
		User user = dao.findFirst(sql);
		System.out.println(user);
		return user;
	}
}

