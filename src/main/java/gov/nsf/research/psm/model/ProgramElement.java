package gov.nsf.research.psm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "programElements")
public class ProgramElement {

	@JsonApiId
	private String id;

	@JsonProperty
	private String programElementCode;
	
	@JsonProperty
	private String programElementDesc;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProgramElementCode() {
		return programElementCode;
	}

	public void setProgramElementCode(String programElementCode) {
		this.programElementCode = programElementCode;
	}

	public String getProgramElementDesc() {
		return programElementDesc;
	}

	public void setProgramElementDesc(String programElementDesc) {
		this.programElementDesc = programElementDesc;
	}

}
