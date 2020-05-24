package uvsq.fr.pglp5_2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupePersonnelDAO implements DAO<GroupePersonnel>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -627783275907040813L;
	/**
	 *
	 */
	private List<GroupePersonnel> groupes = new ArrayList<GroupePersonnel>();
	 
	public List<GroupePersonnel> getAll() {
		
		return groupes;
	}

	public GroupePersonnel find(String gp) {
		for (int i=0;i<groupes.size();i++)
			if(gp.equals(groupes.get(i).getID()))
				return groupes.get(i);
				
			return null;
	}

	public void create(GroupePersonnel GrpouePers) {
		
		GroupePersonnel Gp =new GroupePersonnel();
		Gp=GrpouePers;
		groupes.add(Gp);
	}

	public GroupePersonnel update(GroupePersonnel groupePers) {
		/*
		 * ListePers : liste des personnes dans le nouveau groupe
		 * ListePersAtester : liste des personnes de chaque groupe de la liste des groupe
		 * On fait la comparaison pour identifier quel groupe à modifier
		 */
		int index=-1;
		List<ComponentPersonnel> ListePers1= groupePers.getListePersonnels();
		for(GroupePersonnel gr : groupes) {
			List<ComponentPersonnel>  ListePers2= gr.getListePersonnels();
			for (ComponentPersonnel personne : ListePers2)
				if(ListePers1.contains(personne))
				{
		    	 index = groupes.indexOf(gr);
		    	groupes.set(index, groupePers);
		        break;
		    }
		}
		if(index>=0)
			return groupes.get(index);
			else 
			return null;
		
	}

	public void delete(GroupePersonnel groupePers) {
		groupes.remove(groupePers);
		
	}

}
