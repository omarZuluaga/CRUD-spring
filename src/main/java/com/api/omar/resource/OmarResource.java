package com.api.omar.resource;

import com.api.omar.service.OmarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Omar")
public class OmarResource {

  @Autowired
  private OmarService omarService;

  @PostMapping
  public OmarDto save(@RequestBody OmarDto omar){
    return omarService.save(omar);
  }

  @GetMapping
  public List<OmarDto> findAll(){
    return omarService.findAll();
  }

  @PutMapping
  public OmarDto update(@RequestBody OmarDto omar){
    return omarService.update(omar);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id){
    omarService.delete(id);
  }
}
