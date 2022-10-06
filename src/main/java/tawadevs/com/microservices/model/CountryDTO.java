package tawadevs.com.microservices.model;

import lombok.Data;

@Data
public class CountryDTO {
	private String isoCode;
	private String name;
	private String flag;
}
