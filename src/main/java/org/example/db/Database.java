package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
  private static final String url = "jdbc:sqlite:./Database/MUDatabase.db";
  private static Statement stmt;

  public static Connection connect() throws SQLException {
    return DriverManager.getConnection(url);
  }

//  public static void createTable() throws SQLException {
//
//    String sql =
//        """
//                CREATE TABLE IF NOT EXISTS players (
//                	id integer PRIMARY KEY AUTOINCREMENT,
//                	name text NOT NULL,
//                	age integer NOT NULL,
//                	jersey integer NOT NULL,
//                	height integer NOT NULL,
//                	weight integer NOT NULL,
//                	position text NOT NULL,
//                	speed integer NOT NULL,
//                	goal integer NOT NULL,
//                	pass integer NOT NULL
//                );""";
//
//    try (Connection conn = connect()) {
//      stmt = conn.createStatement();
//
//      stmt.execute(sql);
//    }
//  }
}
