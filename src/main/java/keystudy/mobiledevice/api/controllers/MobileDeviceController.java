package keystudy.mobiledevice.api.controllers;

import keystudy.mobiledevice.business.abstracts.MobileDeviceService;
import keystudy.mobiledevice.core.utilities.results.DataResult;
import keystudy.mobiledevice.core.utilities.results.Result;
import keystudy.mobiledevice.entities.concretes.MobileDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mobiledevices")
public class MobileDeviceController {

	private MobileDeviceService mobileDeviceService;

	@Autowired
	public MobileDeviceController(MobileDeviceService mobileDeviceService) {
		super();
		this.mobileDeviceService = mobileDeviceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody MobileDevice mobileDevice) {

		return this.mobileDeviceService.add(mobileDevice);

	}
	@GetMapping(params = {"page"})
	public DataResult<List<MobileDevice>> getAll(@RequestParam("page") int pageNumber, @RequestParam(defaultValue = "5", required = false) int size, 
														@RequestParam(required = false) String brand, @RequestParam(required = false) String osVersion) {
		if(brand == null)
			return this.mobileDeviceService.getAll(pageNumber-1, size);
		else if(osVersion == null)
			return this.mobileDeviceService.getByBrandContaining(brand, pageNumber-1, size);
		else
			return this.mobileDeviceService.getByBrandAndOsVersion(brand, osVersion, pageNumber-1, size);
	}
	
	
}
