package tn.enicarthage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.enicarthage.model.Enseignant;
import tn.enicarthage.model.Matiere;

public interface EnseignantRepo extends JpaRepository<Enseignant,Long> {
    
	 @Query("SELECT m FROM Matiere m JOIN m.enseignants e WHERE e.email = :email AND e.password = :password")
	 Matiere findMatieresByEmailAndPassword(String email, String password);
	 
	 //find enseignant by email and password
	 Enseignant findEnseignantByEmailAndPassword(String email,String password);

	Enseignant findEnseignantByEmail(String email);
	    
}
