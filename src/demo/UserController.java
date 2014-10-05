package demo;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

import demo.model.User;

public class UserController extends Controller {
	public void list(){
		int pageNumber = this.getParaToInt(0, 1);
		int pageSize = this.getParaToInt(1,10);
		Page<User> page = User.dao.getUser(pageNumber, pageSize);
		renderJson(page);
	}
	
	
	public void add(){
		//String name = getPara("name");
		User user = getModel(User.class);
		int id = user.addUser();
		//int id = User.dao.addUser(name);
		if(id>0){
			renderJson("{\"status\":1, \"id\":"+id+"}");
		}else{
			renderJson("{\"status\":0}");
		}
	}
	
	
	public void  changeInfo(){
		User user = getModel(User.class);
		int id = user.updateUser();
		if(id>0){
			renderJson("{\"status\":1, \"id\":"+id+"}");
		}else{
			renderJson("{\"status\":0}");
		}
	}
}
