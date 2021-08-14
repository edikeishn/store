package ru.rayyana.store.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String saveImage(Long itemId, MultipartFile file);
}
