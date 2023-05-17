package org.example02.dem04Stream;

/**
 * @Author ZhangYiFan
 * @Date 2023/5/17 13:18
 * @description:
 * @Version 1.0
 */
public class Student {
    private String name;
    private int  age;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
