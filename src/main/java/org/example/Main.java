package org.example;

import java.sql.SQLException;
import java.util.Optional;

import org.example.controller.PlayerController;
import org.example.controller.PlayerDTO;
import org.example.model.PlayerModel;
import org.example.vista.PlayerVista;

public class Main {
  public static void main(String[] args) throws SQLException {
    PlayerModel model = new PlayerModel();
    PlayerVista vista = new PlayerVista();

    PlayerController controller = new PlayerController(model, vista);

    while (true) {
      switch (vista.menu()) {
        case 1 -> {
          controller.addPlayerController();
        }
        case 2 -> {
          controller.checkAllPlayersController();
        }
        case 3 -> {
          controller.updatePlayerController();
        }
        case 4 -> {
          controller.deletePlayerController();
        }
        case 5 -> {
          controller.comparePlayerController();
        }
        case 6 -> {
          controller.visualizePlayerController();
        }
        case 7 -> {
          System.exit(0);
        }
      }
    }
  }
}
