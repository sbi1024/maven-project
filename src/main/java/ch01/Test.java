package ch01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class Test {
    public static void main(String[] args) throws Exception {
        //mybatis 설정 파일을 읽고 정보는 저장하는 reader 객체 생성
        Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");

        // SqlSessionFactory 를 Builder 패턴으로 생성
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // SqlSession 객체를 Factory 패턴으로 생성
        SqlSession session = sqlSessionFactory.openSession();

        // mybatis 로 DB 연동 작업 진행
        session.close();
    }
}
