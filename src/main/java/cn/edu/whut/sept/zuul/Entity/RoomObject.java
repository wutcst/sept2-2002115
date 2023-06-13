package cn.edu.whut.sept.zuul.Entity;

public class RoomObject {
    private final String name; // 描述信息
    private final int weight; // 重量

    //物品坐标
    private int left;
    private int top;

    public RoomObject(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getGameDescription() {
        return "description: " + name +
                ",  weight: " +
                weight;
    }

    public int getWeight() {
        return weight;
    }
}
