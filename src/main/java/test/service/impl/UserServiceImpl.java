package test.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import test.entity.User;
import test.model.UserRequest;
import test.repository.UserRepository;
import test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User> findAll(Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 2);
//		List<UserDTO> result = new ArrayList<>();
//		for (User it : users) {
//			UserDTO userDTO = new UserDTO();
//			userDTO.setUsername(it.getUsername());
//			userDTO.setPassword(it.getPassword());
//			userDTO.setImage(it.getImage());
//			result.add(userDTO);
//		}
		return userRepository.findAll(pageable);
	}

	@Override
	public void addOrUpdateUser(UserRequest userRequest) {
		User user = new User();
		user.setUsername(userRequest.getUsername());
		user.setPassword(userRequest.getPassword());
		user.setImage(updateImage(userRequest));
		userRepository.save(user);
		System.out.print("ok");
	}

    private static final Path CURRENT_FOLDER = Paths.get("src/main/resources");
	public String updateImage(UserRequest userRequest) {
		Path staticPath = Paths.get("static");
		Path imagePath = Paths.get("images");
		if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
			try {
				Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(userRequest.getImage().getOriginalFilename());
		try (OutputStream os = Files.newOutputStream(file)) {
			os.write(userRequest.getImage().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userRequest.getImage().getOriginalFilename().toString();
	}

	@Override
	public List<User> getAll(Pageable pageable) {
		return null;
	}

}
