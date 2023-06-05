package cn.edu.whut.sept.zuul.Service;

import cn.edu.whut.sept.zuul.Entity.Game;

public interface ICommandService {
    boolean DoCommandGO(Game game,String direction);
    void DoCommandHELP(Game game);
    void DoCommandQUIT(Game game);
    String DoCommandLOOK(Game game);
}
