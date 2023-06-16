package cn.edu.whut.sept.zuul.Controller;


import cn.edu.whut.sept.zuul.Entity.UserT;
import cn.edu.whut.sept.zuul.Service.UsertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class RegisterController {
    @Resource
    UsertService usertService;

    @RequestMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView model=new ModelAndView("register");
        return model;
    }

    protected Map<String,Object> resultMap = new LinkedHashMap<>();
    @RequestMapping(value = "/registerdo",method = RequestMethod.POST)
    @ResponseBody
    public Object registerdo(UserT userT, ModelMap modelMap)
    {
        try
        {
            if(usertService.userRegister(userT))
            {
                resultMap.put("status",200);
                resultMap.put("message","注册成功");
            }
            else
            {
                resultMap.put("status",500);
                resultMap.put("message","已存在该用户!");
            }
        }
        catch (Exception e)
        {
            resultMap.put("status",406);
            resultMap.put("message",e.getMessage());
        }
        return resultMap;
    }
}
