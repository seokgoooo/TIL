package Page264Six;

class SmartPhone extends Phone {
	private String osType;
	private double osVersion;
	private double memorySize;
	private boolean camera;
	private boolean bluetooth;

	public SmartPhone(String maker, int price, String type, String osType, double osVersion, double memorySize,
			boolean camera, boolean bluetooth) {
		super(maker, price, type);
		this.osType = osType;
		this.osVersion = osVersion;
		this.memorySize = memorySize;
		this.camera = camera;
		this.bluetooth = bluetooth;
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

	public double getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(double memorySize) {
		this.memorySize = memorySize;
	}

	public boolean isCamera() {
		return camera;
	}

	public void setCamera(boolean camera) {
		this.camera = camera;
	}

	public boolean isBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}
	
	public String toString() {
		return super.toString() + osType + osVersion + memorySize + camera + bluetooth ;
	}
}