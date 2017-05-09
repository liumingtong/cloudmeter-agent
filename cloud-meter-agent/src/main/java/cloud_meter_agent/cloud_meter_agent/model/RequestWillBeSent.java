package cloud_meter_agent.cloud_meter_agent.model;

/**
 * 请求发送信息
 * @author tiger
 *
 */
public class RequestWillBeSent {
	//network method, requestWillBeSent responseReceived dataReceived loadingFinishedloadingFailed
	String method;
	String documentURL;
	String requestHeaders; //data form headers key
	String requestMethod; //data form mtehod key,example: "GET",
	String url;  //https://www.baidu.com/favicon.ico"
	String timestamp;
	String type;
	String wallTime; // 1494248691.71326
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getDocumentURL() {
		return documentURL;
	}
	public void setDocumentURL(String documentURL) {
		this.documentURL = documentURL;
	}
	public String getRequestHeaders() {
		return requestHeaders;
	}
	public void setRequestHeaders(String requestHeaders) {
		this.requestHeaders = requestHeaders;
	}
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
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
	public String getWallTime() {
		return wallTime;
	}
	public void setWallTime(String wallTime) {
		this.wallTime = wallTime;
	}
	
	
}
