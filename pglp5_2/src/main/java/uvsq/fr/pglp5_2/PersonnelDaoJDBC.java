package uvsq.fr.pglp5_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelDaoJDBC implements DAO<Personnel> {
	 
		public Personnel find(String t) {
			Personnel p=null;
			 try {	
				 String sql="SELECT * FROM Personnel WHERE nom=?";
				 PreparedStatement preparedStatement =
					        connection.prepareStatement(sql);
				 preparedStatement.setString(1,t);
				 ResultSet result = preparedStatement.executeQuery();
				 while(result.next()){
						 p = new Personnel
				    			.Builder(result.getString(1),result.getString(2),result.getString(3))
				    			.build();
			    	  System.out.println("Personnel "+t+" a été bien trouvé dans");		
			        }
			      
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
			    return p;	
		}
		public Personnel create(Personnel t) {
			try {
				 String sql="INSERT INTO Personnel VALUES (?,?,?)";
				 PreparedStatement preparedStatement =
					        connection.prepareStatement(sql);
				 preparedStatement.setString(1,t.getNom());
				 preparedStatement.setString(2,t.getPrenom());
				 preparedStatement.setString(3,t.getFonction());
				 int result = preparedStatement.executeUpdate();
			      if(result == 1) 
			    	  System.out.println("Personnel "+t.getNom()+" a été bien inséré dans la base de données");
			      
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
			return t;
		}
		public Personnel update(Personnel t) {
			try{
				String sql = "update Personnel set prenom=? , fonction=? where nom=?";
			PreparedStatement preparedStatement =
			        connection.prepareStatement(sql);

			preparedStatement.setString(1, t.getPrenom());
			preparedStatement.setString(2, t.getFonction());
			preparedStatement.setString (3, t.getNom());
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected>0) System.out.println("Personnel "+t.getNom()+" a été bien modifié dans la base de données");
			}catch (SQLException e) {
			      e.printStackTrace();
			    }
			return t;
		}
		public void delete(Personnel t) {
			try {
			String sql = "delete from Personnel where nom=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString (1, t.getNom());
			int rowsAffected = preparedStatement.executeUpdate();
			 if (rowsAffected == 1)System.out.println("Personnel "+t.getNom()+" a été bien supprimé de la base de données");
			}catch (SQLException e) {
			      e.printStackTrace();
			    }
			
		}

}
