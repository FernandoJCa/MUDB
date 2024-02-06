package org.example.vista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.example.controller.PlayerDTO;

public class PlayerVista {
  private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

  public Integer menu() {
    System.out.println("Welcome to the Manchester United FC Player Management System");
    System.out.println("1. Add a new player");
    System.out.println("2. Check all players");
    System.out.println("3. Update player info");
    System.out.println("4. Remove a player from the system");
    System.out.println("5. Compare players");
    System.out.println("6. Visualize player specs");
    System.out.println("7. Exit");
    System.out.print("Select your desired option: ");

    return scanner.nextInt();
  }

  public void allPlayersView(List<PlayerDTO> playerList) {
    AsciiTable table = getAsciiTable(playerList);
    String render = table.render();
    System.out.println(render);
  }

  public PlayerDTO addPlayerView() {
    PlayerDTO player = new PlayerDTO();

    System.out.println("Insert the following data: ");
    System.out.print("Name: ");
    player.setName(scanner.next());
    System.out.print("Age: ");
    player.setAge(scanner.nextInt());
    System.out.print("Jersey: ");
    player.setJersey(scanner.nextInt());
    System.out.print("Height: ");
    player.setHeight(scanner.nextInt());
    System.out.print("Weight: ");
    player.setWeight(scanner.nextInt());
    System.out.print("Position: ");
    player.setPosition(scanner.next());
    System.out.print("Speed: ");
    player.setSpeed(scanner.nextInt());
    System.out.print("Goal: ");
    player.setGoal(scanner.nextInt());
    System.out.print("Pass: ");
    player.setPass(scanner.nextInt());

    return player;
  }

  public Integer findByJerseyView() {
    System.out.print("Type the player's jersey number: ");

    return scanner.nextInt();
  }

  public PlayerDTO updatePlayerView(PlayerDTO player) {

    System.out.println(player);
    System.out.println("================================================");

    System.out.println("Update player's information: ");
    System.out.print("Name: ");
    player.setName(scanner.next());
    System.out.print("Age: ");
    player.setAge(scanner.nextInt());
    System.out.print("Jersey: ");
    player.setJersey(scanner.nextInt());
    System.out.print("Height: ");
    player.setHeight(scanner.nextInt());
    System.out.print("Weight: ");
    player.setWeight(scanner.nextInt());
    System.out.print("Position: ");
    player.setPosition(scanner.next());
    System.out.print("Speed: ");
    player.setSpeed(scanner.nextInt());
    System.out.print("Goal: ");
    player.setGoal(scanner.nextInt());
    System.out.print("Pass: ");
    player.setPass(scanner.nextInt());

    return player;
  }

  public Integer deletePlayerView() throws SQLException {
    System.out.print("Insert the jersey number of the player you want to delete: ");
    return scanner.nextInt();
  }

  public void addPlayerConfirmation(Integer result) {
    if (result >= 1) {
      System.out.println("The player has been added");
    } else {
      System.out.println("There's an error");
    }
  }

  public void updatePlayerConfirmation(Integer result) {
    if (result >= 1) {
      System.out.println("The player has been updated");
    } else {
      System.out.println("There's an error, the players doesnt exist");
    }
  }

  public void deletePlayerConfirmation(Integer result) {
    if (result >= 1) {
      System.out.println("The player has been deleted");
    } else {
      System.out.println("There's an error, the players doesnt exist");
    }
  }

  public void comparePlayerView(List<PlayerDTO> playerList) {
    AsciiTable table = getAsciiTable(playerList);
    String render = table.render();
    System.out.println(render);
  }

  private static AsciiTable getAsciiTable(List<PlayerDTO> playerList) {
    AsciiTable table = new AsciiTable();
    table.addRule();
    table.addRow("name", "jersey", "age", "height", "weight", "position", "speed", "goal", "pass");
    table.addRule();
    for (PlayerDTO player : playerList) {
      table.addRow(
          player.getName(),
          player.getJersey(),
          player.getAge(),
          player.getHeight(),
          player.getWeight(),
          player.getPosition(),
          player.getSpeed(),
          player.getGoal(),
          player.getPass());
      table.addRule();
    }
    table.setTextAlignment(TextAlignment.CENTER);
    return table;
  }

  public void visualizePlayerView(List<PlayerDTO> playerList) {
    AsciiTable table = new AsciiTable();
    table.addRule();
    table.addRow("name", "jersey", "height", "weight", "speed", "goal", "pass");
    table.addRule();
    for (PlayerDTO player : playerList) {
      table.addRow(
          player.getName(),
          player.getJersey(),
          player.getHeight(),
          player.getWeight(),
          player.getSpeed(),
          player.getGoal(),
          player.getPass());
      table.addRule();
    }
    table.setTextAlignment(TextAlignment.CENTER);
    String render = table.render();
    System.out.println(render);
  }
}
