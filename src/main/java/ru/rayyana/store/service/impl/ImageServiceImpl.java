package ru.rayyana.store.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.rayyana.store.service.ImageService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {

    private String URI_PREFIX = "frontend/public/assets/items/";

    @Override
    public void saveImage(String itemId, MultipartFile file) {
        if (file.isEmpty()) throw new RuntimeException("Загружаемого файла не существует");
        Path destinationPath = Paths.get(URI_PREFIX+itemId+".jpg");
        System.out.println(destinationPath.toAbsolutePath());
        try {
            file.transferTo(destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
