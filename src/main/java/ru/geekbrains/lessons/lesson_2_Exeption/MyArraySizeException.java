package ru.geekbrains.lessons.lesson_2_Exeption;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {

    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
