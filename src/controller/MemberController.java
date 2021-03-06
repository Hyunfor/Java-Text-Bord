package controller;

import infra.Container;
import infra.Request;
import service.MemberService;

import static infra.Container.sc;

public class MemberController implements Controller{

    private MemberService memberService;

    public MemberController(){

        this.memberService = Container.memberService;

    }

    // /members/join
    @Override
    public void execute(Request request) {

        switch (request.getTarget()){
            case "join":
                saveMember();
                break;
            default:
                System.out.println("올바른 요청을 보내주시기 바랍니다.");
                break;
        }
    }

    private void saveMember() {

        System.out.println("=== 회원가입 ===");

        System.out.println("아이디 : ");
        String loginId = sc.nextLine().trim();

        System.out.println("비밀번호 : ");
        String password = sc.nextLine().trim();

        System.out.println("이름 : ");
        String name = sc.nextLine().trim();

        int memberId = memberService.saveMember(loginId, password, name);
        System.out.println(memberId + "번째 회원님 환영합니다.");

    }


}
