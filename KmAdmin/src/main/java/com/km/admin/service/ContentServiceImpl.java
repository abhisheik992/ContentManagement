package com.km.admin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.admin.model.Content;
import com.km.admin.model.TransactionHistory;
import com.km.admin.model.User;
import com.km.admin.payload.ContentModel;
import com.km.admin.repository.ContentJPARepository;
import com.km.admin.repository.TransactionsRepository;
import com.km.admin.repository.UserRepository;



@Service
public class ContentServiceImpl implements ContentService {
	
	private boolean status = false;

	@Autowired
	private ContentJPARepository contentJPARepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionsRepository transactionsRepository;
	


	@Override
	public Content findByTitle(String byTitle) {
		// TODO Auto-generated method stub
		return contentJPARepository.findByTitle(byTitle);
	}
	
	

	@Override
	public Content findByContentId(Integer id) {
		return contentJPARepository.findByContentId(id);
	}

	@Override
	public void save(Content content) {
//		
//		 String message = "Added-"+content.getTitle();
//	        transactionsUpdate(message ,content);
	
		contentJPARepository.save(content);
	}

	@Override
	public Iterable<Content> findAll() {
		return contentJPARepository.findAll();
	}

	@Override
	public Optional<Content> findById(Integer id) {
		return contentJPARepository.findById(id);
	}



	@Override
	public String addMetaData(String title, ContentModel contentModel) {
		System.out.println("Hekfiuwgliagvi"+contentModel.getPoster_URL());
	Content getId = contentJPARepository.findByTitle(title);
	Content content = contentJPARepository.findByContentId(getId.getContentId());
	content.setPoster_URL(content.getPoster_URL());
	if (content.getTitle() != null){
		  content.setTitle(contentModel.getTitle());
    	  }
        if (content.getServer_IP() != null) {
            content.setServer_IP(contentModel.getServer_IP());
        }
        if (content.getPoster_URL() != null) {
            content.setPoster_URL(contentModel.getPoster_URL());
        }
     
        if (content.getDescription() != null) {
            content.setDescription(contentModel.getDescription());
        }
        
        if (content.getType() != null) {
            content.setType(contentModel.getType());
        }
        
        if (content.getCast_and_Crew() != null) {
            content.setCast_and_Crew(contentModel.getCast_and_Crew());
        }
        
        if (content.getVideo_Size() != null) {
            content.setVideo_Size(contentModel.getVideo_Size());
        }
        
        if (content.getDuration() != null) {
            content.setDuration(contentModel.getDuration());
        }
        
        if (content.getCategory() != null) {
            content.setCategory(contentModel.getCategory());
        }
        if (content.isStatus() != status) {
            content.setStatus(contentModel.isStatus());
        }
        contentJPARepository.save(content);
        
        return "updated successfully";
	}



	@Override
	public String addMetaDataById(Integer id, ContentModel content) {
		boolean status = false;
		 Optional<Content> existing = contentJPARepository.findById(id);
		 if(content != null) {
			
			 
		 if (content.getTitle() != null){
	            existing.get().setTitle(content.getTitle());
	        }
	        
	        if (content.getServer_IP() != null) {
	            existing.get().setServer_IP(content.getServer_IP());
	        }
	        
	     
	        if (content.getDescription() != null) {
	            existing.get().setDescription(content.getDescription());
	        }
	        
	        if (content.getType() != null) {
	            existing.get().setType(content.getType());
	        }
	        
	        if (content.getCast_and_Crew() != null) {
	            existing.get().setCast_and_Crew(content.getCast_and_Crew());
	        }
	        
	        if (content.getVideo_Size() != null) {
	            existing.get().setVideo_Size(content.getVideo_Size());
	        }
	        
	        if (content.getDuration() != null) {
	            existing.get().setDuration(content.getDuration());
	        }
	        
	        if (content.getCategory() != null) {
	            existing.get().setCategory(content.getCategory());
	        }
	        
	        if (content.getLanguage() != null) {
	            existing.get().setLanguage(content.getLanguage());
	        }
	        if (content.isStatus() != status) {
	            existing.get().setStatus(content.isStatus());
	        }
	        contentJPARepository.save(existing.get());
	        
	        String message = "Updated-"+content.getTitle();
	        transactionsUpdate(message ,existing.get());

	        
	        return "Updated";
	       }else{
	    	   return  "Not Data Found";
	       }
	    	   
		}



	@Override
	public String deleteById(Integer id) {
		String result;
		try {
			 Optional<Content> existing = contentJPARepository.findById(id);
			String message = "Deleted-"+existing.get().getTitle();
			transactionsUpdate(message ,existing.get());
			contentJPARepository.deleteById(id);
		 result ="deleted successfully";
		}catch (Exception e) {
			result = e.toString();
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public void transactionsUpdate(String message ,Content content ) {
		
		TransactionHistory transactions = new TransactionHistory();
		transactions.setcId(content.getContentId());
		transactions.setModifiedClass(message);
		transactions.setUpdatedAt(content.getUpdatedAt());
		Optional<User> user = userRepository.findById(content.getUpdatedBy());
		transactions.setUpdatedBy(user.get().getName());
		transactionsRepository.save(transactions);
		
	}




}
