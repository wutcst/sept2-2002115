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
import java.util.Set;

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
            message=game.getCurrentPlayer().currentRoom.getLongDescription();
            resultMap.put("status",1);
            resultMap.put("discription",message);
            resultMap.put("name",game.getCurrentPlayer().currentRoom.getName());
            resultMap.put("east",0);
            resultMap.put("west",0);
            resultMap.put("south",0);
            resultMap.put("north",0);
            Set<String> keys = game.getCurrentPlayer().currentRoom.getExit().keySet();
            for(String exit : keys) {
                resultMap.replace(exit,1);
            }
            return resultMap;
        }else{
            message="There is no door!";
            resultMap.put("status",0);
            resultMap.put("discription",message);
            return resultMap;
        }

    }
    @RequestMapping(value = "/LOOK",method = RequestMethod.GET)
    @ResponseBody
    public Object LOOK(){
        String message;
        message=CommandService.DoCommandLOOK(this.game);
        resultMap.put("message",message);
        return resultMap;
    }
    @RequestMapping(value = "/GetCurrentRoom",method = RequestMethod.GET)
    @ResponseBody
    private Object GetCurrentRoom(){
        resultMap.put("discription",this.game.getCurrentPlayer().currentRoom.getLongDescription());
        resultMap.put("name",game.getCurrentPlayer().currentRoom.getName());
        resultMap.put("east",0);
        resultMap.put("west",0);
        resultMap.put("south",0);
        resultMap.put("north",0);
        Set<String> keys = game.getCurrentPlayer().currentRoom.getExit().keySet();
        for(String exit : keys) {
            resultMap.replace(exit,1);
        }
        return resultMap;
    }

    @RequestMapping(value = "/BACK",method = RequestMethod.GET)
    @ResponseBody
    private Object BACK(){
        CommandService.DoCommandBACK(game);
        resultMap.put("discription",this.game.getCurrentPlayer().currentRoom.getLongDescription());
        resultMap.put("name",game.getCurrentPlayer().currentRoom.getName());
        resultMap.put("east",0);
        resultMap.put("west",0);
        resultMap.put("south",0);
        resultMap.put("north",0);
        Set<String> keys = game.getCurrentPlayer().currentRoom.getExit().keySet();
        for(String exit : keys) {
            resultMap.replace(exit,1);
        }
        return resultMap;
    }

}
