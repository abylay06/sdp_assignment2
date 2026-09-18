public class PythonFactory extends ProgLangFactory {
    @Override
    public ProgrammingLanguage getProgLang(){
        return new Python();
    }
}