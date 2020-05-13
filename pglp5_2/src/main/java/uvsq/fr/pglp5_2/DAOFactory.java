package uvsq.fr.pglp5_2;

public class DAOFactory {
	
	public static DAO<Personnel> getPersonnelDAO(){
		return new PersonnelDAO();
	}
}
