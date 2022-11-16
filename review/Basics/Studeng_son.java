package Basics;

public class Studeng_son extends Student implements jumping{

    int age = 30;
    public Studeng_son(int age, String name) {
        super(age, name);
    }
    @Override
    public void show() {
        System.out.println(age);
    }

    @Override
    public void jumping() {
        System.out.println("jumping");
    }
}
