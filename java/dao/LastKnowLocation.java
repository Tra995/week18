package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import controller.LostPerson;
import service.LastKnownLocation;
import service.LastKnownLocationService;

@Component
public class LastKnowLocation<Sighting, Person, PersonSighting> implements LastKnownLocationService {

	public static final String Person = null;
	@Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	  
	  public LastKnownLocation saveLastKnownLocation(LastKnownLocation lastknownlocation, LostPerson lostperson) {
		  
		  SqlParameter params = generateInsertSql(lastknownlocation,lostperson);
		  
		  KeyHolder keyHolder = new GeneratedKeyHolder();
		  jdbcTemplate.update(params.sql, params.source,keyHolder);
		  Long personSightingPk = keyHolder.getKey().longValue(); 
		  
		  
		  //@formatter:off
		  return LastKnowLocation.SightingResultSetExtractor
				  .LastKnownLocationPK(personSightingPk)
				  .location(lastknownlocation)
				  .lostperson(lostperson)
				  .build();
		  //@formatter:on
	 };
	  
	 
	 /**
	  * 
	  * @param person
	  * @param location
	  * @param 
	  * @return
	  */
	  private SqlParams generateInsertSql(entity.Location location, LostPerson lostperson) {
	    // @formatter:off
	    String sql = ""
	        + "INSERT INTO lost ("
	        + "Location_fk, lostperson_fk"
	        + ") VALUES ("
	        + ":location_fk, :lostperson_fk"
	        + ")";
	    // @formatter:on
	    
	    SqlParams params = new SqlParams();
	    
	    params.sql = sql;
	    params.source.addValue("lastknownlocation_fk", LastKnownLocation.getLastKnownLocationPK());
	    params.source.addValue("lostperson_fk", LostPerson.getLostpersonPK());
	        
	    return params;
	  }
	  /**
	   * 
	   */
	  public Person fetchLostPerson(String lostpersonId) {
	    // @formatter:off
	    String sql = "" 
	        + "SELECT * " 
	        + "FROM lostperson "
	        + "WHERE lostperson_id = :lostperson_id ";

	    // @formatter:on

	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("lostperson_id", lostpersonId);


	    return jdbcTemplate.query(sql, params, new PersonResultSetExtractor());
	  }

	  /**
	   * 
	   */
	  public void fetchlocation(String locationId) {
	    // @formatter:off
	    String sql = "" 
	        + "SELECT * " 
	        + "FROM location " 
	        + "WHERE location_id = :location_id ";

	        
	        
	    
	    // @formatter:on

	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("location_id", locationId);

	  }


	  class PersonResultSetExtractor implements ResultSetExtractor<Person> {
	    public Person extractData(ResultSet rs) throws SQLException {
	      rs.next();

	      // @formatter:off
	      return LastKnownLocation.builder()
	          .personId(rs.getString("person_id"))
	          .familyName(rs.getString("family_name"))
	          .givenName(rs.getString("given_name"))
//	          .birthday(rs.getDate("birthday").toLocalDate())
	          .gender(rs.getString("gender"))
//	          .missingDate(rs.getDate("missing_date").toLocalDate())
	          .homeProvinceId(rs.getString("Home_province_id"))
	          .build();
	 
	  class SightingResultSetExtractor implements ResultSetExtractor<Lost> {
	    public Lost extractData(ResultSet rs) throws SQLException {
	      rs.next();

	      // @formatter:off
	      return Location.builder()
	          .sightingId(rs.getString("sighting_id"))
//	          .sightingDate(rs.getDate("sighting_date").toLocalDate())
	          .sightingProvinceId(rs.getString("sighting_province_id"))
	          .build();
	      // @formatter:on
	    }
	  }

                                      
	

	  class SqlParams {
	    String sql;
	    MapSqlParameterSource source = new MapSqlParameterSource();
	  }




	    }
	    }




	@Override
	public LastKnownLocation createLastKnownLocation(LastKnownLocationService LastKnowLocationRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}