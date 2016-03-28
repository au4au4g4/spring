package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerService;
import model.CustomerVO;

@WebServlet(
		urlPatterns={"/secure/LoginAction.action"}
		)

public class LoginAction extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{

		Map<String,String> error = new HashMap<String,String>();
		req.setAttribute("error", error);
		
//		System.out.println("input");
		String id = req.getParameter("id");
		String pwds = req.getParameter("pwd");
		
//		System.out.println("validate");
		if(id.equals("")){
			error.put("id", "id is empty string");
		}
		if(pwds.equals("")){
			error.put("pwd","pwd is empty string");
		}
		if(error.size()!=0){
			req.getRequestDispatcher("/secure/login.jsp").forward(req,res);
			return;
		}
		
//		System.out.println("cast");
		byte[] pwd = pwds.getBytes();
		
//		System.out.println("mvc");
		CustomerService cs = new CustomerService();
		CustomerVO vo = cs.select(id);
		if(vo!=null){
			if(Arrays.equals(pwd, vo.getPassword())){
				HttpSession session = req.getSession();
				session.setAttribute("customerVO", vo);
				req.getRequestDispatcher("/index.jsp").forward(req,res);
				return;
			}else{
				error.put("pwd", "password is wrong");
			}
		}else{
			error.put("id", "id does not exist");
		}
		req.getRequestDispatcher("/secure/login.jsp").forward(req,res);
		return;
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		doPost(req, res);
	}
}














