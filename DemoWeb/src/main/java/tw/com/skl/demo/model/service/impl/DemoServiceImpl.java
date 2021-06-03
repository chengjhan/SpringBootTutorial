package tw.com.skl.demo.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.skl.demo.model.entity.Demo;
import tw.com.skl.demo.model.repository.DemoRepository;
import tw.com.skl.demo.model.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoRepository demoRepository;

	@Transactional(readOnly = true)
	@Override
	public Demo selectById(String id) {

		return demoRepository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Demo> list() {

		return demoRepository.findAll();
	}

	@Transactional
	@Override
	public Demo add(Demo demoEntity) {

		demoEntity.setPermission(0);

		return demoRepository.saveAndFlush(demoEntity);
	}

	@Transactional
	@Override
	public Demo edit(Demo demoEntity) {

		Demo usrForDB = demoRepository.findById(demoEntity.getAccount()).orElse(demoEntity);

		Demo usrForEdit = new Demo();
		usrForEdit.setName("".equals(demoEntity.getName()) ? usrForDB.getName() : demoEntity.getName());
		usrForEdit.setAccount(usrForDB.getAccount());
		usrForEdit.setPassword("".equals(demoEntity.getPassword()) ? usrForDB.getPassword() : demoEntity.getPassword());
		usrForEdit.setPermission(usrForDB.getPermission());

		return demoRepository.saveAndFlush(usrForEdit);
	}

	@Transactional
	@Override
	public void delete(String id) {

		demoRepository.deleteById(id);
	}

	@Transactional
	@Override
	public Demo transactionDemo(Demo demoEntity) {

		demoRepository.updateName(demoEntity.getName(), demoEntity.getAccount());
		demoRepository.updatePassword(demoEntity.getPassword(), demoEntity.getAccount());

		return demoRepository.findById(demoEntity.getAccount()).orElse(null);
	}

}
