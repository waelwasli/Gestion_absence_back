package tn.enicarthage.service;

import java.util.List;

import tn.enicarthage.model.Enseignant;
import tn.enicarthage.model.EnseignantDto;
import tn.enicarthage.model.Groupe;
import tn.enicarthage.model.Matiere;

public interface EnseignantService {
	
   public Enseignant saveEnseignant(Enseignant enseignant);
   
   public List<Enseignant>getEnseignant();
   
   public Enseignant getEnseignantById(Long id);
   
   public Enseignant updateEnseignant(Enseignant enseignant ,Long id);
   
   public void deleteEnseignant(Long id);
  

   public Enseignant addGroupesToEnseignant(Long idE,List<Long>idGrps);
   
   public List<Groupe>getListGroupeByEnseignant(Long idEns);
   
   //
  public Enseignant getEnseignantByEmail(String email);
  

 
}
