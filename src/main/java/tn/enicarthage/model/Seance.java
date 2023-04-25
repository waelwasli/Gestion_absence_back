package tn.enicarthage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seance implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String date;
  private String heureDebut;
  private String heureFin;
  private String type;
  
 /* @ManyToMany(cascade = { CascadeType.PERSIST,CascadeType.MERGE})
  private Set<Enseignant>enseignants=new HashSet<>();*/
  
  @ManyToOne
  private Groupe groupe ;
  
  @ManyToOne
  @JsonIgnore
  private Enseignant enseignant;
 
}
