/**
2* @file TestcaseServiceImpl.java 
* @brief 테스트케이스 서비스구현체
* @section Major History
* <pre>
*   - 홍길동 ㅣ 2022-07-29 | First Created
* </pre>
* @section Copyright
* <pre>
*   - Copyright(c) International Business Shinhan DS Inc. 2022 All rights reserved.
* </pre>
*/
/**
 * @namespace com.shinhan.ds.api.v1.cco.service
 * @brief 테스트케이스 서비스패키지
 */

package kr.ac.ewha.cse.ccrew.api.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.ac.ewha.cse.ccrew.api.dao.UserDao;
import kr.ac.ewha.cse.ccrew.api.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;


/**
 * @brief API 서비스
 */
@Service
@Slf4j
public class APIServiceImpl implements IAPIService {
    
    @Resource
    private UserDao dao;

   /**
    * @brief 사용자정보조회
    * @param UserDTO
    * @return List<UserDTO>
    * @throws Exception
    */   
    public List<UserDTO> getUserList(UserDTO user) throws Exception{
        
    	List<UserDTO> list= dao.selectUsers(user);
        
    	log.debug(list.toString());
    	
        return list;
    }

    public UserDTO regScore(UserDTO user) throws Exception{
         
     	UserDTO dto= dao.getUsers(user);
        
     	if(dto==null)
     	{
     		dao.insertUsers(user);
     	}
     	else
     	{
     		dao.updateUser(user);
     	}
         return user;
     }
}
