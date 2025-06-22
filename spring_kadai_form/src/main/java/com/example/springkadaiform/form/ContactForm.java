package com.example.springkadaiform.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContactForm {
	//お名前
	@NotBlank(message = "お名前を入力してください。")
	private String name;
	
	//メールアドレス
	@Email(message ="メールアドレスの入力形式が正しいありません。")
	@NotBlank(message = "メールアドレスを入力してください。")
	private String email;
	
	//お問い合わせ内容
	@NotBlank(message = "お問い合わせ内容を入力してください。")
	private String message;
	
}
