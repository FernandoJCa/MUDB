package org.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.example.controller.PlayerDTO;
import org.example.db.Database;

public class PlayerModel implements playerDAO {

  @Override
  public Integer insertPlayer(PlayerDTO player)  {
    String sql =
        """
                 INSERT INTO players (name, age, jersey, height, weight, position, speed, goal, pass)
                  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
    int result;

    try (Connection conn = Database.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setString(1, player.getName());
      stmt.setInt(2, player.getAge());
      stmt.setInt(3, player.getJersey());
      stmt.setInt(4, player.getHeight());
      stmt.setInt(5, player.getWeight());
      stmt.setString(6, player.getPosition());
      stmt.setInt(7, player.getSpeed());
      stmt.setInt(8, player.getGoal());
      stmt.setInt(9, player.getPass());

      result = stmt.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
      return result;
  }

  @Override
  public List<PlayerDTO> getAll() throws SQLException {
    List<PlayerDTO> playerList = new ArrayList<>();
    String sql =
        """
                      SELECT id, name, age, jersey, height, weight, position, speed, goal, pass FROM players
                     """;

    try (Connection conn = Database.connect();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql)) {

      while (resultSet.next()) {
        playerList.add(createPlayer(resultSet));
      }
    }
    return playerList;
  }

  @Override
  public Integer updatePlayer(PlayerDTO player) throws SQLException {
    String sql =
        """
                      UPDATE players SET name = ?,
                      age = ?,
                      jersey = ?,
                      height = ?,
                      weight = ?,
                      position = ?,
                      speed = ?,
                      goal = ?,
                      pass = ?
                      WHERE id = ?
                     """;
    int result;

    try (Connection conn = Database.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setString(1, player.getName());
      stmt.setInt(2, player.getAge());
      stmt.setInt(3, player.getJersey());
      stmt.setInt(4, player.getHeight());
      stmt.setInt(5, player.getWeight());
      stmt.setString(6, player.getPosition());
      stmt.setInt(7, player.getSpeed());
      stmt.setInt(8, player.getGoal());
      stmt.setInt(9, player.getPass());
      stmt.setInt(10, player.getId());

      result = stmt.executeUpdate();
    }
    return result;
  }

  @Override
  public Integer deletePlayer(Integer jersey) throws SQLException {
    String sql = "DELETE FROM players WHERE jersey = ?";
    int result;

    try (Connection conn = Database.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, jersey);

      result = stmt.executeUpdate();
    }

    return result;
  }

  @Override
  public PlayerDTO findByJersey(Integer jersey) throws SQLException {
    String sql =
        """
                    SELECT players.id, players.name, players.age, players.jersey, players.height, players.weight, players.position, players.speed, players.goal, players.pass
                    FROM players WHERE jersey = ?;
                    """;
    PlayerDTO player = new PlayerDTO();

    try (Connection conn = Database.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setInt(1, jersey);

      ResultSet resultSet = stmt.executeQuery();

      while (resultSet.next()) {
        player = createPlayer(resultSet);
      }
    }
    return player;
  }

  private PlayerDTO createPlayer(ResultSet resultSet) throws SQLException {
    PlayerDTO player = new PlayerDTO("Marcus Antonio", 10, 26, 181, 86, "delantero", 9, 127, 8);

    player.setId(resultSet.getInt("id"));
    player.setName(resultSet.getString("name"));
    player.setAge(resultSet.getInt("age"));
    player.setJersey(resultSet.getInt("jersey"));
    player.setHeight(resultSet.getInt("height"));
    player.setWeight(resultSet.getInt("weight"));
    player.setPosition(resultSet.getString("position"));
    player.setSpeed(resultSet.getInt("speed"));
    player.setGoal(resultSet.getInt("goal"));
    player.setPass(resultSet.getInt("pass"));

    return player;
  }
}
