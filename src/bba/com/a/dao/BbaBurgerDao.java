package bba.com.a.dao;

import java.util.List;

import bba.com.a.model.Bb_IngredientDto;

public interface BbaBurgerDao {
	/*--------------------------------------------------------------------------------------------
	 *버거 만들기 위한 재료들 가져오기
	 *-------------------------------------------------------------------------------------------*/	
	public List<Bb_IngredientDto> getIngredientList();
	
	/*--------------------------------------------------------------------------------------------
	 *버거 
	 *-------------------------------------------------------------------------------------------*/	

}
