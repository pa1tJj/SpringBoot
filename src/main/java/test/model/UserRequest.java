package test.model;

import org.springframework.web.multipart.MultipartFile;

public class UserRequest {

	private Long id;
	private String username;
	private String password;
	private MultipartFile image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPasssword(String password) {
		this.password = password;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
