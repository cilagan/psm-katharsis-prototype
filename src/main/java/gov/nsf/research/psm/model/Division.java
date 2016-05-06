package gov.nsf.research.psm.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiIncludeByDefault;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.JsonApiToMany;

@JsonApiResource(type = "divisions")
public class Division {

	@JsonApiId
	private String id;
	
	@JsonProperty("code")
	private String divisionCode;
	
	@JsonProperty("description")
	private String divisionDesc;

	@JsonProperty("programs")
	@JsonApiIncludeByDefault
	@JsonApiToMany(lazy=false)
	private List<Program> programElementList;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public List<Program> getProgramElementList() {
		if(programElementList == null) {
			programElementList = new ArrayList<Program>();
		}
		return programElementList;
	}


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

