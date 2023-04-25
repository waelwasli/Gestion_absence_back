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

import tn.enicarthage.model.Groupe;
import tn.enicarthage.service.GroupeService;

@RestController
@RequestMapping("/groupe")
@CrossOrigin("http://localhost:4200/")
public class GroupeController {
      @Autowired
	private GroupeService groupeService;
	
	@PostMapping
	public ResponseEntity<Groupe>  creategroupe(@RequestBody Groupe groupe) {
		return new ResponseEntity<Groupe>(groupeService.createGroupe(groupe),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Groupe>getAllGroupe(){
		return groupeService.getAllGroupe();
	}
	
	@GetMapping("/{id}")
	public Groupe getGroupe(@PathVariable Long id) {
		return groupeService.getGroupe(id);
	}
	
	@PutMapping("/update/{id}")
	public Groupe updateGroupe(@RequestBody Groupe groupe,@PathVariable Long id) {
		return groupeService.updateGroupe(groupe, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteGroupe(@PathVariable Long id){
		groupeService.deleteGroupe(id);
		
	}
	
	//add list of matieres to groupe
	@PostMapping("/{idGroupe}/matieres")
	public ResponseEntity<Groupe> addMatieresToGroupe(@PathVariable Long idGroupe,@RequestBody List<Long>idMatieres) {
		return new ResponseEntity<Groupe>(groupeService.addMatieresToGroupe(idGroupe, idMatieres),HttpStatus.OK);
	}
	
/*	//get list of groupe qui etudie les meme  matieres enseigne par le prof
	@GetMapping("/getListGroupe/{idEns}")
	public List<Groupe> getListGroupeByEnseignant(@PathVariable Long idEns){
		return groupeService.getListGroupeByEnseignant(idEns);
	}*/
}
