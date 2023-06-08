package cn.edu.whut.sept.zuul.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Room {
    private String name;
    private final String description;
    private final HashMap<String, Room> exits;        // stores exits of this room.
    private final ArrayList<RoomObject> roomObjects;    // 房间内含有的物品
    private boolean transfer;   // 是否为传输房间

    public Room(String name,String description)
    {
        this.name=name;
        this.description = description;
        exits = new HashMap<>();
        roomObjects = new ArrayList<>();
        transfer = false;
    }

    public void setExit(String direction, cn.edu.whut.sept.zuul.Entity.Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    public HashMap<String, Room> getExit(){
        return exits;
    }
    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    public String getExitString()
    {
        StringBuilder returnString = new StringBuilder("Exits:");
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString.append(" ").append(exit);
        }
        return returnString.toString();
    }

    public cn.edu.whut.sept.zuul.Entity.Room getExit(String direction)
    {
        return exits.get(direction);
    }

    public void addObject(RoomObject roomObject) {
        roomObjects.add(roomObject);
    }

    public String getObjectsDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        if (roomObjects.size()==0){
            stringBuilder.append("Well……There's nothing.");
        }else{
            for (RoomObject roomObject: roomObjects) {
                stringBuilder.append(roomObject.getGameDescription()).append("\n");
            }
        }



        return stringBuilder.toString();
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public boolean getTransfer() {
        return transfer;
    }
    public String getName(){return name;}
}
