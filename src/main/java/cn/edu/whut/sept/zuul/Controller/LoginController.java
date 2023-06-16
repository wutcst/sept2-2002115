package cn.edu.whut.sept.zuul.Controller;


import cn.edu.whut.sept.zuul.Entity.UserT;
import cn.edu.whut.sept.zuul.Service.IUsertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    private IUsertService usertService;
    protected Map<String, Object> resultMap=new LinkedHashMap<String, Object>();

    @RequestMapping(value = "/login")
    public ModelAndView login()
    {
        ModelAndView model=new ModelAndView("login");
        return model;
    }

    @RequestMapping(value = "/logindo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> logindo(UserT user , ModelMap modelMap, HttpServletRequest request){
        try{
            if(usertService.userLogin(user)){
                //登陆成功去主页
                resultMap.put("status",200);
                resultMap.put("message","登陆成功");
                request.getSession().setAttribute("user",user);
            }else{
                resultMap.put("status",500);
                resultMap.put("message","账户或密码错误");
            }
        }catch (Exception e){
            resultMap.put("status",406);
            resultMap.put("message","系统出错");
        }

        return resultMap;
    }
}
