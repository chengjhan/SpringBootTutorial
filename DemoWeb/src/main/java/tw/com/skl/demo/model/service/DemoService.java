package tw.com.skl.demo.model.service;

import java.util.List;

import tw.com.skl.demo.model.entity.Demo;

public interface DemoService {

	Demo selectById(String id);

	List<Demo> list();

	Demo add(Demo demoEntity);

	Demo edit(Demo demoEntity);

	void delete(String id);

	Demo transactionDemo(Demo demoEntity);

}
