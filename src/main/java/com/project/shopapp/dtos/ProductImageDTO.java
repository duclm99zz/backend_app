package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class ProductImageDTO {
    @JsonProperty("product_id")
    private Long productId;

    @Size(min = 5, max = 200, message = "Image's name")
    private String imageUrl;
}
