package kr.co.greenart.model.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSystemRepository implements FileRepository {
	private final File saveFolder = new File("d:\\temp\\");
	private final Path root = Paths.get("d:\\temp\\");

	@Override
	public Resource getByName(String fileName) {
		try {
			return new UrlResource(new File(saveFolder.getAbsolutePath() + File.separatorChar + fileName).toURI());
		} catch (MalformedURLException e) {
			return null;
		}
	}

	@Override
	public List<String> getAllnames() {
		File[] filearr = saveFolder.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return !pathname.isDirectory();
			}
		});

//		listFiles는 선택 폴더 안의 하위 폴더를 다 포함하는데 
//		파일필터가 있어서 해당 폴더 안의 폴더를 걸러줄 수 있다.
//		return new ArrayList<String>(filearr);

//		순환하는 방법 List Generic이 String이라 이렇게 해줌
		List<String> list = new ArrayList<String>();

		for (File f : filearr) {
			list.add(f.getName());
		}

		return list;

//		nio Files와 Stream & 람다식 (Java 8)
//		try {
//			Files.walk(root, 1)
//					.filter(x -> !x.equals(this.root))
//					.filter(x -> Files.isDirectory(x))
//					.map(y -> y.toString())
//					.collect(Collectors.toList());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public int save(MultipartFile file) throws IllegalStateException, IOException {
//		1번째 방법
		if (!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		file.transferTo(new File(saveFolder.getAbsolutePath() + File.separatorChar + file.getOriginalFilename()));
		return 1;

//		2번째 방법
//		Path saveFolder = Paths.get("d:\\");
//		if (!Files.exists(saveFolder)) {
//			Files.createDirectories(saveFolder);
//		}
//		file.transferTo(saveFolder.resolve(Paths.get(file.getOriginalFilename())).normalize());
//		return 1;
	}
}