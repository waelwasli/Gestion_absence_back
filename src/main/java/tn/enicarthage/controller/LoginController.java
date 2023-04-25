package tn.enicarthage.controller;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.model.Enseignant;
import tn.enicarthage.model.Etudiant;
import tn.enicarthage.model.Login;
import tn.enicarthage.repository.EnseignantRepo;
import tn.enicarthage.repository.EtudiantRepo;
import tn.enicarthage.service.EnseignantService;
import tn.enicarthage.service.EtudiantService;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200/")
public class LoginController {
    private EtudiantService etudiantService;
    private EtudiantRepo etudiantRepo;
    private EnseignantService enseignantService;
    private EnseignantRepo enseignantRepo;

public LoginController(EtudiantService etudiantService, EtudiantRepo etudiantRepo, EnseignantService enseignantService, EnseignantRepo enseignantRepo) {
        this.etudiantService = etudiantService;
        this.etudiantRepo = etudiantRepo;
        this.enseignantService = enseignantService;
        this.enseignantRepo = enseignantRepo;
    }

    @PostMapping("/etudiant")
    public ResponseEntity<Etudiant> loginEtudiant(@RequestBody Login request) {
Etudiant etudiant = this.etudiantRepo.findEtudiantByEmail(request.getEmail());
        if (etudiant == null || !etudiant.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(etudiant);
    }
@PostMapping("/enseignant")
    public ResponseEntity<Enseignant> loginEnseignant(@RequestBody Login request) {

        Enseignant enseignant = this.enseignantRepo.findEnseignantByEmail(request.getEmail());
        if (enseignant == null || !enseignant.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(enseignant);
    }

}