package vsii.edu.updateproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsii.edu.updateproduct.entity.ThietBi;
import vsii.edu.updateproduct.entity.ThietBiImage;

@Repository
public interface ThietBiImageRepository extends JpaRepository<ThietBiImage,Long> {
    public ThietBiImage getByThietBi_idThietBi(Long idThietBi);

}
