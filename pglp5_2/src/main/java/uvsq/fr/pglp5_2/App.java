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
        	GroupePersonnel groupe1= new GroupePersonnel("gr1");
        	groupe1.addPersonnel(p1);
        	groupe1.addPersonnel(p2);
        	 DAO<Personnel> personneljdbcDAO = DAOjdbcFactory.getPersonnelDaoJDBC();
        	 DAO<GroupePersonnel> GroupePersonneljdbcDAO = DAOjdbcFactory.getGroupePersonnelDaoJDBC();
        	 personneljdbcDAO.create(p1);
        	 personneljdbcDAO.create(p2);
        	 GroupePersonneljdbcDAO.create(groupe1);
    }
}
