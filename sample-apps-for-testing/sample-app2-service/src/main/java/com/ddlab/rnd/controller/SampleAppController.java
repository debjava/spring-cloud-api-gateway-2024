package com.ddlab.rnd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.vo.InfoVO;

@RestController
public class SampleAppController {

	@Value("${app.message: DefaultMessage}")
	private String message;

	@Value("${common.config.name: NoConfigInfo}")
	private String commonConfigName;

	@Value("${key.config.name: NoKeyConfig}")
	private String envKey;

	@GetMapping(path = "/v1/info")
	public ResponseEntity<InfoVO> getMessage() {
		InfoVO infoVo = new InfoVO(message, commonConfigName, envKey);
		return new ResponseEntity<>(infoVo, HttpStatus.OK);
	}

}
