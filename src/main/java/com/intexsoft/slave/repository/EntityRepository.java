package com.intexsoft.slave.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface EntityRepository<T> extends
		PagingAndSortingRepository<T, Long> {
//	
//	@Query("UPDATE T SET  T = entity WHERE T.ID = entity.ID")
//	T update(T entity);

}
