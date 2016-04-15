package gov.nsf.research.psm.storedprocedure.mapper;

import gov.nsf.research.psm.model.Division;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DivisionMapperCode  implements RowMapper<Division> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public final Division mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		Division division;

		if (rs.getString("divisionCode") != null) {
			division = new Division();

			division.setDivisionCode((rs.getString("divisionCode")));// divisionCode
			
		} else {
			division = null;
		}

		return division;

	}

}
