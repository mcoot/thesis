package conf;

public class Main {

    private static ConferenceSystem conferenceSystem;

    private static Paper[] papers;

    public static void main(String[] args) {
        System.out.println("Conference system" +
                         "\n-----------------\n");

        System.out.println("Initialising system...");
        setupDummyData();

        System.out.println("Performing session allocations [secret]");

        // Perform the allocations
        conferenceSystem.performAllocations();

        System.out.println();

        // Allocations to sessions have been made, but are not visible to authors yet!
        System.out.println("Allocations completed [secret]: attempting to retrieve session numbers:");

        // Attempt to print out allocations (should return consistent default value of -1)
        printAllocations();

        System.out.println();

        // Mark allocations as visible (i.e. notification date expired)
        conferenceSystem.setAllocationsVisible();

        System.out.println("Allocations made public: attempting to retrieve session numbers:");

        // Print out allocations again (now available)
        printAllocations();

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
        papers = new Paper[3];
        papers[0] = new Paper("A Paper We Did Together", "We all did it :3", allAuthors);
        papers[1] = new Paper("An Excellent Paper", "Truly excellent", authorsABC);
        papers[2] = new Paper("A Terrible Paper", "This paper is bad", authorsDE);

        conferenceSystem.handleSubmission(papers[0]);
        conferenceSystem.handleSubmission(papers[1]);
        conferenceSystem.handleSubmission(papers[2]);
    }

    private static void printAllocations() {
        for (int i = 0; i < papers.length; ++i) {
            int sessionNumber = conferenceSystem.getSessionNumber(papers[i]);
            System.out.println("Session number for \"" + papers[i].getTitle() + "\": " + sessionNumber);
        }
    }

}
