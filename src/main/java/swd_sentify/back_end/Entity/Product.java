package swd_sentify.back_end.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.*;

@Entity                     // 1. Đánh dấu đây là một bảng trong DB
@Table(name = "products")   // 2. Đặt tên bảng trong MySQL là "products"
@Data                       // 3. Lombok tự sinh Getter/Setter/toString
@NoArgsConstructor          // 4. Constructor không tham số (Bắt buộc cho JPA)
@AllArgsConstructor         // 5. Constructor có tham số
@Builder                    // 6. Design pattern để khởi tạo object dễ hơn
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự tăng ID (1, 2, 3...)
    private Long id;

    @Column(nullable = false) // Không được để trống
    private String name;

    @Column(length = 1000)    // Cho phép mô tả dài hơn mặc định (255)
    private String description;

    private Double price;

    private Integer stockQuantity; // Số lượng tồn kho

    private String imageUrl;       // Link ảnh sản phẩm

    private String category;       // Ví dụ: "Gọng kính", "Tròng kính"

    private boolean active = true; // true = Đang bán, false = Ngừng kinh doanh
}
