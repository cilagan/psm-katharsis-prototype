package gov.nsf.research.psm.service;

import java.util.List;

import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.ProgramElement;


public interface ProposalManagementService {

	/**
	 * 
	 * @return list of fundingopportunity
	 */
	public List<FundingOpportunity> getAllFundingOpportunities();

	
	/**
	 * 
	 * @return
	 */
	public List<Division> getAllDivisions();

	/**
	 * 
	 * @return
	 */
	public List<Directorate> getAllDirectorates();

	/**
	 * 
	 * @return
	 */
	public List<ProgramElement> getAllProgramElements();
	

}
