package keystudy.mobiledevice.core.utilities.results;

public class DataResult<T> extends Result { // <T> Data Result'a döndüreceği veri tipinin ne olduğunu söylemeye yarar.
	
	private T data;
	
	public DataResult(T data,boolean success, String message) {
		super(success, message);
		this.data = data;
	}

	public DataResult(T data,boolean success) {
		super(success);
		this.data = data;
	}
	
	public T getData () {
		
		return this.data;
		
	}
}
