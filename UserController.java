package jp.co.internous.deneb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.internous.deneb.model.domain.MstUser;
import jp.co.internous.deneb.model.form.UserForm;
import jp.co.internous.deneb.model.mapper.MstUserMapper;
import jp.co.internous.deneb.model.session.LoginSession;

@Controller
@RequestMapping("/deneb/user")
public class UserController {
	
	@Autowired
	private MstUserMapper userMapper;
	
	////ログイン情報保持
	@Autowired
	private LoginSession loginSession;
		
	//セッション情報をregister_userに渡す
	//modelでユーザー側の画面に表示
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("loginSession",loginSession);
		return "register_user";
	}
		
	//名前重複確認ボタン押下でdialog_duplicated_user_name.htmlにuserNameを送る。
	@RequestMapping("/duplicatedUserName")
	@ResponseBody
	public boolean duplicatedUserName(@RequestParam String userName) {
		int count = userMapper.findCountByUserName(userName);
		return count > 0;
	}
	
	//確認ボタン押下後でDBに情報を送る。
	@RequestMapping("/register")
	@ResponseBody
	public boolean register(@RequestBody UserForm f) {
		MstUser user = new MstUser(f);
		
		int count = userMapper.insert(user);
		
		return count > 0;
	}
}
