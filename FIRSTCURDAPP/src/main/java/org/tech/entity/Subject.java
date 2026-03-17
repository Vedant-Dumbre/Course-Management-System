package org.tech.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Subject {
	private int id;
	private String sname;
	private List<String> csVal;

	private MultipartFile pdf;
	private String pdfPath;

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public MultipartFile getPdf() {
		return pdf;
	}

	public void setPdf(MultipartFile pdf) {
		this.pdf = pdf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<String> getCsVal() {
		return csVal;
	}

	public void setCsVal(List<String> csVal) {
		this.csVal = csVal;
	}

}
