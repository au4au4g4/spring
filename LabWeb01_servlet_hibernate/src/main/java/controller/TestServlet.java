package controller;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.dao.ProductDAO;


@WebServlet(
		urlPatterns={"/test.action"}
)

public class TestServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO;
	
	public void init() {
		ServletContext applicaiton = this.getServletContext();
		ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(applicaiton);
		productDAO=(ProductDAO) applicationContext.getBean("productDAO");
		System.out.println(productDAO.select());
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
//		res.setContentType("text/plain;charset=UTF-8");
//		PrintWriter pw = res.getWriter();
//		
//		CustomerDAO cdao = new CustomerDAO();
//		CustomerVO cvo = new CustomerVO();		
//		cvo=cdao.select("alex");
//		cvo.setEmail("au4au4g");
//		cdao.update(cvo);
//		
//		ProductDAO pdao = new ProductDAO();
//		ProductVO pvo = new ProductVO();
//		for(ProductVO vo : pdao.select()){
//			pw.write(vo.toString()+"\n");
//		}
//		pvo.setId(11);
//		pvo.setName("ccc");
//		pdao.delete(11);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		doGet(req, res);
	}

}
















