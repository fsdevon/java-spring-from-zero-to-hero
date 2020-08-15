package com.github.fsdevon.bbbms.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class DemoServiceImpl implements DemoService {

    @Setter
    int number = 0;

    @Override
    public String getMessage() {
        number = 10;
        return "Hello from the core module";
    }
}
