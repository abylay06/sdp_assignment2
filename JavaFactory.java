public class JavaFactory extends ProgLangFactory {
    @Override
    public ProgrammingLanguage getProgLang(){
        return new Java();
    }
}