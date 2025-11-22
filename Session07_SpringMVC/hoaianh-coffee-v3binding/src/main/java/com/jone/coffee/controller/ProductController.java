package com.jone.coffee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jone.coffee.entity.Category;
import com.jone.coffee.entity.Product;


@Controller
public class ProductController {
	
	public List<Category> getCategories() {
		List<Category> categories = List.of(
				new Category(100L, "bia rượu", "..."),
				new Category(200L, "trà sữa", "..."),
				new Category(300L, "cà phê", "..."),
				new Category(400L, "nước lọc", "...")
				);
		return categories;
	}

	@GetMapping("/product/create")
	public String createProduct(Model model) {
		model.addAttribute("productRes", new Product());
		model.addAttribute("categories", getCategories());
		return "product-edit";
	}
	
	@PostMapping("/products-edit")
	public String updateProduct(Model model, @ModelAttribute("productRes") Product product, RedirectAttributes redirectAttributes) {		
		redirectAttributes.addFlashAttribute("formMsg", "đã update thành công");
		redirectAttributes.addFlashAttribute("pname", product.getName());
;		return "redirect:/products";
	}
	
	@GetMapping("/msg")
	public String getResult(){
		return "result";
	}
	
	@GetMapping(path = {"products/edit/{id}"})
	public String productEdit(@PathVariable String id, Model model) {
		List<Product> products = new ArrayList<Product>();
		Product product1 = new Product("sp01", "cà phê trung nguyên", 204032);
		Product product2 = new Product("sp02", "cà phê vina", 55000);
		Product product3 = new Product("sp03", "cà phê phố", 60000);
		products.add(product1);
		products.add(product2);
		products.add(product3);
		Product productResponse = new Product();
		for(Product item : products) {
			if(item.getId().equalsIgnoreCase(id)) {
				productResponse.setId(item.getId());
				productResponse.setName(item.getName());
				productResponse.setPrice(item.getPrice());
			}
		}
		model.addAttribute("categories", getCategories());
		model.addAttribute("productRes", productResponse);
		return "product-edit";
	}

	@RequestMapping(path =  {"prod", "/products"}, method = RequestMethod.GET)
	public String getProducts(Model model) {
		model.addAttribute("msg", "xin chào, forget my  gun");
		List<Product> products = new ArrayList<Product>();
		Product product1 = new Product("sp01", "cà phê trung nguyên", 204032);
		Product product2 = new Product("sp02", "cà phê vina", 55000);
		Product product3 = new Product("sp03", "cà phê phố", 60000);
		products.add(product1);
		products.add(product2);
		products.add(product3);
		model.addAttribute("products", products);
		return "products";//return tên trang - view, ko cần .html - tự thymeleaf dependency nó lo gắn tên
	}
 }
