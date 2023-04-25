package tn.enicarthage.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Groupe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nomGrp;
  
   /*
   @OneToMany(mappedBy = "groupe")
   @JsonIgnore
   private Set<Enseignant>enseignants=new HashSet<>();
   */
   @ManyToMany(mappedBy = "groupes")
   @JsonIgnore
   private Set<Enseignant>enseignants=new HashSet<>();
   
   
   @ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
   private Set<Matiere>matieres=new HashSet<>();
   
   
   @OneToMany(cascade = {CascadeType.REMOVE},mappedBy = "groupe")
   @JsonIgnore
   private Set<Etudiant>etudiants=new HashSet<>();
   
  @OneToMany(mappedBy ="groupe")
  @JsonIgnore
   private Set<Seance>seances=new HashSet<>();
}
