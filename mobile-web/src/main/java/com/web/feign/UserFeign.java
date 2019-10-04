package com.web.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

import com.nitro.servicr.UserService;
@Service
@FeignClient("member")
public interface UserFeign extends UserService {

}
