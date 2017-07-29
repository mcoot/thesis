package conf;

import jif.util.HashMap;

/**
 * A system to handle the submission, approval and session allocation of papers
 to a conference
 */
public class ConferenceSystem {
    public Organiser organiser;
    public jif.lang.Label AL;
    private boolean allocationsVisible;
    private int numSubmissions;
    private Paper[] submissions;
    private HashMap allocations;
    
    public ConferenceSystem conf$ConferenceSystem$() {
        this.jif$init();
        {
            this.organiser = new Organiser().conf$Organiser$("TheOrganiser");
            this.submissions = (new Paper[5]);
            this.numSubmissions = 0;
            this.allocations = new HashMap(this.AL,
                                           this.AL).jif$util$HashMap$();
        }
        return this;
    }
    
    /**
     * Upgrade a paper's policy such that its authors may only be viewed under
     the double-blind conditions
     */
    public void handleSubmission(final Paper paper) {
        try {
            if (!this.allocationsVisible) {
                this.submissions[this.numSubmissions] = paper;
                this.numSubmissions++;
                if (this.numSubmissions >= this.submissions.length) {
                    Paper[] newSubmissions = new Paper[this.numSubmissions * 2];
                    for (int i = 0; i < this.submissions.length; ++i) {
                        newSubmissions[i] = this.submissions[i];
                    }
                    this.submissions = newSubmissions;
                }
            }
        }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        catch (final NegativeArraySizeException ex) {  }
        catch (final NullPointerException ex) {  }
    }
    
    public Paper[] getSubmissions() {
        try { return (Paper[]) this.submissions.clone(); }
        catch (final NullPointerException ex) { return new Paper[2]; }
    }
    
    public int getSessionNumber(final Paper paper) {
        try {
            if (this.allocationsVisible) {
                jif.lang.JifInteger sNo =
                  jif.lang.JifInteger.jif$cast$jif_lang_JifInteger(
                                        this.AL, this.allocations.get(paper));
                return sNo.intValue();
            } else {
                return -1;
            }
        }
        catch (final NullPointerException ex) { return -1; }
        catch (final ClassCastException ex) { return -1; }
    }
    
    public void performAllocations() {
        try {
            for (int i = 0; i < this.numSubmissions; ++i) {
                this.allocations.put(
                                   this.submissions[i],
                                   new jif.lang.JifInteger(
                                     this.AL).jif$lang$JifInteger$(i));
            }
        }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        catch (final NullPointerException ex) {  }
    }
    
