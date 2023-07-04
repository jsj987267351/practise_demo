package day2023_03_19.practise25.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {

    @Update("update tb_account set money = money + #{money} where name = #{name}")
    void inMoney(@Param("name") String name, @Param("money") Double money);

    @Update("update tb_account set money = money - #{money} where name = #{name}")
    void outMoney(@Param("name") String name, @Param("money") Double money);
}