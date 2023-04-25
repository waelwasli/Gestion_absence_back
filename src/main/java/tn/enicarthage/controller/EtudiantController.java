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

import tn.enicarthage.model.Etudiant;
import tn.enicarthage.service.EtudiantService;

@RestController
@RequestMapping("/etudiant")
@CrossOrigin("http://localhost:4200/")
public class EtudiantController {
     
	@Autowired
 	private EtudiantService Etudservice;
     
	
	
	//method save etudiant
	 @PostMapping
     public   Etudiant saveEtudiant(@RequestBody Etudiant etudiant) {
    	return Etudservice.saveEtudiant(etudiant); 
     }
	 
	 //method get all etudiant
	 @GetMapping
	 public List<Etudiant> getAllEtudiant(){
		 return Etudservice.getEtudiant();
	 }
	 //method get etudiant by id
	 @GetMapping("/{id}")
	 public Etudiant getEtudiantById(@PathVariable Long id) {
		 return Etudservice.getEtudiantById(id);
	 }
	 
	/* //update by id
	 @PutMapping("/udpate/{id}")
	 public Etudiant updateEtudiantById ( @RequestBody Etudiant etudiant,@PathVariable Long id) {
		 return Etudservice.updateEtudiant(etudiant,id);
	 }*/
	 
	 @PutMapping("/update/{id}")
	 public Etudiant updateEtudiant(@RequestBody Etudiant etudiant,@PathVariable Long id) {
		 return Etudservice.updateEtudiant(etudiant, id);
	 }
	 //delete by id
	 @DeleteMapping("/delete/{id}")
	 
	 public void deleteEtudiantById(@PathVariable Long id) {
		 Etudservice.deleteEtudiant(id);
		  
	 }
}
