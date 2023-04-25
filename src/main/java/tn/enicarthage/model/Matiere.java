package tn.enicarthage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Matiere implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nomMat;
  
  
  @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "matiere")
  @JsonIgnore
  private Set<Enseignant>enseignants=new HashSet<>();
  
  @ManyToMany(mappedBy = "matieres")
  @JsonIgnore
  private Set<Groupe>groupes=new HashSet<>();
  
  @OneToMany(mappedBy = "matiere")
  List<Absence>absences=new ArrayList<>();
  

 
  
}
