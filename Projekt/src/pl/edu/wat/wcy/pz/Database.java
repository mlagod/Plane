package pl.edu.wat.wcy.pz;

import java.sql.*;
public class Database {

	static String data;
	
	String[] queries = {"SELECT country FROM landings WHERE id = ", //0
						"SELECT city FROM landings WHERE id = ",	//1
						"SELECT name FROM landings WHERE id = ",	//2
						"SELECT iata FROM landings WHERE id = ",	//3
						"SELECT icao FROM landings WHERE id = "};	//4
	
	String[] planeQueries = {"SELECT producer FROM planes WHERE id = ",
							 "SELECT model FROM planes WHERE id = ",
							 "SELECT registration FROM planes WHERE id ="}; // info o samolocie
	
	String[] planeLandingQueries = {"SELECT country FROM landings WHERE id = ",
									  "SELECT city FROM landings WHERE id = ",
									  "SELECT name FROM landings WHERE id = "};
	

	
	//String connection = "jdbc:mysql://localhost:3306/projekt?user=root&password=programowanieZdarzeniowe";
	static String connection = "jdbc:mysql://localhost:3306/projekt?";
	static String cityId;
	static String planeId;
	static int planeIdInList;
	
	
	
	
	Connection con = null;
	
	public void setConnection(String query ,String parameter){
		
			query += parameter;
		try{
			
			con = DriverManager.getConnection(connection);
			Class.forName("com.mysql.jdbc.Driver");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//System.out.println("ID | COUNTRY | CITY");
			while(rs.next()){
				sendInfo(rs);
				
			}
			con.close();
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void showData(ResultSet rs){
		
		try {
			data = rs.getString(1);
			System.out.print("\n" + data + " ");
			data = rs.getString(2);
			System.out.print(data + " ");
			data = rs.getString(3);
			System.out.print(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendInfo(ResultSet rs){
		
		try {
			data = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
