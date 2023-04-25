package tn.enicarthage.service;

import java.util.List;

import tn.enicarthage.model.Enseignant;
import tn.enicarthage.model.Seance;

public interface SeanceService {
    
	public Seance saveSeance(Seance seance);
	
	public Seance getSeanceById( Long id);
	
	public List<Seance>getAllSeance();
	
	public Seance updateSeance(Seance seance,Long id);
	
	public Seance addEnsToSeance(Seance seance,Long idEns);
	
	public List<Seance>findByEnseignant(Long idEns);
}
