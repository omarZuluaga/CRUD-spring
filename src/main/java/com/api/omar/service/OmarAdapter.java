package com.api.omar.service;

import com.api.omar.model.Omar;
import com.api.omar.model.OmarRepository;
import com.api.omar.resource.OmarDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmarAdapter implements OmarService {

  @Autowired
  OmarRepository omarRepository;

  @Autowired
  ObjectMapper objectMapper;

  @Override
  public OmarDto save(OmarDto omar) {
    Omar omarSave = objectMapper.convertValue(omar, Omar.class);
    return objectMapper.convertValue(omarRepository.save(omarSave), OmarDto.class);
  }

  @Override
  public List<OmarDto> findAll() {
    String stringList = "";
    List<OmarDto> listReturn = null;
    try {
      stringList = objectMapper.writeValueAsString(omarRepository.findAll());
      listReturn = objectMapper.readValue(stringList, new TypeReference<List<OmarDto>>() {});
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return listReturn;
  }

  @Override
  public OmarDto update(OmarDto omar) {
    return save(omar);
  }

  @Override
  public void delete(String id) {
    omarRepository.deleteById(id);
  }
}
