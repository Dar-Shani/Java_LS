package Work3;

public class Greeter {
    private final String formality;

    public Greeter(String _formality) {
        this.formality = _formality;
    }

    public String greet() {
        switch (this.formality) {
            case "formal":
                return "Good evening, sir.";
            case "casual":
                return "Sup bro?";
            case "intimate":
                return "Hello Darling!";
            default:
                return "Hello.";
        }
    }

    //public void setFormality(String formality) {
        //this.formality = formality;
    //}
}
