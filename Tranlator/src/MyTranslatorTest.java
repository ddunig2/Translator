import static org.junit.Assert.*;
import org.junit.Test;

public class MyTranslatorTest {
	MyTranslator myTranslator = new MyTranslator();;
	
	@Test
	public void testOneEnglishToSpanish() {
		assertEquals(myTranslator.translateThis("hello", "en", "es"), "Hola");
	}
	
	@Test
	public void testWordSpanishToEnglish() {
		assertEquals(myTranslator.translateThis("hola", "es", "en"), "Hello");
	}
	
	@Test
	public void testPhraseEnglishToSpanish() {
		assertEquals(myTranslator.translateThis("the love of my life", "en", "es"), "el amor de mi vida");
	}
	
	@Test
	public void testPhraseSpanishToEnglish() {
		assertEquals(myTranslator.translateThis("el amor de mi vida", "es", "en"), "the love of my life");
	}
	@Test
	public void testSentenceEnglishToSpanish() {
		assertEquals(myTranslator.translateThis("hi, how are you?", "en", "es"), "¿Hola! Cómo estás?");
	}
	
	@Test
	public void testSentenceSpanishToEnglish() {
		assertEquals(myTranslator.translateThis("¿hola! cómo te llamas?", "es", "en"), "Hello! What is your name?");
	}

}
