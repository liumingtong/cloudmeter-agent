package cloud_meter_agent.cloud_meter_agent.model;

/**
 * 响应数据信息
 * @author tiger
 *
 */
public class ResponseReceived {
	//network method, requestWillBeSent responseReceived dataReceived loadingFinishedloadingFailed
	String method;
	String responseHeaders;
	String remoteIPAddress;
	String remotePort;
	String securityState;
	String status;
	String url; //https://www.baidu.com/favicon.ico"
	String timestamp;
	String type;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getResponseHeaders() {
		return responseHeaders;
	}
	public void setResponseHeaders(String responseHeaders) {
		this.responseHeaders = responseHeaders;
	}
	public String getRemoteIPAddress() {
		return remoteIPAddress;
	}
	public void setRemoteIPAddress(String remoteIPAddress) {
		this.remoteIPAddress = remoteIPAddress;
	}
	public String getRemotePort() {
		return remotePort;
	}
	public void setRemotePort(String remotePort) {
		this.remotePort = remotePort;
	}
	public String getSecurityState() {
		return securityState;
	}
	public void setSecurityState(String securityState) {
		this.securityState = securityState;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
