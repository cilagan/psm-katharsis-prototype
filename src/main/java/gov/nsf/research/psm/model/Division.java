package gov.nsf.research.psm.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "divisions")
public class Division {

	@JsonApiId
	private String id;
	
	@JsonProperty
	private String divisionCode;
	
	@JsonProperty
	private String divisionDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*private List<ProgramElement> ProgramElementList;

	public List<ProgramElement> getProgramElementList() {
		return ProgramElementList;
	}

	public void setProgramElementList(List<ProgramElement> programElementList) {
		ProgramElementList = programElementList;
	}
*/
	public String getDivisionDesc() {
		return divisionDesc;
	}

	public void setDivisionDesc(String divisionDesc) {
		this.divisionDesc = divisionDesc;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	
	

}

