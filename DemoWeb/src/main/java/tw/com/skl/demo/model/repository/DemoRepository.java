package tw.com.skl.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tw.com.skl.demo.model.entity.Demo;

@Repository
public interface DemoRepository extends JpaRepository<Demo, String> {

	// 基本的查詢、新增、修改、刪除已經由JpaRepository介面提供，不需再撰寫以下方法

//	Optional<DemoEntity> findById(String id);

//	List<DemoEntity> findAll();

//	<S extends DemoEntity> S saveAndFlush(DemoEntity demoEntity);

//	void deleteById(String id);

	@Modifying
	@Query(value = "UPDATE usr u SET u.name=:name, u.password=:password WHERE u.account=:account", nativeQuery = true)
	public int update(@Param("name") String name, @Param("password") String password, @Param("account") String account);

	@Modifying
	@Query(value = "UPDATE usr u SET u.name=:name WHERE u.account=:account", nativeQuery = true)
	public int updateName(@Param("name") String name, @Param("account") String account);

	@Modifying
	@Query(value = "UPDATE usr u SET u.password=:password WHERE u.account=:account", nativeQuery = true)
	public int updatePassword(@Param("password") String password, @Param("account") String account);

}
