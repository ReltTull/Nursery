package connectionMySQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Animals.Animal;

public class Connector {
	private static final String url = "jdbc:mysql://localhost:3306/nursery";
	private static final String username = "root";
	private static final String password = "slash1702";
	
	private static Connection con;
	private static Statement stmt;
	private static ResultSet res;
	


	public static void getConnect() {
		try {
			con = DriverManager.getConnection(url, username, password);			
			System.out.print("Connection is established");
		} catch (SQLException e) {
			System.out.print("no connection");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
	}
	

	public static void insertNewAnimal(Animal animal) {
		
		String sql = "INSERT INTO animal (is_pack_animal, kind, name, age, skills, birth_date) " +
                "VALUES (?,?,?,?,?,?);";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			if (animal.getKind() == "Horse" || animal.getKind() == "Camel" ||animal.getKind() == "Donkey") {
				preparedStatement.setBoolean(1, false);
			} else {
				preparedStatement.setBoolean(1, true);
			}
			preparedStatement.setString(2, animal.getKind());
			preparedStatement.setString(3, animal.getName());
			preparedStatement.setInt(4, animal.getAge());
			preparedStatement.setString(5, animal.getSkills().toString());
			preparedStatement.setDate(6, animal.getBirthDate());
			preparedStatement.executeUpdate();
			
			System.out.print("Data uploaded");
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.getMessage();
			}
			try {
				stmt.close();
			} catch (Exception e3) {
				e3.getMessage();
			}
			
			try {
				res.close();
			} catch (Exception e4) {
				e4.getMessage();
			}
		}
	}
	
	public static void showCommands (int id) throws SQLException {
		String sql = "SELECT skills FROM animal WHERE id = '"+ id + "';";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();	
			res = stmt.executeQuery(sql);
			
			ResultSetMetaData rsmd = res.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			while (res.next()) {
				for(int i = 1; i <= columnCount; i++) {
					String value = res.getString(i);
					System.out.print(value + " ");
				}
			}
		} catch (SQLException e) {
			System.out.print("no connection");
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.getMessage();
			}
			try {
				stmt.close();
			} catch (Exception e3) {
				e3.getMessage();
			}
			
			try {
				res.close();
			} catch (Exception e4) {
				e4.getMessage();
			}
		}
	}
	
	public static void selectAllFromTable(String tableName) throws IOException {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();	
			String request = "SELECT * FROM " + tableName +";";
			res = stmt.executeQuery(request);
			
			ResultSetMetaData rsmd = res.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			while (res.next()) {
				for(int i = 1; i <= columnCount; i++) {
					String value = res.getString(i);
					System.out.print(value + " ");
				}
			}
		} catch (SQLException e) {
			System.out.print("no connection");
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.getMessage();
			}
			try {
				stmt.close();
			} catch (Exception e3) {
				e3.getMessage();
			}
			
			try {
				res.close();
			} catch (Exception e4) {
				e4.getMessage();
			}
		}
	}

	public static void updateSkillInfo(Animal animal) {
		String sql = "UPDATE animal SET skills = ? WHERE name = ?;";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, animal.getSkills().toString());
			preparedStatement.setString(2, animal.getName());
			preparedStatement.executeUpdate();
			System.out.print("Data uploaded");
			
		} catch (SQLException e) {
			System.out.print("no connection");
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.getMessage();
			}
			try {
				stmt.close();
			} catch (Exception e3) {
				e3.getMessage();
			}
			
			try {
				res.close();
			} catch (Exception e4) {
				e4.getMessage();
			}
		}
	}
}
