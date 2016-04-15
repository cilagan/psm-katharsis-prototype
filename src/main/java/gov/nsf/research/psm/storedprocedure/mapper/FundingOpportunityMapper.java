package gov.nsf.research.psm.storedprocedure.mapper;

import gov.nsf.research.psm.model.FundingOpportunity;

import java.sql.ResultSet;
import java.sql.SQLException;




import org.springframework.jdbc.core.RowMapper;

public class FundingOpportunityMapper implements RowMapper<FundingOpportunity>{
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public final FundingOpportunity mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		FundingOpportunity fundingOpportunity;

		if (rs.getString("pgmAnncID") != null) {
			fundingOpportunity = new FundingOpportunity();

			fundingOpportunity.setId((rs.getString("pgmAnncID")));
			fundingOpportunity.setFundingOpportunityId((rs.getString("pgmAnncID")));// pgmAnncID
			fundingOpportunity.setFundingOpportunityTitle((rs.getString("pgmAnncTitle")));// pgmAnncTitle

		} else {
			fundingOpportunity = null;
		}

		return fundingOpportunity;

	}

}

