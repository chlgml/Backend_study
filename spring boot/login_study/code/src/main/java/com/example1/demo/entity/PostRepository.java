package com.example1.demo.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // DAO 클래스에서 쓰인다. 해당 클래스를 bean으로 등록. @Component의 구체화 형태
// DAO : 데이터메이스에 접근하는 객체를 말함.
// bean : Spring Container에서 생성되는 객체
// @Component : 개발자가 직접 작성한 클래스를 bean으로 등혹하기 위한 것
// 루트 컨테이너 : 어플리케이션(프로젝트 단위)에 딱 하나만 생기는 최상위 부모 컨테이너 => 클래스가 빈에 등혹되면 컨테이너가 객체를 관리 해줌
public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAllBy();
}
