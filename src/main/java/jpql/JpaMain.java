package jpql;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        //엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //엔티티 매니저는 쓰레드간에 공유X(사용하고 버려야된다)
        EntityManager em = emf.createEntityManager();

        //!! JPA의 모든 데이터 변경은 트랜잭션 안에서 실행

        //jpa는 트랜잭션이 매우 중요함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);

//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
            //리스트를 반환할 때는 getResultList()
            //결과가 없으면 빈 리스트 반환(NullPointException 걱정 안해도됨)
//            List<Member> resultList = query1.getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }


//            TypedQuery<Member> query2 = em.createQuery("select m from Member m where m.age = 10", Member.class);
//            //반환 값이 한개일 때는 getSingleResult()
//            //결과가 없어도, 결과가 둘 이상이어도 Exception 발생 -> 무조건 결과가 정확히 하나, 단일 객체 반환일 때만 사용 가능
//            //Spring Data JPA -> 결과가 없을 때 터지는 Exception을 방지하고자 null or optional로 반환한다(Exception 안 터짐)
//            Member singleResult = query2.getSingleResult();
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
//            Query query3 = em.createQuery("select m.username, m.age from Member m");


            //TypedQuery<Member> query2 = em.createQuery("select m from Member m where m.username = :username", Member.class);
            //query2.setParameter("username", "member1");
            //Member singleResult = query2.getSingleResult();
            // ->
//            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//            System.out.println("result = " + result.getUsername());




//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            MemberDTO memberDTO = result.get(0);
//            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
//            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());





//            for (int i = 0; i < 100; i++) {
//                Member member = new Member();
//                member.setUsername("member" + i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
//
//
//            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            System.out.println("result.size() = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }






//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("teamA");
//            member.setAge(10);
//            member.changeTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            //inner join
//            String query = "select m from Member m inner join m.team t";

            //outer join(outer 생략 가능)
//            String query = "select m from Member m left outer join m.team t";
            
            //세타조인(막조인)
//            String query = "select m from Member m, Team t where m.username = t.name";
            
            //조인 대상 필터링
//            String query = "select m from Member m left join m.team t on t.name = 'teamA'";
            
            //연관관계 없는 엔티티 외부 조인(left 빼면 내부조인)
//            String query = "select m from Member m left join Team t on m.username = t.name";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//            System.out.println("result = " + result);
//            for (Member member1 : result) {
//                System.out.println("member1.getUsername() = " + member1.getUsername());
//                System.out.println("member1.getTeam().getName() = " + member1.getTeam().getName());
//            }


            

            //jpql은 select에서 서브쿼리는 가능하나, from에서 서브쿼리는 불가능(조인으로 풀 수 있으면 풀어서 해결)
//            String query = "select (select avg(m1.age) from Member m1) as avgAge from Member m left join Team t on m.username = t.name";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//            System.out.println(result.size());







//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("teamA");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//            member.changeTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            //JPQL 타입 표현
////            String query = "select m.username, 'HELLO', true From Member m";
//
//            //Enum class 표현
////            String query = "select m.username, 'HELLO', true From Member m " +
////                           "where m.type = jpql.MemberType.USER";
//
//            //Enum class 파라미터
//            String query = "select m.username, 'HELLO', true From Member m " +
//                    "where m.type = :userType";
//            List<Object[]> result = em.createQuery(query)
//                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : result) {
//                System.out.println("objects[0] = " + objects[0]);
//                System.out.println("objects[1] = " + objects[1]);
//                System.out.println("objects[2] = " + objects[2]);
//            }








//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//            member.changeTeam(team);
//
//            Member member1 = new Member();
//            member1.setUsername(null);
//            member1.setAge(20);
//            member1.setType(MemberType.USER);
//            member1.changeTeam(team);
//
//            em.persist(member);
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
            
            //case문
//            String query = "select "
//                         + "case when m.age <= 10 then '학생요금'"
//                         + "     when m.age >= 60 then '경로요금'"
//                         + "     else '일반요금'"
//                         + " end"
//                         + " from Member m";
//            List<String> result = em.createQuery(query, String.class).getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }
            
            //coalesce : 하나씩 조회해서 null이 아니면 반환
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m";
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            //nullif : 두 값이 같으면 null 반환, 다르면 첫번째 값 반환
//            String query = "select nullif(m.username, 'member') from Member m";
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }






//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//            member.changeTeam(team);
//
//            Member member1 = new Member();
//            member1.setUsername("관리자");
//            member1.setAge(20);
//            member1.setType(MemberType.USER);
//            member1.changeTeam(team);
//
//            em.persist(member);
//            em.persist(member1);
//
//            em.flush();
//            em.clear();

            //concat
//            String query = "select concat('a', 'b') from Member m";
//            String query = "select 'a' || 'b' from Member m";
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            //substring
//            String query = "select substring(m.username, 2, 3) from Member m";
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            //locate
//            String query = "select locate('de', 'abcdefg') from Member m";
//            List<Integer> result = em.createQuery(query, Integer.class).getResultList();
//            for (int s : result) {
//                System.out.println("s = " + s);
//            }

            //size
//            String query = "select size(t.members) from Team t";
//            List<Integer> result = em.createQuery(query, Integer.class).getResultList();
//            for (int s : result) {
//                System.out.println("s = " + s);
//            }


            //group_concat(하이버네이트 함수)
//            String query = "select function('group_concat', m.username) from Member m";
//            String query = "select group_concat(m.username) from Member m";
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }






