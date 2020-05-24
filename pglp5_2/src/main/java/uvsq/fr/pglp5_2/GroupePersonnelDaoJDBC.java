package uvsq.fr.pglp5_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupePersonnelDaoJDBC implements DAO<GroupePersonnel> {
	public GroupePersonnel find(String t) {
		 try {	
			 GroupePersonnel  gr = new GroupePersonnel("");
			 String sql1="SELECT * FROM Groupe WHERE id=?";
				 PreparedStatement preparedStatement1 =
					        connection.prepareStatement(sql1);
				 preparedStatement1.setString(1,t);
				 ResultSet result1 = preparedStatement1.executeQuery();
				 if (result1.next()) {
					 System.out.println("tttt");
					gr = new GroupePersonnel(result1.getString(1));
				 String sql2="SELECT * FROM Composer WHERE idGroupe=?;";
				 PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				 preparedStatement2.setString(1,t);
				 ResultSet result2 = preparedStatement2.executeQuery();
				
				 while(result2.next()){
					 System.out.println("tttt  tttt");
					 sql1="SELECT * FROM Personnel WHERE nom=?"; // recuperer tous les noms de personnel
					 preparedStatement1 = connection.prepareStatement(sql1);
					 preparedStatement1.setString(1,result2.getString(2));
					  result1 = preparedStatement1.executeQuery();
		  
					  if(result1.next()) {
				
						   Personnel personne = new Personnel
					    			.Builder(result2.getString(1),result1.getString(2),result1.getString(3))
					    			.build();
						  gr.addPersonnel(personne);
						  System.out.println("personnel "+personne.getNom()+" ajoute");
					  }
								  }
		    	  System.out.println("Groupe "+gr.getNom()+" a été bien trouvé dans la base de données");

				 }
		    	  return gr;
		    } catch (SQLException e) {
		       e.printStackTrace();
		    }
		    return null;
	}

	public GroupePersonnel create(GroupePersonnel t) {
		 GroupePersonnel g = new GroupePersonnel("");
			try {
				 String sql1="INSERT INTO Groupe VALUES (?)";
				 PreparedStatement preparedStatement =
					        connection.prepareStatement(sql1);
				 preparedStatement.setString(1,t.getNom());
				 int result1 = preparedStatement.executeUpdate();
			      if(result1 == 1){
			    	  System.out.println("Groupe creé !");
			    	  g.setID(t.getNom());
			    	  for(ComponentPersonnel elem : t.getListePersonnels()) {
				    	  g.addPersonnel(elem);
				    		 String sql2="INSERT INTO Composer VALUES (?,?)";
							 PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				    	System.out.println(elem.getClass().getSimpleName());
				  	  preparedStatement2.setString(1,t.getNom());
			 		  preparedStatement2.setString(2,elem.getNom());
			 		 int result2 = preparedStatement2.executeUpdate();
			 		 if (result2==1)System.out.println("Ajouté à composer");
			    	  }	  System.out.println("groupe a été bien inséré dans la base de données"); 
			      }	      
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
			 return g;
	}

	public GroupePersonnel update(GroupePersonnel t) {
		this.delete(t);
		this.create(t);
		return t;
	}

	public void delete(GroupePersonnel t) {
		try{
			String sql = "delete from Groupe where id=?";
			String sql2 = "delete from Composer where idGroupe=?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

		preparedStatement2.setString (1, t.getNom());
		preparedStatement2.executeUpdate();
		preparedStatement.setString (1, t.getNom());
		preparedStatement.executeUpdate();
		//preparedStatement.executeUpdate()==1
		if(preparedStatement.executeUpdate()==1 )
			System.out.println("Groupe a été bien supprimé de la base de données");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
	}

	
}
