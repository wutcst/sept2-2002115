package cn.edu.whut.sept.zuul.Service;

import cn.edu.whut.sept.zuul.Entity.Game;
import cn.edu.whut.sept.zuul.Entity.Room;
import org.springframework.stereotype.Service;

@Service("CommandService")
public class CommandService implements ICommandService{
    //暂时在这个方法里实现所有命令的执行
    @Override
    public boolean DoCommandGO(Game game,String direction) {
        //方位判断放在前端
        Room currentRoom = game.getCurrentRoom();

        Room nextRoom = game.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
//            System.out.println("There is no door!");
            return false;
        }
        else {
            game.setCurrentRoom(nextRoom);
            return true;
        }

    }

    @Override
    public void DoCommandHELP(Game game) {

    }

    @Override
    public void DoCommandQUIT(Game game) {

    }
}
