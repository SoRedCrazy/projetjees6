package com.jee.projet.DAO;

import com.jee.projet.ENTITY.Comment;
import com.jee.projet.ENTITY.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {


}
