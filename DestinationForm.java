package jp.co.internous.deneb.model.form;

import java.io.Serializable;

public class DestinationForm implements Serializable {

	private static final long serialVersionUID = -4524273044110061094L;

	//各フィールドをセット
	private int userId;
	private String familyName;
	private String firstName;
	private String address;
	private String telNumber;
	
	//ゲッターセッターを記述
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

}
