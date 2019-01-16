package Translate;


//Imports the Google Cloud client library
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class translator {
	public static void main(String... args) throws Exception {
		// Instantiates a client
		Translate translate = TranslateOptions.getDefaultInstance().getService();
		// The text to translate
		String text = "Hello, my name";
		// Translates some text into Russian
		Translation translation = translate.translate(text, TranslateOption.sourceLanguage("en"),
				TranslateOption.targetLanguage("es"));

		System.out.printf("Text: %s%n", text);
		System.out.printf("Translation: %s%n", translation.getTranslatedText());
	}
}
