package com.qzk.model;

import lombok.*;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class User implements Serializable{
	
	private static final long serialVersionUID = -4481104812517683307L;

	//用户id
	private Integer id;
	
	//用户姓名
	private String userName;
	
	//账户名
	private String account;
	
	//密码
	private String 	passWord;
	
	//邮箱
	private String email;
	
	//手机号
	private String phone;
	
	//登陆ip地址
	private String ip;
	
	//是否禁用
	private String authorize;
}

