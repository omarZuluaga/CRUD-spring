package com.api.omar.service;

import com.api.omar.resource.OmarDto;
import java.util.List;

public interface OmarService {
   public OmarDto save(OmarDto omar);
   public List<OmarDto> findAll();
   public OmarDto update(OmarDto omar);
   public void delete(String id);
}
