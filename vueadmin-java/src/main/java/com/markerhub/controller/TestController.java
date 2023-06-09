package com.markerhub.controller;

import com.markerhub.common.lang.Result;
import com.markerhub.entity.SysUser;
import com.markerhub.mqtt.MqttProducer;
import com.markerhub.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	SysUserService sysUserService;

	@Autowired
	MqttProducer mqttProducer;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	// @PreAuthorize("hasRole('admin')")
	@GetMapping("/test")
	public Result test() {
		mqttProducer.sendToMqtt("test", 0, "这是我史秀海发的测试数据");
		SysUser sysUser = sysUserService.getByUsername("admin");
		sysUser.setPassword("1234");
		return Result.succ(sysUser);
	}

	// 普通用户、超级管理员
	// @PreAuthorize("hasAuthority('sys:user:list')")
	@PreAuthorize("hasAuthority('sys:ok')")
	@GetMapping("/test/pass")
	public Result pass() {

		// 加密后密码
		String password = bCryptPasswordEncoder.encode("111111");

		boolean matches = bCryptPasswordEncoder.matches("111111", password);

		System.out.println("匹配结果：" + matches);

		return Result.succ(password);
	}

}
