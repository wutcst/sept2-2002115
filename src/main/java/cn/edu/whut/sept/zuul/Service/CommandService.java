package cn.edu.whut.sept.zuul.Service;

import cn.edu.whut.sept.zuul.Entity.Game;
import cn.edu.whut.sept.zuul.Entity.Room;
import cn.edu.whut.sept.zuul.Entity.RoomObject;
import org.springframework.stereotype.Service;

@Service("CommandService")
public class CommandService implements ICommandService{
    //暂时在这个方法里实现所有命令的执行
    @Override
    public boolean DoCommandGO(Game game,String direction) {
        //方位判断放在前端
        Room currentRoom = game.getCurrentPlayer().currentRoom;

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
//            System.out.println("There is no door!");
            return false;
        }
        else {
            game.getCurrentPlayer().setCurrentRoom(nextRoom);

            // 如果是传输房间，随机去另一个非传输房间
            if (nextRoom.getTransfer()) {
                // （可在此输出提示信息）
                game.getCurrentPlayer().setCurrentRoom(game.randomNonTransferRoom());
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

        return game.getCurrentPlayer().getCurrentRoom().getShortDescription()
                + "\n\nThings in this room:\n"
                + game.getCurrentPlayer().getCurrentRoom().getObjectsDescription()
                + "\n"
                + game.getCurrentPlayer().getCurrentRoom().getExitString();
    }

    @Override
    public String DoCommandITEMS(Game game) {
        if (game.getCurrentPlayer() == null) {
            return "Player not logged in!\n";
        }
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("current room: ").append(game.getCurrentPlayer().getCurrentRoom().getShortDescription()).append("\n");
        stringBuilder.append("Things in the room: ").append(game.getCurrentPlayer().getCurrentRoom().getObjectsDescription()).append("\n");
        stringBuilder.append("carried objects:\n");

        for (RoomObject o: game.getCurrentPlayer().getCarryObjects()) {
            stringBuilder.append(o.getGameDescription()).append("\n");
        }

        return stringBuilder.toString();
    }

    @Override
    public void DoCommandTAKE(Game game, RoomObject roomObject) {
        game.getCurrentPlayer().takeObject(roomObject);
    }

    @Override
    public void DoCommandDROP(Game game, RoomObject roomObject) {
        game.getCurrentPlayer().dropObject(roomObject);
    }

    public void DoCommandBACK(Game game){
        Room saveRoom = game.getCurrentRoom();
        game.setCurrentRoom(game.getLastRoom());
        game.setLastRoom(saveRoom);
    }
}
