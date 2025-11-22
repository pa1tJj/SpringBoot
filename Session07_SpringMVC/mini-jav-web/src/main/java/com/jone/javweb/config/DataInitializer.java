package com.jone.javweb.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jone.javweb.model.entity.Actor;
import com.jone.javweb.model.entity.Auth;
import com.jone.javweb.model.entity.Genre;
import com.jone.javweb.model.entity.Movie;
import com.jone.javweb.service.ActorService;
import com.jone.javweb.service.AuthService;
import com.jone.javweb.service.GenreService;
import com.jone.javweb.service.MovieService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner{
	
	private final MovieService movieService;
	private final GenreService genreService;
	private final ActorService actorService;
	private final AuthService authService;
	
	@Override
	public void run(String... args) throws Exception {
		 Genre g1 = new Genre("BDSM");
		 Genre g2 = new Genre("Masturbation");
		 Genre g3 = new Genre("Public");
		 Genre g4 = new Genre("Blow job");
		 Genre g5 = new Genre("Solo");
		 Genre g6 = new Genre("Uncovered");
		 Genre g7 = new Genre("Hentai");
		 
		 genreService.save(g1);
		 genreService.save(g2);
		 genreService.save(g3);
		 genreService.save(g4);
		 genreService.save(g5);
		 genreService.save(g6);
		 genreService.save(g7);
		 
		 Actor a1 = new Actor("Sakura", 20L, "88-60-89");
		 Actor a2 = new Actor("Hana", 22L, "90-63-91");
		 Actor a3 = new Actor("Airi", 19L, "86-58-87");
		 Actor a4 = new Actor("Natsuki", 21L, "95-72-92");
		 Actor a5 = new Actor("Rin", 23L, "89-61-90");
		 Actor a6 = new Actor("Yuna", 20L, "91-64-92");
		 Actor a7 = new Actor("Haruka", 24L, "87-59-88");
		 Actor a8 = new Actor("Mio", 19L, "84-56-85");
		 Actor a9 = new Actor("Ayaka", 22L, "92-66-93");
		 Actor a10 = new Actor("Rei", 25L, "90-60-89");
		 Actor a11 = new Actor("Megumi", 21L, "88-62-90");
		 Actor a12 = new Actor("Riko", 20L, "85-57-86");
		 Actor a13 = new Actor("Sayaka", 23L, "89-60-91");
		 Actor a14 = new Actor("Hikari", 19L, "86-58-88");
		 
		 actorService.save(a1);
		 actorService.save(a2);
		 actorService.save(a3);
		 actorService.save(a4);
		 actorService.save(a5);
		 actorService.save(a6);
		 actorService.save(a7);
		 actorService.save(a8);
		 actorService.save(a9);
		 actorService.save(a10);
		 actorService.save(a11);
		 actorService.save(a12);
		 actorService.save(a13);
		 actorService.save(a14);
		 		 
		 List<Actor> l1 = new ArrayList<Actor>();
		 l1.add(a1);
		 l1.add(a2);
		 l1.add(a3);
		 
		 List<Actor> l2 = new ArrayList<Actor>();
		 l2.add(a4);
		 l2.add(a5);
		 l2.add(a6);
		 
		 List<Actor> l3 = new ArrayList<Actor>();
		 l3.add(a7);
		 l3.add(a8);
		 l3.add(a9);
		 
		 List<Actor> l4 = new ArrayList<Actor>();
		 l4.add(a10);
		 l4.add(a11);
		 l4.add(a12);
		 
		 List<Actor> l5 = new ArrayList<Actor>();
		 l5.add(a13);
		 l5.add(a14);
		 l5.add(a12);
		 
		 Movie m1 = new Movie("Qúy cô quyến rũ", "2h15", "anh1.jpg", 1L, "Tôi bị tai nạn giao thông trên đường đi học về, vết thương không nặng, nhưng để lại di chứng."
		 		+ " Và di chứng đó chính là... không thể ngừng cương cứng! Xấu hổ không dám ra đường, cũng không dám đến trường. Cô bạn thân từ thuở nhỏ - Mei,"
		 		+ " vì lo lắng nên đã đến thăm tôi. Biết tình trạng của tôi, Mei liền muốn giúp tôi chữa bệnh. Từ dùng tay, đến miệng, rồi đến lồn của cô ấy! "
		 		+ "Sau biết bao nhiêu cố gắng, cuối cùng con cặc của tôi cũng đã được cái lồn của Mei làm mềm đi một chút...", g1, l1);
		 Movie m2 = new Movie("Cô bạn thân quyến rũ", "2h15", "anh2.jpg", 1L, "Karen đã sống chung với anh trai cùng cha khác mẹ được mười năm. Karen là một cô em gái xinh đẹp, "
		 		+ "tốt bụng, dịu dàng, giỏi mọi việc, nhất là luôn đối tốt với anh trai. Nhưng khi tên anh trai này nghe thấy cô đã có bạn trai, hắn ta liền lộ bộ mặt thật,"
		 		+ " hắn muốn chiếm hữu cô, muốn cô chỉ thuộc về một mình hắn. Vì vậy, hắn đã đánh thuốc mê Karen khi cô đang ngủ, rồi coi cô như một món đồ chơi tình dục để "
		 		+ "giải phóng toàn bộ thú tính của mình...", g2, l2);
		 Movie m3 = new Movie("Qúy cô hở hang", "1h15", "anh3.jpg", 1L, "Hôm nay là ngày hạnh phúc nhất của Sayuri, là ngày mà cô và Hideyuki, người mình yêu sẽ về chung một "
		 		+ "nhà. Vì muốn cho Sayuri một tuần trăng mật thật đáng nhớ, Hideyuki đã sắp xếp cho cả hai nghỉ ngơi tại một khu nghỉ dưỡng cao cấp. Căn phòng sang trọng, "
		 		+ "dịch vụ tuyệt vời kèm theo cả massage làm đẹp khiến Sayuri vô cùng hạnh phúc. Nhưng khi sử dụng dịch vụ massage này, cô phải thay một bộ đồ gần như xuyên "
		 		+ "thấu. Không những vậy, khi được thoa tinh dầu đặc biệt lên người, cô dường như mất sạch sức lực, không thể cử động. Và đó là lúc tên massage lộ ra bộ mặt "
		 		+ "thật của hắn. Trong lúc Sayuri không cử động được, hắn đã kích thích những nơi nhạy cảm của cô, sau đó đụ cô và bắn tinh vào tử cung của cô! Dù biết chuyện "
		 		+ "này là vô cùng sai trái, nhưng không hiểu tại sao, Sayuri lại có cảm giác sung sướng khó tả. Cô dần bị nghiện cái cảm giác này, cô muốn được tên massage này"
		 		+ " đụ nhiều hơn, muốn được quay trở lại khách sạn này sau khi trở về...", g3, l3);
		 Movie m4 = new Movie("Cô bạn gái dâm đãng của tôi", "2h15", "anh4.jpg", 1L, "Vì sáng ngày mai là ngày sẽ diễn ra lễ cưới thế nên Shiori Yamate muốn chuẩn bị thật tốt mọi thứ, "
		 		+ "đêm đó cô nàng đến tìm anh thợ chụp ảnh để trang điểm thật xinh và chụp những bức ảnh lộng lẫy. Ai ngờ vì nhìn thấy Shiori quá ngon múp nên gã thợ ảnh biến"
		 		+ " thái nảy sinh ý đồ hiếp dâm cô gái trẻ xinh đẹp, của ngon phải biết chia sẻ thế nên tên thợ ảnh đã gọi thêm cả bạn hắn đến, cả hai thay nhau hưởng thụ cặp"
		 		+ " vú tròn và cái bím hồng múp míp. Chỉ tội nghiệp cho cô dâu trẻ Shiori, cô đang mặc váy cưới vô cùng xinh đẹp nhưng đêm đó người đụ cô không phải là chồng "
		 		+ "mình mà lại là hai tên dâm tặc, biến thái.", g4, l4);
		 Movie m5 = new Movie("Cô hàng xóm may mắn", "3h15", "anh5.jpg", 1L, "Vì sáng ngày mai là ngày sẽ diễn ra lễ cưới thế nên Shiori Yamate muốn chuẩn bị thật tốt mọi thứ, "
		 		+ "đêm đó cô nàng đến tìm anh thợ chụp ảnh để trang điểm thật xinh và chụp những bức ảnh lộng lẫy. Ai ngờ vì nhìn thấy Shiori quá ngon múp nên gã thợ ảnh"
		 		+ " biến thái nảy sinh ý đồ hiếp dâm cô gái trẻ xinh đẹp, của ngon phải biết chia sẻ thế nên tên thợ ảnh đã gọi thêm cả bạn hắn đến, cả hai thay nhau hưởng"
		 		+ " thụ cặp vú tròn và cái bím hồng múp míp. Chỉ tội nghiệp cho cô dâu trẻ Shiori, cô đang mặc váy cưới vô cùng xinh đẹp nhưng đêm đó người đụ cô không phải"
		 		+ " là chồng mình mà lại là hai tên dâm tặc, biến thái.", g5, l5);
		 Movie m6 = new Movie("Người chị cùng công ty", "2h15", "anh6.jpg", 1L, "Anh chồng tranh thủ tan ca về sớm cùng cô giúp việc lén lút vụng trộm, hôm nay tan công ty sớm hơn mọi khi nên cô vợ vẫn chưa về nhà.\r\n"
		 		+ "Thường thì cô vợ về trước nên anh chồng ít có dịp địt nhau cùng với cô giúp việc. Bởi cả 2 đã lén lút ngoại tình cùng nhau, nay được công ty cho phép về "
		 		+ "sớm, anh chồng nhân cơ hội này cùng cô giúp việc địt nhau.", g6, l2);
		 Movie m7 = new Movie("Cô em gái nuôi xinh xắn", "1h55", "anh7.jpg", 1L, "Vừa mở cửa thì Ichijo bất ngờ khi trước mặt cô chính là người yêu cũ- người đã từng có bao kỉ niệm "
		 		+ "đẹp đẽ gắn bó với cô trong khoảng thời gian dài nhưng cũng tràn đầy thất vọng, buồn tủi. Sau cuộc chia tay không một lí do thì cuối cùng anh ta cũng đã "
		 		+ "xuất hiện, chưa kịp nói câu gì thì cả hai đã vội vàng cuốn quít lấy nhau và tình cảm giữa hai người dần ùa về, họ nhớ những ngày còn mây mưa, sớm tối có "
		 		+ "nhau, cùng nhau thực hiện những buồn vui của cuộc đời. Giờ đây, một lần nữa cả hai lại có thể tiếp tục thực hiện những cuộc tình riêng của họ, có lẽ đây"
		 		+ " cũng là phần thưởng xứng đáng cho một câu chuyện tình cảm động sau quãng thời gian chia li dài.", g1, l3);
		 Movie m8 = new Movie("Nữ gia sư xinh đẹp", "2h35", "anh8.jpg", 1L, "Trước đi đến nhà nam đồng nghiệp để hợp tác làm sự án sắp tới cho công ty thì nữ nhân viên Saegimi"
		 		+ " có ghé qua một tiệm massage. Đen đủi thay gặp đúng tên nhân viên dâm dục nên hắn chỉ lợi dụng công việc nhằm được sờ mó mọi bộ phận nhạy cảm trên thể cô,"
		 		+ " bao gồm cả vùng kín. Hắn liên tục lấy tay khẽ chà vào cặp vú và cái bím hồng hào khiến cô nứng lên trong sự sung sướng. Đây chính là sự việc bắt nguồn cho"
		 		+ " cuộc tình giữa cặp đôi nhân viên trong công ty. Sau khi massage xong, cô đã đi đến nhà nam đồng nghiệp để cùng nhau làm việc thế nhưng khi vừa bước vào "
		 		+ "cửa thì cơn nứng sau dư chấn vừa rồi bắt đầu ào ra bằng những giọt nước liên tục tuôn xuống từ vùng kín của cô. Thấy vậy nam đồng nghiệp lập tức hiểu ý, "
		 		+ "vội vã lột đồ rồi bế cô lên giường để giúp cô giả tỏa cơn khát dục đó. Thật là một người bạn tốt bụng.", g1, l4);
		 Movie m9 = new Movie("Cô bán hàng quyến rũ", "2h15", "anh9.jpg", 1L, "Một bộ phim đưa bạn vào góc nhìn của nam chính! Karen sẽ thì thầm vào tai bạn những lời nói quyến "
		 		+ "rũ, dùng cơ thể để khiến con cặc của bạn cương lên và cuối cùng là ngoại tình khi bạn gái còn đang ở bên cạnh! Khi Karen đến nhà bạn uống rượu, khi bạn "
		 		+ "tới tiệm massage thẩm mỹ của Karen, khi Karen \"thưởng\" cho bạn vì giúp em ấy dọn nhà, và khi cả hai làm thêm giờ. Cảm giác lén lút, lo sợ sẽ khiến bạn "
		 		+ "có một trải nghiệm vô cùng kích thích! Tận hưởng tối đa sự quyến rũ của Karen với tai nghe!", g2, l4);
		 Movie m10 = new Movie("Chị hàng xóm quyến rũ", "2h15", "anh10.jpg", 1L, "Trong một lần đến nhà bạn gái làm bài báo cáo, Nahoto đã ngạc nhiên khi thấy chị gái của "
		 		+ "cô ấy- Onee-chan xuất hiện với bộ đồ ngủ mà không hề mặc nội y để lộ hai núm vú trông rất kích thích khiến cậu bị mê hoặc ngay từ giây phút đó."
		 		+ " Tối hôm đó sau khi được mời ở lại dùng cơm, trong lúc đi lấy nước cho bạn gái cậu lại bắt gặp chị ta một lần nữa với bộ đồ khêu gợi không kém lúc ban đầu."
		 		+ " Lần này không thể kiềm chế bản thân nên cậu đã lén đưa mắt nhìn trộm một phần ngực bị lộ ra nhưng không may bị chị ta phát hiện. Sự dâm dục bắt đầu trỗi "
		 		+ "dậy, chị ta liên tục dùng những từ ngữ thậm chí là hành động nhạy cảm như chạm vào dương vật khiến cu cậu không biết làm gì hơn ngoài đứng yên tận hưởng"
		 		+ " mà quên mất cả việc lấy nước trước đó. Kể từ đây, cu cậu bắt đầu học được nhiều thứ hơn trong chuyện người lớn bằng những cuộc tình vụng trộm với chị ta "
		 		+ "sau lưng cô bạn gái đáng thương kia.", g3, l5);
		 
		 Movie m11 = new Movie("Người con giá tôi yêu", "2h15", "anh11.jpg", 1L, "Tôi và Amiri là bạn thân của nhau, mặc dù hay bị cô ấy trêu chọc nhưng tôi biết Amiri luôn quan tâm"
		 		+ " đến tôi. Suốt quãng thời gian học đại học, tôi không có một người bạn nào cả, cũng không có bạn cùng phòng, luôn cô đơn một mình, thấy vậy Amiri luôn đến "
		 		+ "chơi với tôi. Amiri cũng có rất nhiều bạn trai, cô ấy không hề nghiêm túc với mối quan hệ của mình, chơi xong rồi đá, đó là phong cách của cô ấy. Trong một "
		 		+ "lần bị Amiri ép uống rượu, vì tửu lượng kém nên tôi ngủ gục từ lúc nào không hay. Khi thức dậy, thấy bản thân mình đang khỏa thân, còn Amiri thì đang nằm "
		 		+ "cạnh với chỉ một bộ đồ lót! Thì ra đêm qua, lúc bị say rượu, tôi đã đè Amiri ra \"hấp diêm\"! Tôi vội vàng cầu xin cô ấy tha thứ, nhưng có vẻ Amiri không hề "
		 		+ "giận. Trái lại, Amiri còn vui vẻ muốn thấy con cặc của tôi, muốn tôi đụ cô ấy thêm lần nữa! Và từ đó, chúng tôi liên tục quấn lấy nhau không rời, tôi đã "
		 		+ "xuất tinh vào lồn của cô ấy không biết bao nhiêu lần. Và sau đó, bằng tất cả dũng khí của mình, tôi quyết định tỏ tình với Amiri. Cô ấy đồng ý, và thế là"
		 		+ " tôi đã có được người con gái trong mơ của mình...", g4, l1);
		 Movie m12 = new Movie("Bà chị họ dâm đãng", "2h15", "anh12.jpg", 1L, "Tôi bị tai nạn giao thông trên đường đi học về, vết thương không nặng, nhưng để lại di chứng."
			 		+ " Và di chứng đó chính là... không thể ngừng cương cứng! Xấu hổ không dám ra đường, cũng không dám đến trường. Cô bạn thân từ thuở nhỏ - Mei,"
			 		+ " vì lo lắng nên đã đến thăm tôi. Biết tình trạng của tôi, Mei liền muốn giúp tôi chữa bệnh. Từ dùng tay, đến miệng, rồi đến lồn của cô ấy! "
			 		+ "Sau biết bao nhiêu cố gắng, cuối cùng con cặc của tôi cũng đã được cái lồn của Mei làm mềm đi một chút...", g5, l2);
		 Movie m13 = new Movie("Người tình trong mộng", "2h15", "anh13.jpg", 1L, "Tôi bị tai nạn giao thông trên đường đi học về, vết thương không nặng, nhưng để lại di chứng."
			 		+ " Và di chứng đó chính là... không thể ngừng cương cứng! Xấu hổ không dám ra đường, cũng không dám đến trường. Cô bạn thân từ thuở nhỏ - Mei,"
			 		+ " vì lo lắng nên đã đến thăm tôi. Biết tình trạng của tôi, Mei liền muốn giúp tôi chữa bệnh. Từ dùng tay, đến miệng, rồi đến lồn của cô ấy! "
			 		+ "Sau biết bao nhiêu cố gắng, cuối cùng con cặc của tôi cũng đã được cái lồn của Mei làm mềm đi một chút...", g6, l3);
		 Movie m14 = new Movie("Cô thư ký dâm đãng của tôi", "2h15", "anh14.jpg", 1L, "Tôi bị tai nạn giao thông trên đường đi học về, vết thương không nặng, nhưng để lại di chứng."
			 		+ " Và di chứng đó chính là... không thể ngừng cương cứng! Xấu hổ không dám ra đường, cũng không dám đến trường. Cô bạn thân từ thuở nhỏ - Mei,"
			 		+ " vì lo lắng nên đã đến thăm tôi. Biết tình trạng của tôi, Mei liền muốn giúp tôi chữa bệnh. Từ dùng tay, đến miệng, rồi đến lồn của cô ấy! "
			 		+ "Sau biết bao nhiêu cố gắng, cuối cùng con cặc của tôi cũng đã được cái lồn của Mei làm mềm đi một chút...", g5, l1);
		 
		 movieService.save(m1);
		 movieService.save(m2);
		 movieService.save(m3);
		 movieService.save(m4);
		 movieService.save(m5);
		 movieService.save(m6);
		 movieService.save(m7);
		 movieService.save(m8);
		 movieService.save(m9);
		 movieService.save(m10);
		 movieService.save(m11);
		 movieService.save(m12);
		 movieService.save(m13);
		 movieService.save(m14);
		 
		 List<Movie> mo1 = new ArrayList<Movie>();
		 mo1.add(m1);
		 mo1.add(m2);
		 mo1.add(m3);
		 
		 List<Movie> mo2 = new ArrayList<Movie>();
		 mo2.add(m4);
		 mo2.add(m5);
		 mo2.add(m6);
		 
		 List<Movie> mo3 = new ArrayList<Movie>();
		 mo3.add(m7);
		 mo3.add(m8);
		 mo3.add(m9);
		 
		 
		 List<Movie> mo4 = new ArrayList<Movie>();
		 mo4.add(m10);
		 mo4.add(m12);
		 mo4.add(m13);
		 
		 List<Movie> mo5 = new ArrayList<Movie>();
		 mo5.add(m10);
		 mo5.add(m1);
		 mo5.add(m3);
		 
		 Auth au1 = new Auth("0999999999", "Phan Anh Tuấn", "1234", "admin");
		 Auth au2 = new Auth("0888888888", "Đinh Mạnh Ninh", "1234", "user");
		 Auth au3 = new Auth("0111111111", "Mai Anh", "1234", "admin");
		 Auth au4 = new Auth("0444444444", "Phan Hoài Anh", "1234", "manager");
		 authService.save(au1);
		 authService.save(au2);
		 authService.save(au3);
		 authService.save(au4);
	}

}
