package com.nnsuu.p.front;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * Created by user on 16-8-12.
 */
public class P_Home_Page_Controller extends Controller{
    public void index(){
        render("front/Home_Page.html");
    }

    public void login(){
        render("front/Home_Login.html");
    }

    @Before(P_Front_Login_Interceptor.class)
    public void test(){
        renderText("123321");
    }
    public void nulls(){
        renderText("hhh");
    }

    public void suuwebalpha(){
        render("suuwebalpha/SuuPage.html");
    }
}
