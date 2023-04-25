package com.goodee.controller;

import java.util.ArrayList;

import com.goodee.model.dao.MemberDao;
import com.goodee.model.vo.Member;
import com.goodee.view.MainMenu;

public class MemberController {

/*
 * Controller : view를 통해서 사용자가 요청한 기능에 대해 처리를 담당.
 *              해당 메소드로 전달된 데이터를 [가공처리한 후] DAO 메소드 호출 전달.
 *              반환된 데이터를 전달할 응답화면 결정(view 호출) 
 */

	
	/*
	 * 회원 추가 요청을 처리하는 메서드 
	 */
	public void insertMember(String userId,String userPwd,String userName,
			                 String gender,String age,String email,
			                 String phone, String address,String hobby) {
		
		Member m = new Member(userId,userPwd,userName,gender,Integer.parseInt(age)
				                ,email,phone,address,hobby);
		
		int result = new MemberDao().insertMember(m);
		
		if(result > 0) { //성공
			new MainMenu().displaySuccess("성공적으로 회원 추가되었습니다.");
		}else {
			new MainMenu().displayFail("회원 추가에 실패했습니다.");
		}
	}
	
	/*
	 * 회원전체 조회요청을 처리하는 메서드 
	 */

	public void selectList() {
		ArrayList<Member> list = new MemberDao().selectList();
		
		if(list.isEmpty()) { // 리스트가 비어있을 경우 => 조회된 결과 없음.
			new MainMenu().displayNoData("조회 결과 데이터가 없습니다.");
		} else {
			new MainMenu().displayMemberList(list);
		}
	}
	
	/*
	 * 회원아이디로 검색요청을 처리하는 메서드
	 * @param : userId : 사용자가 
	 */

	public void selectById(String userId) {
		Member m = new MemberDao (). selectByUserId(userId);
		
		if(m == null) {
			new MainMenu().displayNoData(userId+"에 대한 조회결과가 없습니다.");
		}else {
			new MainMenu().displayMember(m);
		}
		
	}









}