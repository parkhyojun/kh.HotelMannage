package kr.or.iei.point.controller;

import java.util.Scanner;

import kr.or.iei.point.vo.pointVo;

public class pointController {
	private pointVo [] member;
	private Scanner sc;
	private int index ;
	
	public pointController() {
		member = new pointVo[10];
		sc = new Scanner(System.in);
		index = 0;
	}
		
	
	public void main() {
		while(true) {
			System.out.println("\n====== 회원관리프로그램 ======");
			System.out.println("1. 회원 정보 등록 ");
			System.out.println("2. 전체 회원 조회 ");
			System.out.println("3. 회원 1명 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1 :
				memberInsert();
				break;
			case 2 :
				printAllMember();
				break;
			case 3 :
				printOneMember();
				break;
			case 4 :
				updateMember();
				break;
			case 5 :
				deleteMember();
				break;
			case 0 : 
				System.out.println("시스템을 종료합니다.");
				return;
			default : 
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void memberInsert() {
		System.out.println("\n====== 회원 정보 등록 ======");
		System.out.print("회원 등급 입력[sliver] : ");
			String rank = sc.next();
		System.out.print("회원 이름 입력 : ");
			String name = sc.next();
		System.out.print("회원 포인트 입력 : ");
			int point = sc.nextInt();
			
		pointVo m = new pointVo(rank, name, point);
		member[index] = m;
		index++;
		System.out.println("회원 정보 등록 완료");
	}
	
	
	
	public void printAllMember() {
		System.out.println("\n====== 전체 회원 출력 ======");
		System.out.println("등급\t이름\t포인트\t보너스");
		for(int i = 0 ; i < index ; i++) {
			System.out.println(member[i].getRank()+"\t"+member[i].getName()+"\t"+member[i].getPoint()+"\t"+(double)(member[i].getPoint())*0.02);
			
		}
	}
	public int selectName(String searchName) {
		for(int i = 0 ; i < index ; i++) {
			if(searchName.equals(member[i].getName())){
				return i;
			}
		}return -1;
	}
	
	
	
	public void printOneMember() {
		System.out.println("\n====== 회원 정보 출력 ======");
		System.out.print("조회할 회원 이름 입력 : ");
		String searchName = sc.next();
		int searchIndex = selectName(searchName);
			if(searchIndex== -1) {
				System.out.println("등록되지 않은 이름입니다.");
		}else{
			System.out.println("등급 : " + member[searchIndex].getRank());
			System.out.println("이름 : " + member[searchIndex].getName());
			System.out.println("포인트 : "+ member[searchIndex].getPoint());
			System.out.println("보너스 : " + (double)(member[searchIndex].getPoint())*0.02);
		}
	}
	
	
	
	public void updateMember() {
		System.out.println("\n====== 회원 정보 수정 ======");
		System.out.print("수정할 회원 이름 입력 : ");
		String searchName = sc.next();
		int searchIndex = selectName(searchName);
			if(searchIndex == -1) {
				System.out.println("등록되지 않은 회원입니다.");
			}else {
				System.out.print("수정할 등급 입력 : ");
				String rank = sc.next();
				System.out.print("수정할 이름 입력 : ");
				String name = sc.next();
				System.out.print("수정할 포인트 입력 :");
				int point = sc.nextInt();
				
				pointVo p = member[searchIndex];
				p.setRank(rank);
				p.setName(name);	
				p.setPoint(point);
				System.out.println("수정이 완료 되었습니다 !");
			}
	}
	
	public void deleteMember() {
		System.out.println("\n====== 회원 정보 삭제 ======");
		System.out.print("삭제 회원 이름 : ");
		String searchName = sc.next();
		int searchIndex = selectName(searchName);
			if(searchIndex == -1) {
				System.out.println("등록되지 않은 회원입니다.");
			}else {
				for(int i = searchIndex; i< index-1; i++) {
					member[i] = member[i + 1];
				}index--;
				System.out.println("삭제했습니다!");
			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
