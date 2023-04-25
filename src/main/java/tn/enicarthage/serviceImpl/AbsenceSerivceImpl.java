package tn.enicarthage.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.enicarthage.model.Absence;
import tn.enicarthage.model.Etudiant;
import tn.enicarthage.model.Matiere;
import tn.enicarthage.repository.AbsenceRepo;
import tn.enicarthage.repository.EnseignantRepo;
import tn.enicarthage.repository.EtudiantRepo;
import tn.enicarthage.repository.MatiereRepo;
import tn.enicarthage.service.AbsenceService;

@Service
@AllArgsConstructor
public class AbsenceSerivceImpl implements AbsenceService {
           
	@Autowired
	AbsenceRepo absenceRepo;
	@Autowired
	EtudiantRepo etudiantRepo;
	@Autowired
	MatiereRepo matiereRepo;
	
	@Override
	public Absence saveAbsence(Absence absence) {
		// TODO Auto-generated method stub
		return absenceRepo.save(absence);
	}
	@Override
	public List<Absence> getAllAbsence() {
		// TODO Auto-generated method stub
		return absenceRepo.findAll();
	}
	@Override
	public Absence createAbsenceToEtd(Long etudiantId,Long idMat, Absence absence) {
		Etudiant etudiant=etudiantRepo.findById(etudiantId).orElse(null);
		Matiere matiere=matiereRepo.findById(idMat).orElse(null);
		absence.setMatiere(matiere);
		absence.setEtudiant(etudiant);
		return absenceRepo.save(absence) ;
	}
	public Integer findAbsenceByEtudiantAndMatiere(Long etudiantId,Long matId) {
        Etudiant etudiant = etudiantRepo.findById(etudiantId).orElse(null);
        Matiere matiere = matiereRepo.findById(matId).orElse(null);
        return absenceRepo.findAbsenceByEtudiantAndMatiere(etudiant,matiere).size();

    }
	
     
}
