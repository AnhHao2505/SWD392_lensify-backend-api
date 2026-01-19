package swd_sentify.back_end.Service;

import org.springframework.beans.factory.annotation.Autowired;
import swd_sentify.back_end.DTO.CreateReq;
import swd_sentify.back_end.Entity.Product;
import swd_sentify.back_end.Repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(CreateReq request) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
