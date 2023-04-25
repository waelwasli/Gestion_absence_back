package tn.enicarthage.service;

import java.util.List;

import tn.enicarthage.model.Etudiant;

public interface EtudiantService {
     public Etudiant saveEtudiant(Etudiant etudiant);
     public List<Etudiant> getEtudiant();
     public Etudiant getEtudiantById(Long id);
     public Etudiant updateEtudiant(Etudiant etudiant, Long id);
	 public void deleteEtudiant(Long id);
	 
	
}
