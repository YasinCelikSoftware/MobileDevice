package keystudy.mobiledevice.dataAccess.abstracts;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;


import keystudy.mobiledevice.entities.concretes.MobileDevice;

public interface MobileDeviceDao extends JpaRepository<MobileDevice, Integer>  {

	@Query(value = "Select * From mobile_devices Where brand = :brand and model = :model and os_version = :os_version", nativeQuery = true)
	MobileDevice itemControl(@Param("brand") String brand,@Param("model") String model, @Param("os_version") String osVersion);
	
	Page<MobileDevice> findByBrandContaining(String brand, Pageable pageable);
	Page<MobileDevice> findByBrandAndOsVersionContaining(String brand, String osVersion, Pageable pageable);
	
	
}