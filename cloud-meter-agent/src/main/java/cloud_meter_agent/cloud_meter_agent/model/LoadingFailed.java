package cloud_meter_agent.cloud_meter_agent.model;

/**
 * 加载失败信息
 * @author tiger
 *
 */
public class LoadingFailed {
	//network method, requestWillBeSent responseReceived dataReceived loadingFinishedloadingFailed
	String method;
	//封锁原因
	String blockedReason;
	Boolean canceled;
	String errorText;
	String timestamp;  
	String type;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getBlockedReason() {
		return blockedReason;
	}
	public void setBlockedReason(String blockedReason) {
		this.blockedReason = blockedReason;
	}
	public Boolean getCanceled() {
		return canceled;
	}
	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
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
