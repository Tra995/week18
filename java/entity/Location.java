package entity;


import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Location {
  private Long sightingPK;
  private String sightingId;
  private LocalDate sightingDate;
  private String sightingProvinceId;
  

}