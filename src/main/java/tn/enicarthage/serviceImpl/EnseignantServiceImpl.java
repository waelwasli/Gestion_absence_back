package tn.enicarthage.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.enicarthage.Exception;
import tn.enicarthage.model.Enseignant;
import tn.enicarthage.model.EnseignantDto;
import tn.enicarthage.model.Groupe;
import tn.enicarthage.model.Matiere;
import tn.enicarthage.model.Seance;
import tn.enicarthage.repository.EnseignantRepo;
import tn.enicarthage.repository.GroupeRepo;
import tn.enicarthage.repository.MatiereRepo;
import tn.enicarthage.repository.SeanceRepo;
import tn.enicarthage.service.EnseignantService;

@Service
@AllArgsConstructor
public class EnseignantServiceImpl implements EnseignantService {
	
	  @Autowired
      private EnseignantRepo enseignantRepo;
	
	  @Autowired
     private MatiereRepo matiereRepo;
	  
	  @Autowired
	  private GroupeRepo groupeRepo;
	  @Autowired
	  private SeanceRepo seanceRepo;
	
	
	
	//cree enseignant
	@Override
	public Enseignant saveEnseignant(Enseignant enseignant) {
		
		return enseignantRepo.save(enseignant);
	}
	
	//get list des enseignants
	@Override
	public List<Enseignant> getEnseignant() {
		
		return enseignantRepo.findAll();
	}
      //get enseignant by id
	@Override
	public Enseignant getEnseignantById(Long id) {
		
		return enseignantRepo.findById(id).orElseThrow(()-> new Exception("not found") );
	}

	@Override
	public Enseignant updateEnseignant(Enseignant enseignant, Long id) {
             Enseignant existenseignant= enseignantRepo.findById(id).orElseThrow(()->new Exception("Not Found"));
             
             existenseignant.setFirstName(enseignant.getFirstName());
             existenseignant.setLastName(enseignant.getLastName());
             existenseignant.setEmail(enseignant.getEmail());
             existenseignant.setImageUrl(enseignant.getImageUrl());
             existenseignant.setPassword(enseignant.getPassword());
             existenseignant.setGroupes(enseignant.getGroupes());
             existenseignant.setMatiere(enseignant.getMatiere());
           
           enseignantRepo.save(existenseignant);  
		return existenseignant;
	}

	@Override
	public void deleteEnseignant(Long id) {
		
		enseignantRepo.deleteById(id);
		
	}
    
	
	//add groupes to enseignant
	@Override
	public Enseignant addGroupesToEnseignant(Long idE, List<Long> idGrps) {
		Enseignant enseignant=enseignantRepo.findById(idE).orElse(null);
		List<Groupe> groupes=groupeRepo.findAllById(idGrps);
		enseignant.getGroupes().addAll(groupes);
		enseignantRepo.save(enseignant);
		
		return enseignant;
	}

	@Override
	public List<Groupe> getListGroupeByEnseignant(Long idEns) {
		
		return groupeRepo.findGroupesByEnseignant(idEns);
	}

	@Override
	public Enseignant getEnseignantByEmail(String email) {
		
		return enseignantRepo.findEnseignantByEmail(email);
	}

	

	
	

	

	

	

}
