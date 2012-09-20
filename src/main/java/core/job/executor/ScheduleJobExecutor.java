package core.job.executor;

import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleJobExecutor {
	
	@Scheduled(cron="0 0 */2 * * ?")
	public void doSchedule() {
		
	}
}
