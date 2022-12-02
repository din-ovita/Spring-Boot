package com.example.tokoonline.service;

import com.example.tokoonline.exception.InternalErrorException;
import com.example.tokoonline.exception.NotFoundException;
import com.example.tokoonline.model.Barang;
import com.example.tokoonline.model.BarangImage;
import com.example.tokoonline.repository.BarangImageRepository;
import com.example.tokoonline.repository.BarangRepository;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@Service
public class BarangImageServiceImpl implements BarangImageService{

    @Autowired
    BarangRepository barangRepository;

    @Autowired
    BarangImageRepository barangImageRepository;

//    menyimpan file

    private static final String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/upload-image-example-e8ba4.appspot.com/o/%s?alt=media";

    @Override
    public BarangImage addImage(int barangId, MultipartFile multipartFile) {
        Barang barang = barangRepository.findById(barangId).orElseThrow(() -> new NotFoundException("Barang id tidak ditemukan"));
//        cara pemakaian
        String url = imageConverter(multipartFile);
        BarangImage barangImage = new BarangImage(url, barang);
        return barangImageRepository.save(barangImage);
    }

//    untuk sistem utama, menggunakan upload sistem ke fire base, multipartfile
    private String imageConverter(MultipartFile multipartFile) {
        try {
            String fileName = getExtensions(multipartFile.getOriginalFilename());
            File file = convertToFile(multipartFile, fileName);
            var RESPONSE_URL = uploadFile(file, fileName);
            file.delete();
            return RESPONSE_URL;
        } catch (Exception e) {
            e.getStackTrace();
            throw new InternalErrorException("Error upload file");
        }
    }

//    merubah multipartfile menjadi file
    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return file;
    }

//    mengupload file
    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("upload-image-example-e8ba4.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("./src/main/resources/serviceAccountKey.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

//        OTOMATIS NAMBAH FILE, memanggil nama file
    private String getExtensions(String fileName) {
        return fileName.split("\\.")[0];
    }

    @Override
    public List<BarangImage> findAll() {
        return barangImageRepository.findAll();
    }

}
