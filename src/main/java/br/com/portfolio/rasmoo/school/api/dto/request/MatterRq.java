package br.com.portfolio.rasmoo.school.api.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

public class MatterRq {

	@NotNull
	private String name;
	@NotNull
	private int hour;
	@URL(message = "URL invalida")
	private String code;
	@NotNull
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
