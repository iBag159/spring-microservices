package tawadevs.com.microservices.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AccountDTO {
	@NonNull
	private Integer id;
	@NonNull
	private String name;
}	
