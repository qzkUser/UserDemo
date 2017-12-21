package com.qzk.controller;

import com.qzk.model.User;
import com.qzk.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@EnableAutoConfiguration
public class UserLoginController {
	@Autowired
    private UserService userService;
	
	@RequestMapping("/")
	public String test(){
		return "holle word";
	}
    
    @ApiOperation("添加用户")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="username",dataType="String",required=true,value="账户名",defaultValue="zhaojigang"),
        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户密码",defaultValue="wangna")
    })
    @ApiResponses({
        @ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/addUser",method=RequestMethod.GET)
    public boolean addUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        return userService.addUser(username,password);
    }
    
    @ApiOperation("添加用户且返回已经设置了主键的user实例")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="username",dataType="String",required=true,value="账户名"),
        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户密码")
    })
    @ApiResponses({
    	@ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/addUserWithBackId",method=RequestMethod.GET)
    public User addUserWithBackId(@RequestParam("username") String username, 
                                     @RequestParam("password") String password) {
        return userService.addUserWithBackId(username, password);
    }
    
    @ApiOperation(value="用户登录",httpMethod="get",notes="登录1.0",response=boolean.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType="query",name="username",dataType="String",required=true,value="账户名"),
    	@ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="密码")
    })
    @ApiResponses({
    	@ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public User loginUser(@RequestParam("username") String username, @RequestParam("password") String password){
    	return userService.loginUser(username, password).build();
    }

    @ApiOperation(value="获取全部用户",httpMethod="get",notes="获取全部用户1.0",response=List.class)
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/listUsers",method=RequestMethod.GET)
    public List<User> listUsers(){
        System.out.println("=============>>>>>>>>>>>>>>");
        List<User> list = userService.getAllUsers();
        return list;
    }
    
    @ApiOperation(value="获取全部用户",httpMethod="get",notes="获取全部用户1.0",response=List.class)
    @ApiResponses({
    	@ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
    public List<User> getAllUsers(){
    	List<User> list = userService.getAllUsers();
    	return list;
    }
    
    @ApiOperation(value="删除用户",httpMethod="get",notes="删除用户1.0",response=boolean.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType="query",name="id",dataType="Integer",required=true,value="用户ID")
    })
    @ApiResponses({
    	@ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/deleteUserById",method=RequestMethod.DELETE)
    public boolean deleteUserById(@RequestParam Integer id){
    	return userService.deleteUserById(id);
    }
    
    @ApiOperation(value="根据id查询用户",httpMethod="get",notes="根据id查询用户",response=boolean.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType="query",name="id",dataType="Integer",required=true,value="用户ID")
    })
    @ApiResponses({
    	@ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/findUserById",method=RequestMethod.GET)
    public User findUserById(@RequestParam Long id){
    	return userService.findUseById(id);
    }
    
}
