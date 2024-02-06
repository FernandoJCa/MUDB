package org.example.controller;

import org.example.model.PlayerModel;
import org.example.vista.PlayerVista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerController {
  private PlayerModel model;
  private PlayerVista view;
  private PlayerDTO player;

  public PlayerController(PlayerModel model, PlayerVista view) {
    this.model = model;
    this.view = view;
  }

  public void checkAllPlayersController() throws SQLException {
    view.allPlayersView(model.getAll());
  }

  public void addPlayerController() throws SQLException {
    int result = model.insertPlayer(view.addPlayerView());

    view.addPlayerConfirmation(result);
  }

  public void updatePlayerController() throws SQLException {
    player = model.findByJersey(view.findByJerseyView());

    int result;

    if (player.getName() != null) {
      result = model.updatePlayer(view.updatePlayerView(player));
      view.updatePlayerConfirmation(result);
    } else {
      view.updatePlayerConfirmation(0);
    }
  }

  public void deletePlayerController() throws SQLException {
    int result;

    result = model.deletePlayer(view.deletePlayerView());

    view.deletePlayerConfirmation(result);
  }

  public void comparePlayerController() throws SQLException {
    List<PlayerDTO> playerList = new ArrayList<>(2);

    for (int i = 0; i < 2; i++) {
      playerList.add(model.findByJersey(view.findByJerseyView()));
    }

    view.comparePlayerView(playerList);
  }

  public void visualizePlayerController() throws SQLException {
    view.visualizePlayerView(model.getAll());
  }
}
