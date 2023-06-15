package cn.edu.whut.sept.zuul.Service;

import cn.edu.whut.sept.zuul.Entity.Game;
import cn.edu.whut.sept.zuul.Entity.RoomObject;

public interface ICommandService {
    boolean DoCommandGO(Game game,String direction);
    void DoCommandHELP(Game game);
    void DoCommandQUIT(Game game);
    String DoCommandLOOK(Game game);
    void DoCommandBACK(Game game);
    String DoCommandITEMS(Game game);
    boolean DoCommandTAKE(Game game, RoomObject roomObject);
    boolean DoCommandDROP(Game game, RoomObject roomObject);
}
