package br.com.portfolio.rasmoo.school.api.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class MatterUpdateRq {
	
	private Long id;
	@NotBlank(message = "Enter the name of the matter")
	private String name;
	
	@Min(value = 34, message = "Minimum of 34 hrs per matter allowed")
	@Max(value = 120, message = "Maximum of 120 hrs per matter allowed")
	private int hour;
	
	@NotBlank(message = "Enter the code of the matter")
	private String code;
	
	@Min(value = 1, message = "Minimum allowed once a year")
	@Max(value = 2, message = "Maximum of 2 times per year allowed")
	private int frequency;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
