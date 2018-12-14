package com.spring.controller;


import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.dao.UserDao;
import com.spring.model.User;

@Controller
public class HomeController
{	@Autowired
	UserDao udao;

	
	@RequestMapping(value="/")
	public String home() {	return "form";	}
	
	
	
	@RequestMapping(value="insert", method = RequestMethod.POST)
	public String insert(@RequestParam("username")String un,@RequestParam("password")String pwd)
	{
		User u = new User();
		u.setUsername(un);
		u.setPassword(pwd);
		udao.addUser(u);
		return "redirect:showAll";
	}
	@RequestMapping(value="showAll", method = RequestMethod.GET)
	public String showAll(Model model) {
		model.addAttribute("result",udao.listUser());
//		for (User temp : udao.listUser()) {
//			System.out.println("show ---"+temp.getUsername());
//		}
		return "userList";
	}
	
	@RequestMapping(value = "deleteUser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int id)throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException 
	{	
		udao.deleteEmp(id);
		System.out.println("delete user :::"+id);
		return "redirect:showAll";
	}
	
	@RequestMapping(value = "editUser", method = RequestMethod.GET)
	public String editEmployee(@RequestParam("id")int id, Model model) {
		model.addAttribute("result", udao.getById(id));
		return "update";
	}
	@RequestMapping(value="update",method = RequestMethod.POST)
	public String update(Model model,@RequestParam("id")int id,@RequestParam("username")String un,@RequestParam("password")String pwd)
	{
		User u= new User();
		u.setId(id);
		u.setUsername(un);
		u.setPassword(pwd);
		udao.update(u);
		return "redirect:showAll";
		
	}
}
