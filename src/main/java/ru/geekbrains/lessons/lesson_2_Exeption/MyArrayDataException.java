package ru.geekbrains.lessons.lesson_2_Exeption;

public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException() {
        super();
    }

    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(int i, int j) {

    }
}
