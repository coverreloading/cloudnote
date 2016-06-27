/*
* sql:id note_name content del_or_not note_time user_id
* */

package com.cloudnote.entity;

public class ShareNote {

	private long id;
	private long userId;
	private String shareUrl;
	private String shareNoteName;
	private String shareTime;

	public String getShareTime() {
		return shareTime;
	}

	public void setShareTime(String shareTime) {
		this.shareTime = shareTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public String getShareNoteName() {
		return shareNoteName;
	}

	public void setShareNoteName(String shareNoteName) {
		this.shareNoteName = shareNoteName;
	}

	@Override
	public String toString() {
		return "ShareNote{" +
				"id=" + id +
				", userId=" + userId +
				", shareUrl='" + shareUrl + '\'' +
				", shareNoteName='" + shareNoteName + '\'' +
				", shareTime='" + shareTime + '\'' +
				'}';
	}

	
}
