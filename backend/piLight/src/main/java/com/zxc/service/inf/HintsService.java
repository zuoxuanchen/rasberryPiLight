package com.zxc.service.inf;


import java.util.List;

import com.zxc.model.Hints;


public interface HintsService {

	
	/**
	 * 查询今天所有的待办事项
	 * @param oldDate
	 * @return
	 */
	List<Hints> findAllHints(String oldDate);
}
