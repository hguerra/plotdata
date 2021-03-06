package br.inpe.ccst.eba.plot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.net.URL;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.inpe.ccst.eba.AbstractTest;

public class SpreadsheetReaderTest extends AbstractTest {

	@Autowired
	private SpreadsheetReader reader;

	@Test
	public void shouldSpreedsheetReaderNotBeNull() {
		assertThat(reader, is(notNullValue()));
	}

	@Test
	public void shouldSpreadsheetResourceExists() {
		URL resource = this.getClass().getClassLoader().getResource(SPREADSHEET);
		assertThat(resource, is(notNullValue()));
	}

	@Test
	public void shouldLoadASpreadsheetFromDisk() {
		URL resource = this.getClass().getClassLoader().getResource(SPREADSHEET);
		Spreadsheet spreadsheets = this.reader.read(resource.getPath());
		assertThat(spreadsheets, is(notNullValue()));
		assertThat(spreadsheets.size(), is(equalTo(2847)));
	}
}
