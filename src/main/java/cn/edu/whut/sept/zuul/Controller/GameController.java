package cn.edu.whut.sept.zuul.Controller;

import cn.edu.whut.sept.zuul.Entity.Game;
import cn.edu.whut.sept.zuul.Service.ICommandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
public class GameController {
    private final Game game = new Game();
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
        resultMap.put("direct",direction);
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
    @RequestMapping(value = "/GetCurrentRoom",method = RequestMethod.GET)
    @ResponseBody
    private Object testJson(){
        resultMap.put("discription",this.game.getCurrentRoom().getLongDescription());
        return resultMap;
    }

}
