package com.SpringCompletePlaylist.journalApp.controller;

import com.SpringCompletePlaylist.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")//adds mapping to the whole class and endpoint would now be /journal/<endpoint of GetMapping>
//when server sees /journal path, it directly goes to this class
public class JournalEntryController {
    //Since we have no database connected now, we will use this for adding Journal entries
    private Map<Long, JournalEntry> journalEntries= new HashMap<>();

    @GetMapping//to get endpoint for API call->http://localhost:8080/journal GET
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping//http://localhost:8080/journal POST
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJounralEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJounralEntryById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJounralEntryById(@PathVariable Long id, @RequestBody JournalEntry myEntry){//updates according to id
        return journalEntries.put(id, myEntry);
    }


}
