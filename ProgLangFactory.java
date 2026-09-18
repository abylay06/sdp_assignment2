public class ProgLangFactory {
    public ProgrammingLanguage getProgLang(String progLang){
        if (progLang.equalsIgnoreCase("python")) {
            return new Python();
        }
        else if (progLang.equalsIgnoreCase("java")) {
            return new Java();
        }
        else return null;
    }
}