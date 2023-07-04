package com.join.usermanagementsystem1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repo1 extends JpaRepository<User1,Long>
{

}
