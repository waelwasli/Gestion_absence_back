package tn.enicarthage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.enicarthage.model.Groupe;

public interface GroupeRepo extends JpaRepository<Groupe,Long> {
   
	 @Query("select distinct g from Groupe g join g.matieres m join m.enseignants e where e.id = :enseignantId")
	    List<Groupe> findGroupesByEnseignant(@Param("enseignantId") Long enseignantId);
}
