package model.DTO;

public class AuthInfo {
	String userId;
	String grade;
	String userPw;
	// 알트쉬프트에스
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserId() {
		return userId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
