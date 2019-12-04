package com.km.admin.service;

import java.util.Optional;

import com.km.admin.model.Content;
import com.km.admin.payload.ContentModel;

public interface ContentService {
	
	Content findByTitle(String byTitle);
	
	Content findByContentId(Integer id);

	void save(Content content);

	Iterable<Content> findAll();

	Optional<Content> findById(Integer id);

	String addMetaData(String title, ContentModel contentModel);

	String addMetaDataById(Integer id, ContentModel contentModel);

	String deleteById(Integer id);


}
