package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import controller.LostPerson;
import lombok.extern.slf4j.Slf4j;
import lostapplication.Person;

@Service
@Slf4j
public class Lostdefault implements LostPerson {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Person> fetchPerson(String personId, String homeStateId, String gender) {
		log.debug("DAO: personId = {}, provinceId = {}, gender = {}", personId,
				homeStateId, gender);
		
		// @formatter: off
		String sql = ""
		+ "SELECT * "
		+ "FROM person "
		+ "WHERE person_id = :person_id AND Home_province_id = :Home_province_id AND gender = :gender";
		// @formatter: on
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("person_id", personId);
		params.put("Home_state_id", homeStateId);
		params.put("gender", gender);
		return jdbcTemplate.query(sql, params, new RowMapper(){

		public LostPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
		//@formatter:off
		return LostPerson.builder()
		.lostpersonPK(rs.getLong("person_Pk"))
		.lostpersonId(rs.getString("person_id"))
		.familyName(rs.getString("family_name"))
		.givenName(rs.getString("given_name"))
		.birthday(rs.getDate("birthday").toLocalDate())
		.gender(rs.getString("gender"))
		.missingDate(rs.getDate("missing_date").toLocalDate())
		.homeStateId(rs.getString("Home_State_id"))
		.build();
		//@formatter:on
		}});
	}

	@Override
	public List<LostPerson> fetchLostPerson(String lostPersonId, String homeStateId, String gender) {
		// TODO Auto-generated method stub
		return null;
	}

}