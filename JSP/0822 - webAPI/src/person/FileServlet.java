package person;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/fileupload")
@MultipartConfig(location = "d:\\temp", fileSizeThreshold = 10 * 1024 * 1024, maxFileSize = 50 * 1024 * 1024)
public class FileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part p = req.getPart("fileupload");
		System.out.println(p.getName());
		System.out.println(p.getSubmittedFileName());
		for (String header : p.getHeaderNames()) {
			System.out.println(header + " : " + p.getHeader(header));
		}

		String contextPath = getServletContext().getRealPath("");
		Path directory = Paths.get(contextPath);
		Files.copy(p.getInputStream(), directory.resolve(p.getSubmittedFileName()),
				StandardCopyOption.REPLACE_EXISTING);

		resp.sendRedirect("/" + URLEncoder.encode(p.getSubmittedFileName(), "UTF-8"));
	}
}