//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//            member.changeTeam(team);
//
//            Member member1 = new Member();
//            member1.setUsername("관리자");
//            member1.setAge(20);
//            member1.setType(MemberType.USER);
//            member1.changeTeam(team);
//
//            em.persist(member);
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
  
              //단일 값 연관 경로
//            String query = "select m.team from Member m"; //묵시적 내부조인(inner join) 발생, 추가 탐색 O
//                                                          // -> 성능에 영향이 있기때문에 묵시적 내부조인 일어나게 쿼리를 짜면 안됨
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }


            //컬렉션 값 연관 경로
//            String query = "select t.members from Team t"; //묵시적 내부조인 발생, 추가 탐색 X
//            List<List> result = em.createQuery(query, List.class).getResultList();
//            for (List list : result) {
//                System.out.println("list = " + list);
//            }
//            Collection result = em.createQuery(query, Collection.class).getResultList();
//            System.out.println("result = " + result);
//            for (Object o : result) {
//                System.out.println("o = " + o);
//            }
            
            //-> 해결방법(묵시적 조인을 쓰면 안되고 무조건 명시적 조인을 쓸 것)
//            String query = "select m.username from Team t join t.members m"; //from 절에서 명시적 조인을 통해 별칭을 얻으면 추가 탐색 가능
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }






            Team team1 = new Team();
            team1.setName("teamA");
            em.persist(team1);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Team team3 = new Team();
            team3.setName("teamC");
            em.persist(team3);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.changeTeam(team1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.changeTeam(team1);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.changeTeam(team2);

            Member member4 = new Member();
            member4.setUsername("회원4");


            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);

            em.flush();
            em.clear();
            
            //패치 조인(FetchType.LAZY여도 즉시 조인문 쿼리가 날아감)
//            String query = "select m from Member m join fetch m.team";
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//            for (Member member : result) {
//                System.out.println("member = " + member);
//                System.out.println("member.getUsername() = " + member.getUsername());
//                System.out.println("member.getTeam().getName() = " + member.getTeam().getName());
//            }
            
            //컬렉션 패치 조인(일대다 관계, 컬렉션 패치 조인) : 데이터가 뻥튀기 될 수도 있다.(로컬에선 안되고 있음)
//            String query = "select t from Team t join fetch t.members";
//            List<Team> result = em.createQuery(query, Team.class).getResultList();
//            for (Team team : result) {
//                System.out.println("team.getName() = " + team.getName() + " || " + team.getMembers().size());
//                for(Member member : team.getMembers()) {
//                    System.out.println("-> member.getUsername() = " + member.getUsername());
//                }
//            }

            //컬렉션 패치 조인(일대다 관계, 컬렉션 패치 조인) : 별칭을 안주는게 좋다
            // -> distinct(db에선 완전 똑같은 row일 때만 적용) 추가
            // -> 그러나 jpa가 어플리케이션 단계에서 한번 더 걸러준다(jpa distinct)
//            String query = "select distinct t from Team t join fetch t.members";
//            List<Team> result = em.createQuery(query, Team.class).getResultList();
//            for (Team team : result) {
//                System.out.println("team.getName() = " + team.getName() + " || " + team.getMembers().size());
//                for(Member member : team.getMembers()) {
//                    System.out.println("-> member.getUsername() = " + member.getUsername());
//                }
//            }

            //컬렉션 패치 조인 페이징 -> 실제 페이징 쿼리가 나가지않는다 -> 쓰면 안된다
            //100만건이면 100만건 다 조회 후 페이징하므로 문제 생김
            //일대일, 다대일 같은 단일 값 연관 필드들은 페치조인해도 페이징 가능
//            String query = "select t from Team t join fetch t.members";
//            List<Team> result = em.createQuery(query, Team.class)
//                    .setFirstResult(0)
//                    .setMaxResults(1)
//                    .getResultList();
//            for (Team team : result) {
//                System.out.println("team.getName() = " + team.getName() + " || " + team.getMembers().size());
//                for(Member member : team.getMembers()) {
//                    System.out.println("-> member.getUsername() = " + member.getUsername());
//                }
//            }


            //컬렉션 페치 조인 해결
            //지연로딩 때문에 쿼리가 따로따로 나가는 부분을 @BatchSize로 해결 가능
//            String query = "select t from Team t";
//            List<Team> result = em.createQuery(query, Team.class)
//                    .setFirstResult(0)
//                    .setMaxResults(2)
//                    .getResultList();
//            System.out.println("result.size() = " + result.size());
//
//            for (Team team : result) {
//                System.out.println("team.getName() = " + team.getName() + " || " + team.getMembers().size());
//                for(Member member : team.getMembers()) {
//                    System.out.println("-> member.getUsername() = " + member.getUsername());
//                }
//            }


            //엔티티 직접 사용
//            String query = "select m from Member m where m = :member";
//            Member findMember = em.createQuery(query, Member.class)
//                    .setParameter("member", member1)
//                    .getSingleResult();

//            String query = "select m from Member m where m.id = :memberId";
//            Member findMember = em.createQuery(query, Member.class)
//                    .setParameter("memberId", member1.getId())
//                    .getSingleResult();

            //엔티티 직접 사용 - 외래 키 값
            String query = "select m from Member m where m.team = :team";
            List<Member> result = em.createQuery(query, Member.class)
                    .setParameter("team", team1)
                    .getResultList();

            System.out.println("result = " + result);




            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
