package com.itcrazy.alanmall.office.manager;

import com.itcrazy.alanmall.office.model.ScheduleJob;
import java.util.List;

public interface ScheduleJobManager {
  List<ScheduleJob> getAll();
  
  int insertSelective(ScheduleJob paramScheduleJob);
  
  ScheduleJob selectByPrimaryKey(Long paramLong);
  
  int updateByPrimaryKeySelective(ScheduleJob paramScheduleJob);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\manager\ScheduleJobManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */