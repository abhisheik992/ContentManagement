package com.km.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.km.admin.model.audit.UserDateAudit;


@Entity
@Table(name = "content_metadata")
public class Content extends UserDateAudit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7199027253501691781L;
	
		  @Id
		  @GeneratedValue(strategy=GenerationType.IDENTITY)
		  @Column(name = "content_id")
		  private Integer contentId;
		  
//		  @NotBlank(message = "Please enter title")
		  @Size(max = 40)
		  private String title;
		  
//		  @NotBlank(message = "Please enter server_IP")
		  @Size(max = 40)
		  private String server_IP;
		  
//		  @NotBlank(message = "Please enter video_URL")
		  @Size(max = 155)
		  private String video_URL;
		  
//		  @NotBlank(message = "Please enter poster_URL")
		  @Size(max = 155)
		  private String poster_URL;
		  
//		  @NotBlank(message = "Please enter description")
		  @Size(max = 255)
		  private String description;
		  
//		  @NotBlank(message = "Please enter type")
		  @Size(max = 40)
		  private String type;
		  
//		  @NotBlank(message = "Please enter castNcrew")
		  @Size(max = 40)
		  private String cast_and_Crew;
		 
//		  @NotBlank(message = "Please enter video_size")
		  @Size(max = 40)
		  private String video_Size;
		  
//		  @NotBlank(message = "Please enter duration")
		  @Size(max = 40)
		  private String duration;
		  
//		  @NotBlank(message = "Please enter category")
		  @Size(max = 40)
		  private String category;
		  
	//		  @NotBlank(message = "Please enter language")
		  @Size(max = 40)
		  private String language;
		  
		  
		  private boolean status;

		public Content() {
			super();
		}

		public Content(@NotBlank @Size(max = 40) String title, @NotBlank @Size(max = 40) String server_IP,
				@NotBlank @Size(max = 155) String video_URL, @NotBlank @Size(max = 155) String poster_URL,
				@NotBlank @Size(max = 255) String description, @NotBlank @Size(max = 40) String type,
				@NotBlank @Size(max = 40) String cast_and_Crew, @NotBlank @Size(max = 40) String video_Size,
				@NotBlank @Size(max = 40) String duration, @NotBlank @Size(max = 40) String category,
				@NotBlank @Size(max = 40) String language, boolean status) {
			super();
			this.title = title;
			this.server_IP = server_IP;
			this.video_URL = video_URL;
			this.poster_URL = poster_URL;
			this.description = description;
			this.type = type;
			this.cast_and_Crew = cast_and_Crew;
			this.video_Size = video_Size;
			this.duration = duration;
			this.category = category;
			this.language = language;
			this.status = status;
		}

		public Integer getContentId() {
			return contentId;
		}

		public void setContentId(Integer contentId) {
			this.contentId = contentId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getServer_IP() {
			return server_IP;
		}

		public void setServer_IP(String server_IP) {
			this.server_IP = server_IP;
		}

		public String getVideo_URL() {
			return video_URL;
		}

		public void setVideo_URL(String video_URL) {
			this.video_URL = video_URL;
		}

		public String getPoster_URL() {
			return poster_URL;
		}

		public void setPoster_URL(String poster_URL) {
			this.poster_URL = poster_URL;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getCast_and_Crew() {
			return cast_and_Crew;
		}

		public void setCast_and_Crew(String cast_and_Crew) {
			this.cast_and_Crew = cast_and_Crew;
		}

		public String getVideo_Size() {
			return video_Size;
		}

		public void setVideo_Size(String video_Size) {
			this.video_Size = video_Size;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Content [contentId=" + contentId + ", title=" + title + ", server_IP=" + server_IP + ", video_URL="
					+ video_URL + ", poster_URL=" + poster_URL + ", description=" + description + ", type=" + type
					+ ", cast_and_Crew=" + cast_and_Crew + ", video_Size=" + video_Size + ", duration=" + duration
					+ ", category=" + category + ", language=" + language + ", status=" + status + "]";
		}
		  
		  

}































