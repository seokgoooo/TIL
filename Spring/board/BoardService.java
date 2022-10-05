package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {
	@Autowired
	private BoardMapper dao;

	@Transactional(readOnly = true)
	public BoardDTO getAll() {
		return new BoardDTO(dao.getAll(), dao.getCount());
	}

	public int write(Article a) {
		return dao.write(a);
	}
}