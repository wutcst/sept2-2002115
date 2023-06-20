package cn.edu.whut.sept.zuul.Service;

import cn.edu.whut.sept.zuul.Entity.UserT;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UsertServiceTest {

    @Test
    void userLogin() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            UserT user = new UserT(11,"a","123","33@qq.com", simpleDateFormat.parse("2001-01-01") ,10.0f);
            UsertService UsertService = new UsertService();
            UsertService.userLogin(user);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void userRegister() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            UserT user = new UserT(11,"a","123","33@qq.com", simpleDateFormat.parse("2001-01-01") ,10.0f);
            UsertService UsertService = new UsertService();
            UsertService.userRegister(user);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void userChange_Password() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            UserT user = new UserT(11,"a","123","33@qq.com", simpleDateFormat.parse("2001-01-01") ,10.0f);
            UsertService UsertService = new UsertService();
            UsertService.userChange_Password(user);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void userpdchange() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            UserT user = new UserT(11,"a","123","33@qq.com", simpleDateFormat.parse("2001-01-01") ,10.0f);
            UsertService UsertService = new UsertService();
            UsertService.userpdchange("a","123");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}