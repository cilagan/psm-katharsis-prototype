package gov.nsf.research.psm.storedprocedure.mapper;

import gov.nsf.research.psm.model.ProgramElement;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProgramElementCodeMapper implements RowMapper<ProgramElement> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public final ProgramElement mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		ProgramElement programElement;

		if (rs.getString("pgmEleCode") != null) {
			programElement = new ProgramElement();

			programElement.setProgramElementCode((rs.getString("pgmEleCode")));// pgmEleCode
			

		} else {
			programElement = null;
		}

		return programElement;

	}

}
