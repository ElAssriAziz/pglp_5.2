package uvsq.fr.pglp5_2;

import java.time.LocalDate;
import java.time.Month;


public class App 
{
    public static void main( String[] args )
    {
    		Personnel p1 = new Personnel
        			.Builder("nomB","prenomB","Directeur")
        			.dateNaissance( LocalDate.of(1975, Month.MAY, 15))
        			.addNumTelephone(new NumeroTele("Personnel","06054852371"))
        			.build();
        	
        	Personnel p2 = new Personnel
        			.Builder("nomA","prenomA","Manager")
        			.dateNaissance( LocalDate.of(1989, Month.MAY, 10))
        			.addNumTelephone(new NumeroTele("Personnel","0605842691"))
        			.build(); 
        	Personnel p3 = new Personnel
        			.Builder("nomcc","prenomc","Teacher")
        			.dateNaissance( LocalDate.of(1991, Month.MAY, 16))
        			.addNumTelephone(new NumeroTele("Personnel","0605842691"))
        			.build();
        	GroupePersonnel groupe1= new GroupePersonnel("groupe1");
        	groupe1.addPersonnel(p1);
        	groupe1.addPersonnel(p2);
        	 DAO<Personnel> personneljdbcDAO = DAOjdbcFactory.getPersonnelDaoJDBC();
        	 DAO<GroupePersonnel> GroupePersonneljdbcDAO = DAOjdbcFactory.getGroupePersonnelDaoJDBC();
        	System.out.println("---------------test creation-----------");
        	 personneljdbcDAO.create(p1);
        	
        	 personneljdbcDAO.create(p2);
        	 GroupePersonneljdbcDAO.create(groupe1);
        	 System.out.println("---------------test update et find-----------");
        	 p1.setFonction("chef de projet");
        	 personneljdbcDAO.update(p1);
        	 Personnel persTest = new Personnel
         			.Builder(null,null,null)
         			.build(); 
        	 persTest = personneljdbcDAO.find(p1.getNom());
        	 System.out.println("la fonction de la personne est bien modifiée à "+persTest.getFonction());
        	 persTest.setNom("groupeTest1");
        	 
        	 // faut creer d'abord la personne avant de l'afecter à un groupe
        	 // à cause de la clè étrangère
        	 personneljdbcDAO.create(persTest);
        	 groupe1.addPersonnel(persTest); 
        	
        	 System.out.println("---les personnels groupe "+groupe1.getNom()+" avant update  ---");
        	 groupe1 = GroupePersonneljdbcDAO.find("groupe1");
        	 System.out.println(groupe1);
        	 GroupePersonneljdbcDAO.update(groupe1);
        	 GroupePersonnel grptest1 =  GroupePersonneljdbcDAO.find("groupe1");
        	 System.out.println("---les personnels groupe "+groupe1.getNom()+" après update  ---");
        	 System.out.println(groupe1);
        	 
        	 
        	 
    }
}
