package gov.nsf.research.psm.service;

import java.util.List;

import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.Program;


public interface ProposalManagementService {

	public List<FundingOpportunity> getAllFundingOpportunities();

	public List<Division> getAllDivisions();
	
	public List<Directorate> getAllDirectorates();
	
	public List<Program> getAllProgramElements();
	

}
