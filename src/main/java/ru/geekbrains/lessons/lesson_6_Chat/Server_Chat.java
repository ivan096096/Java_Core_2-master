package ru.geekbrains.lessons.lesson_6_Chat;

import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;

import java.util.ArrayList;

import java.util.List;


public class Server_Chat {
  public static void main(String[] args) {
    new Server_Chat().start();
  }

  private static final int PORT = 8189;

  private List<ServerHandlerThread> handlers;


  public Server_Chat() {

    this.handlers = new ArrayList<>();

  }


  public void start() {

    try (ServerSocket serverSocket = new
        ServerSocket(PORT)) {

      System.out.println("Server start!");

      while (true) {

        System.out.println("Waiting for connection......");

        Socket socket = serverSocket.accept();

        System.out.println("Client connected");

        ServerHandlerThread handler = new ServerHandlerThread(socket, this);

        handlers.add(handler);

        handler.handle();

      }

    } catch (IOException e) {

      e.printStackTrace();

    }

  }


  public void broadcast(String message) {

    for (ServerHandlerThread handler : handlers) {

      handler.send(message);

    }

  }

}