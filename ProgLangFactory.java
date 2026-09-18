abstract class ProgLangFactory {
    public abstract ProgrammingLanguage getProgLang();

    public void planWork(){
        ProgrammingLanguage progLang = getProgLang();
        progLang.work();
    }
}