package swd_sentify.back_end.DTO;

import lombok.Data;

@Data
public class CreateReq {
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private String imgUrl;
    private String category;
}
