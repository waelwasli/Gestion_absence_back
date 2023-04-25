package tn.enicarthage.service;

import java.util.List;

import tn.enicarthage.model.Absence;

public interface AbsenceService {
	
   public Absence saveAbsence(Absence absence);
   
   public List<Absence> getAllAbsence();
   
//   public Absence createAbsence(Long etudiantId, Long matiereId, String dateAbs, String heureDebut, String heureFin, String status);
   public Absence createAbsenceToEtd(Long idetd,Long idMat,Absence absence);
   
   public Integer findAbsenceByEtudiantAndMatiere(Long etudiantId,Long matId);
   
  
}
