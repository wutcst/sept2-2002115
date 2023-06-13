/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul.Entity;

import java.util.ArrayList;
import java.util.Random;

public class Game {
//    private Room currentRoom; // Player类中已经包含了currentRoom信息
    private Player currentPlayer;   // 当前玩家
    private final ArrayList<Room> gameRooms;  // 保存游戏中的所有非传输房间，以实现随机传送房间的功能

    public Game()
    {
//        currentRoom = null;
        currentPlayer = null;
        gameRooms = new ArrayList<>();
        createRooms();
    }

    private void createRooms()
    {
        Room outside, theater, pub, lab, office, transfer;

        // create the rooms
        outside = new Room("outside","outside the main entrance of the university");
        theater = new Room("theater","in a lecture theater");
        pub = new Room("pub","in the campus pub");
        lab = new Room("lab","in a computing lab");
        office = new Room("office","in the computing admin office");
        transfer = new Room("transfer","transfer room");
        transfer.setTransfer(true);

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);
        theater.addObject(new RoomObject("TV", 40));
        theater.addObject(new RoomObject("seat", 5));

        pub.setExit("east", outside);
        pub.setExit("north", transfer);
        pub.addObject(new RoomObject("cup", 2));
        pub.addObject(new RoomObject("wine", 5));

        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.addObject(new RoomObject("microscope", 30));
        lab.addObject(new RoomObject("computer", 30));

        office.setExit("west", lab);
        office.addObject(new RoomObject("desk", 20));
        office.addObject(new RoomObject("book", 10));
        office.addObject(new RoomObject("pen", 3));

        gameRooms.add(outside);
        gameRooms.add(theater);
        gameRooms.add(pub);
        gameRooms.add(lab);
        gameRooms.add(office);

        if (currentPlayer != null) {
            currentPlayer.currentRoom = outside;
        }
//        currentRoom = outside;  // start game outside
    }

    public Room randomNonTransferRoom() {
        return gameRooms.get(new Random().nextInt(gameRooms.size()));
    }

//    public Room getCurrentRoom() {
//        return currentRoom;
//    }

//    public void setCurrentRoom(Room room){
//        this.currentRoom = room;
//    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}