package cn.edu.whut.sept.zuul.Service;

import cn.edu.whut.sept.zuul.Entity.Game;
import cn.edu.whut.sept.zuul.Entity.RoomObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandServiceTest {

    @Test
    void doCommandGO() {
        Game game = new Game();
        CommandService CommandService = new CommandService();
        CommandService.DoCommandGO(game,"west");
    }

    @Test
    void doCommandHELP() {
        Game game = new Game();
        CommandService CommandService = new CommandService();
        CommandService.DoCommandHELP(game);
    }

    @Test
    void doCommandQUIT() {
        Game game = new Game();
        CommandService CommandService = new CommandService();
        CommandService.DoCommandQUIT(game);
    }

    @Test
    void doCommandLOOK() {
        Game game = new Game();
        CommandService CommandService = new CommandService();
        CommandService.DoCommandLOOK(game);
    }

    @Test
    void doCommandITEMS() {
        Game game = new Game();
        CommandService CommandService = new CommandService();
        CommandService.DoCommandITEMS(game);
    }

    @Test
    void doCommandTAKE() {
        Game game = new Game();
        RoomObject roomobject = new RoomObject("pen",20);
        CommandService CommandService = new CommandService();
        CommandService.DoCommandTAKE(game,roomobject);
    }

    @Test
    void doCommandDROP() {
        Game game = new Game();
        RoomObject roomobject = new RoomObject("pen",20);
        CommandService CommandService = new CommandService();
        CommandService.DoCommandDROP(game,roomobject);
    }

    @Test
    void doCommandBACK() {
        Game game = new Game();
        CommandService CommandService = new CommandService();
        CommandService.DoCommandBACK(game);
    }
}