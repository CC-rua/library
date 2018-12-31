package cn.edu.hqu.library.repository;


import cn.edu.hqu.library.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String > {

    int countAllById(String id);

}
