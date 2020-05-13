package uvsq.fr.pglp5_2;

import java.util.List;

public interface DAO <T>{

	public abstract List<T> getAll();
     
    public  abstract T  find(T t);
    
    public abstract void create(T t);
    
    public abstract T update(T t);
     
    public abstract void delete(T t);
    
}
