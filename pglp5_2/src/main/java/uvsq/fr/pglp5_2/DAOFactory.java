package uvsq.fr.pglp5_2;

import uvsq.fr.pglp5_2.AbstractDaoFactory;

public class DAOFactory extends AbstractDaoFactory{

	@Override
	public DAO<Personnel> getPersonnelDAO() {
		return new PersonnelDAO();
	}
	@Override
	public DAO<GroupePersonnel> getGroupePersonnelDAO() {
		return new GroupePersonnelDAO();
	
	}
}
