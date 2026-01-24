package swd_sentify.back_end.DTO;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "The name of product can not empty!")
    private String name;

    @NotBlank(message = "The description of product can not empty!")
    private String description;

    @NotBlank(message = "The price of product can not empty!")
    private BigDecimal price;

    @NotBlank(message = "The stock quantity of product can not null!")
    @Min(value = 0)
    private Integer stockQuantity;

    private String imageUrl;

    @NotBlank(message = "Category can not empty")
    private String category;
}
