package cloud_meter_agent.cloud_meter_agent.model;

import java.util.List;

/**
 * har常量类
 * 
 * @author Administrator
 *
 */
public class HarSummary {
	

	private List<PageSummary> pageSummaries;

		public List<PageSummary> getPageSummaries() {
			return pageSummaries;
		}

		public void setPageSummaries(List<PageSummary> pageSummaries) {
			this.pageSummaries = pageSummaries;
		} 
		

}
