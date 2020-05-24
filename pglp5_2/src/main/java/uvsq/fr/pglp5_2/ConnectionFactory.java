package uvsq.fr.pglp5_2;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	 static Connection con=null;
	public static  Connection getConnection() {
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			// get db properties
			Properties props = new Properties();
			props.load(new FileInputStream("connexion.properties"));
			
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			String dburl = props.getProperty("dburl");
			con = DriverManager.getConnection(dburl,user,password);
			if (con!=null)
				System.out.println("DB connection successful to: " + dburl);
			con.createStatement().execute("Drop table Composer  ");
			con.createStatement().execute("Drop table Personnel ");
			con.createStatement().execute("Drop table Groupe  ");
			String sql = " create table Personnel (nom varchar(50) primary key,"
					+ " prenom  varchar(50) ,fonction  varchar(50)) ";
			con.createStatement().execute(sql);
			sql = "create table  Groupe(id varchar(50) primary key)";
			con.createStatement().execute(sql);
			sql = "create table Composer(idGroupe varchar(50) references Groupe(id), "
					+ "nom varchar(50) references Personnel(nom),"
					+ " primary key(nom,idGroupe))";
			if(con.createStatement().execute(sql))
				System.out.print("Table bien cree !");


			} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
