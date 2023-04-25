package tn.enicarthage.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enseignant implements Serializable {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String firstName;
      private String lastName;
      private String email;
      private String password;
      private String imageUrl;
      
 
      @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
      private Set<Groupe>groupes=new HashSet<>();
      
      @ManyToOne
       private Matiere matiere;   
     
      
      @OneToMany(cascade = {CascadeType.ALL},mappedBy = "enseignant")
     Set<Seance>  seances;
      

   
}
