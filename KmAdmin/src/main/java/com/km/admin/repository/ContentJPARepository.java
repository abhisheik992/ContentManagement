package com.km.admin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.km.admin.model.Content;

@Repository
public interface ContentJPARepository extends JpaRepository<Content, Integer> {
	
	Content findByTitle(String byTitle);

	Content findByContentId(Integer id);


}
