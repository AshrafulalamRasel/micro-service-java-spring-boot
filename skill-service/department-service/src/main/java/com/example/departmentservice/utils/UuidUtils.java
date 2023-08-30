package com.example.departmentservice.utils;

import java.util.UUID;

public class UuidUtils {

    public String getUuid() {
        return UUID.randomUUID().toString().replace("-","").substring(0,4);
    }
}
