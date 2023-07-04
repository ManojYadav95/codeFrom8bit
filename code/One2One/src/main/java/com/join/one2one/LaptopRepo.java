package com.join.one2one;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LaptopRepo extends JpaRepository<Laptop,Long>
{

}
