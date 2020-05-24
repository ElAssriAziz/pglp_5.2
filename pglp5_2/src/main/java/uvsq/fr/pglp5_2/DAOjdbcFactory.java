package uvsq.fr.pglp5_2;



public class DAOjdbcFactory {
	
	public static DAO<Personnel> getPersonnelDaoJDBC() {
		return  new PersonnelDaoJDBC();
	}
	
	public static DAO<GroupePersonnel> getGroupePersonnelDaoJDBC() {
		return new GroupePersonnelDaoJDBC(); 
	}
}
