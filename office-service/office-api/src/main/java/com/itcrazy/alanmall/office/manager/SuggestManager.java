package com.itcrazy.alanmall.office.manager;

import com.itcrazy.alanmall.office.dto.SuggestDto;
import com.itcrazy.alanmall.office.model.Suggest;
import java.util.List;

public interface SuggestManager {
  Suggest addSuggest(Suggest paramSuggest);
  
  List<Suggest> getPageList(SuggestDto paramSuggestDto);
  
  int getPageTotal(SuggestDto paramSuggestDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\manager\SuggestManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */