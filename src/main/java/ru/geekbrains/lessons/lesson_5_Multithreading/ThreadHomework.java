package ru.geekbrains.lessons.lesson_5_Multithreading;

import java.util.Arrays;

public class ThreadHomework extends Thread {

  public static void main(String[] args) throws InterruptedException {
    oneMethod();
    twoMethod();
  }

  public static void oneMethod() throws InterruptedException {
    final int size =10000000;
    float[] arr = new float[size];
    Arrays.fill(arr, 1);
    long start = System.currentTimeMillis();
    Thread one = new Thread(() -> {
      for (int i = 0; i < arr.length; i++) {
        arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(
            0.4f + i / 2));
      }
      System.out.printf("Time one Thread №:%s = %d ms. \n", Thread.currentThread().getName(),
          (System.currentTimeMillis() - start));
    });
    one.start();
    one.join();
  }


  public static void twoMethod() throws InterruptedException {
    final int size =
        10000000;
    final int half = size / 2;
    float[] arr2 = new float[size];
    Arrays.fill(arr2, 1);
    long Start = System.currentTimeMillis();
    float[] myArrayLeft = new float[half];
    float[] myArrayRight = new float[half];
    System.arraycopy(arr2, 0, myArrayLeft, 0, half);
    System.arraycopy(arr2, half, myArrayRight, 0, half);
    Thread one = new Thread(() -> {
      for (int i = 0; i < myArrayLeft.length; i++) {
        myArrayLeft[i] = (float) (myArrayLeft[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
            * Math.cos(0.4f + i / 2));
      }
    });
    one.start();

    Thread two = new Thread(() -> {
      for (int i = 0; i < myArrayRight.length; i++) {
        myArrayRight[i] = (float) (myArrayRight[i] * Math.sin(0.2f + (i + half) / 5) * Math.cos(
            0.2f + (i + half) / 5)
            *
            Math.cos(0.4f + (i + half) / 2));
      }
    });
    two.start();
    two.join();
    one.join();
    float[] result = new float[size];
    System.arraycopy(myArrayLeft, 0, result, 0, half);
    System.arraycopy(myArrayRight, 0, result, half, half);
    System.out.printf("Time two Thread №:%s = %d ms. \n", Thread.currentThread().getName(),
        (System.currentTimeMillis() - Start));
  }
}



