package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.portfoliotracker.DemoApplication; // Add this import

@SpringBootTest(classes = DemoApplication.class) // Specify the main application class
class DemoApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        // Check that the application context loads without issues
        assert(applicationContext != null);
    }
}
