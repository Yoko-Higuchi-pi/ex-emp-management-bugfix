package jp.co.sample.emp_management.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class InsertAdministratorForm {
	/** 名前 */
	@Size(min = 1, max = 64, message = "１文字以上64文字以下を入力してください")
	@NotBlank(message = "スペースなどは無効です")
	private String name;
	/** メールアドレス */
	@Email(message = "メールアドレスが不正です")
	@NotBlank(message = "文字を入力してください")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message = "スペース等は無効です")
	@Size(min = 8, max = 24, message = "8文字未満のパスワードは無効です")
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
	
}
