package entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LastKnowLocation<Sighting> {
  private Long LastKnownLocationPK;
  private Person person; 
  private Sighting sighting;

  
  @JsonIgnore
  public Long getLastKnownLocationPK() {
    return LastKnownLocationPK;
  }
}