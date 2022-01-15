package ru.geekbrains.lessons.lesson_1;

public class Human implements Sportsman{
    public int distans ;
    public int Jump;
    private String name;

    public Human(int distans,int Jump,String name){
        this.distans = distans;
        this.Jump = Jump;
        this.name = name;
    }


    @Override
    public boolean run(int length) {return this.distans >= length;}

    @Override
    public boolean jump(int height) {return this.Jump >= height;}

    @Override
    public String getName() {return this.name;}
}
