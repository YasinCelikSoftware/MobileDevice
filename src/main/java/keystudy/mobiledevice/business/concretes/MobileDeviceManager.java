package keystudy.mobiledevice.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import keystudy.mobiledevice.business.abstracts.MobileDeviceService;
import keystudy.mobiledevice.core.utilities.results.DataResult;
import keystudy.mobiledevice.core.utilities.results.ErrorResult;
import keystudy.mobiledevice.core.utilities.results.Result;
import keystudy.mobiledevice.core.utilities.results.SuccesDataResult;
import keystudy.mobiledevice.core.utilities.results.SuccessResult;
import keystudy.mobiledevice.dataAccess.abstracts.MobileDeviceDao;
import keystudy.mobiledevice.entities.concretes.MobileDevice;

@Service
public class MobileDeviceManager implements MobileDeviceService {

	private MobileDeviceDao mobileDeviceDao;
	
	@Autowired
	public MobileDeviceManager(MobileDeviceDao mobileDeviceDao) {

		super();
		this.mobileDeviceDao = mobileDeviceDao;

	}

	@Override
	public Result add(MobileDevice mobileDevice) {
		
		try
		{
			if(mobileDeviceDao.itemControl(mobileDevice.getBrand(), mobileDevice.getModel(), mobileDevice.getOsVersion()) == null) {
				if (isNullorEmpty(mobileDevice.getBrand()) || isNullorEmpty(mobileDevice.getModel()) 
															|| isNullorEmpty(mobileDevice.getOs()) || isNullorEmpty(mobileDevice.getOsVersion())) {
					
					return new ErrorResult("This device has an null or empty value.");

				}
				else if (mobileDevice.getOs().equals("Android") || mobileDevice.getOs().equals("ios")){
					mobileDeviceDao.save(mobileDevice);
					return new SuccessResult("Mobile device saved. Device ID is : " + mobileDevice.getId());
				}else {
					return new ErrorResult("Mobile device os is not Android or ios.");
				}	
			} else {
				
				return new ErrorResult("This mobile device is already exist.");
				
			}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return new ErrorResult("Exception catched.");
			
		}
	}
	
	private boolean isNullorEmpty(String input){

		return input == null || input.trim().isEmpty();

	}



	@Override
	public DataResult<List<MobileDevice>> getAll(int pageNumber, int pageSize) {
		
		return new SuccesDataResult<List<MobileDevice>>(this.mobileDeviceDao.findAll(PageRequest.of(pageNumber, pageSize)).getContent(), "Page found with no filter.");
		
	}

	@Override
	public List<MobileDevice> save(List<MobileDevice> mobileDevices) {		
		return mobileDeviceDao.saveAll(mobileDevices);
	}

	@Override
	public DataResult<List<MobileDevice>> getByBrandContaining(String brand, int page, int size) {
		
		return new SuccesDataResult<List<MobileDevice>>(this.mobileDeviceDao.findByBrandContaining(brand, PageRequest.of(page, size)).getContent(), "Page found with " + brand + " filter.");
	}

	@Override
	public DataResult<List<MobileDevice>> getByBrandAndOsVersion(String brand, String osVersion, int page, int size) {
		
		return new SuccesDataResult<List<MobileDevice>>(this.mobileDeviceDao.findByBrandAndOsVersionContaining(brand, osVersion, PageRequest.of(page, size)).getContent(), "Page found with " + brand + " and " + osVersion + " filter.");
	}
}
