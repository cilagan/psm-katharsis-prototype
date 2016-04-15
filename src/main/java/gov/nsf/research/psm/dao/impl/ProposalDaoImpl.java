package gov.nsf.research.psm.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import gov.nsf.research.psm.dao.ProposalDao;
import gov.nsf.research.psm.model.Directorate;
import gov.nsf.research.psm.model.Division;
import gov.nsf.research.psm.model.FundingOpportunity;
import gov.nsf.research.psm.model.ProgramElement;
//import gov.nsf.research.psm.model.Division;
//import gov.nsf.research.psm.model.FundingOpportunity;
//import gov.nsf.research.psm.model.ProgramElement;
import gov.nsf.research.psm.storedprocedure.SPGetAllDirectorates;
import gov.nsf.research.psm.storedprocedure.SPGetAllDivisions;
//import gov.nsf.research.psm.storeprocedure.SPGetAllDivisions;
import gov.nsf.research.psm.storedprocedure.SPGetAllFundingOpportunities;
import gov.nsf.research.psm.storedprocedure.SPGetAllProgramElement;
//import gov.nsf.research.psm.storeprocedure.SPGetAllProgramElement;
import gov.nsf.research.psm.storedprocedure.SPGetDirectoratesByFundID;
//import gov.nsf.research.psm.storeprocedure.SPGetDivisionsByFundID;
//import gov.nsf.research.psm.storeprocedure.SPGetProgramElementByDivID;

public class ProposalDaoImpl implements ProposalDao {

	@Autowired
	private JdbcTemplate psmFLJdbcTemplate;

	public JdbcTemplate getPsmFLJdbcTemplate() {
		return psmFLJdbcTemplate;
	}

	public void setPsmFLJdbcTemplate(JdbcTemplate psmFLJdbcTemplate) {
		this.psmFLJdbcTemplate = psmFLJdbcTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FundingOpportunity> getAllFundingOpportunities() {
		SPGetAllFundingOpportunities sPGetAllFundingOpportunities = new SPGetAllFundingOpportunities(
				psmFLJdbcTemplate.getDataSource(),
				SPGetAllFundingOpportunities.STORED_PROC_GET_FUND_OPPORTUNITY);

		Map<String, Object> result = sPGetAllFundingOpportunities.execute();

		List<FundingOpportunity> fundingOpportunityList = (List<FundingOpportunity>) result
				.get(SPGetAllFundingOpportunities.RESULT_SET);

		for (FundingOpportunity fundingOpportunity : fundingOpportunityList) {

			fundingOpportunity.setDirectorateList(getDirectorateByFundID(fundingOpportunity.getFundingOpportunityId()));
			//fundingOpportunity.setDivisionList(getDivisionsByFundingOpportunity(fundingOpportunity.getFundingOpportunityId()));

		}

		return fundingOpportunityList;
	}

	//DONE
	@SuppressWarnings("unchecked")
	@Override
	public List<Division> getAllDivisions() {
		SPGetAllDivisions sPGetAllDivisions = new SPGetAllDivisions(
				psmFLJdbcTemplate.getDataSource(),
				SPGetAllDivisions.STORED_PROC_GET_ALL_DIVISIONS_LIST);

		Map<String, Object> result = sPGetAllDivisions.execute();

		List<Division> divisionsList = (List<Division>) result
				.get(SPGetAllDivisions.RESULT_SET);

		//setting program element code list for each division
		for (Division division : divisionsList) {

			//division.setProgramElementList(getProgramElementCode(division.getDivisionCode()));

		}

		return divisionsList;
	}

	
/*
	private List<Division> getDivisionsByFundingOpportunity(String pgmAnncID) {
		SPGetDivisionsByFundID sPGetDivisions = new SPGetDivisionsByFundID(
				psmFLJdbcTemplate.getDataSource(),
				SPGetDivisionsByFundID.STORED_PROC_GET_DIVISIONS_LIST);

		Map<String, Object> result = sPGetDivisions.execute(pgmAnncID);
			
		return (List<Division>) result
				.get(SPGetDivisionsByFundID.RESULT_SET);
	}
*/
	
	//Done
	@SuppressWarnings("unchecked")
	@Override
	public List<Directorate> getAllDirectorates() {
		System.out.println("ProposalDaoImpl.getAllDirectorates()");
		SPGetAllDirectorates sPGetAllDirectorates = new SPGetAllDirectorates(
				psmFLJdbcTemplate.getDataSource(),
				SPGetAllDirectorates.STORED_PROC_GET_ALL_DIRECTORATES);

		Map<String, Object> result = sPGetAllDirectorates.execute();

		List<Directorate> directorateList = (List<Directorate>) result
				.get(SPGetAllDirectorates.RESULT_SET);

		return directorateList;
	}
/*
	//done
	@SuppressWarnings("unchecked")
	private List<ProgramElement> getProgramElementCode(String divisionCode) {
		SPGetProgramElementByDivID sPGetProgramElementByDivID = new SPGetProgramElementByDivID(
				psmFLJdbcTemplate.getDataSource(),
				SPGetProgramElementByDivID.STORED_PROC_GET_PROGRAMELEMENT_LIST_BY_DIV_CODE);

		Map<String, Object> result = sPGetProgramElementByDivID.execute(divisionCode);

		List<ProgramElement> sPGetProgramElementList = (List<ProgramElement>) result
				.get(SPGetProgramElementByDivID.RESULT_SET);

		return sPGetProgramElementList;
	}
*/
	@SuppressWarnings("unchecked")
	private List<Directorate> getDirectorateByFundID(String pgmAnncID) {

		SPGetDirectoratesByFundID sPGetDirectorates = new SPGetDirectoratesByFundID(
				psmFLJdbcTemplate.getDataSource(),
				SPGetDirectoratesByFundID.STORED_PROC_GET_DIRECTORATE_LIST_BY_FUND_ID);

		Map<String, Object> result = sPGetDirectorates.execute(pgmAnncID);

		List<Directorate> directorateList = (List<Directorate>) result
				.get(SPGetDirectoratesByFundID.RESULT_SET);

		return directorateList;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProgramElement> getAllProgramElements() {
		SPGetAllProgramElement sPGetAllProgramElement = new SPGetAllProgramElement(
				psmFLJdbcTemplate.getDataSource(),
				SPGetAllProgramElement.STORED_PROC_GET_ALL_PROGRAMELEMENT_LIST);

		Map<String, Object> result = sPGetAllProgramElement.execute();

		List<ProgramElement> sPGetAllProgramElementList = (List<ProgramElement>) result
				.get(SPGetAllProgramElement.RESULT_SET);

		return sPGetAllProgramElementList;
	}

}
