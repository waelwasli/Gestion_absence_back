package tn.enicarthage.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.model.Absence;
import tn.enicarthage.service.AbsenceService;

@RestController
@RequestMapping("/absence")
@CrossOrigin("http://localhost:4200/")
public class AbsenceController {
   
	@Autowired
	AbsenceService absenceService;
	
	@PostMapping
	public Absence createAbsence(@RequestBody Absence absence) {
		return absenceService.saveAbsence(absence);
	}
	
	@GetMapping
	public List<Absence>getAllAbsence(){
		return absenceService.getAllAbsence();
	}
	

	@PostMapping("/ToEtd/{etudiantId}/ToMat/{idMat}")
	public Absence createAbsenceToEtd(@PathVariable Long etudiantId,@PathVariable Long idMat ,@RequestBody Absence absence) {
		return absenceService.createAbsenceToEtd(etudiantId, idMat,absence);
	}
	
	@GetMapping("/absencesetud/{etudiantId}/matiere/{matiereId}")
    public Integer getAbsenceByEtudiantAndMatiere( @PathVariable Long etudiantId,@PathVariable Long matiereId ){

        return this.absenceService.findAbsenceByEtudiantAndMatiere(etudiantId,matiereId);}
	
	
}
