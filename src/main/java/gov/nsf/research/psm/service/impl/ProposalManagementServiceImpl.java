package gov.nsf.research.psm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gov.nsf.research.psm.dao.ProposalDao;
import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.Program;
import gov.nsf.research.psm.service.ProposalManagementService;

public class ProposalManagementServiceImpl implements ProposalManagementService {
	
	@Autowired
	ProposalDao proposalDao;
	
	@Override
	public List<FundingOpportunity> getAllFundingOpportunities() {
		System.out
				.println("ProposalManagementServiceImpl.getAllFundingOpportunities()");
		
		return proposalDao.getAllFundingOpportunities();
	}

	@Override
	public List<Division> getAllDivisions() {
		System.out.println("ProposalManagementServiceImpl.getAllDivisions()");
		return proposalDao.getAllDivisions();
	}

	@Override
	public List<Directorate> getAllDirectorates() {
		System.out
				.println("ProposalManagementServiceImpl.getAllDirectorates()");
		return proposalDao.getAllDirectorates();
	}

	@Override
	public List<Program> getAllProgramElements() {
		System.out
				.println("ProposalManagementServiceImpl.getAllProgramElements()");
		return proposalDao.getAllProgramElements();
	}


}
