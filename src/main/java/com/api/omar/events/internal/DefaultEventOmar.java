package com.api.omar.events.internal;

import com.api.omar.events.EventOmar;
import com.api.omar.resource.OmarDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class DefaultEventOmar implements EventOmar {

  @Autowired
  private JmsTemplate jmsTemplate;

  @Autowired
  private ObjectMapper mapper;

  @Value("${message.outbound.omarInBound}")
  private String outboundOmarWithJMQueue;

  @Override
  public void publishOmar(OmarDto eventOmar) {
    try{
      jmsTemplate.convertAndSend(outboundOmarWithJMQueue, mapper.writeValueAsString(eventOmar));
    }catch(JsonProcessingException ex){
      //new RuntimeException("jms send, exception convert object to json");
    }
  }
}
