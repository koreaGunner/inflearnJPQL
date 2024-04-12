package jpql;

import jakarta.persistence.*;

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

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

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


            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList();

            MemberDTO memberDTO = result.get(0);
            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());
            

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