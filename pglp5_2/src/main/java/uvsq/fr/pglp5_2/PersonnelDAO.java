package uvsq.fr.pglp5_2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PersonnelDAO implements DAO<Personnel>,Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2853081473510341864L;
	private List<Personnel> personnels = new ArrayList<Personnel>();
	 
	
	public List<Personnel> getAll() {
		
		return personnels;
	}

	
	public void create(Personnel p) {
	
		personnels.add(p);
		
	}
	public Personnel find(String p) {
		
		for (int i=0;i<personnels.size();i++)
		if(p.equals(personnels.get(i).getNom()))
			return personnels.get(i);
			
		return null;
	}

	public Personnel update(Personnel t) {
		int index=-1;
		for(Personnel pers : personnels) {
		    if(pers!=null && t.getNom().equals(pers.getNom())) {
		    	 index = personnels.indexOf(pers);
		        personnels.set(index, t);
		        break;
		    }
		}
		if(index>=0)
		return personnels.get(index);
		else 
		return null;
	}
	
	public void delete(Personnel t) {
		personnels.remove(t);
		System.out.print("Bien supprimé !\n");
	}

}
