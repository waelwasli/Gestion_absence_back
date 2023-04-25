package tn.enicarthage.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.model.Etudiant;

public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {

	Etudiant findEtudiantByEmail(String email);
	

	

	
 
}
