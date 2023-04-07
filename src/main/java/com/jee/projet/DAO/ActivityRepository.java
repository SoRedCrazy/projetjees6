package com.jee.projet.DAO;

import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
//    @Query("SELECT a.id FROM program_activities a JOIN a. ")
//    List<Program> findByProgram(long id);
}