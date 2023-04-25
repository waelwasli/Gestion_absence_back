package tn.enicarthage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.model.Seance;
import tn.enicarthage.service.SeanceService;

@RestController
@RequestMapping("/seance")
@CrossOrigin("http://localhost:4200/")
public class SeanceController {
	@Autowired
   private SeanceService seanceService;
	
	@PostMapping
	
	public ResponseEntity<Seance>  saveSeance(@RequestBody Seance seance) {
		return new ResponseEntity<Seance>(seanceService.saveSeance(seance),HttpStatus.CREATED);
	}
	
	  @GetMapping("/{id}")
	    public Seance getSeanceById(@PathVariable Long id) {
	        return seanceService.getSeanceById(id);
	    }
	  
	  @GetMapping
	  public List<Seance> getAllSeance() {
        
		  return seanceService.getAllSeance();
}   
	  @PutMapping("/update/{id}")
	  public Seance updateSeance(@RequestBody Seance seance,@PathVariable Long id) {
		  return seanceService.updateSeance(seance, id);
	  }
	  
	  @PostMapping("/addEns/{idEns}/ToSeance")
	  public Seance addEnsToSeance(@RequestBody Seance seance, @PathVariable Long idEns) {
		  return seanceService.addEnsToSeance(seance, idEns);
	  }
	  
	  @GetMapping("/findByEns/{idEns}")
	 public List<Seance> findByEnseignant(@PathVariable Long idEns){
		  return seanceService.findByEnseignant(idEns);
	  }
	  
}
