package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    public static void main(String[] args) throws IOException {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        //增加学生
        Student student1=new Student();
        student1.setId(5);
        student1.setStudentID(5);
        student1.setName("增加的学生");
        session.insert("AddStudent",student1);

        //删除学生
        Student student2=new Student();
        student2.setId(1);
        session.delete("DelStudent",student2);

        //修改学生
        Student student3=new Student();
        student3.setId(2);
        student3.setName("修改的学生");
        session.update("UpdateStudent",student3);

        //获取单个学生
        Student student4=new Student();
        student4.setId(2);
        session.selectOne("getStudent",student4);


        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<Student> listStudent = session.selectList("listStudent");
        for (Student student : listStudent) {
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }

        session.commit();
        session.close();
    }
}
