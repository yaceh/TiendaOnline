package pe.edu.udaff.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("uploadFileService")
public class UploadFileService {
	private String uploadFolder = "src/main/resources/static/public/images/";

	public String saveImagen(MultipartFile file, Integer idproducto) throws IOException {
		return saveFile(file, "producto_" + idproducto, "png");
	}


	private String saveFile(MultipartFile file, String filename, String type) throws IOException {
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadFolder+ filename + "." + type);
			Files.write(path, bytes);
			return filename + "." + type;
		} else
			return "";
	}

}