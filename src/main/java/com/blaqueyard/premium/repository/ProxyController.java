package com.blaqueyard.premium.repository;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.Callable;

@RestController
public class ProxyController {

    @PostMapping("delivery-report")
    public Callable<ResponseEntity<HashMap<String,Object>>> tisaDelivery(@RequestBody String json) {
        System.out.println();
        System.out.println();
        System.out.println("Response from Safaricom");
        System.out.println(json);

        HashMap<String,Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("status", "success");
        stringObjectHashMap.put("data", new Gson().toJson(json));

        return () -> ResponseEntity.ok().body(stringObjectHashMap);
    }
}
