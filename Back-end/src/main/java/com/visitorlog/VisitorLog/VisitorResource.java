package com.visitorlog.VisitorLog;

import com.visitorlog.VisitorLog.model.Visitor;
import com.visitorlog.VisitorLog.service.VisitorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitor")
public class VisitorResource
{
    private final VisitorService visitorService;

    public VisitorResource(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Visitor>> getAllVisitor ()
    {
        List<Visitor> visitors = visitorService.findAllVisitors();
        return new ResponseEntity<>(visitors, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable("id") Long id)
    {
        Visitor visitor = visitorService.findVisitorById(id);
        return new ResponseEntity<>(visitor, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Visitor> addVisitor(@RequestBody Visitor visitor)
    {
        Visitor newVisitor = visitorService.addVisitor(visitor);
        return new ResponseEntity<>(newVisitor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Visitor> updateVisitor(@RequestBody Visitor visitor)
    {
        Visitor updateVisitor = visitorService.updateVisitor(visitor);
        return new ResponseEntity<>(updateVisitor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVisitor(@PathVariable ("id") Long id)
    {
        visitorService.deleteVisitor(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
