package swd_sentify.back_end.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swd_sentify.back_end.Entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByActiveTrue();

    List<Product> findByNameIgnoreCaseAndActiveTrue(String name);
}
