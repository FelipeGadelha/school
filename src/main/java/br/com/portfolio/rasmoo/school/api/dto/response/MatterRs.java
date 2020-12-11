package br.com.portfolio.rasmoo.school.api.dto.response;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class MatterRs extends RepresentationModel<MatterRs> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int hour;
	private String code;
	private int frequency;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	
	

}
