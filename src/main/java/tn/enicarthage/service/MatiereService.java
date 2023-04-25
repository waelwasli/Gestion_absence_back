package tn.enicarthage.service;

import java.util.List;

import tn.enicarthage.model.Matiere;

public interface MatiereService {
	
        public Matiere saveMatiere(Matiere matiere);
        
        public List<Matiere>getAllMatieres();
        
        public Matiere getMatierById(Long id);
        
        public Matiere updateMatiere(Matiere matiere ,Long id);
        
        public void deleteMatiere(Long id);
        
        public List<Matiere>getMatiereByIDs(List<Long>idMats);
        
        public List<String> getListMatofEtd(Long etd);
        
        public List<Matiere>getMatEtd(Long etd);
}
