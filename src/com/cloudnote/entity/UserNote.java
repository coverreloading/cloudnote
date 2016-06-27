/*
* sql:id note_name content del_or_not note_time user_id
* */

package com.cloudnote.entity;

public class UserNote extends IdEntity{


	private long userId;
	private String noteName;
	private String content;
	private int delOrNot;
	private String noteTime;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getNoteName() {
		return noteName;
	}

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDelOrNot() {
		return delOrNot;
	}

	public void setDelOrNot(int delOrNot) {
		this.delOrNot = delOrNot;
	}

	public String getNoteTime() {
		return noteTime;
	}

	public void setNoteTime(String noteTime) {
		this.noteTime = noteTime;
	}

	@Override
	public String toString() {
		return "UserNote{" +
				"userId=" + userId +
				", noteName='" + noteName + '\'' +
				", content='" + content + '\'' +
				", delOrNot=" + delOrNot +
				", noteTime='" + noteTime + '\'' +
				'}';
	}





}
