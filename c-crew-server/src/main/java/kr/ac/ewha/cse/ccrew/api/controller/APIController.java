package kr.ac.ewha.cse.ccrew.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    public @ResponseBody List<UserDTO> getList(@RequestBody UserDTO userdto) throws Exception {
    	
    	log.debug("**************************");
    	log.debug(userdto.toString());
    	log.debug("**************************");
    	
    	List<UserDTO> list = service.getUserList(userdto);
    	
    	return list;
    }
}