    public void setAllocationsVisible() { this.allocationsVisible = true; }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1501301140980L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "zqP80ModiyKF312Z/a4KO/j8PxkHXrreRgAA");
    
    public ConferenceSystem(final jif.lang.Principal jif$O) {
        super();
        this.jif$conf_ConferenceSystem_O = jif$O;
    }
    
    public void jif$invokeDefConstructor() { this.conf$ConferenceSystem$(); }
    
    private void jif$init() {
        AL =
          jif.lang.LabelUtil.singleton().
            toLabel(
              jif.lang.LabelUtil.singleton(
                                   ).readerPolicy(
                                       this.jif$conf_ConferenceSystem_O,
                                       jif.lang.PrincipalUtil.topPrincipal()),
              jif.lang.LabelUtil.singleton().topInteg());
    }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$O,
                                         final Object o) {
        if (o instanceof ConferenceSystem) {
            ConferenceSystem c = (ConferenceSystem) o;
            return jif.lang.PrincipalUtil.equivalentTo(
                                            c.jif$conf_ConferenceSystem_O,
                                            jif$O);
        }
        return false;
    }
    
    public static ConferenceSystem jif$cast$conf_ConferenceSystem(
      final jif.lang.Principal jif$O, final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$O, o)) return (ConferenceSystem) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Principal jif$conf_ConferenceSystem_O;
    public static final String jlc$CompilerVersion$jl = "2.7.1";
    public static final long jlc$SourceLastModified$jl = 1501301140980L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM17e8z02Fnf7Leb3WSTbDahCSE3PpIl3WWStWc89oyzpWLG" +
       "Ht/Gt/FtxiZh4/H9fh/bQ1MBFYQWSgssl0pA/0krikJQUVFFERKqKAVBW4EQ" +
       "pJUKCCEVClGhaukfLaWeed/v/u7X5A8Qr+Rzzutze57n/J7L0Tz+7BdGb6jK" +
       "0e08i3svzuqX6z53qpdFs6wcG4vNqlKGF69a3zcGXvuBb3j+J58cvc0YvS1I" +
       "5dqsAwvL0trpamP0lsRJDk5ZLW3bsY3R21PHsWWnDMw4OA0Ds9QYvaMKvNSs" +
       "m9KpJKfK4uN54DuqJnfKy553XrKjt1hZWtVlY9VZWdWj59nQPJpAUwcxwAZV" +
       "/Qo7etoNnNiuitHfHj3Bjt7gxqY3DHwXe4cL4LIiQJzfD8OfDQYyS9e0nDtT" +
       "noqC1K5HX/nwjLscv7AZBgxTn0mc2s/ubvVUag4vRu+4Iik2Uw+Q6zJIvWHo" +
       "G7Jm2KUeved1Fx0GvTE3rcj0nFfr0bsfHidedQ2j3nQRy3lKPXrnw8MuK3Xl" +
       "6D0Pndl9p/UF/m981zemVHrrQrPtWPGZ/jcMkz7w0CTJcZ3SSS3nauJbvob9" +
       "fvNdP/vtt0ajYfA7Hxp8NeZf/q0/+bqPfODnfvFqzHtvGCMcQseqX7U+c3ju" +
       "V9+HvYQ+eSbjjXlWBWcoPMD55VTF655XunzA4rvurnjufPlO589Jv6B/0485" +
       "f3hr9Cw9etrK4iYZUPV2K0vyIHZK0kmd0qwdmx69yUlt7NJPj54Z2myQOldv" +
       "BdetnJoePRVfXj2dXf4fROQOS5xF9NTQDlI3u9POzdq/tLt8NBo9Mzyj9w/P" +
       "G4fnc9f1D9ajT64/9nG1ckpiWKX6OJ5ZTeKkdfVxNQ0+XvtOFVQft8zKebWq" +
       "GzsYRgz4vpb6pflqGLgfr0rr8s/Hsbudcl/VTvLy0Jv/JezRnfl8a/vEE8MR" +
       "vO9hcxAPukNlse2Ur1qvNav1n3zu1V++dVchriU0YPW8+ssPrz564onLqn/t" +
       "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" +
       "YVBgWAHw1JjPcpVEpJU62RgTOzFjdbCu");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "vq7dL+54fvoxfT9zLv5FPXrOc+qHGPrkTdSfU+n0oa1c1x/70qg/T0Gva+hL" +
       "OJZ//RgWfv5c/OxwLGcWnAv9V7kz5/e7m5j44PD4o9Fbn7mq3/LHXxoT5yn/" +
       "7br+gy/uCH75MX3/7lz8Qj16R+6U54T25b0sp3PPP3+9Y2hGo+e+57ruvjQO" +
       "zlPa67r44jj49cf0/ca5+A/16J2VUy8fyTK9iYnL5x4fPp/xte281PXo84/m" +
       "4d9+8S83Df+lj90uGrMKiiarnRev8ttvn5X59tk9BOkQwTi449738cOLL93+" +
       "xtoPqpdvNnEvvvTKp17K89c/lsvf0w8L49z7n/L8MWL/rcf0/c65+Hw9evfr" +
       "EX3TqZyd1iU3+sFTeeLn/8qdylX+8/3HEtTnY7j99c7RjF9cst9oJodP3f7a" +
       "c+elecmpu2pdMrPVOoiv/q2C1IudOktffOnlOrt0vvilzSod03ZKMRuA0r94" +
       "AcJjAomP3ETS3e8K7m0wuPu7b1986aUbpz2Wk5xOa8cbpr70yifk2zchkHwQ" +
       "gc/chMDfeywCf/8xff/1XPxuPXrjnfO5CXGXzd//KOJ+7q8a4q7yQm9fm4Pr" +
       "hPML9O6k6Wbui19/yTx+7AFf4fI8b0DC9XDzaD48/irN9mpw9gliQHbg3n4x" +
       "ux3c3ez2w8Sf0f/wu9vWoAIvPjIye+X2VRLx7Ue/bDnD6WWnaAYFiwfJKtmL" +
       "1mPhfGFlsHDXC7pmXDmP2LubU7XPxbdefzr0II5u3Rt1Cbq7y6j//hi0XXJi" +
       "/+jqA4z7juT8lrsfc3c++Xr3HazdeXHuff9fBNX/+zFU/9m5+NN69IGLhM2q" +
       "vlnMF5q6IcJ5uOP8XdO7H/m++OorWOtzP/K2N375j6i/eZXTf+dL1afZ0Rvd" +
       "Jo7v/1LnvvbTeem4wYW4p6++27mI5JxE/dSZtnP7Vn7F3f8DNBnOceE8AAA=");
}
