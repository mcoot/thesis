package conf;

import jif.util.HashMap;

/**
 * A system to handle the submission, approval and session allocation of papers
 to a conference
 */
public class ConferenceSystem {
    public Organiser organiser;
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
            this.allocations =
              new HashMap(
                jif.lang.LabelUtil.
                    singleton().
                    toLabel(
                      jif.lang.LabelUtil.
                          singleton().readerPolicy(
                                        this.jif$conf_ConferenceSystem_O,
                                        jif.lang.PrincipalUtil.topPrincipal()),
                      jif.lang.LabelUtil.singleton().topInteg()),
                jif.lang.LabelUtil.
                    singleton().
                    toLabel(
                      jif.lang.LabelUtil.
                          singleton().readerPolicy(
                                        this.jif$conf_ConferenceSystem_O,
                                        jif.lang.PrincipalUtil.topPrincipal()),
                      jif.lang.LabelUtil.singleton().topInteg())).
                jif$util$HashMap$();
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
        jif.lang.JifObject sNoObj;
        try {
            sNoObj =
              this.allocations.
                get(
                  jif.lang.LabelUtil.
                      singleton().
                      toLabel(
                        jif.lang.LabelUtil.
                            singleton().readerPolicy(
                                          this.jif$conf_ConferenceSystem_O,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )),
                        jif.lang.LabelUtil.singleton().topInteg()), paper);
        }
        catch (final NullPointerException e) { return -1; }
        jif.lang.JifObject sNoObjDeclass = sNoObj;
        jif.lang.JifInteger sNo;
        try {
            sNo =
              jif.lang.JifInteger.
                jif$cast$jif_lang_JifInteger(
                  jif.lang.LabelUtil.
                      singleton().
                      toLabel(
                        jif.lang.LabelUtil.
                            singleton().readerPolicy(
                                          this.jif$conf_ConferenceSystem_O,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )),
                        jif.lang.LabelUtil.singleton().topInteg()),
                  sNoObjDeclass);
        }
        catch (final ClassCastException ex) { return -1; }
        int r;
        try { r = sNo.intValue(); }
        catch (final NullPointerException ex) { return -1; }
        int result = r;
        return result;
    }
    
    public void performAllocations() {
        try {
            for (int i = 0; i < this.numSubmissions; ++i) {
                this.allocations.
                  put(
                    this.submissions[i],
                    new jif.lang.JifInteger(
                      jif.lang.LabelUtil.
                          singleton().
                          toLabel(
                            jif.lang.LabelUtil.
                                singleton().
                                readerPolicy(
                                  this.jif$conf_ConferenceSystem_O,
                                  jif.lang.PrincipalUtil.topPrincipal()),
                            jif.lang.LabelUtil.singleton().topInteg())).
                        jif$lang$JifInteger$(i));
            }
        }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        catch (final NullPointerException ex) {  }
    }
    
    public void setAllocationsVisible() { this.allocationsVisible = true; }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1501311901255L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAL1cC3gVRZau24GEEB4hPBJe4RICEtDEB4IYGR4BBAwk8lIC" +
       "Gjp9O0lD39uX7r4hwOCKq+D4YEZE1E9gdQdGUQRnVmZmx7ergo9x1FFBZxRX" +
       "Z2ecZZhR1+fuOk6dU9Wv6r6X4De7fF+q+lbXOVV1zl+nTp2qZv9J0t0yyfBV" +
       "Wmu1vS6tWtXztNZG2bTURKOhr1tMi5qVr+55KXHHsvRxieQ3kR6atSRlya1q" +
       "PSmUM3a7YWr2OpsU16+SO+SajK3pNfWaZdfWkyLFSFm2KWsp21pDriKxelKs" +
       "0RI5ZWuyrSZmm0bSJiPr07ShNt2wa9ROuyYtm3KyBrtS01iny5ZFOeVjqcOk" +
       "R9o0OrSEatpkRD3tOK+tyy2qXtPI39XDr9pOk8Qd9nx8bHDImY3utvE122+/" +
       "svgneaRvE+mrpRbZsq0pdUbKpv1pIr2SarJFNa3piYSaaCL9UqqaWKSamqxr" +
       "62lFI9VESiytLSXbGVO1FqqWoXdAxRIrk6ZdhDadwnrSi4kko9iG6Qwnv1VT" +
       "9YTzq3urLrdZNhnkiYUNbzaUU1n0pOJUzVZZUR2Sbqu1VAJkIVC4Y6y8hFag" +
       "pAVJlerLbapbSqYFpIRpTpdTbTWLbFNLtdGq3Y2MDQIekpVpLShCVlbLbWqz" +
       "TcrEeo3sFa1ViIIAEpsMFKshJ6qlIYKWfPo5ueCirRtSc1IS9jmhKjr0vwcl" +
       "KheIFqqtqqmmFJUR9hpXv0Me9Nj1EiG08kChMqvzs+9+PO3M8iePsDpDI+o0" +
       "tKxSFbtZ2dPS59VhdVWT8xgEDUsD5QdGjuBv5G9qO9N0Yg1yOcLLauflkwuf" +
       "W3b1/eoJifScS/IVQ88kKY76KUYyremqebGaUk2YInNJoZpK1OH7uaSAPtdr" +
       "KZWVNrS2Wqo9l3TTsSjfwN9URK2UBYiogD5rqVbDeU7Ldjs+d6YJIQX0jwyn" +
       "fz3o3wGe32GTlbMuXLHEUs3ZlIu1YqahZJIqncArlqS0FXa7amnWCkW21GbL" +
       "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");
    
    public ConferenceSystem(final jif.lang.Principal jif$O) {
        super();
        this.jif$conf_ConferenceSystem_O = jif$O;
    }
    
    public void jif$invokeDefConstructor() { this.conf$ConferenceSystem$(); }
    
    private void jif$init() {  }
    
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
    public static final long jlc$SourceLastModified$jl = 1501311901255L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM17a8zs6FnY7NlkN9mE3CAhJNnkkCxhg5P1fTzOloqxPZ7x" +
       "jMee8W1sZ8Piuz32+G6PxyEIkAoICm1pCKlEUlUNFYUQVFTaHygqVC2FQltB" +
       "q1JUUegFtVUatVQtvZd65vvO7TtnT8kPECP5fd95r8/9eV758ee+NHp1VY5u" +
       "51lyCpKsfqE+5V71wsYqK8+lE6uqlKHjZeeHAPATP/zNb/rpJ0dvNEdvjFK5" +
       "turIobO09rraHL3+4B1sr6ymruu55ujNqee5sldGVhL1w8QsNUdvqaIgteqm" +
       "9CrJq7KkPU98S9XkXnk5804nP3q9k6VVXTZOnZVVPXoTv7daC2zqKAH5qKpf" +
       "5EdP+ZGXuFUx+rbRE/zo1X5iBcPEt/F3sAAvO4LsuX+Y/kw0gFn6luPdWfKq" +
       "OErdevSemyvuYvzcapgwLH364NVhdveoV6XW0DF6yxVIiZUGoFyXURoMU1+d" +
       "NcMp9egdr7jpMOk1ueXEVuC9XI/efnPe5mpomPXaC1nOS+rRW29Ou+zUlaN3" +
       "3ODZfdz6kvAnfuBj6SK9dYHZ9ZzkDP+rh0XvvrFI8nyv9FLHu1r4+m/gP2m9" +
       "7Qvfc2s0Gia/9cbkqzl/81t/95s++O6f+8WrOe98xBzR3ntO/bLzWfsNv/ou" +
       "+gPkk2cwXpNnVXQWhQcwv3B1cz3yYpcPsvi2uzueB1+4M/hz0i8Y3/7j3hdv" +
       "jZ7hRk85WdIcBql6s5Md8ijxyrmXeqVVey43eq2XuvRlnBs9PbT5KPWuekXf" +
       "r7yaG70quXQ9lV3+DyTyhy3OJHrV0I5SP7vTzq06vLS7fDQaPT08o2eH5zXD" +
       "8/nr+lP16FtmH35JrbySHXapXmIypzl4aV29pKbRS3XoVVH1kmNV3stV3bjR" +
       "MGOQ72uqX5ov7yP/pap0Ln9eou8Oyqeq9g4vDKP5H8EZ3RnPrzg+8cTAgnfd" +
       "NAfJoDuLLHG98mXnEw01+93Pv/zLt+4qxDWFBlk97/7Czd1HTzxx2fWrzkpz" +
       "xdSBJfGg6oM2v/4D8keX3/I9731ykKb8+KqBoOepz92U7XsWgRta1rD3y84b" +
       "v/vf/d5PffLj2T0pr0fPPaR8D688K897b2JYZo7nDsbp3vbfcNv6mZe/8PHn" +
       "bp0l4bUDZrU1SM2g4O++ecYDSvTiHYN0psotfvQ6PysPVnIeumNFnqnDMjve" +
       "67mQ/nWX9ht+f/g9MTz/9/yc5e3cca4Hq0Nfy/rtu8JejzLxX33XD374D1s4" +
       "PgxD8AcR6EMIll/JyZmdN0h4sbbfKOef/mf/8N+jt86o3zHMb7zPgste/eJ9" +
       "xuC82esvav/me9KhlJ43zPvNT23+/A996bs/chGNYcb7HnXgc+fyTBhrIEhW" +
       "/qlfLH7jt/7FZ//JrXviVI+eyhs7iZwL5O8aNnr/vaMGO5EMtmqApHpOTQ+Z" +
       "G/mRZSfeWTT/9xu/Dv6Z//ADb7qSr2ToueJWOfrg/3+De/1fQ42+/Ze/+b+9" +
       "+7LNE87ZT90jx71pV8bvK+/tPC1L63SGo/uOX3v2L/w969ODGR1MVxX13sUa" +
       "PXGtLWeg3jJIx8CmF84eaZDlKHWi3EouCH/wMuHrLyVwFqTLstFlDDoX7+wu" +
       "Y2+99L+2ethHsGdne08vTPBzP/IO+k9+8YLPPb047/GO7mHboVn3qSzy44f/" +
       "euu9T/3dW6OnzdGbLn7eSmvNSpozw83BU1f0dSc/+ooHxh/0ulcu5sW7ev+u" +
       "mzp537E3NfKezRra59nn9tP3K+FAiDefiQRcNW7h1/U7z6Nvys/lm7snRpfG" +
       "+LLkPZfyvefi6674cm6+/0rk6tFrszKw0mhQ0TvsesPFVIp3uq+U6lwid0F4" +
       "/RmEDw3PW4ejP3ldN48A4RtfAYR69HReRu1gKLq7m16Y/7rrzerr+nDfpgOd" +
       "rSTJnEvYVmlRFQ3S/AipGKTsMKhwex05eN/zie/9/Rd+4BO37guv3vdQhHP/" +
       "mqsQ60KhZy5k6oZTvvZxp1xWsP/2pz7+sz/28e++Cj/e8mCwMEubw0/+0//z" +
       "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" +
       "KIG2khLCMapFsoZDYirzmyXM1NOApYgc");
    public static final String jlc$ClassType$jl$1 =
      ("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");
}
