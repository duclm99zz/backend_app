package com.project.shopapp.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {
    @Min(value = 1, message = "Order's id must be greater than 1")
    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("product_id")
    private Long productId;

    private Float price;
    @Min(value = 0, message = "Number of product must be greater than 0")
    @JsonProperty("number_of_products")
    private int numberOfProducts;
    @Min(value = 0, message = "Total money must be greater than 0")
    @JsonProperty("total_money")
    private Float totalMoney;

    private String color;
}
