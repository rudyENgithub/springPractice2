package com.spring_cookbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_cookbook.dao.UserDAO;
import com.spring_cookbook.domain.Users;
import java.util.LinkedList;
import java.util.List;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@RequestMapping("user_list")
	public void userList() {
		System.out.println("UserController.userList()");
                Users usuario1 =  new Users();
                usuario1.setFirstName("Rudy Sorto");
                usuario1.setAge(27);
		userDAO.add(usuario1);
	}
        
        @RequestMapping("buscarPorId")
	public void buscarPorId() {
		Users user = userDAO.findById(11L);
		System.out.println(user.getFirstName());
		System.out.println(user.getAge());
	}
        
        
        @RequestMapping("buscarTodos")
	public void buscarTodos() {
		List<Users> userList = userDAO.findAll();
		for (Users user : userList) {
			System.out.println(user.getFirstName());
			System.out.println(user.getAge());			
		}
	}
        
        @RequestMapping("buscarTodosDepen")
	public void buscarTodosDepen() {
		List<Users> userList = userDAO.findAllDepen();
		for (Users user : userList) {
			System.out.println(user.getFirstName());
			System.out.println(user.getAge());
                       
		}
	}
        
        @RequestMapping("updateUser")
	public void updateUser() {
		
                Users usuario1 =  new Users();
                usuario1.setFirstName("Rudyto Sorto Ayala");
                usuario1.setAge(28);
                 usuario1.setId(11L);
		userDAO.update(usuario1);
	}
        
         @RequestMapping("deleteUser")
	public void deleteUser() {
		
                Users usuario1 =  new Users();
                 usuario1.setId(18L);
		userDAO.delete(usuario1);
	}
        
        @RequestMapping("countMinosUsers")
	public void countMinosUsers() {
		System.out.println(userDAO.countMinorUsers());
	}
        
        
        @RequestMapping("addVariosObjetos")
	public void addVariosObjetos() {
		List<Users> userList = new LinkedList<Users>();

		Users user1 = new Users();
		user1.setFirstName("Merlin");
                user1.setAge(12);
		userList.add(user1);

		Users user2 = new Users();
		user2.setFirstName("Arthur");
                 user2.setAge(66);
		userList.add(user2);

		userDAO.add(userList);
	}
         
        

}
