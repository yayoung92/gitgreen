package mini;

import java.util.Scanner;

import info.Person;
import info.User;

public class Controller {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		User user = new User();
		Person p = new Person();
		Login login = new Login();
		Search search = new Search();
		
		boolean check = true;
		int start = 0;

		System.out.println("******************************************");
		System.out.println("*             주소록 관리 프로그램             *");
		System.out.println("******************************************");
		
		while (true) {
			System.out.println("------------------------------------------");
			System.out.println(" 1. 로그인           ||  2. 회원가입      ");
			start = scan.nextInt();

			if (start == 1) {
				System.out.println("------------------------------------------");
				System.out.println("          <      로그인 하기      >          ");
				System.out.print("  ●  아이디를 입력하세요: ");
				String id = scan.next();

				System.out.print("  ●  비밀번호를 입력하세요: ");
				String password = scan.next();
				System.out.println();

				if (login.login(id, password) == 1) {

					// 로그인 성공했을 경우
					System.out.println("-----------     로그인 성공!!     -----------");
					System.out.println();
					System.out.println(">>           " + id + " 님 환영합니다!           <<");

					stop: while (check) {
						System.out.println();
						System.out.println("******************************************");
						System.out.println("*             주소록 관리 프로그램             *");
						System.out.println("******************************************");
						System.out.println();
						System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료  7.설정");
						System.out.println("------------------------------------------");
						System.out.print("> 메뉴번호 : ");
						int num = 0;
						num = scan.nextInt();
						System.out.println();

						switch (num) {
						case 1:
							System.out.println("<1.리스트>");
							// 회원 리스트 나온다.
							System.out.println();
							if (Person.getPersonName() == null) {
								System.out.println("   등록된 사람이 없습니다.  ");
							} else {
								int n = 0;
								n++;
								System.out
										.println(num + ". " + Person.getPersonName() + " : " + Person.getPhoneNumber());
							}

							break;
						case 2:
							// 등록하는 입력 창

							System.out.println("<2.등록하기>");
							System.out.println();

							System.out.print(" -  이름 : ");
							Person.setPersonName(scan.next());

							System.out.print(" -  전화번호( - 포함해서 입력해주세요) : ");
							Person.setPhoneNumber(scan.next());

							System.out.print(" -  나이 : ");
							Person.setAge(scan.nextInt());

							System.out.print(" -  생일 : ");
							Person.setDate(scan.next());

							System.out.print(" -  MBTI : ");
							Person.setMBTI(scan.next());

							System.out.print(" -  성별 : ");
							Person.setGender(scan.next());

							System.out.print(" -  별명 : ");
							Person.setStar(scan.next());

							System.out.println();
							System.out.println(p.toString());
							System.out.println();
							System.out.println(" [ 등록되었습니다. ] ");

							break;
						case 3:
							// 수정하는 부분
							System.out.println("<3.수정하기>");
							System.out.println();

							System.out.println(" 이름 수정하기 = " + Person.getPersonName() + " -> ");
							Person.setPersonName(scan.next());

							System.out.println();
							System.out.println(" [ 수정되었습니다. ] ");
							break;
						case 4:
							// 삭제하는 부분
							System.out.println("<4.삭제하기>");
							System.out.println();

							System.out.println(" [ 삭제되었습니다. ] ");
							break;
						case 5:
							// 검색하는 부분
							System.out.println("<5.검색하기>");
							System.out.println("검색어를 입력하세요 : ");
							String keyword = scan.next();
							search.searchData(keyword);
							
							break;
						case 6:
							// 종료하는 부분
							System.out.println();
							break stop;
						case 7:
							// 설정하는 부분
							System.out.println("<7.설정>");
							System.out.println();

							break;
						default:
							break;
						}
					}
					System.out.println("종료되었습니다.");

				}

			} else if(start==2) {
				System.out.println("    >>>>   회원가입  하기   <<<<   ");
				System.out.println("  ●  아이디를 입력하세요: ");
				String newId = scan.next();
				
				System.out.println("  ●  비밀번호를 입력하세요: ");
				String newPassword = scan.next();
				
				Join.join(newId, newPassword);
				
			}
		}
		// 로그인 실패했을 경우

	}
}
