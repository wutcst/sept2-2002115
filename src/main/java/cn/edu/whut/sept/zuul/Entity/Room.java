package cn.edu.whut.sept.zuul.Entity;

import java.util.HashMap;
import java.util.Set;

public class Room {
    private final String description;
    private final HashMap<String, cn.edu.whut.sept.zuul.Entity.Room> exits;        // stores exits of this room.

    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, cn.edu.whut.sept.zuul.Entity.Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public cn.edu.whut.sept.zuul.Entity.Room getExit(String direction)
    {
        return exits.get(direction);
    }
}
