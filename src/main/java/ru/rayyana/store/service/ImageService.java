package ru.rayyana.store.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImage(String itemId, MultipartFile file);
}
