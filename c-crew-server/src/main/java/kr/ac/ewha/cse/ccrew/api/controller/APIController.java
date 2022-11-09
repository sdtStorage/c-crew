package kr.ac.ewha.cse.ccrew.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.ewha.cse.ccrew.api.dto.UserDTO;
import kr.ac.ewha.cse.ccrew.api.service.IAPIService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class APIController {
	
	
    @Autowired
    private IAPIService service;

    /**
     * @brief 샘플 페이징 목록 조회
     * @param param
     * @return ResponseBody
     * @throws Exception
     */
    @PostMapping(value = "/list/userinfo")
    public @ResponseBody Map getList(@RequestBody UserDTO userdto) throws Exception {
    	
    	log.debug("**************************");
    	log.debug(userdto.toString());
    	log.debug("***********m***************");
    	
    	List<UserDTO> list = service.getUserList(userdto);
    	Map map = new HashMap();
    	map.put("ranking", list);
    	return map;
    }
    
    
    
    @PostMapping(value = "/score/userinfo")
    public @ResponseBody UserDTO regScore(@RequestBody UserDTO userdto) throws Exception {
    	
    	log.debug("**************************");
    	log.debug(userdto.toString());
    	log.debug("**************************");
    	
    	UserDTO dto = service.regScore(userdto);
    	
    	return dto;
    }
    
    @PostMapping(value = "/delete/userinfo")
    public @ResponseBody UserDTO deleteUser() throws Exception {
    	
    	
    	UserDTO dto = service.deleteUser();
    	
    	return dto;
    }    
}



