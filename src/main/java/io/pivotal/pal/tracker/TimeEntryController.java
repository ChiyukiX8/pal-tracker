package io.pivotal.pal.tracker;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TimeEntryController {
    TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry newTimeEntry = timeEntryRepository.create(timeEntryToCreate);
        ResponseEntity<TimeEntry> response = new ResponseEntity(newTimeEntry, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable() long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if (timeEntry == null) {
            ResponseEntity<TimeEntry> response = new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);
            return response;
        }
        ResponseEntity<TimeEntry> response = new ResponseEntity(timeEntry, HttpStatus.OK);
        return response;
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list(){
        List<TimeEntry> timeEntries = timeEntryRepository.list();
        ResponseEntity<List<TimeEntry>> response = new ResponseEntity(timeEntries, HttpStatus.OK);
        return response;
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable long id, @RequestBody TimeEntry expected) {
        TimeEntry newTimeEntry = timeEntryRepository.update(id, expected);
        if (newTimeEntry == null) {
            ResponseEntity<TimeEntry> response = new ResponseEntity(newTimeEntry, HttpStatus.NOT_FOUND);
            return response;
        }
        ResponseEntity<TimeEntry> response = new ResponseEntity(newTimeEntry, HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        timeEntryRepository.delete(id);
        ResponseEntity response = new ResponseEntity(HttpStatus.NO_CONTENT);

        return response;
    }
}
