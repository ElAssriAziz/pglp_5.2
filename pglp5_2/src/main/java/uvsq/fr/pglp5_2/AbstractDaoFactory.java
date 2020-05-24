package uvsq.fr.pglp5_2;

import uvsq.fr.pglp5_2.DAOFactory;

public abstract class AbstractDaoFactory {
	public enum DaoType{dao,jdbc}
	public abstract DAO<Personnel> getPersonnelDAO();
	public abstract DAO<GroupePersonnel> getGroupePersonnelDAO();
	
	public static AbstractDaoFactory getFactory(DaoType type) {
		if(type == DaoType.dao) return new DAOFactory();
		if(type == DaoType.jdbc) return new DAOjdbcFactory();
		return null;
	}
}
