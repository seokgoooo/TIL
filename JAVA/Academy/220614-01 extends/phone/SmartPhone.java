package phone;
public class SmartPhone extends Phone {
	private String osType;
	private double osVersion;
	private int memorySize;
	private boolean hasCamera;
	private boolean supportBluetooth;
	
	public SmartPhone(String production, int price, String commType, String osType, double osVersion, int memorySize,
			boolean hasCamera, boolean supportBluetooth) {
		super(production, price, commType);
		this.osType = osType;
		this.osVersion = osVersion;
		this.memorySize = memorySize;
		this.hasCamera = hasCamera;
		this.supportBluetooth = supportBluetooth;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public double getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(double osVersion) {
		this.osVersion = osVersion;
	}

	public int getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}

	public boolean isHasCamera() {
		return hasCamera;
	}

	public void setHasCamera(boolean hasCamera) {
		this.hasCamera = hasCamera;
	}

	public boolean isSupportBluetooth() {
		return supportBluetooth;
	}

	public void setSupportBluetooth(boolean supportBluetooth) {
		this.supportBluetooth = supportBluetooth;
	}
}
