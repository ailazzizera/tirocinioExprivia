package com.example.example.repository.impl;

import com.example.example.domain.documents.Assessment;
import com.example.example.repository.AssessmentRepository;
import com.mongodb.client.result.DeleteResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AssessmentRepositoryImpl implements AssessmentRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Assessment> findAll() {
        return mongoTemplate.findAll(Assessment.class);
    }

    @Override
    public Optional<Assessment> findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Assessment assessment = mongoTemplate.findOne(query, Assessment.class);
        return Optional.ofNullable(assessment);
    }

    @Override
    public Assessment save(Assessment assessment) {
        return mongoTemplate.save(assessment);
    }

    @Override
    public boolean deleteById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult result = mongoTemplate.remove(query, Assessment.class);
        return result.wasAcknowledged() && result.getDeletedCount() > 0;
    }

    @Override
    public Optional<Assessment> updateById(String id, Assessment updatedAssessment) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update()
                .set("assessmentName", updatedAssessment.getAssessmentName())
                .set("surveys", updatedAssessment.getSurveys())
                .set("tools", updatedAssessment.getTools())
                .set("engine", updatedAssessment.getEngine());

        Assessment result = mongoTemplate.findAndModify(query, update, Assessment.class);
        return Optional.ofNullable(result);
    }
}
