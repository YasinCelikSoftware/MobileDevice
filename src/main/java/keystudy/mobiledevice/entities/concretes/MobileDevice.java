package keystudy.mobiledevice.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mobile_devices")
@AllArgsConstructor
@NoArgsConstructor
public class MobileDevice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "brand", nullable = false)
	private String brand;
	
	@Column(name = "model", nullable = false)
	private String model;
	
	@Column(name = "os", nullable = false)
	private String os;
	
	@Column(name = "os_version", nullable = false)
	private String osVersion;

}
