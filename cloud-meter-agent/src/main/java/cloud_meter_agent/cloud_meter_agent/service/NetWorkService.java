package cloud_meter_agent.cloud_meter_agent.service;

import cloud_meter_agent.cloud_meter_agent.constants.NetWorkConstants;
import cloud_meter_agent.cloud_meter_agent.model.NetWorkInfo;
import net.sf.json.JSONObject;

/**
 * 网络信息处理业务类
 * @author tiger
 *
 */
public class NetWorkService {
	private final static NetWorkService instance = new NetWorkService();
	public static NetWorkService getInstance() {
		return instance;
	}

	/**
	 * 处理网络信息
	 * @param message
	 */
	public NetWorkInfo dealNetWorkInfo(String message) {
		JSONObject jsonObj = JSONObject.fromObject(message);
		JSONObject messageObj = (JSONObject) jsonObj.get("message");
		if (messageObj == null) {
			return null;
		}
		Object methodObj = messageObj.get("method");
		if (methodObj == null) {
			return null;
		}
		String method = methodObj.toString();
		switch (method) {
		case NetWorkConstants.NETWORK_DATA_RECEIVED:

			break;
		case NetWorkConstants.NETWORK_LOADING_FAILED:

			break;
		case NetWorkConstants.NETWORK_LOADING_FINISHED:

			break;
		case NetWorkConstants.NETWORK_REQUEST_WILLBE_SENT:

			break;
		case NetWorkConstants.NETWORK_RESPONSE_RECEIVED:

			break;
		default:
			break;
		}

		JSONObject paramsObj = (JSONObject) messageObj.get("params");
		if (paramsObj == null) {
			return null;
		}
		JSONObject responseObj = (JSONObject) paramsObj.get("response");
		if (responseObj == null) {
			return null;
		}

		String timestamp = paramsObj.get("timestamp") == null ? "" : paramsObj.get("timestamp").toString();
		String type = paramsObj.get("type") == null ? "" : paramsObj.get("type").toString();
		String requestId = paramsObj.get("requestId") == null ? "" : paramsObj.get("requestId").toString();
		String url = responseObj.get("url") == null ? "" : responseObj.get("url").toString();
		String status = responseObj.get("status") == null ? "" : responseObj.get("status").toString();

		Long dataLength = null;

		NetWorkInfo netWorkInfo = new NetWorkInfo();
		return netWorkInfo;
		// logger.debug(new Date(entry.getTimestamp()) + " " +
		// entry.getLevel() + " " + entry.getMessage());
		// logger.debug("========================" + url);
		// do something useful with the data
	}
}
