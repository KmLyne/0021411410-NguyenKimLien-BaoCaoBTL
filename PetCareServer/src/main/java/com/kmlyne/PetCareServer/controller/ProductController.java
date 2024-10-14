package com.kmlyne.PetCareServer.controller;

import com.kmlyne.PetCareServer.model.Products;
import com.kmlyne.PetCareServer.service.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductSevice productService;

    @GetMapping
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable int id) {
        Optional<Products> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public Products addProduct(@RequestBody Products product) {
//        return productService.addProduct(product);
//    }

    @PostMapping
    public ResponseEntity<Products> addProduct(
            @RequestParam("productname") String productName,
            @RequestParam("categoryid") int categoryId,
            @RequestParam("animalid") int animalId,
            @RequestParam("description") String description,
            @RequestParam("price") int price,
            @RequestParam("stockquantity") int stockQuantity,
            @RequestParam("image") MultipartFile image) {

        // Xử lý lưu file ảnh
        String fileName = image.getOriginalFilename();
        // Lưu file vào một thư mục nào đó hoặc xử lý ảnh (tuỳ vào yêu cầu)

        // Tạo đối tượng sản phẩm mới
        Products product = new Products();
        product.setProductname(productName);
        product.setCategoryid(categoryId);
        product.setAnimalid(animalId);
        product.setDescription(description);
        product.setPrice(price);
        product.setStockquantity(stockQuantity);
        product.setImage(fileName); // Hoặc lưu đường dẫn ảnh đã được xử lý

        // Lưu sản phẩm vào cơ sở dữ liệu
        Products savedProduct = productService.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable int id, @RequestBody Products productDetails) {
        Products updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}


