import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class MyTranslator {
	Translate translate;
	Translation translation;
	public MyTranslator() {
		translate = TranslateOptions.getDefaultInstance().getService();
		
	}
	public String translateThis(String text,String fromCode,String toCode) {
		translation = translate.translate(text, TranslateOption.sourceLanguage(fromCode),
				TranslateOption.targetLanguage(toCode));
		return translation.getTranslatedText();
	}
}
