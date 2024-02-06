package org.example.model;

import java.sql.SQLException;
import java.util.List;
import org.example.controller.PlayerDTO;

/*Create:
Add new players to the system with their respective details.
Read:
View the complete list of current players with their jersey number, position, age, height, and other statistical information.
Update:
Modify player information as needed, such as position, age, or height.
Delete:
Remove players from the system if they are no longer part of the team.
Compare Players:
Utilize the comparison feature to analyze and contrast the characteristics of two players.
Visualize Characteristics:
Display the statistical and physical attributes of each player for a comprehensive overview.*/
public interface playerDAO {
  Integer insertPlayer(PlayerDTO player) throws SQLException;

  List<PlayerDTO> getAll() throws SQLException;

  Integer updatePlayer(PlayerDTO player) throws SQLException;

  Integer deletePlayer(Integer id) throws SQLException;

  PlayerDTO findByJersey(Integer jersey) throws SQLException;
}
