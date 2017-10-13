package com.jxust.ssm.service;

import java.util.List;

import com.jxust.ssm.pojo.Report;
import com.jxust.ssm.pojo.Tzinfo;
import com.jxust.ssm.pojo.User;
/**
 * Service层接口
 * @author Peng
 * @Date2016年12月11日下午7:05:05
 */
public interface UserService {
	//根据id查找
	public User getUserById(String userid);
	
	//添加一条数据
	public int insert(User user);
	
	//登陆测试
	public User testlogin(User user);
	
	//重置
	public int reset();
	
	//第一轮投资
	public int confirm(Tzinfo tzinfo);
	
	//校验重复提交
	public List<Tzinfo> checkins(Tzinfo tzinfo);
		
	//校验
	public List<Tzinfo> check(Tzinfo tzinfo);
	
	//计算本金
	public Tzinfo calcul(Tzinfo tzinfo);
	
	//获取报表
	public List<Report> getReport();
	
}
