package entity;


import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Person {
  private Long personPK;
  private String personId;
  private String familyName;
  private String givenName;
  private LocalDate birthday;
  private String gender;
  private LocalDate missingDate;
  private String homeStateId;
  
  

  
  
}