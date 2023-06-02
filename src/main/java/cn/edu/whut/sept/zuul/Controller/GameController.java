package cn.edu.whut.sept.zuul.Controller;

import cn.edu.whut.sept.zuul.Entity.Game;
import cn.edu.whut.sept.zuul.Service.ICommandService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
public class GameController {
    private final cn.edu.whut.sept.zuul.Entity.Game game = new Game();
    private final HashMap<Object, Object> resultMap=new HashMap<>();
    @Resource
    private ICommandService CommandService;
    @RequestMapping(value = "/Game")
    public ModelAndView Game(){
        return new ModelAndView("Game");
    }
    @RequestMapping(value = "/GO",method = RequestMethod.POST)
    @ResponseBody
    public Object GO(String direction){
        String message;
        if(CommandService.DoCommandGO(game,direction)){
            message=game.getCurrentRoom().getLongDescription();
            resultMap.put("status",1);
            resultMap.put("discription",message);
            return resultMap;
        }else{
            message="There is no door!";
            resultMap.put("status",0);
            resultMap.put("discription",message);
            return resultMap;
        }

    }
    @RequestMapping(value = "/HELP")
    public void HELP(){

    }
    @RequestMapping(value = "/QUIT")
    public void QUIT(){

    }
}
