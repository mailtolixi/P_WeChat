package com.nnsuu.p;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.render.ViewType;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.nnsuu.p.front.P_Home_Page_Controller;

public class P_WeChat_Config extends JFinalConfig {

    public void configConstant(Constants me) {
        //加载配置文件
        PropKit.use("config.txt");
        me.setEncoding("utf-8");
        me.setViewType(ViewType.JSP);
        //是否为开发模式
        me.setDevMode(PropKit.getBoolean("devMode", false));
        ApiConfigKit.setDevMode(me.getDevMode());
    }
    public void configRoute(Routes me) {
        me.add("/", P_Home_Page_Controller.class);
        me.add("/msg", P_WeChat_Controller.class);
        me.add("/api", P_WeChat_Api_Controller.class, "/api");
    }
    public void configPlugin(Plugins me) {
        //数据库连接
        // C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        // me.add(c3p0Plugin);

        // EhCachePlugin ecp = new EhCachePlugin();
        // me.add(ecp);
    }

    public void configInterceptor(Interceptors me) {

    }

    public void configHandler(Handlers me) {

    }


    public static void main(String[] args){
        JFinal.start("web", 8080, "/", 5);
    }
}