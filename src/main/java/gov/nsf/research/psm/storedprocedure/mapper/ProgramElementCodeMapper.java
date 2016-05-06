package gov.nsf.research.psm.storedprocedure.mapper;

import gov.nsf.research.psm.model.Program;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProgramElementCodeMapper implements RowMapper<Program> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public final Program mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		Program programElement;

		if (rs.getString("pgmEleCode") != null) {
			programElement = new Program();

			programElement.setId((rs.getString("pgmEleCode")));
			//programElement.setProgramElementCode((rs.getString("pgmEleCode")));// pgmEleCode
			

		} else {
			programElement = null;
		}

		return programElement;

	}

}
