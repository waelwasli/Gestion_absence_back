package tn.enicarthage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.model.Absence;
import tn.enicarthage.model.Etudiant;
import tn.enicarthage.model.Matiere;

public interface AbsenceRepo extends JpaRepository<Absence,Long> {
  
	public List<Absence> findByEtudiantId(Long etudiantId);

	public List<Absence> findAbsenceByEtudiantAndMatiere(Etudiant etudiant, Matiere matiere);
}
