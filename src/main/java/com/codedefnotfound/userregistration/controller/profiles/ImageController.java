package com.codedefnotfound.userregistration.controller.profiles;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
public class ImageController {

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {}

    @GetMapping("/{imageName}")
    public void getImage(@PathVariable("imageName") String imageName) {}
}
