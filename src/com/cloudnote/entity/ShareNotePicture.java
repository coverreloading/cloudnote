package com.cloudnote.entity;

/**
 * 	FileName: User.java
 *	desc: 用户实体类.
 *	sql: id user_name email password display_pic age sex phone
 */
public class ShareNotePicture {

	private long id;
	private int userNoteId;
	private String picName;
	private String picUrl;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserNoteId() {
		return userNoteId;
	}

	public void setUserNoteId(int userNoteId) {
		this.userNoteId = userNoteId;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}


	@Override
	public String toString() {
		return "UserNotePicture{" +
				"id=" + id +
				", userNoteId=" + userNoteId +
				", picName='" + picName + '\'' +
				", picUrl='" + picUrl + '\'' +
				'}';
	}

}
