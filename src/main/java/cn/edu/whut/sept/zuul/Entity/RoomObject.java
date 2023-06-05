package cn.edu.whut.sept.zuul.Entity;

public class RoomObject {
    private final String description; // 描述信息
    private final int weight; // 重量

    public RoomObject(String description, int weight) {
        this.description = description;
        this.weight = weight;
    }

    public String getGameDescription() {
        return "description: " + description +
                ",  weight: " +
                weight;
    }
}
