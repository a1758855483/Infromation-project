package com.rj.bd.student.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rj.bd.student.entity.Student;
import org.apache.ibatis.annotations.*;

/**
 * student模块的持久层
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {

	//多表联查
	@Select("  select * from student u,classes c,department d where u.cid=c.cid AND u.departid=d.departid ")
	public List<Student> queryAll();
	
	@Update("update user set name=#{name} where id=#{id}")
	public void UpdateUser(Student user);

	@Insert("insert into user(id,name) values(#{id},#{name});")
	public void InsertUser(Student user);

	/**
	 * @desc  根据id删除
	 * @param uid
	 */
	@Delete("delete from student where uid=#{uid}")
	public void DeleteUser(@Param("uid") String uid);

	/**
	 * @desc   根据班级名称查询班级id
	 */
	@Select("select cid from classes where cname=#{cname}")
	public String queryByNametoId(@Param("cname") String cname);

	/**
	 * @desc   根据系名查询系id
	 */
	@Select("select departid from department where departname=#{departname}")
	public String queryByNametodId(@Param("departname") String departname);

	/**
	 * @desc   添加学生
	 */
	@Insert("insert into student (uid,uname,sex,birth,unumber,password,cid,school,departid) values(#{uid},#{uname},#{sex},#{birth},#{unumber},#{password},#{cid},#{school},#{departid})")
	public void save(@Param("uid") String uid, @Param("uname") String uname, @Param("sex") String sex, @Param("birth")Date birth, @Param("unumber") String unumber,
					@Param("password") String password, @Param("cid") String cid, @Param("school") String school, @Param("departid") String departid);
	
	
	
	
}
