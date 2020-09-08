package com.itcrazy.alanmall.office.manager;

import com.itcrazy.alanmall.office.dto.TaskDto;
import com.itcrazy.alanmall.office.model.Task;
import java.util.List;

public interface TaskManager {
  Task addTask(Task paramTask);
  
  List<Task> getPageList(TaskDto paramTaskDto);
  
  Integer updataTask(Task paramTask);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\manager\TaskManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */