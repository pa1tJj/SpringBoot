package com.example.demo.creational.factorymethod;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Factory Method phù hợp để xây dựng mà sau này muốn tạo thêm các chức năng mới thì không ảnh hưởng tới code hiện tại 
interface PaymentMethod {

	//tạo một phương thức thanh toán chung nhất
	public void paymentMethod();
}
//tạo lớp thanh toán theo COD
class CODPayment implements PaymentMethod{

	//triển khai phương thức thanh toán COD
	@Override
	public void paymentMethod() {
		System.out.print("thanh toán khi nhận hàng");
	}	
}

//tạo lớp thanh toán Online
class OnlinePayment implements PaymentMethod{

	//triển khai phương thức thanh toán Online
	@Override
	public void paymentMethod() {
		System.out.print("thanh toán online");
	}	
}


//tạo lớp này để thực hiện các thao tác để thanh toán
abstract class Creator{
	public abstract PaymentMethod createPayment();// phương thức tạo đối tương thanh toán cụ thể 
	public void constrPayment() {
		PaymentMethod payment = createPayment();
		payment.paymentMethod();
	}
}

class CreateCOD extends Creator{

	//tạo ra đối tượng thanh toán COD
	@Override
	public PaymentMethod createPayment() {
		return new CODPayment();
	}	
}

class CreateOnline extends Creator{

	//tạo ra đối tương thanh toán Online
	@Override
	public PaymentMethod createPayment() {
		return new OnlinePayment();
	}
}
//giả sử khi thêm một phương thức thanh toán mới là thanh toán với ví điện tử ta chỉ cần tạo một class mới CreateEWallet
//toàn bộ phần code thêm cách thức thanh toán này tạo mới mà không ảnh hưởng tới code cũ
class EWalletPayment implements PaymentMethod {

	@Override
	public void paymentMethod() {
		System.out.print("thanh toán theo ví điện tử");		
	}
	
}

class CreateEWallet extends Creator {

	@Override
	public PaymentMethod createPayment() {
		return new EWalletPayment();
	}
	
}
//===> cho thấy Factory Method hữu ích cho việc mở rộng tính năng

@SpringBootApplication
public class Payment {
	public static void main(String[] args) {
		SpringApplication.run(Payment.class, args);
		Scanner sc = new Scanner(System.in);
		Creator creator = null;
		System.out.println("chon phuong thuc thanh toan:");
		int chonPhuongThucThanhToan = sc.nextInt();
		switch (chonPhuongThucThanhToan) {
		case 1 -> {
			creator = new CreateCOD();
			PaymentMethod paymentMethod = creator.createPayment();
			paymentMethod.paymentMethod();
		}
		case 2 -> {
			creator = new CreateOnline();
			PaymentMethod paymentMethod = creator.createPayment();
			paymentMethod.paymentMethod();
		}
		case 3 -> {
			creator = new CreateEWallet();
			PaymentMethod paymentMethod = creator.createPayment();
			paymentMethod.paymentMethod();
		}
		default -> System.out.print("chon phuong thuc thanh toan khac");
		}
	}
}

//Như vậy, Factory Pattern là một pattern hữu ích giúp tăng tính linh hoạt và khả năng mở rộng cho hệ thống bằng cách tách biệt quá trình khởi tạo đối tượng.
//Pattern này được sử dụng rộng rãi trong thiết kế phần mềm.
