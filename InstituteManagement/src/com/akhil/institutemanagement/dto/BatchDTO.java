package com.akhil.institutemanagement.dto;

public class BatchDTO {
	String batchName;
	String instructorName;
	String batchTimingsFrom;
	String batchTimingsTo;
	String batchDays;
	String batchCode;
	String numberOfStudents;
	String batchPerformance;
	
	public String getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(String numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	public String getBatchPerformance() {
		return batchPerformance;
	}
	public void setBatchPerformance(String batchPerformance) {
		this.batchPerformance = batchPerformance;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getBatchTimingsFrom() {
		return batchTimingsFrom;
	}
	public void setBatchTimingsFrom(String batchTimingsFrom) {
		this.batchTimingsFrom = batchTimingsFrom;
	}
	public String getBatchTimingsTo() {
		return batchTimingsTo;
	}
	public void setBatchTimingsTo(String batchTimingsTo) {
		this.batchTimingsTo = batchTimingsTo;
	}
	public String getBatchDays() {
		return batchDays;
	}
	public void setBatchDays(String batchDays) {
		this.batchDays = batchDays;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
}
