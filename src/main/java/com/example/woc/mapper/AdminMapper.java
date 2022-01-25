package com.example.woc.mapper;


import com.example.woc.entity.Admin;
import com.example.woc.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository

public interface AdminMapper extends Mapper<Account>{

    @Insert("INSERT into tab_admin(name,password) VALUES(#{name},#{password})")
    int saveUser(@Param("name") String name, @Param("password") String password);

    @Select("select id,name,password from tab_admin where name=#{name}")
    Admin selectUser(@Param("name") String name);


}
