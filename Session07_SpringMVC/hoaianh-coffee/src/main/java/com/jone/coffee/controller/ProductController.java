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

//class này sẽ lo xử lí liên quan đến sản phẩm
//CRUD product nhưng ở góc độ xử lí request, response
//phụ trách các URL dính dáng đến CRID Product
//Rồi sẽ tương tác với Service, Repository
//class này lắng nghe các URL và xem URL nào phù hợp với hàm trong class này thì gọi hàm đó - method mapping với URL
//2 việc: nó phải lắng nghe URL, nghe xong gọi đúng hàm ứng với URL
//việc 1: nó phải là 1 bean được new tự động, vào RAM và nghe
//việc 2: nghe - mày là @Controller: Bean và lắng nghe
//việc 3: hàm nào ứng với URL nào, trả về HTML

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
	
	
	//VỚI HÀM POST(BẢN CHẤT VẪN LÀ GET - NHƯNG GỬI KÈM NHIỀU DATA KHI GET)
	//KHI HÀM POST TRẢ VỀ 1 TRANG KẾT QUẢ QUA LỆNH RETURN "TÊN TRANG"
	//THÌ URL POST VẪN GIỮ NGUYÊN, TRONG KHI ĐÓ THÂN TRÌNH DUYỆT CÓ DATA ĐC TRẢ VỀ - TRANG TRẢ VỀ
	//HIỆN TƯỢNG GET Y CHANG: URL GET VẪN GIỮ NGUYÊN, TRONG KHI ĐÓ THÂN TRÌNH DUYỆT CÓ DATA ĐƯỢC TRẢ VỀ - TRANG TRẢ VỀ
	//Ý NGHĨA VIỆC GIỮ NGUYÊN URL: GỌI HÀM THÌ TRẢ VỀ KQ Ở DƯỚI, TÊN HÀM VẪN Ở TRÊN
	
	//F5 VỚI POST THÌ SAO?
	//THÌ VẪN TRẢ VỀ TRANG KẾT QUẢ NHƯ BÌNH THƯỜNG, NHƯNG LẠI GỬI ĐỐNG DATA
	//RESUBMITION FORM, GỌI LẠI URL CỰC KÌ NGUY HIỂM VỚI TÍNH NĂNG CREATE, F5 MÀN HÌNH KẾT QUẢ SẼ TƯƠNG ỨNG VIỆC GỬI LẠI DATA , CHẠY LẠI XỬ LÍ => DUPLICATE DATA
	
	// TÓM LẠI : VỚI POST, TA CẦN ĐỔI URL TRÁNH SUBMIT LẠI KHI F5
	// URL POST , F5 CHẠY LẠI => NGUY HIỂM. URL POST XỬ LÍ XONG, RETURN TRANG VÀ PHẢI ĐỔI URL LUÔN
	//ĐỊNH HƯỚNG LẠI URL , GỌI LẠI 1 URL MỚI NHƯNG VẪN CÙNG KẾT QUẢ TRẢ VỀ TRANG
	
	// ========> XỬ LÍ POST XONG THÌ NHỚ ĐỔI URL KẾT QUẢ TRÁNH F5 LẠI POST
	
	/*
	dùng get để gửi về trang, giữ url cũ, nhưng khi f5 thì dữ liệu đó nó lấy trên thanh url rồi nên ko có hiện tượng resubmit
	còn post cũng là gửi về trang,, giữ url cũ nhưng khi f5 thì có hiện tượng resubmit là vì dữ liệu được giấu, ko có trên thanh url nên nó nó mới có câu hỏi là resubmit
	-> từ đó họ mới quy ước dùng post khi có lấy dữ liệu từ client về server
    còn dùng get là dữ liệu từ server về client
	*/
	
	@GetMapping("/product/create")
	public String createProduct(Model model) {
		model.addAttribute("productResponse", new Product());
		model.addAttribute("categories", getCategories());
		return "product-edit";
	}
	
	@PostMapping("/products-edit")
	public String updateProduct(Model model, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("price") Double price, RedirectAttributes redirectAttributes) {
		//2 lệnh này sẽ vô dụng nếu chơi redirect vì bên redirect dùng model khác
		model.addAttribute("msg", "đã update thành công");
		model.addAttribute("pname", name);
		
		redirectAttributes.addFlashAttribute("formMsg", "đã update thành công");
		redirectAttributes.addFlashAttribute("pname", name)
;		return "redirect:/products";
	}
	
	@GetMapping("/msg")
	public String getResult(){
		// 1 URL, 1 HÀM TƯƠNG ỨNG, 1 THÙNG MODEL MỚI TINH ĐỂ TA BỎ ĐỒ VÀO TRƯỚC KHI RENDER TRANG
		//MỖI HÀM 1 MODEL RIÊNG, 1 THÙNG RIÊNG
		
		//KĨ THUẬT CHUYỂN DATA TỪ MODEL KIA SANG MODEL NÀY Ở CÂU LỆNH REDIRECT. 
		//TẠI SAO LÀM VẬY: REDIRECT LÀ  GỌI URL MỚI, URL MỚI LÀ CHƠI THÙNG MỚI
		//TRƯỚC KHI REDIRECT, GỬI KÉ THÊM DATA TỪ MODEL CŨ SANG MODEL MỚI
		// TỪ ,ODEL CỦA THẰNG POST KÉ SANG MODEL THẰNG GET
		
		//MODEL Ở ĐÂY, NGOÀI DATA CỦA NÓ ỬO HÀM NÀY CÒN NHÂN THÊM TỪ BÊN POST GỬI SANG
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
		model.addAttribute("productResponse", productResponse);
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

//KHI CONTROLLER TÌM THẤY HÀM XỬ LÍ URL TƯƠNG ỨNG, NÓ SẼ GỌI HÀM NÀY NHƯNG TRƯỚC KHI GỌI, NÓ GỬI CHO 1 HÀM THÙNG CHỨA ĐỒ RỖNG GỌI LÀ MODEL
//MÌNH NHÉT DATA VÀO THÙNG CHỨA ĐỒ NÀY, THÙNG ĐỒ MODEL ĐC NEW TỰ ĐỘNG VÀ CHÍCH VÀO HÀM XỬ LÍ URL
//KHI THỰC THI LỆNH RETURN CHO URL GET...THÌ SPRING NÓ SẼ ĐÍNH KÈM CÁI THÙNG ĐỒ VÀO CÙNG TRANG TRẢ VỀ, VÀ ĐƯA TÊN TRANG + THÙNG ĐỒ CHO THYMELEAF MIX, TRỘN, RENDER

// THYMELEAF SẼ LẤY ĐỒ TRONG THÙNG, TRỘN VỚI CÁC TAG HTML, TRỘN XONG, TRẢ CHO TOMCAT TRANG WEB HTML -> ĐẨY VỀ TRÌNH DUYỆT USER

// CONTROLLER LÀ NHÉT ĐỒ VÀO THÙNG
//HTML/THYMELEAF LÀ LẤY RA THÙNG VÀ MIX
//TƯỞNG TƯỢNG TỦ GỬI ĐỒ, QUẦY GỬI TÚI/GIỎ Ở SIÊU THỊ VÀ TTTM
//BỎ ĐỒ VÀO HỘC TỦ, LẤY CHÌA KHÓA, MẢNH GIẤY

//CHÌA KHÓA, MẢNH GIÁY GỌI LÀ KEY | MÓN ĐỒ GỌI LÀ VALUE
//CÓ CHÌA KHÓA, MẢNH GIÁY THÌ LẤY ĐC VALUE/MÓN ĐỒ

//GỬI ĐỒ VÀO THÙNG (TRONG CONTROLLER)
// model.addAttribute(key, value);

//bên trong view, lấy đồ dùng key - ${tên key} -> trả về object món đồ
