/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chyernobog.tasklistbackend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 *
 * @author roger
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class TaskControllerTests {
    
    @Autowired
    private WebTestClient webClient;
    
    @Test
    public void testGetTasks() {
        String tasksPattern = "\"taskName\":\"Mow the lawn\"";
        Pattern pattern = Pattern.compile(tasksPattern);
        
        String contents = this.webClient.get().uri("/task/tasks").exchange().expectStatus().isOk()
                .expectBody(String.class).returnResult().getResponseBody();
        
        assertThat(contents).containsPattern(pattern);
    }
    
}
