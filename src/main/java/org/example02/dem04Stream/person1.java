package org.example02.dem04Stream;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2023/5/10 22:49
 */
public class person1 {
    private String name;
    public person1() {}
    public person1(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
