package kr.ac.ewha.cse.ccrew.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDTO {
	
	private String userId;
	private int score;

}
