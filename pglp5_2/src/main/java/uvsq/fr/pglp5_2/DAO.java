package uvsq.fr.pglp5_2;

import java.sql.Connection;
import java.util.List;

public interface DAO <T>{
	
	 Connection connection = ConnectionFactory.getConnection();

	public abstract List<T> getAll();
     
    public  abstract T  find(String t);
    
    public abstract void create(T t);
    
    public abstract T update(T t);
     
    public abstract void delete(T t);
    
}
