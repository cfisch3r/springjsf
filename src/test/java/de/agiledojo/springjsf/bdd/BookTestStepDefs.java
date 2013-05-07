package de.agiledojo.springjsf.bdd;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Gegebensei;
import cucumber.api.java.de.Wenn;
import de.fisch3r.springdemo.jsf.controller.BookList;
import de.fisch3r.springdemo.jsf.domain.Book;

public class BookTestStepDefs {

	private BookList sut;
	
	@Gegebensei("^ich habe eine leere Buchliste$")
	public void ich_habe_eine_leere_Buchliste() throws Throwable {
		sut = new BookList();
	}

	@Wenn("^ich ein Buch hinzufüge$")
	public void ich_ein_Buch_hinzufüge() throws Throwable {
		sut.add(new Book());
	}

	@Dann("^sollte die Anzahl der Bücher in der Liste (\\d+) sein.$")
	public void sollte_die_Anzahl_der_Bücher_in_der_Liste_sein(int arg1)
			throws Throwable {
		assertThat(sut.getAll().size(), is(1));
	}
}