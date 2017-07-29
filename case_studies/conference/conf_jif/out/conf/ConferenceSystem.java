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
        if (this.allocationsVisible) {
            int result;
            try {
                jif.lang.JifInteger sNo =
                  jif.lang.JifInteger.jif$cast$jif_lang_JifInteger(
                                        this.AL, this.allocations.get(paper));
                int toDowngrade = sNo.intValue();
                int rr = toDowngrade;
            }
            catch (final NullPointerException ex) {  }
            catch (final ClassCastException ex) {  }
            return -1;
        } else {
            return -1;
        }
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
    public static final long jlc$SourceLastModified$jif = 1501309432183L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "Yuu+MhJZu2NxLPfLqzPfiWIH7P8Az99PHEZJAAA=");
    
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
    public static final long jlc$SourceLastModified$jl = 1501309432183L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM17e+z82FXf7G83u8kmJNnQhJDnj2RJd3GyHo89Y0+2qRjb" +
       "4/HbHr9tEjYe2zO2x+O3xx5DqtIKAkWlBZZXW2ip0oqiENSqqKIIFVWUh6Ct" +
       "ihCllRoQoiptQCpVS6W2lHrm+/29v/tr8geIr+R779znued8zrnn6nvuZ39v" +
       "9LqqHN3Os+S0S7L6pfqUB9VLsltWgU8kblVpQ8Ur3vcA4Kvf9/Vv/UdPjt7i" +
       "jN4SpWrt1pFHZGkddLUzetMhOGyCslr4fuA7o+fSIPDVoIzcJOqHjlnqjN5W" +
       "RbvUrZsyqJSgypLjuePbqiYPysuadyr50Zu8LK3qsvHqrKzq0Vv52D26YFNH" +
       "CchHVf0yP3p6GwWJXxWjvzB6gh+9bpu4u6HjO/g7uwAvM4LUuX7o/mw0kFlu" +
       "XS+4M+SpfZT69ej9D4+4u+PnuaHDMPSZQ1CH2d2lnkrdoWL0tiuSEjfdgWpd" +
       "Rulu6Pq6rBlWqUfves1Jh06vz11v7+6CV+rROx/uJ181Db3ecGHLeUg9evvD" +
       "3S4zdeXoXQ/J7D5p/Z74577jG1I6vXWh2Q+85Ez/64ZB73tokBJsgzJIveBq" +
       "4Ju+hv9e9x0//a23RqOh89sf6nzV55984+9/7Yff9zO/cNXn3Tf0kTZx4NWv" +
       "eJ/ZvPnfvId4cf7kmYzX51kVnaHwwM4vUpWvW17u8gGL77g747nxpTuNP6P8" +
       "nP0XfzT4wq3Rs8zoaS9LmsOAque87JBHSVCugjQo3TrwmdEbgtQnLu3M6Jmh" +
       "zEdpcFUrbbdVUDOjp5JL1dPZ5ffAou0wxZlFTw3lKN1md8q5W4eXcpePRqNn" +
       "hm/03uF7/fB97jr//nr0yeVHP65XQUkNs1QfJzOvOQRpXX1cT6OP12FQRdXH" +
       "PbcKXqnqxo+GHgO+r7l+Kb4SR9uPV6V3+fFx4m6jeqrq4PDS0Jr/CazRnff5" +
       "Ze0TTwwieM/D5iAZdIfOEj8oX/FebfDl73/ulV+6dVchrjk0YPU8+0sPzz56" +
       "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" +
       "ZrtGwJQ5jR24WiV5Fbp7WFUMYhymUOOc");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "v9rd/wOm3Xp2mT0AAA==");
}
