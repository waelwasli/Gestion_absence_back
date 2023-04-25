package tn.enicarthage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnseignantDto {
	  private String firstName;
      private String lastName;
      private String email;
      private String password;
      private String imageUrl;
     // private Groupe groupe;
	  private Long matiereId;
}
