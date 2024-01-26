package com.project.shopapp.controllers;

import com.project.shopapp.dtos.CategoryDTO;
import com.project.shopapp.models.Category;
import com.project.shopapp.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor

//@Validated
public class CategoryController {
    private final CategoryService categoryService;


    @PostMapping("")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDTO categoryDto, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
            System.out.println("Come to bad request");
            return ResponseEntity.badRequest().body(errorMessages);
        }
        categoryService.createCategory(categoryDto);
        return ResponseEntity.ok("CREATE A CATEGORY" + categoryDto);
    }

    // LIST ALL CATEGORIES
    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories(@RequestParam("page") int page, @RequestParam("size") int size) {
        List<Category> result = categoryService.getAllCategories();
        return ResponseEntity.ok().body(result);
    }



    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory (@PathVariable Long id,@Valid @RequestBody CategoryDTO categoryDto) {
        categoryService.updateCategory(id, categoryDto);
        return ResponseEntity.ok("UPDATE CATEGORY " + id);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory (@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("DELETE CATEGORY " + id);
    };
}
