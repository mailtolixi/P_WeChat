package com.nnsuu.p.front;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * Created by user on 16-8-13.
 */
public class P_Front_Login_Interceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();

        if ("Smith".equals(controller.getPara("name").toString())) {
            inv.invoke();
        } else {
            controller.redirect("/nulls");
        }
    }
}
