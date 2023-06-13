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

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
//            System.out.println("There is no door!");
            return false;
        }
        else {
            game.setCurrentRoom(nextRoom);

            // 如果是传输房间，随机去另一个非传输房间
            if (nextRoom.getTransfer()) {
                // （可在此输出提示信息）
                game.setCurrentRoom(game.randomNonTransferRoom());
            }

            return true;
        }

    }

    @Override
    public void DoCommandHELP(Game game) {

    }

    @Override
    public void DoCommandQUIT(Game game) {

    }

    @Override
    public String DoCommandLOOK(Game game) {

        return game.getCurrentRoom().getShortDescription()
                + "\n\nThings in this room:\n"
                + game.getCurrentRoom().getObjectsDescription()
                + "\n"
                + game.getCurrentRoom().getExitString();
    }
}
