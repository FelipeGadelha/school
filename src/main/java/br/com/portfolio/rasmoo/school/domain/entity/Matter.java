package br.com.portfolio.rasmoo.school.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATTER")
public class Matter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "HOUR")
	private int hour;

	@Column(name = "CODE")
	private String code;

	@Column(name = "FREQUENCY")
	private int frequency;

	@Deprecated
	public Matter() {
	}

	private Matter(Builder builder) {
		this.name = builder.name;
		this.hour = builder.hour;
		this.code = builder.code;
		this.frequency = builder.frequency;
	}

	public static class Builder {

		private String name;
		private int hour;
		private String code;
		private int frequency;

		public Builder() {
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder hour(int hour) {
			this.hour = hour;
			return this;
		}
		
		public Builder code(String code) {
			this.code = code;
			return this;
		}
		
		public Builder frequency(int frequency) {
			this.frequency = frequency;
			return this;
		}

		public Matter build() {
			return new Matter(this);
		}

	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matter other = (Matter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
