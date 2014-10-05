package demo;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;

import demo.kit.ReadProperties;
import demo.model.User;

public class DemoConfig extends JFinalConfig{

	
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
		me.add("/api/user",UserController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		/*配置连接池*/
		DruidPlugin dp = new DruidPlugin(ReadProperties.getProperty("jdbcUrl"), ReadProperties.getProperty("dbUser"), ReadProperties.getProperty("dbPwd"));
		WallFilter wall = new WallFilter();
		wall.setDbType(ReadProperties.getProperty("dbType"));
		dp.addFilter(wall);
		dp.addFilter(new StatFilter());
		dp.setMaxActive(150);
		me.add(dp);
		
		/*配置活动记录的支持*/
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		arp.setDialect(new MysqlDialect());
		me.add(arp);
		
		/*添加表映射*/
		arp.addMapping("User", "id",User.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}
	
}
