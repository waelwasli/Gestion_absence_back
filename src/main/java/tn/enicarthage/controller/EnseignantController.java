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

import tn.enicarthage.model.Enseignant;
import tn.enicarthage.model.EnseignantDto;
import tn.enicarthage.model.Groupe;
import tn.enicarthage.model.Matiere;
import tn.enicarthage.service.EnseignantService;

@RestController
@RequestMapping("/enseignant")
@CrossOrigin("http://localhost:4200/")
public class EnseignantController {
      @Autowired	
    private  EnseignantService enseignantService; 
      
      //cree un enseignant
      @PostMapping
      public Enseignant saveEnseignant(@RequestBody Enseignant enseignant) {
    	  return enseignantService.saveEnseignant(enseignant);
      }
      
      
      //get list of enseignant
      @GetMapping
      public List<Enseignant> getAllEnseignants(){
    	  return enseignantService.getEnseignant();
      }
      
      
      //getby id enseignant
      @GetMapping("/{id}")
      public Enseignant getEnseignantById(@PathVariable Long id) {
    	  return enseignantService.getEnseignantById(id);
      }
      
      
      //update enseignant
      @PutMapping("/update/{id}")
      
      public Enseignant updateEnseignantById(@RequestBody Enseignant enseignant,@PathVariable Long id) {
    	  return enseignantService.updateEnseignant(enseignant, id);
      }
      
      @DeleteMapping("/delete/{id}")
      public void deleteEnseignantById(@PathVariable Long id){
    	  enseignantService.deleteEnseignant(id);
    	  //return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
      }
           

      //get list of matiere selon email and password
     
    /*  @GetMapping("/{email}/{password}")
      public Matiere findMatieresByEmailAndPassword(@PathVariable String email,@PathVariable String password){
    	  return enseignantService.getListMatierePassAndEmail(email, password);
      }*/
   
      //add list of groupes to enseignant
      @PostMapping("/{idE}/groupes")
      public ResponseEntity<Enseignant>addgroupesToEnseignant(@PathVariable Long idE , @RequestBody List<Long> idGrps){
    	  return new ResponseEntity<Enseignant>(enseignantService.addGroupesToEnseignant(idE, idGrps),HttpStatus.OK);
      }
      
      @GetMapping("/{idEns}/groupes")
      public List<Groupe>getListGroupeByEnseignant(@PathVariable Long idEns){
    	  return enseignantService.getListGroupeByEnseignant(idEns);
      }
     
      //get enseignant by email
      @GetMapping("/getby/{email}")
      public Enseignant getEnseignantByEmail(@PathVariable String email) {
    	  return enseignantService.getEnseignantByEmail(email);
      }
      
    
      
}
