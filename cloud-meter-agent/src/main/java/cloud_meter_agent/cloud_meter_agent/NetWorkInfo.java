package cloud_meter_agent.cloud_meter_agent;

public class NetWorkInfo {
	
	public NetWorkInfo(String requestId, String methodObj, String timestampObj, String typeObj, String urlObj, String statusObj, Long dataLength) {
		
	}
	
	private String requestId;
	private String methodObj;
	private String timestampObj;
	private String typeObj;
	private String urlObj;
	private String statusObj;
	private Long dataLength;
	
	
	public String getMethodObj() {
		return methodObj;
	}
	public void setMethodObj(String methodObj) {
		this.methodObj = methodObj;
	}
	public String getTimestampObj() {
		return timestampObj;
	}
	public void setTimestampObj(String timestampObj) {
		this.timestampObj = timestampObj;
	}
	public String getTypeObj() {
		return typeObj;
	}
	public void setTypeObj(String typeObj) {
		this.typeObj = typeObj;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getUrlObj() {
		return urlObj;
	}
	public void setUrlObj(String urlObj) {
		this.urlObj = urlObj;
	}
	public String getStatusObj() {
		return statusObj;
	}
	public void setStatusObj(String statusObj) {
		this.statusObj = statusObj;
	}
	public Long getDataLength() {
		return dataLength;
	}
	public void setDataLength(Long dataLength) {
		this.dataLength = dataLength;
	}
	
	
}
