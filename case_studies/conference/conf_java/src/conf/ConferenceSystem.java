package conf;

import java.util.HashMap;
import java.util.Map;

/**
 * A system to handle the submission, approval and session allocation of papers to a conference
 */
public class ConferenceSystem {

    private boolean allocationsMade;

    private int numSubmissions;
    private Paper[] submissions;

    // The allocation of accepted papers to allocations
    private Map<Paper, Integer> allocations;

    public ConferenceSystem() {
        submissions = new Paper[5];
        numSubmissions = 0;

        allocationsMade = false;

        allocations = new HashMap<>();
    }

    public void handleSubmission(Paper paper) {
        // Can't submit after the conference sessions are already allocated
        if (allocationsMade) return;

        submissions[numSubmissions] = paper;
        numSubmissions++;

        // Resize array if required
        if (numSubmissions >= submissions.length) {
            Paper[] newSubmissions = new Paper[numSubmissions * 2];
            for (int i = 0; i < submissions.length; ++i) {
                newSubmissions[i] = submissions[i];
            }
            submissions = newSubmissions;
        }
    }

    public int getSessionNumber(Paper paper) {
        if (allocationsMade) {
            return allocations.get(paper);
        } else {
            return -1;
        }
    }

    public void performAllocations() {
        // ...
    }

}
