package gov.nsf.research.psm.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiIncludeByDefault;
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
	
	@JsonProperty("code")
	private String fundingOpportunityId;
	
	@JsonProperty("title")
	private String fundingOpportunityTitle;
	

	@JsonProperty("directorates")
	@JsonApiIncludeByDefault
	@JsonApiToMany(lazy=false)
	private List<Directorate> directorateList;
	
	
	
	@JsonProperty("divisions")
	@JsonApiIncludeByDefault
	@JsonApiToMany(lazy=false)
	private List<Division> divisionList;
	
	
	/**
	 * 
	 * @return
	 */
	
	public List<Division> getDivisionList() {
		if(divisionList == null) {
			divisionList = new ArrayList<Division>();
		}
		return divisionList;
	}


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
	public void setFundingOpportunityTitle(String fundingOpportunityTitle) {
		this.fundingOpportunityTitle = fundingOpportunityTitle;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public List<Directorate> getDirectorateList() {
		if(directorateList == null) {
			directorateList = new ArrayList<Directorate>();
		}
		return directorateList;
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
	
}
