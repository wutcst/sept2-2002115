package cn.edu.whut.sept.zuul.Entity;

import java.util.ArrayList;

public class Player {
    private final ArrayList<RoomObject> carryObjects; // 玩家随身携带的物品集合

    public int getMaxObjectWeight() {
        return maxObjectWeight;
    }

    private final int maxObjectWeight;  // 玩家随身携带物品重量的上限
    public Room currentRoom;


    public Player() {
        this.maxObjectWeight = 10;
        this.carryObjects = new ArrayList<>();
        this.currentRoom = null;
    }

    public Room getCurrentRoom() { return currentRoom; }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean takeObject(RoomObject roomObject) {
        if (roomObject == null) {
            return false;
        }else {
            int weight = 0;
            for (RoomObject o: carryObjects) {
                weight += o.getWeight();
            }

            if (roomObject.getWeight() + weight > maxObjectWeight) {
                return false;
            }else {
                // 若不超过，将该物品加入到玩家随身携带的物品集合中
                carryObjects.add(roomObject);
                currentRoom.getRoomObjects().remove(roomObject);
                return true;
            }
            }


        // 判断是否超过重量上限

    }

    public boolean dropObject(RoomObject roomObject) {
        if (roomObject == null) {
            return false;
        }else {
            for (int i = 0; i < carryObjects.size(); i++) {
                if (carryObjects.get(i) == roomObject) {

                    carryObjects.remove(i);
                    currentRoom.addObject(roomObject);
                    return true;
                }
            }
            return false;

        }


    }

    public ArrayList<RoomObject> getCarryObjects() {
        return carryObjects;
    }

    public RoomObject getCarryObject(String name) {

        RoomObject object=null;
        for(RoomObject ob:carryObjects){
            if (ob.name.equals(name)){
                object=ob;
            }
        }
        return object;
    }
}
