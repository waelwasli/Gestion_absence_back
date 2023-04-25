package tn.enicarthage.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.model.Groupe;
import tn.enicarthage.model.Matiere;
import tn.enicarthage.repository.GroupeRepo;
import tn.enicarthage.repository.MatiereRepo;
import tn.enicarthage.service.GroupeService;

@Service
public class GroupeServiceImpl implements GroupeService {
      @Autowired
	private GroupeRepo groupeRepo;
      @Autowired
      private MatiereRepo matiereRepo;
	
	@Override
	public Groupe createGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		return groupeRepo.save(groupe) ;
	}

	@Override
	public List<Groupe> getAllGroupe() {
		// TODO Auto-generated method stub
		return groupeRepo.findAll();
	}

	@Override
	public Groupe getGroupe(Long id) {
		
		return groupeRepo.findById(id).orElse(null);
	}

	@Override
	public Groupe updateGroupe(Groupe groupe, Long id) {
		
		Groupe existgroupe=groupeRepo.findById(id).orElse(null);
		existgroupe.setNomGrp(groupe.getNomGrp());
		groupeRepo.save(existgroupe);
		return existgroupe;
	}

	@Override
	public void deleteGroupe(Long id) {

		 groupeRepo.deleteById(id);
		
	}

	@Override
	public Groupe addMatieresToGroupe(Long idGroupe, List<Long> idMatieres) {
		Groupe groupe=groupeRepo.findById(idGroupe).orElse(null);
		List<Matiere>matieres=matiereRepo.findAllById(idMatieres);
		groupe.getMatieres().addAll(matieres);
		groupeRepo.save(groupe);
		return groupe;
		
	}

/*	@Override
	public List<Groupe> getListGroupeByEnseignant(Long idEns) {
		// TODO Auto-generated method stub
		return groupeRepo.findGroupesByEnseignant(idEns);
	}
  */ 
}
