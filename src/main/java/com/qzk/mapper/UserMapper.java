package com.qzk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.qzk.model.User;
import com.qzk.model.User.UserBuilder;



public interface UserMapper {
	@Insert("INSERT INTO `itqzk`.`u_user` (`u_name`, `u_account`, `u_password`, `u_email`, `u_phone` , `u_ip`, `u_authorize`) VALUES ('邱振珂', #{username}, #{password}, '769911900@qq.com', '15692175747' , '116.231.145.194', '0')")
    public int insertUser(@Param("username") String username, @Param("password")  String password);

	@Select("select u_id as id,u_name as username,u_account as account,u_password as password,u_email as email,u_phone as phone,u_ip as ip,u_authorize as authorize from u_user where u_name = #{username} and u_password = #{password}")
	public UserBuilder loginUser(@Param("username") String username, @Param("password") String password);
	
	@Select("select u_id as id,u_name as username,u_account as account,u_password as password,u_email as email,u_phone as phone,u_ip as ip,u_authorize as authorize from u_user where u_authorize = 0")
	public List<User> getAllUsers();
	
	@Delete("delete from u_user where u_id = #{id}")
	public int deleteUserById(@Param("id") String id);
	
	@Select("select u_id as id,u_name as username,u_account as account,u_password as password,u_email as email,u_phone as phone,u_ip as ip,u_authorize as authorize from u_user where u_authorize = 0 and u_id = #{id}")
	public User findUserById(@Param("id") String id);
    
    /**
     * 插入用户，并将主键设置到user中
     * 注意：返回的是数据库影响条数，即1
     */
    public int insertUserWithBackId(User user);
}
