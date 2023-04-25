package tn.enicarthage.service;

import java.util.List;

import tn.enicarthage.model.Groupe;

public interface GroupeService {
	
    public Groupe createGroupe(Groupe groupe);
    
    public List<Groupe>getAllGroupe();
    
    public Groupe getGroupe(Long id);
    
    public Groupe updateGroupe(Groupe groupe,Long id);
    
    public void deleteGroupe(Long id);
    
    //add list of matiere to an groupe
    public Groupe addMatieresToGroupe(Long idGroupe, List<Long>idMatieres);
    
    //get list of groupe qui etudie les mems matieres enseigne par l'enseigannt
   // public List<Groupe>getListGroupeByEnseignant(Long idEns);
}
