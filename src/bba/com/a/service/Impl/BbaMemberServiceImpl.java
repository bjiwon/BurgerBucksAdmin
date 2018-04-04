package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaMemberDao;
import bba.com.a.model.Bb_AdminDto;
import bba.com.a.model.Bb_StoreDto;
import bba.com.a.service.BbaMemberSerivce;

@Service
public class BbaMemberServiceImpl implements BbaMemberSerivce {

	@Autowired
	private BbaMemberDao bbsMemberDao;
	
	/*------------------------------------------------------------------------------
	* 사원등록(브랜치매니저)
	* -----------------------------------------------------------------------------*/
	@Override
	public boolean addAdmin(Bb_AdminDto adminDto) throws Exception {
		return bbsMemberDao.addAdmin(adminDto);
	}

	/*------------------------------------------------------------------------------
	* 사원리스트 불러오기(브랜치매니저)
	* -----------------------------------------------------------------------------*/
	@Override
	public List<Bb_AdminDto> getAdminList() throws Exception {
		return bbsMemberDao.getAdminList();
	}
	
	/*------------------------------------------------------------------------------
	* 사원 id 중복체크 (브랜치매니저)
	* -----------------------------------------------------------------------------*/
	@Override
	public int getAdminID(Bb_AdminDto adminDto) {
		return bbsMemberDao.getAdminID(adminDto);
	}

	/*------------------------------------------------------------------------------
	* 사원 삭제
	* -----------------------------------------------------------------------------*/
	@Override
	public void delAdmin(int seq) {
		bbsMemberDao.deladmin(seq);
	}
	
	
	/*------------------------------------------------------------------------------
	* 사원 수정 디테일
	* -----------------------------------------------------------------------------*/
	@Override
	public Bb_AdminDto updateadmin(int seq) {
		// TODO Auto-generated method stub
		return bbsMemberDao.updateadmin(seq);
	}
	
	/*------------------------------------------------------------------------------
	* 사원 수정 버튼 클릭 후
	* -----------------------------------------------------------------------------*/
	@Override
	public void updateadminAf(Bb_AdminDto adminDto) {
		bbsMemberDao.updateadminAf(adminDto);
		
	}
	
	
	
}
