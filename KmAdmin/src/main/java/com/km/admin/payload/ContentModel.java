package com.km.admin.payload;

public class ContentModel {
	
	
	private Integer contentId;
	private String title;
	private String server_IP;
	private String video_URL;
	private String poster_URL;
	private String description;
	private String type;
	private String cast_and_Crew;
	private String video_Size;
	private String duration;
	private String uploaded_By;
	private String category;
	private String language;
	private boolean status;
	
	
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
	public String getUploaded_By() {
		return uploaded_By;
	}
	public void setUploaded_By(String uploaded_By) {
		this.uploaded_By = uploaded_By;
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
		return "ContentModel [contentId=" + contentId + ", title=" + title + ", server_IP=" + server_IP + ", video_URL="
				+ video_URL + ", poster_URL=" + poster_URL + ", description=" + description + ", type=" + type
				+ ", cast_and_Crew=" + cast_and_Crew + ", video_Size=" + video_Size + ", duration=" + duration
				+ ", uploaded_By=" + uploaded_By + ", category=" + category + ", language=" + language + ", status="
				+ status + "]";
	}
	
	
	
	

}
