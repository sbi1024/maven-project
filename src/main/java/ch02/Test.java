package ch02;

import ch02.dao.BookDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class Test {
    public static void main(String[] args) throws Exception {
        //mybatis 설정 파일을 읽고 정보는 저장하는 reader 객체 생성
        Reader reader = Resources.getResourceAsReader("config/mybatis-config-2.xml");
        // SqlSessionFactory 를 Builder 패턴으로 생성
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // SqlSession 객체를 Factory 패턴으로 생성
        SqlSession session = sqlSessionFactory.openSession();


        BookDao bookDao = session.getMapper(BookDao.class);
//        {
//            List<BookDto> bookList = bookDao.listBook();
//            for (BookDto bookDto : bookList) {
//                System.out.println(bookDto);
//            }
//        }

//        {
//            BookDto bookDto = bookDao.detailBook(1);
//            System.out.println(bookDto);
//        }


//        {
//            BookDto bookDto = new BookDto(11
//                    , "11번째 책"
//                    , "11 출판사"
//                    , "20000");
//            int count = bookDao.insertBook(bookDto);
//            System.out.println("count = " + count);
//
//            // 등록/수정/삭제 commit() 처리
//            session.commit();
//        }

//        {
//            BookDto bookDto = new BookDto(11
//                    , "11번째 책 수정"
//                    , "11 출판사 수정"
//                    , "20000");
//
//            int ret = bookDao.updateBook(bookDto);
//            System.out.println(ret);
//
//            // 등록/수정/삭제 commit() 처리
//            session.commit();
//        }

        {
            int ret = bookDao.deleteBook(11);
            System.out.println(ret);
            session.commit();
        }


        // mybatis 로 DB 연동 작업 진행
        session.close();
    }
}
