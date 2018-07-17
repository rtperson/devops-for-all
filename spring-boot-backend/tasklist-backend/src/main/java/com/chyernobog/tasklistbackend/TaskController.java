
package com.chyernobog.tasklistbackend;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author roger
 */
@RestController
@RequestMapping(value="task")
public class TaskController {
    
    private List<Task> taskList = new ArrayList<Task>();
    
    private RestTemplate restClient = new RestTemplate();
    
    @RequestMapping(value="/tasks", method=GET)
    public List<Task> tasks() {
        List<Task> taskList = new ArrayList<Task>();
        Task task1 = new Task(1, "Mow the lawn", DateTime.now().plusDays(3));
        Task task2 = new Task(2, "Buy groceries", DateTime.now());
        Task task3 = new Task(3, "Solve deep and lasting issues", DateTime.now().plusYears(800));
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        
        return taskList;
    }
    
    
    
}
