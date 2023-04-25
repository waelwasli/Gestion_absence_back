package tn.enicarthage.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.model.Enseignant;
import tn.enicarthage.model.Matiere;
import tn.enicarthage.model.Seance;
import tn.enicarthage.repository.EnseignantRepo;
import tn.enicarthage.repository.MatiereRepo;
import tn.enicarthage.repository.SeanceRepo;
import tn.enicarthage.service.SeanceService;

@Service
public class SeanceServiceImpl implements SeanceService {
       @Autowired
       private SeanceRepo seanceRepo;
       @Autowired
      private MatiereRepo matiereRepo;  
       @Autowired
       private EnseignantRepo enseignantRepo;
       
       //create seance
       
	@Override
	public Seance saveSeance(Seance seance) {
		// TODO Auto-generated method stub
		return seanceRepo.save(seance);
	}
	


	//get seance by id
	 public Seance getSeanceById( Long id) {
	        return seanceRepo.findById(id).orElse(null);
	    }

	@Override
	public List<Seance> getAllSeance() {
		// TODO Auto-generated method stub
		return seanceRepo.findAll();
	}

	@Override
	public Seance updateSeance(Seance seance, Long id) {
		// TODO Auto-generated method stub
		
		Seance existseance=seanceRepo.findById(id).orElse(null);
		if(existseance!=null) {

			existseance.setDate(seance.getDate());
			existseance.setHeureDebut(seance.getHeureDebut());
			existseance.setHeureFin(seance.getHeureFin());
			existseance.setType(seance.getType());
			seanceRepo.save(existseance);
		}
		return existseance;
		
	}



	@Override
	public Seance addEnsToSeance(Seance seance, Long idEns) {
		Enseignant enseignant=enseignantRepo.findById(idEns).orElse(null);
		seance.setEnseignant(enseignant);
		
		return seanceRepo.save(seance);
	}



	@Override
	public List<Seance> findByEnseignant(Long idEns) {
		Enseignant enseignant=enseignantRepo.findById(idEns).orElse(null);
		
		return seanceRepo.findByEnseignant(enseignant);
	}



	

}
