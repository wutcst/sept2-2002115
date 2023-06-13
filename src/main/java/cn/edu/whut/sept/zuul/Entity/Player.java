package cn.edu.whut.sept.zuul.Entity;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final String password;
    private final ArrayList<RoomObject> carryObjects; // 玩家随身携带的物品集合
    private final int maxObjectWeight;  // 玩家随身携带物品重量的上限
    public Room currentRoom;


    public Player(String name, String password) {
        this.name = name;
        this.password = password;
        this.maxObjectWeight = 0;
        this.carryObjects = new ArrayList<>();
        this.currentRoom = null;
    }

    public Room getCurrentRoom() { return currentRoom; }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void takeObject(RoomObject roomObject) {
        if (roomObject == null) {
            return;
        }

        // 判断是否超过重量上限
        int weight = 0;
        for (RoomObject o: carryObjects) {
            weight += o.getWeight();
        }

        if (roomObject.getWeight() + weight > maxObjectWeight) {
            return;
        }

        // 若不超过，将该物品加入到玩家随身携带的物品集合中
        carryObjects.add(roomObject);
    }

    public void dropObject(RoomObject roomObject) {
        if (roomObject == null) {
            return;
        }

        for (int i = 0; i < carryObjects.size(); i++) {
            if (carryObjects.get(i) == roomObject) {
                carryObjects.remove(i);
                return;
            }
        }
    }

    public ArrayList<RoomObject> getCarryObjects() {
        return carryObjects;
    }
}
