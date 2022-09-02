package kr.co.greenart.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repo;

	public List<User> list() {
		logger.info("-- ���� ��� �ҷ����� --");
		return repo.list();
	}

	public int add(User user) {
		logger.info("-- ���� �߰��ϱ� --");
		return repo.add(user);
	}
}
