package vsii.edu.updateproduct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "thietbi_image")
@Builder
public class ThietBiImage {
    /**
     * id la khoa chinh va tu dong tang
     * id duy nhat
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long idImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thiet_bi_id", referencedColumnName = "thiet_bi_id") // Cột `id` phải tồn tại trong `ThietBi`
    private ThietBi thietBi;

    @Column(name = "image_url")
    private String imageUrl; // url image dung de truy cap toi cloudinary

}
