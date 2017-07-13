package conf;

public class Main {

    private static ConferenceSystem conferenceSystem;

    public static void main(String[] args) {
        setupDummyData();


    }

    private static void setupDummyData() {
        conferenceSystem = new ConferenceSystem();

        Author alice = new Author("Alice");
        Author bob = new Author("Bob");
        Author charles = new Author("Charles");
        Author dennis = new Author("Dennis");
        Author eve = new Author("Eve");

        Author[] allAuthors = {alice, bob, charles, dennis, eve};
        Author[] authorsABC = {alice, bob, charles};
        Author[] authorsDE = {dennis, eve};

        Paper paper1 = new Paper("A Paper We Did Together", "We all did it :3", allAuthors);
        Paper paper2 = new Paper("An Excellent Paper", "Truly excellent", authorsABC);
        Paper paper3 = new Paper("A Terrible Paper", "This paper is bad", authorsDE);

        conferenceSystem.handleSubmission(paper1);
        conferenceSystem.handleSubmission(paper2);
        conferenceSystem.handleSubmission(paper3);
    }

}
