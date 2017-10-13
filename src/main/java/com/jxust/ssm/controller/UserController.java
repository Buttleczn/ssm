package com.jxust.ssm.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jxust.ssm.pojo.Report;
import com.jxust.ssm.pojo.Tzinfo;
import com.jxust.ssm.pojo.User;
import com.jxust.ssm.service.UserService;

@Controller
public class UserController {
	/**
	 * 使用@Autowired也可以，@Autowired默认按类型装配
	 * @Resource 默认按名称装配，当找不到与名称匹配的bean才会按类型装配。
	 */
	@Resource 
	private UserService userService;

	/**
	 * 测试查询
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/showUser")
	public String testtoshowUser(@RequestParam(value = "id") String id, Model model) {
		System.out.println("id:" + id);
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "showUser";
	}

	/**
	 * 测试添加数据
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/insertUser")
	public String testinsertUser() {
		User user = new User();
		user.setUserName("tomy");
		user.setPassword("123");
		user.setAge(22);
		int count = userService.insert(user);
		System.out.println("插入" + count + "条数据成功");
		return "showUser";
	}
	
	@RequestMapping("/loginlink")
	public String login(){
		return "Login";
	}
	
	/**
	 * 测试登陆
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String testlogin(@RequestParam(value = "id") String id,@RequestParam(value = "password") String password,HttpSession httpSession) {
		System.out.println("id:" + id +"$pwd:" + password);
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		User rsuser = userService.testlogin(user);
		try{String userid = rsuser.getId();}
		catch(Exception e){
			return "error";
		}
		httpSession.setAttribute("id", id);
		httpSession.setAttribute("turn", 1);
		httpSession.setAttribute("capital", 100);
		httpSession.setAttribute("comment", "");
	    if(user.getId().toString().equals("1")){
	    	System.out.println("管理者：" + rsuser.getId() );
	    	return "UserMster";
		}else{
			System.out.println("登录人：" + rsuser.getId() );
			return "Invest";
		}
	}
	
	/**
	 * 测试重置
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/reset")
	public String reset() {
		int rscnt = userService.reset();
		if(rscnt > 0){
			String msg = "成功重置！";
		}
			return "UserMster";	
	}
	
	/**
	 * 测试提交第一轮
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/confirm")
	public String confirm(@RequestParam(value = "id") String id,@RequestParam(value = "turn") Integer turn,
						  @RequestParam(value = "capital") String capital,@RequestParam(value = "invest") String invest,
						  HttpSession httpSession) {
		Tzinfo tzinfo = new Tzinfo();
		tzinfo.setTurn(turn);
		tzinfo.setId(id);
		tzinfo.setCapital(capital);
		tzinfo.setInvest(invest);
		List<Tzinfo> itemlist = userService.checkins(tzinfo);
		if(itemlist.size() == 0){
			httpSession.setAttribute("comment", "");
			int count = userService.confirm(tzinfo);
			System.out.println("插入" + count + "条数据成功");
			return "Invest";
		}else{
			httpSession.setAttribute("comment", "不要重复作答");
			return "Invest";
		}
		
	}
	
	/**
	 * 测试下一轮
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/next")
	public String next(@RequestParam(value = "id") String id,@RequestParam(value = "turn") Integer turn,
			           HttpSession httpSession) {
		Tzinfo tzinfo = new Tzinfo();
		tzinfo.setTurn(turn);
		tzinfo.setId(id);
		List<Tzinfo> itemlist = userService.check(tzinfo);
		System.out.println("一共" + itemlist.size() + "人作答");
		if(itemlist.size() == 4){
			Tzinfo resinfo = userService.calcul(tzinfo);
			httpSession.setAttribute("turn", resinfo.getTurn());
			httpSession.setAttribute("capital", resinfo.getCapital());
			httpSession.setAttribute("comment", "");
			System.out.println("本金为" + resinfo.getCapital() + "元");
			if(turn == 6){
				return "showUser";
			}else{
				return "Invest";	
			}
		}else{
			httpSession.setAttribute("comment", "请作答或等待其他同学.....");
			return "Invest";
		}
		
	}
	
	/**
	 * 测试获取报表
	 * 
	 * @return list
	 */
	@RequestMapping("/report")
	public String getReport(Model model) {
		List<Report> rep_list = userService.getReport();
		model.addAttribute("item", rep_list);
		System.out.println(rep_list.get(0).getCapital1());
		return "UserMster";
	}
}
