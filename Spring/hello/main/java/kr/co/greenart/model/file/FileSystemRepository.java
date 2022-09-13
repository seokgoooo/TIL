package kr.co.greenart.model.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSystemRepository implements FileRepository {

	@Override
	public Resource getByName(String fileName) {
		throw new UnsupportedOperationException("�̱���");
	}

	@Override
	public List<String> getAllnames() {
		throw new UnsupportedOperationException("�̱���");
	}

	@Override
	public int save(MultipartFile file) throws IllegalStateException, IOException {
//		1��° ���
		File saveFolder = new File("d:\\temp\\");
		if (!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		file.transferTo(new File(saveFolder.getAbsolutePath() + File.separatorChar + file.getOriginalFilename()));
		return 1;

//		2��° ���
//		Path saveFolder = Paths.get("d:\\");
//		if (!Files.exists(saveFolder)) {
//			Files.createDirectories(saveFolder);
//		}
//		file.transferTo(saveFolder.resolve(Paths.get(file.getOriginalFilename())).normalize());
//		return 1;
	}
}