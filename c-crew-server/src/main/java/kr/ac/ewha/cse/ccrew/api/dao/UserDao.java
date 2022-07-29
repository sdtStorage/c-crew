package kr.ac.ewha.cse.ccrew.api.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.ac.ewha.cse.ccrew.api.dto.UserDTO;


@Repository
@Mapper
public interface UserDao {

	List<UserDTO> selectUsers(UserDTO param) throws Exception;
	
}
