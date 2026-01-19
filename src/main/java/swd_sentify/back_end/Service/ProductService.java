package swd_sentify.back_end.Service;

import swd_sentify.back_end.DTO.CreateReq;
import swd_sentify.back_end.Entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(CreateReq request);
    List<Product> getAllProducts();
}
