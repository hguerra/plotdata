package br.inpe.ccst.eba.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.inpe.ccst.eba.AbstractTest;
import br.inpe.ccst.eba.domain.impl.Species;

public class SpeciesRepositoryTest extends AbstractTest {
	
	@Autowired
	private SpeciesRepository repository;

	@Test
	public void shouldRepositoryNotBeNull() {
		assertThat(this.repository, is(not(nullValue())));
	}
	
	@Test
	public void findByNameLike() {
		List<String> options = this.repository.findByNameLike("anna");
		
		assertThat(options.size(), is(equalTo(2)));
		assertThat(options.get(0), is(equalTo("antrocaryon nannanii")));
		assertThat(options.get(1), is(equalTo("stereospermum annamense")));
	}
	
	@Test
	public void shouldFindByName() {
		Species findByName = this.repository.findByName("antrocaryon nannanii");
		
		assertThat(findByName.getId(), is(not(nullValue())));
	}
	
	
}
