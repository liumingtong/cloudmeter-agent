package cloud_meter_agent.cloud_meter_agent.model;

/**
 * 收到的数据信息
 * @author tiger
 *
 */
public class DataReceived {
	//network method, requestWillBeSent responseReceived dataReceived loadingFinishedloadingFailed
	String method;
	String type;
	Long dataLength;
	//转码后数据长度
	Long encodedDataLength;
	Long timestamp;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getDataLength() {
		return dataLength;
	}
	public void setDataLength(Long dataLength) {
		this.dataLength = dataLength;
	}
	public Long getEncodedDataLength() {
		return encodedDataLength;
	}
	public void setEncodedDataLength(Long encodedDataLength) {
		this.encodedDataLength = encodedDataLength;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
