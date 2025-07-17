public class Word {
    private String term;
    private String meaning;
    private String example;

    public Word(String term, String meaning, String example) {
        this.term = term;
        this.meaning = meaning;
        this.example = example;
    }

    public String getTerm() { return term; }
    public String getMeaning() { return meaning; }
    public String getExample() { return example; }

    
}
