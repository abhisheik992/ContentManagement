package com.km.admin.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.km.admin.model.TransactionHistory;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionHistory, Integer> {

	@Query("FROM TransactionHistory WHERE content_id = :id")
    List<TransactionHistory> findByContent_id(Integer id);

	

	

}
