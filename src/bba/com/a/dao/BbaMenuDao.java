package bba.com.a.dao;

import java.util.List;

import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_MenuDto;
import bba.com.a.model.Bb_SideDto;

public interface BbaMenuDao {

	/*--------------------------------------------------------------------------------------------
	 *menu리스트가져오기 
	 *-------------------------------------------------------------------------------------------*/
	
	public List<Bb_MenuDto> getMenuList();
	

	/*--------------------------------------------------------------------------------------------
	 *menu 디테일 사이드 가져오기 
	 *-------------------------------------------------------------------------------------------*/
	
	public Bb_SideDto getDetailSide(int seq);
	

	/*--------------------------------------------------------------------------------------------
	 *menu 디테일 음료 가져오기 
	 *-------------------------------------------------------------------------------------------*/
	
	public Bb_BeverageDto getDetailBeverage(int seq);
	
	/*--------------------------------------------------------------------------------------------
	 *menu 디테일 음료 가져오기 
	 *-------------------------------------------------------------------------------------------*/
	
	public void deleteMenu(int seq);
	
}
