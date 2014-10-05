package demo;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class HelloController extends Controller {
	public void index(){
		renderText("Gao Ji!");
	}
	
	@ActionKey("/login")
	public void login(){
		getPara();
		render("login.html");
	}
}
