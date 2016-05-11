package com.bugreporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Attachment")
public class BugAttachment {

	private int attachmentId;
	private Bug bug1;
	private byte[] image;
	private MultipartFile imageFile;

	public BugAttachment() {

	}

	@Id
	@GeneratedValue
	@Column(name = "Attachment_Id")
	public int getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Bug_Id")
	public Bug getBug1() {
		return bug1;
	}

	public void setBug1(Bug bug1) {
		this.bug1 = bug1;
	}

	@Column(name = "Image")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Transient
	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

}
