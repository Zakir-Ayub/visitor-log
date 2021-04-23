package com.visitorlog.VisitorLog.service;

import com.visitorlog.VisitorLog.exception.UserNotFoundException;
import com.visitorlog.VisitorLog.model.Visitor;
import com.visitorlog.VisitorLog.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VisitorService
{
    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorService(VisitorRepository visitorRepository)
    {
        this.visitorRepository = visitorRepository;
    }

    public Visitor addVisitor(Visitor visitor)
    {
        visitor.setUniqueCode(UUID.randomUUID().toString());
        visitor.setTimeAndDate(LocalDateTime.now());
        return visitorRepository.save(visitor);
    }

    public List<Visitor> findAllVisitors()
    {
        return visitorRepository.findAll();
    }

    public Visitor updateVisitor(Visitor visitor)
    {
        return visitorRepository.save(visitor);
    }

    public Visitor findVisitorById(Long id)
    {
        return visitorRepository.findVisitorById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id "+id+" Was not found."));
    }

    public void deleteVisitor(Long id)
    {
        visitorRepository.deleteVisitorById(id);
    }


}
