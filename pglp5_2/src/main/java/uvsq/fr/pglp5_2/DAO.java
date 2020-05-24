package uvsq.fr.pglp5_2;

import java.sql.Connection;
import java.util.List;

public interface DAO <T>{
	
	 Connection connection = ConnectionFactory.getConnection();
     
    public  abstract T  find(String t);
    
    public abstract T create(T t);
    
    public abstract T update(T t);
     
    public abstract void delete(T t);
    
}
