package com.utsavi.splitwise.service;

import com.utsavi.splitwise.stratergy.ConsecutiveSettleUpStrategy;
import com.utsavi.splitwise.stratergy.HeapSettleUpStrategy;
import com.utsavi.splitwise.stratergy.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SettleUpStrategyFactory {
  @Autowired
  @Qualifier("ConsecutiveSettleUpStrategy") //Inject specifically this implementation
  private ConsecutiveSettleUpStrategy consecutiveSettleUpStrategy;

  @Autowired
  @Qualifier("HeapSettleUpStrategy")
  private HeapSettleUpStrategy heapSettleUpStrategy;

  public SettleUpStrategy getStrategy(String type){
    if("Consecutive".equalsIgnoreCase(type)){
      return consecutiveSettleUpStrategy;
    }else if("Heap".equalsIgnoreCase(type)){
      return heapSettleUpStrategy;
    }
    throw new IllegalArgumentException("Invalid strategy type");
  }
}
