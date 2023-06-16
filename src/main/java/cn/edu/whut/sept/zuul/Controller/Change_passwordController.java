package cn.edu.whut.sept.zuul.Controller;


import cn.edu.whut.sept.zuul.Mapper.UsertMapper;
import cn.edu.whut.sept.zuul.Service.UsertService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class Change_passwordController {
    @Resource
    UsertService usertService;
    @Resource
    UsertMapper usertMapper;

    @RequestMapping(value = "/change_password")
    public ModelAndView change_password(){
        ModelAndView model=new ModelAndView("change_password");
        return model;
    }
    protected Map<String, Object> resultMap=new LinkedHashMap<String, Object>();
    @RequestMapping(value = "/change_passsword_do",method = RequestMethod.POST)
    @ResponseBody
    public Object change_password_do(String username,String password)
    {
        try
        {
//            UserT userT=usertMapper.getUserByName(username);
//            userT.setPassword(password);
//            if(usertService.userChange_Password(userT))
            if(usertService.userpdchange(username,password))
            {
                resultMap.put("status",200);
                resultMap.put("message","修改成功");
            }
            else
            {
                resultMap.put("status",500);
                resultMap.put("message","无该用户");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            resultMap.put("status",406);
            resultMap.put("message",e.getMessage());
        }
        return resultMap;
    }
}
