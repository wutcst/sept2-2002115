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

import cn.edu.whut.sept.zuul.Entity.Command;
import cn.edu.whut.sept.zuul.Entity.Room;

public class Game
{
    private cn.edu.whut.sept.zuul.Entity.Room currentRoom;

    public Game()
    {
        createRooms();
    }

    private void createRooms()
    {
        cn.edu.whut.sept.zuul.Entity.Room outside, theater, pub, lab, office;

        // create the rooms
        outside = new cn.edu.whut.sept.zuul.Entity.Room("outside the main entrance of the university");
        theater = new cn.edu.whut.sept.zuul.Entity.Room("in a lecture theater");
        pub = new cn.edu.whut.sept.zuul.Entity.Room("in the campus pub");
        lab = new cn.edu.whut.sept.zuul.Entity.Room("in a computing lab");
        office = new cn.edu.whut.sept.zuul.Entity.Room("in the computing admin office");

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside
    }

    public cn.edu.whut.sept.zuul.Entity.Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }
}