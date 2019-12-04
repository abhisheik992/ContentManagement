package com.km.admin.controller;

import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.km.admin.exception.RecordNotFoundException;
import com.km.admin.model.Content;
import com.km.admin.payload.ContentModel;
import com.km.admin.service.ContentService;
import com.km.admin.service.FileStorageService;


@RestController
@RequestMapping(path = "/mp-cms")
@CrossOrigin
public class ContentController {

	
	private static final Logger logger = LogManager.getLogger(ContentController.class);

	/*
	 * @Autowired private ContentJPARepository contentJPARepository;
	 */
//
//	 @Autowired
//	 private KafkaTemplate<String, Content> kafkaTemplate;
//
//	 private static final String TOPIC = "contentData";
	    
	@Autowired
	private ContentService contentService;
	
	
	@Autowired
	private FileStorageService fileStorageService;

	public ContentController() {
		logger.info("ContentController Default Constructor");
	}



	
	@PostMapping(path = "/addfile")
	public @ResponseBody String addFile(@RequestParam("file") MultipartFile file) {
		logger.info("addFile");
		Content content = new Content();
		logger.info("addFile");
		String title = StringUtils.cleanPath(file.getOriginalFilename());
		@SuppressWarnings("unused")
		Path filePath = fileStorageService.storeFile(file);
		logger.info("addFile");
		content.setVideo_URL("http://localhost:8080/videos/"+title);
		content.setCreatedAt(Instant.now());
		
		if (title.indexOf(".") > 0)
			title = title.substring(0, title.lastIndexOf("."));
		
		content.setTitle(title.toString());
	
		System.out.println("=====================>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		contentService.save(content);

		System.out.println("=====================");
		return null;
	}
	

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Content> getMetaDataList() {
		logger.info(" @getAllUsers controller"  );
		return contentService.findAll();

	}
	
	@GetMapping(path = "/byId/{id}")
	public Content findById(@PathVariable("id")Integer id) {
		Content content = (Content) contentService.findByContentId(id);
		
		System.out.println(content);
		return content;
	}
	
	
	@PatchMapping(path = "/addMetaById/{id}")
	public String addMetaById(@RequestBody ContentModel contentModel,@PathVariable("id")Integer id) {
		System.out.println(contentModel);
		String result = contentService.addMetaDataById(id,contentModel);
//		Content content = contentService.findByContentId(id);
//		kafkaTemplate.send(TOPIC, content);

		return result;
	}
	
	@DeleteMapping(path = "/deleteById/{id}")
	public String deleteById(@PathVariable("id")Integer id) {
		logger.info(" @deleteById controller" );
		String result = contentService.deleteById(id);
		logger.info(" @deleteById result @"+result );
		return result;
	}
	
	
	@SuppressWarnings("unused")
	@GetMapping(path = "/getAllVideos")
	public ResponseEntity<Iterable<String>> getAllVideos() {
		logger.info(" @getAllVideos  controller" );
		Iterable<Content> contentList = contentService.findAll();
		 List<String> videoUrl = new ArrayList<String>();
		for (Content content : contentList) {
			videoUrl.add(content.getVideo_URL());
			logger.info(" @getAllUsers controller"+videoUrl );
		}
		
		if(videoUrl == null) {
			logger.info(" @getAllVideos RecordNotFoundException  @");
	         throw new RecordNotFoundException("no videos are found " );
	    }
	    return new ResponseEntity<Iterable<String>>(videoUrl, HttpStatus.OK);
	}
	

}
