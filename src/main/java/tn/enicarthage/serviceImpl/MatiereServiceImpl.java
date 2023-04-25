package tn.enicarthage.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Exception;
import tn.enicarthage.model.Absence;
import tn.enicarthage.model.Etudiant;
import tn.enicarthage.model.Matiere;
import tn.enicarthage.repository.AbsenceRepo;
import tn.enicarthage.repository.EtudiantRepo;
import tn.enicarthage.repository.MatiereRepo;
import tn.enicarthage.service.MatiereService;

@Service
public class MatiereServiceImpl implements MatiereService {
      @Autowired
      MatiereRepo matierRepo;
      
      @Autowired
      AbsenceRepo absenceRepo;
      
      @Autowired
      EtudiantRepo etudiantRepo;

	@Override
	public Matiere saveMatiere(Matiere matiere) {
		// TODO Auto-generated method stub
		return matierRepo.save(matiere);
	}

	@Override
	public List<Matiere> getAllMatieres() {
		// TODO Auto-generated method stub
		return matierRepo.findAll();
	}

	@Override
	public Matiere getMatierById(Long id) {
		// TODO Auto-generated method stub
		return matierRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteMatiere(Long id) {
		// TODO Auto-generated method stub
		 matierRepo.deleteById(id);
	}

	@Override
	public Matiere updateMatiere(Matiere matiere,Long id) {
		// TODO Auto-generated method stub
	Matiere	existMatiere=matierRepo.findById(id).orElse(null);
	if(existMatiere!=null) {
		existMatiere.setNomMat(matiere.getNomMat());
		matierRepo.save(existMatiere);
	}
	
		return existMatiere;
	}

	@Override
	public List<Matiere> getMatiereByIDs(List<Long> idMats) {
		
		return matierRepo.findAllById(idMats) ;
	}

	@Override
	public List<String> getListMatofEtd(Long etd) {
		 List<String> matieres = new ArrayList<>();
		 Etudiant etudiant=etudiantRepo.findById(etd).orElse(null);
		 List<Absence>absences=absenceRepo.findByEtudiantId(etd);
		 for (Absence absence : absences) {
		      String nomMatiere = absence.getMatiere().getNomMat();
		      if (!matieres.contains(nomMatiere)) {
		        matieres.add(nomMatiere);
		      }
		    }
		    
		    return matieres;
		  }
		
	public List<Matiere>getMatEtd(Long etd){
		List<Matiere> matieres = new ArrayList<>();
		 Etudiant etudiant=etudiantRepo.findById(etd).orElse(null);
		 List<Absence>absences=absenceRepo.findByEtudiantId(etd);
		 for (Absence absence : absences) {
		     Matiere existmatiere = absence.getMatiere();
		      if (!matieres.contains(existmatiere)) {
		        matieres.add(existmatiere);
		      }
		    }
		    
		    return matieres;
		  }
		
	
      
}
