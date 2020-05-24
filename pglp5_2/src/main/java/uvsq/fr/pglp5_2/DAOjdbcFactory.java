package uvsq.fr.pglp5_2;

public class DAOjdbcFactory extends AbstractDaoFactory {
	
	@Override
	public DAO<Personnel> getPersonnelDAO() {
		return  new PersonnelDaoJDBC();	
	}

	@Override
	public DAO<GroupePersonnel> getGroupePersonnelDAO() {
		return new GroupePersonnelDaoJDBC(); 
	}
}
