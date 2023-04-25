package tn.enicarthage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.model.Matiere;
import tn.enicarthage.service.MatiereService;

@RestController
@RequestMapping("/matiere")
@CrossOrigin("http://localhost:4200/")
public class MatiereController {
   
	@Autowired
	MatiereService matiereService;
	
	@PostMapping
	public Matiere saveMatiere(@RequestBody Matiere matiere) {
		return matiereService.saveMatiere(matiere);
		}
	
	@GetMapping
	public List<Matiere> getAllMatiere(){
		return matiereService.getAllMatieres();
	}
	
	@GetMapping("/{id}")
	public Matiere getMatiereById(@PathVariable Long id) {
		return matiereService.getMatierById(id);
	}
	
	@PutMapping("/update/{id}")
	 public Matiere updateMatiere(@RequestBody Matiere matiere,@PathVariable Long id) {
		return matiereService.updateMatiere(matiere, id);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteMatiere(@PathVariable Long id){
		matiereService.deleteMatiere(id);
		
	}
	
	@GetMapping("getmatieres")
	public List<Matiere> getMatiereByIDs(@RequestBody List<Long> idMats){
		return matiereService.getMatiereByIDs(idMats);
	}
	
	@GetMapping("getmatiereFromAbs/{idEtd}")
		public List<String> getListMatofEtd(@PathVariable Long idEtd){
		return matiereService.getListMatofEtd(idEtd);
	}
	
	@GetMapping("getlistmatieres/{idEtd}")
	public List<Matiere>getMatEtd(@PathVariable Long idEtd){
		return matiereService.getMatEtd(idEtd);
	}
	
}
	
