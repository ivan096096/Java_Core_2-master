package ru.geekbrains.lessons.lesson_6_Chat;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Client_Chat {

  private static final String HOST = "127.0.0.1";
  private static final int PORT = 8181;
  private DataInputStream in;
  private DataOutputStream out;
  private Thread clientConsoleThread;

  public static void main(String[] args) {
    new Client_Chat().start();
  }

  public void start() {
    try (var socket = new Socket(HOST, PORT)) {
      System.out.println("Подключение к серверу");
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      startConsoleThread();

      while (true) {
        var message = in.readUTF();
        System.out.println("Получено: " + message);
      }
    } catch (SocketException e) {
      System.out.println("Соединение с сервером было потеряно");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        shutdown();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void shutdown() throws IOException {
    if (clientConsoleThread.isAlive()) {
      clientConsoleThread.interrupt();
    }
    System.out.println("Отключение клиента!");
  }

  private void startConsoleThread() {
    clientConsoleThread = new Thread(() -> {
      try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
        System.out.print("Введите сообщение для сервера >>>> ");
        while (!Thread.currentThread().isInterrupted()) {
          if (reader.ready()) {
            var clientMessage = reader.readLine();
            if (clientMessage.equalsIgnoreCase("/quit")) {
              out.writeUTF("/end");
              shutdown();
            }
            out.writeUTF(clientMessage);
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    clientConsoleThread.start();
  }
}

