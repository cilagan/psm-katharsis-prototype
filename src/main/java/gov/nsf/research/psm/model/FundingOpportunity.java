package gov.nsf.research.psm.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.JsonApiToMany;

/**
 * Proposal Funding Opportunity
 * 
 * @author cilagan
 *
 */
@JsonApiResource(type = "fundingOpportunities")
public class FundingOpportunity {

	@JsonApiId
	private String id;
	
	@JsonProperty
	private String fundingOpportunityId;
	
	@JsonProperty
	private String fundingOpportunityType;
	
	@JsonProperty
	private Date fundingOpportunityDeadline;
	
	@JsonProperty
	private String fundingOpportunityTitle;
	
	@JsonApiToMany
	private List<Directorate> directorateList;
	//private List<Division> divisionList;
	
	/**
	 * 
	 * @return
	 */
	/*public List<Division> getDivisionList() {
		return divisionList;
	}*/

	/**
	 * 
	 * @param divisionList
	 */
	/*public void setDivisionList(List<Division> divisionList) {
		this.divisionList = divisionList;
	}*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getFundingOpportunityTitle() {
		return fundingOpportunityTitle;
	}
	/**
	 * 
	 * @param fundingOpportunityTitle
	 */
	
	/**
	 * 
	 * @param fundingOpportunityTitle
	 */
	public void setFundingOpportunityTitle(String fundingOpportunityTitle) {
		this.fundingOpportunityTitle = fundingOpportunityTitle;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public List<Directorate> getDirectorateList() {
		return directorateList;
	}
	
	/**
	 * 
	 * @param directorateList
	 */
	
	public void setDirectorateList(List<Directorate> directorateList) {
		this.directorateList = directorateList;
	}

	
	
	/**
	 * @return the fundingOpportunityId
	 */
	public String getFundingOpportunityId() {
		return fundingOpportunityId;
	}
	/**
	 * @param fundingOpportunityId the fundingOpportunityId to set
	 */
	public void setFundingOpportunityId(String fundingOpportunityId) {
		this.fundingOpportunityId = fundingOpportunityId;
	}
	/**
	 * @return the fundingOpportunityType
	 */
	public String getFundingOpportunityType() {
		return fundingOpportunityType;
	}
	/**
	 * @param fundingOpportunityType the fundingOpportunityType to set
	 */
	public void setFundingOpportunityType(String fundingOpportunityType) {
		this.fundingOpportunityType = fundingOpportunityType;
	}
	/**
	 * @return the fundingOpportunityDeadline
	 */
	public Date getFundingOpportunityDeadline() {
		return fundingOpportunityDeadline;
	}
	/**
	 * @param fundingOpportunityDeadline the fundingOpportunityDeadline to set
	 */
	public void setFundingOpportunityDeadline(Date fundingOpportunityDeadline) {
		this.fundingOpportunityDeadline = fundingOpportunityDeadline;
	}	
}
