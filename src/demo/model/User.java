package demo.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class User extends Model<User> {
	
	public static final User dao = new User();
	
	public Page<User> getUser(int pageNumber,int pageSize){
		Page<User> page = dao.paginate(pageNumber, pageSize, "select *", "from user");
		return page;
	}
	
	
	public int addUser(){
		this.save();
		return this.get("id");
	}
	
	public int updateUser(){
		this.update();
		return this.get("id");
	}
}

