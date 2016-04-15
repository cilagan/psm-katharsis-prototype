package gov.nsf.research.psm.storedprocedure.mapper;

import gov.nsf.research.psm.model.ProgramElement;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProgramElementMapper implements RowMapper<ProgramElement> {

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

			programElement.setId((rs.getString("pgmEleCode")));
			programElement.setProgramElementCode((rs.getString("pgmEleCode")));// pgmEleCode
			programElement.setProgramElementDesc((rs.getString("pgmEleName")));// pgmEleName
			
		} else {
			programElement = null;
		}

		return programElement;

	}

}
