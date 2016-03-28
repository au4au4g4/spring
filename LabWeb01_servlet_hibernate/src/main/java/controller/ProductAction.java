package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductService;
import model.ProductVO;

@WebServlet(urlPatterns = { "/pages/productaction.action" })

public class ProductAction extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Map<String,String> error = new HashMap<String,String>();
		req.setAttribute("error", error);
		
//		System.out.println("input");
		String ids = req.getParameter("id");
		String name = req.getParameter("name");
		String prices = req.getParameter("price");
		String makes = req.getParameter("make");
		String expires = req.getParameter("expire");
		String button = req.getParameter("button");
		
//		System.out.println("validate & cast");
		Integer id=null;
		Integer price=null;
		java.util.Date make=null;
		Integer expire=null;
		if(ids.equals("")){
			error.put("id", "id is empty");
		}else{
			try{
				id=Integer.parseInt(ids);	
			}catch(NumberFormatException e){
				error.put("id", "id should be number");
			}
		}
		if(name.equals("")){
			error.put("name", "name is empty");
		}
		try{
			price=Integer.parseInt(prices);	
		}catch(NumberFormatException e){
			error.put("price", "price should be number");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			make = sdf.parse(makes);
		} catch (ParseException e1) {
			error.put("make","format of make should be yyyy-MM-dd");
		}
		try{
			expire=Integer.parseInt(expires);	
		}catch(NumberFormatException e){
			error.put("expire", "expire should be number");
		}
		
		ProductVO vo = new ProductVO();
		vo.setExpire(expire);
		vo.setId(id);
		vo.setMake(make);
		vo.setName(name);
		vo.setPrice(price);
		
//		System.out.println("mvc");
		ProductService ps = new ProductService();
		if(button.equals("Insert")){
			if(error.size()==0){
				if(ps.select(vo.getId())==null){
					ps.insert(vo);	
					req.setAttribute("success", "insert success");
				}else{
					error.put("id", "id is exist");
				}
			}
		}else if(button.equals("Update")){
			if(error.size()==0){
				if(ps.select(vo.getId())==null){
					error.put("id", "id is not exist");
				}else{
					ps.update(vo);
					req.setAttribute("success", "update success");
				}
			}
		}else if(button.equals("Delete")){
			if(error.get("id") == null){
				error.clear();
				if(ps.select(vo.getId())==null){
					error.put("id", "id is not exist");
				}else{
					ps.delete(id);
					req.setAttribute("success", "delete success");
				}
			}else{
				System.out.println(2);
				String iderror = error.get("id");
				error.clear();
				error.put("id", iderror);
			}
		}else if(button.equals("Select")){
			List<ProductVO> result = null;
			if(ids.equals("")){
				result= ps.select();
				req.setAttribute("result", result);
				req.getRequestDispatcher("/pages/display.jsp").forward(req, res);;
				return;
			}else if(error.get("id")==null){
				if(ps.select(vo.getId())==null){
					error.clear();
					error.put("id", "id is not exist");
				}else{
					result=new ArrayList<ProductVO>();
					result.add(ps.select(id));
					req.setAttribute("result", result);
					req.getRequestDispatcher("/pages/display.jsp").forward(req, res);;
					return;
				}
			}
		}
		req.getRequestDispatcher("/pages/product.jsp").forward(req, res);
		return;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
