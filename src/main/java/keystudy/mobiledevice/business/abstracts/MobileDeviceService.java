package keystudy.mobiledevice.business.abstracts;

import java.util.List;

import keystudy.mobiledevice.core.utilities.results.DataResult;
import keystudy.mobiledevice.core.utilities.results.Result;
import keystudy.mobiledevice.entities.concretes.MobileDevice;

public interface MobileDeviceService {

	Result add(MobileDevice mobileDevice);
	DataResult<List<MobileDevice>> getAll(int pageNumber, int pageSize);
	List<MobileDevice> save(List<MobileDevice> mobileDevices);
	DataResult<List<MobileDevice>> getByBrandContaining(String brand, int page, int size);
	DataResult<List<MobileDevice>> getByBrandAndOsVersion(String brand, String osVersion, int page, int size);
	
}
