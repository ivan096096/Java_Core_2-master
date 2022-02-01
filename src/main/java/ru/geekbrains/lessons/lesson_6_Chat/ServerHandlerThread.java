package ru.geekbrains.lessons.lesson_6_Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerHandlerThread {
  private static int clientCounter = 0;
  private int clientNumber;
  private Socket socket;
  private DataOutputStream out;
  private DataInputStream in;
  private Thread handlerThread;
  private Server_Chat server;

  public ServerHandlerThread(Socket socket, Server_Chat server) {
    try {
      this.server = server;
      this.socket = socket;
      this.in = new DataInputStream(socket.getInputStream());
      this.out = new DataOutputStream(socket.getOutputStream());
      System.out.println("Handler created");
      this.clientNumber = ++clientCounter;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void handle() {
    handlerThread = new Thread(() -> {
      while (!Thread.currentThread().isInterrupted() && socket.isConnected()) {
        try {
          String message = in.readUTF();
          message = "client #" + this.clientNumber + ": " + message;
          server.broadcast(message);
          System.out.printf("Client #%d: %s\n", this.clientNumber, message);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
    handlerThread.start();
  }

  public void send(String msg) {
    try {
      out.writeUTF(msg);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Thread getHandlerThread() {
    return handlerThread;
  }
}