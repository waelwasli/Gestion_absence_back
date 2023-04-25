package tn.enicarthage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.model.Enseignant;
import tn.enicarthage.model.Seance;

public interface SeanceRepo extends JpaRepository<Seance,Long>{

	List<Seance> findByEnseignant(Enseignant enseignant);

}
