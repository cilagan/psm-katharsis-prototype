package gov.nsf.research.psm.storedprocedure;

import gov.nsf.research.psm.storedprocedure.mapper.DivisionMapperCode;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SPGetDivisionsByFundID extends StoredProcedure {

	public static final String STORED_PROC_GET_DIVISIONS_LIST = "flp.pr_psm_sel_div";
	public static final String RESULT_SET = "Division";
	private static final String IN_PGM_ANNC_ID = "pgmAnncID";

	public SPGetDivisionsByFundID() {
		super();
	}

	public SPGetDivisionsByFundID(DataSource dataSource, String storedProcName) {
		super(dataSource, storedProcName);

		declareParameter(new SqlReturnResultSet(RESULT_SET,
				new DivisionMapperCode()));
		declareParameter(new SqlParameter(SPGetDivisionsByFundID.IN_PGM_ANNC_ID,
				Types.VARCHAR));

		compile();
	}

	public SPGetDivisionsByFundID(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
	}

	public final Map<String, Object> execute(String pgmAnncID) {
		Map<String, Object> inParams = new HashMap<String, Object>();

		inParams.put(SPGetDivisionsByFundID.IN_PGM_ANNC_ID, pgmAnncID);

		Map<String, Object> results = super.execute(inParams);

		return results;
	}

}
