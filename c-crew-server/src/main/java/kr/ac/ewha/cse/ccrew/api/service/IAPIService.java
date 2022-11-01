package kr.ac.ewha.cse.ccrew.api.service;

import java.util.List;

import kr.ac.ewha.cse.ccrew.api.dto.UserDTO;


/**
 * @brief API 서비스
 */
public interface IAPIService {

   /**
    * @brief 사용자정보조회
    * @param UserDTO
    * @return List<UserDTO>
    * @throws Exception
    */       
    public List<UserDTO> getUserList(UserDTO user) throws Exception;
 

    public UserDTO regScore(UserDTO user) throws Exception;

    public UserDTO deleteUser() throws Exception;

    
}
