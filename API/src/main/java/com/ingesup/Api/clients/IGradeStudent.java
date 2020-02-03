package com.ingesup.Api.clients;

import com.ingesup.Api.entities.Grade;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name= "GradeClient")
public interface IGradeStudent {

    @RequestLine("GET /")
    List<Grade> getAll();
}
