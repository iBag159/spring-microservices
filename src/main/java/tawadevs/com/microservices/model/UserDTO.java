package tawadevs.com.microservices.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDTO extends RepresentationModel<UserDTO> {
	@NonNull
	private Integer id;
	@NonNull
	private String name;
	private String lastName;
	@ToString.Exclude
	private int age;
}
