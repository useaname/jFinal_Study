package demo;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

import demo.model.User;

public class UserController extends Controller {
	
	public void index(){
		list();
	}
	
	
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
			renderJson("{ \"status\":1, \"id\":"+id+"}");
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
	
	public void del(){
		User user = getModel(User.class);
		boolean res = user.delete();
		if(res){
			renderJson("{\"status\":1}");
		}else{
			renderJson("{\"status\":0}");
		}
	}
	
	/*手动传入id*/
	public void getOneUser(){
		int uid = this.getParaToInt("id");
		User user  = new User();
		user = user.findUserById(uid);
		if(StrKit.notNull(user)){
			renderJson(user);
		}else{
			renderJson("{}");
		}
	}
	
	/*getModel传入Id*/
	public void getOneUser2(){
		User user = getModel(User.class);
		user = user.findById();
		if(StrKit.notNull(user)){
			renderJson(user);
		}else{
			renderJson("{}");
		}
	}
	
}
