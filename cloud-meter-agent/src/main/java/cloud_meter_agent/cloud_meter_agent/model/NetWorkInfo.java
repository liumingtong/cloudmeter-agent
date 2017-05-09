package cloud_meter_agent.cloud_meter_agent.model;

/**
 * 网络数据信息
 * 
 * @author tiger
 *
 */
public class NetWorkInfo {

	public NetWorkInfo() {
		
	}
	public NetWorkInfo(String requestId, RequestWillBeSent requestSend, ResponseReceived responseReceived,
			DataReceived dataReceived, LoadingFailed loadingFailed) {
	}

	private String requestId;
	private String frameId;
	private String loaderId;
	private RequestWillBeSent requestSend;
	private ResponseReceived responseReceived;
	private DataReceived dataReceived;
	private LoadingFailed loadingFailed;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getFrameId() {
		return frameId;
	}

	public void setFrameId(String frameId) {
		this.frameId = frameId;
	}

	public String getLoaderId() {
		return loaderId;
	}

	public void setLoaderId(String loaderId) {
		this.loaderId = loaderId;
	}

	public RequestWillBeSent getRequestSend() {
		return requestSend;
	}

	public void setRequestSend(RequestWillBeSent requestSend) {
		this.requestSend = requestSend;
	}

	public ResponseReceived getResponseReceived() {
		return responseReceived;
	}

	public void setResponseReceived(ResponseReceived responseReceived) {
		this.responseReceived = responseReceived;
	}

	public DataReceived getDataReceived() {
		return dataReceived;
	}

	public void setDataReceived(DataReceived dataReceived) {
		this.dataReceived = dataReceived;
	}

	public LoadingFailed getLoadingFailed() {
		return loadingFailed;
	}

	public void setLoadingFailed(LoadingFailed loadingFailed) {
		this.loadingFailed = loadingFailed;
	}

}
