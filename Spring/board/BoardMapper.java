package kr.co.greenart;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardMapper {
	@Select("SELECT * FROM board")
	@Results(id = "boardResult", value = { @Result(property = "no", column = "no", id = true),
			@Result(property = "title", column = "title"), @Result(property = "writer", column = "writer") })
	List<Article> getAll();

	@Select("SELECT COUNT(*) FROM board")
	int getCount();

	@Insert("INSERT INTO board(title, writer) VALUES(#{title}, #{writer})")
	int write(Article a);
}