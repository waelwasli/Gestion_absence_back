package tn.enicarthage.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.model.Matiere;

public interface MatiereRepo extends JpaRepository<Matiere,Long>{

 Matiere findByNomMat(String nom);
	
}
