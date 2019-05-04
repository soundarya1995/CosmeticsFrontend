package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.DAO.CategoryDAO;
import com.ecom.DAO.ProductDAO;
import com.ecom.DAO.SupplierDAO;
import com.ecom.Model.Category;
import com.ecom.Model.Product;
import com.ecom.Model.Supplier;

@Controller
public class ProductController 
{
	
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping(value="/Product")
	public String displayProduct(Model m) {
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);

		for (Product product : listProducts) {
			System.out.println(product.getProductName() + ",");
		}
		return "Product";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@RequestParam("productName") String productName, @RequestParam("productDesc") String productDesc,
			@RequestParam("productPrice") int productPrice,@RequestParam("productStock") int productStock,
			@RequestParam("categoryId") int categoryid,@RequestParam("supplierId") int supplierid,Model m)
	{
		Product product=new Product();
		product.setProductName(productName);
		product.setProductDesc(productDesc);
		product.setPrice(productPrice);
		product.setStock(productStock);
		product.setCategoryId(categoryid);
		product.setSupplierId(supplierid);
	    productDAO.addProduct(product);
	    
	   

	    List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);

		return "Product";
	}

	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		productDAO.deleteProduct(product);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		return "Product";
	}

	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		m.addAttribute("product",product);
		
		return "UpdateProduct";
	}

	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public String updateProduct(@RequestParam("productId") int productid,@RequestParam("productName") String productname,
			@RequestParam("productDesc") String productdesc,@RequestParam("price") int productPrice,@RequestParam("stock") int productStock,
			@RequestParam("categoryId") int categoryid,@RequestParam("supplierId") int supplierid,Model m)
	{
		Product product=productDAO.getProduct(productid);
		product.setProductName(productname);
		product.setProductDesc(productdesc);
		product.setPrice(productPrice);
		product.setStock(productStock);
		product.setCategoryId(categoryid);
		product.setSupplierId(supplierid);
		
		productDAO.updateProduct(product);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		
		return "Product";
	}
}
