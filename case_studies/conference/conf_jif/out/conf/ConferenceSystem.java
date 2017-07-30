package conf;

import jif.util.HashMap;

/**
 * A system to handle the submission, approval and session allocation of papers to a conference
 */
public class ConferenceSystem {
    public Organiser organiser;
    private boolean allocationsVisible;
    private int numSubmissions;
    private Paper[] submissions;
    private HashMap allocations;
    
    public ConferenceSystem conf$ConferenceSystem$() { this.jif$init();
                                                       { this.organiser = new Organiser(
                                                                            ).conf$Organiser$(
                                                                                "TheOrganiser");
                                                         this.submissions = (new Paper[5]);
                                                         this.numSubmissions = 0;
                                                         this.allocations = new HashMap(
                                                                              jif.lang.LabelUtil.
                                                                                singleton(
                                                                                  ).
                                                                                toLabel(
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    readerPolicy(
                                                                                      this.
                                                                                        jif$conf_ConferenceSystem_O,
                                                                                      jif.lang.PrincipalUtil.
                                                                                        topPrincipal(
                                                                                          )),
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    topInteg(
                                                                                      )),
                                                                              jif.lang.LabelUtil.
                                                                                singleton(
                                                                                  ).
                                                                                toLabel(
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    readerPolicy(
                                                                                      this.
                                                                                        jif$conf_ConferenceSystem_O,
                                                                                      jif.lang.PrincipalUtil.
                                                                                        topPrincipal(
                                                                                          )),
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    topInteg(
                                                                                      ))).
                                                                              jif$util$HashMap$(
                                                                                );
                                                       }
                                                       return this; }
    
    /**
     * Upgrade a paper's policy such that its authors may only be viewed under the double-blind conditions
     */
    public void handleSubmission(final Paper paper) { try { if (!this.allocationsVisible) {
                                                                this.submissions[this.
                                                                                   numSubmissions] =
                                                                  paper;
                                                                this.numSubmissions++;
                                                                if (this.numSubmissions >=
                                                                      this.submissions.
                                                                        length) {
                                                                    Paper[] newSubmissions =
                                                                      new Paper[this.
                                                                                  numSubmissions *
                                                                                  2];
                                                                    for (int i =
                                                                           0; i <
                                                                                this.
                                                                                  submissions.
                                                                                  length;
                                                                         ++i) { newSubmissions[i] =
                                                                                  this.
                                                                                    submissions[i];
                                                                    }
                                                                    this.submissions =
                                                                      newSubmissions;
                                                                } } }
                                                      catch (final ArrayIndexOutOfBoundsException ex) {
                                                           }
                                                      catch (final NegativeArraySizeException ex) {
                                                           }
                                                      catch (final NullPointerException ex) {
                                                           } }
    
    public Paper[] getSubmissions() { try { return (Paper[]) this.submissions.clone(
                                                                                );
                                      }
                                      catch (final NullPointerException ex) { return new Paper[2];
                                      } }
    
    public int getSessionNumber(final Paper paper) { if (this.allocationsVisible) {
                                                         return this.declassifySessionNumber(
                                                                       paper); }
                                                     else { return -1; } }
    
    private int declassifySessionNumber(final Paper paper) { jif.lang.JifObject sNoObj;
                                                             try { sNoObj = this.
                                                                              allocations.
                                                                              get(
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  toLabel(
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      readerPolicy(
                                                                                        this.
                                                                                          jif$conf_ConferenceSystem_O,
                                                                                        jif.lang.PrincipalUtil.
                                                                                          topPrincipal(
                                                                                            )),
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      topInteg(
                                                                                        )),
                                                                                paper);
                                                             }
                                                             catch (final NullPointerException e) {
                                                                 return -1; }
                                                             jif.lang.JifObject sNoObjDeclass =
                                                               sNoObj;
                                                             jif.lang.JifInteger sNo;
                                                             try { sNo = jif.lang.JifInteger.
                                                                           jif$cast$jif_lang_JifInteger(
                                                                             jif.lang.LabelUtil.
                                                                               singleton(
                                                                                 ).
                                                                               toLabel(
                                                                                 jif.lang.LabelUtil.
                                                                                   singleton(
                                                                                     ).
                                                                                   readerPolicy(
                                                                                     this.
                                                                                       jif$conf_ConferenceSystem_O,
                                                                                     jif.lang.PrincipalUtil.
                                                                                       topPrincipal(
                                                                                         )),
                                                                                 jif.lang.LabelUtil.
                                                                                   singleton(
                                                                                     ).
                                                                                   topInteg(
                                                                                     )),
                                                                             sNoObjDeclass);
                                                             }
                                                             catch (final ClassCastException ex) {
                                                                 return -1; }
                                                             int r;
                                                             try { r = sNo.intValue(
                                                                             ); }
                                                             catch (final NullPointerException ex) {
                                                                 return -1; }
                                                             int result = r;
                                                             return result; }
    
    public void performAllocations() { try { for (int i = 0; i < this.numSubmissions;
                                                  ++i) { this.allocations.put(this.
                                                                                submissions[i],
                                                                              new jif.lang.JifInteger(
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  toLabel(
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      readerPolicy(
                                                                                        this.
                                                                                          jif$conf_ConferenceSystem_O,
                                                                                        jif.lang.PrincipalUtil.
                                                                                          topPrincipal(
                                                                                            )),
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      topInteg(
                                                                                        ))).
                                                                                jif$lang$JifInteger$(
                                                                                  i));
                                             } }
                                       catch (final ArrayIndexOutOfBoundsException ex) {
                                            }
                                       catch (final NullPointerException ex) {  }
    }
    
    public void setAllocationsVisible() { this.allocationsVisible = true; }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501401181952L;
    public static final String jlc$ClassType$jif = ("H4sIAAAAAAAAAL1cC3hURZau7kACCRLehFdoIIABSRQVxKACgUCYQCIB1IjG" +
                                                    "m+6b5EJ3307f2yHA4AN18ImKgDoKqw4oKoq6uuP6YHyN4GN0fKMzAqs7qzsO" +
                                                    "42PVGcd13Dqn6r7qVl8ad3bzfam6XbfOqapz/jrn1KN712HS3UiTEcu11gpz" +
                                                    "VUo1KuZrrQ1K2lBjDXp81WJa1Bz99o5XYjefkzoYJvlNpIdmLEkaSqtaR3oq" +
                                                    "GbNdT2vmKpP0qVuudCqVGVOLV9ZphllVR4qietIw04qWNI0OciEJ1ZE+Gi1R" +
                                                    "kqammGqsJq0nTDKqLkUbaovrZqXaZVamlLSSqMSuVDZUxxXDoJzysdRi0iOV" +
                                                    "1ju1mJo2ycg62nFeO660qPHKBv6uDj5VdaVJxGLPx8cGh5zZ6DZPrNx00/l9" +
                                                    "Hs4jxU2kWEs2moqpRav1pEn700R6JdREi5o2ZsZiaqyJ9E2qaqxRTWtKXFtN" +
                                                    "K+rJJtLP0NqSiplJq8Yi1dDjnVCxn5FJ0S5Cm1ZhHenFRJKJmnraGk5+q6bG" +
                                                    "Y9an7q1xpc0wySBHLGx4NVBOZVFIxammW5WoapF0W6ElYyALgcIeY9lPaAVK" +
                                                    "WpBQqb7sprolFVpA+jHNxZVkW2WjmdaSbbRqdz1jgoCHZmVaBYpQoiuUNrXZ" +
                                                    "JCVivQb2itbqiYIAEpMMFKshJ6qloYKWXPo5vHD6hjXJeckw9jmmRuPQ/x6U" +
                                                    "qFQgWqS2qmk1GVUZYa8JdVuUQU9dESaEVh4oVGZ1fvnTL2YcV/r0PlZnmKRO" +
                                                    "fctyNWo2R7e39H59eHX5tDwGQd3QQPmekSP4G/ibqq4UnViDbI7wssJ6+fSi" +
                                                    "F865+F710zAprCX5UT2eSVAc9Y3qiZQWV9Nz1aSahilSS3qqyVg1vq8lBfS5" +
                                                    "TkuqrLS+tdVQzVrSLY5F+Tp+piJqpSxARAX0WUu26tZzSjHb8bkrRQgpoP9k" +
                                                    "BP3vQf8f4PnNJrlgzqnLlhhquoZyMZbN1qOZhEon8LIlSW2Z2a4amrEsqhhq" +
                                                    "s2FmYhqtQRHNpY6PzXRCLjPSUfywrNp+2bjKMNVEBX2b+n9oowvG2WdlKERV" +
                                                    "MFw0AHE6d+bpcWokmqObMrPmfPFA88the0JwCVGsAvcKkTsJhZDrAJg0TKlU" +
                                                    "JSvo5KZGr1d543nzL7hidB5FU2plNypQqDraY1yrHQtQi8YwSmH45hmpCzac" +
                                                    "PGx6mHRvokbSmK22Kpm42VA9S88kqTEZYBctUqmdSaJ1k1rYglQUaUwy2Gcb" +
                                                    "mU2kZGmHCZANo9AvEyegrJvF6z/5ZveWtbozFU1S5rMQfkqY4aNFNaT1qBqj" +
                                                    "NtNhPyGiPNr81NqyMOlGzQYdm0lHBlaoVGzDM9OrLKsJY+lOh9eqpxNKHF5Z" +
                                                    "Uik029P6SqcE8dEbn/tSLRVZc4H+563huQZv+6cgHcDwBGoXRoFW+bTG1Nb9" +
                                                    "r/7niWESdgx4scshNqpmlctoALNiNA99HRQtTqsqrffBzQ03bj68/lyEEK0x" +
                                                    "RtZgGaTV1FhQt0jFfPm+jvcOHtj+VtiBnUl9ZqYlrkW77EFCOSnkg2vneYtr" +
                                                    "kLS1cU5/qNGJU8NHu2uULUkm9JjWqiktcRVw/t/FY0949E8b+jAcxGkJk2qa" +
                                                    "HHdkBk75kFnk4pfP/0spsglFwek5MnOqMUva3+E8M51WVkE/ui55Y8Qte5Wt" +
                                                    "1CZTO2hoq1U0bQRlQFBpx+P4J2JaKbybDEmETmfxJW1umDNpcfLQuEFjQUVz" +
                                                    "dNCXoytTNbMPob4LwUzQWEmL0ihouG/OVdtvYeKB726zKo/wVa51XsOUGSz2" +
                                                    "gbff7bxI7MvI6HNxnhTFVCOa1lIWsKilLzS0RCpOxa3GcHrTGMPU51Px2QFT" +
                                                    "WkkacepgmElYjC/ndKXS4K47lTTqCaUypgtAanejAeKw5ujUq9en9TFXTQlz" +
                                                    "QfaGZFQXjQJjzEpFUtFI3DIvpwKMkYfVrCNMp+nm6NaBNz3Z776NM5kvHuml" +
                                                    "8NWefnz1z5pPeug3CHoASKkorUWqQm08E2dz9Mtt76uLTv72z2yS6iuTYvyY" +
                                                    "oqFPVEspEEPyJwg908gFxjGD9qrEBwvOfsq1t+8+fKBhBmLZpQAIEHwxKtew" +
                                                    "S3SQVnt9hd2fisV6yu5Sc/T8Qb+dOPzJc650i0kgcNXecM9tBZ8d9+3tOGwb" +
                                                    "BmMEGNgEgVCAdBrrL9oKj4LcnXTrafDAD97a1znvz6y7Ig5kFGdMHrDnk5Ih" +
                                                    "a7hmocHZvFXI5kmVfRZdhjjKjlTUPfurgkUvuZSNGqQiWIkVmT4hnekoYCFl" +
                                                    "PFYmz1m6aeoJl1RPG/P+8qrvX3/EmgBzbKmUewcoULqHmT/hiSEbfndxvcWj" +
                                                    "lg213jXUM1nRSakutNBL8NN0AyyDEH3MU4x26j32x99t2vzBhFImbJd34e8f" +
                                                    "n3355i2P/fIkFqD0orauzxkzCGFGD5ifkcK+NLGupDzdED4uYFWbmYJStnK8" +
                                                    "H1legoYVVprDPcFQDSx9nAAguvq0/9j49w4aAOQ1kd7tilGbpA4TVlp0QQfW" +
                                                    "0/5kkr6uaYVmCcKAuDukEZcHQmNNlbtuG1p9+qc4Y51oA6hHdvnDxqWKKxCa" +
                                                    "fG/i6/Do/F+HSQGN1zAKo6vapUo8Az68iS7SjGpeWEeO8bz3LrjY6qLKjqaG" +
                                                    "i5GOq1kxznHCVfoMteG5UAht4J9MZA/hk3k+zB3ahAg+rECS0ZiOheRY1FkY" +
                                                    "HstN2rKWVOJCNNGH8xvK894uvibpqafblKRG43zD48vQlKsxtgDbsXPXA1W9" +
                                                    "7tmBM7Un6o9q0+R+qwdQWJ/Z0I7xDi3Cm54gGxqbPTbBUBlBmZsAswyfZpCe" +
                                                    "JZ0kNsdhUDiScyrn+VgxcFxFx18mtdOAW5dZGa4lMtu/eqkBIXkMbnpYyjfJ" +
                                                    "EBHwTnSNJsjbqeG8M+NknTJ87hUZuq3T/rrvt532zp5Hbfc6RIgCnMkw5cV7" +
                                                    "815bumwrU6ErbHd7Plj5uLYO+J5FabYxsS0LHFi7PbBSGFg5X6o+zvPd7oER" +
                                                    "huXL5FjO41jON3CLBz7pHNE/0L8Q/f87/EMzUAA5na7VfFUesZflKbo8DNUb" +
                                                    "fhNDdZmgNqqT70CoV2y66oeKDZvCrm2aMb6dEjeNa9zHQHIl6GpUUCtIUfPx" +
                                                    "7rVP7Fy7ntn9ft5NhznJTOL+d75/peLmQy9K1rk9bTxai5zhWVSNTY3+qGB9" +
                                                    "7Sfzd6CN7gN2DqMEauhg7mJRbdJbVKQZNshxaNdDshFWx+hXvAoWp9Oxvhlt" +
                                                    "OSBIOpHhzY7r7PT6LH/RQJP0xqV9vWWecNzENfdVu0cw+8kk+j+Q9mQLzzMS" +
                                                    "8/lPcsjRhVgBlS+NuVTBdhZxZibPEx7b2U+Jx/Uo7i8aSzVDs4KwtLdnQzjx" +
                                                    "OlnPBOvXX0bwU5/125m79RsAhSWc0yU8Xytav11Yf42XaiCvfaGMCqte5JrJ" +
                                                    "DkIGy5q8OBAh92AvHnHgcI8fId6ia/jMg+w6qsAWXY+rStIFk50ymIxl/Qs/" +
                                                    "xfPtEpg8yWACyZ1+PADVL3h+mwcPvekcbsy0JDTDAEjIsDCQE94va17AQrGM" +
                                                    "4G4fFp7LHQsQCqBqgdMunu8UsbBXwAJScb2G75FRBWChv6zJ+wKx8Dz24jVH" +
                                                    "8c/7sfB8EBby6ArehYPnZDg4iUE0/CXPX5Lg4N1AHADVizx/1oODIiMYBOM5" +
                                                    "1R9kbQsgGCUjOOgDwYHcQTAaCsdxTv/O80MiCD4UQIBUY3jtf5NRBYBgrKzJ" +
                                                    "jwJBcBB78UdH4wf9IHCK0mSo4w4xqMftJ+bg955Ysnn9jX8ZTEOfJlLAg34M" +
                                                    "/xfqSfwgOdtw0X++6+Cnbxwz4gHcyenWohgshhcPhfxnPp6jHBxPLy8QRln6" +
                                                    "zAoEATkjecUPckDOEBnBuz7kfJ07cjA0L+Wcfs/z/SJyvhWQg1TDeO33ZFQB" +
                                                    "yBkha/J3gcj5BnrB9wvrWYEPOd+4kOM9VqX22zBdB1tnH7v0mcuGGFezoK3c" +
                                                    "RonaZVZg7M9JRbr39udNLjLLrsN42wZND7o6NKCmSSLZj1SRF4svi2xJ4FFQ" +
                                                    "P/qfT//P5XmDSZb8I49pGpSUmubnP/83jFE5Pa0YD/dlK/AlHtf4NNEc7Tvt" +
                                                    "1pbWdTP2YlBcjMLDiLWRiXGcd/nCicoavfW8Z8xS3TVHP9l97b5Rf1zaHw8P" +
                                                    "LTW5TwgWKKkq8UQA9mxoefeC9595btAFr+eRcA0pjOtKrEbBwxXS02xPq0a7" +
                                                    "Ho91pfjECq2ENVGYWLH1JV5vWcaVm+D5MhBZEcA91IsvnkKDghZPkFwBiY4Y" +
                                                    "upJ6pJl4CQAFIvOY9p5MiK3cb4THESREBJsC+MPIDqbhOzz/rWhTQiNztyk4" +
                                                    "4sGc09s8f12wKaExgk2xowqo/YaMymdTZtvEg2RNvuUjnufYlFAEezHRNiC0" +
                                                    "QLQpTlFXl3crITssT6iKLnxWn1aO2M432zWj7Hg8YJFAuoqJtj82Uoko6mYj" +
                                                    "CI3LlzxuCZ0kB0fYBoeNi/y4mmwz2eI9zXjIjlUW057xY40t3wxYtO6svy5B" +
                                                    "uxaOYpw1so70aM3E4wvtFSukUxk/k8xAJhG9NULNRsRIqVFNiUesbevIaBj3" +
                                                    "6IiWjKAdOHdN/Yc/27j2PMw+vGrH2nPPS9lbvvZWSLWSTOqm77whP6o9eriy" +
                                                    "9Xtru/Y0pp/P+NDsYX6Fb79GWwTJibjZIj0Vm5NImXiOtfqxwY9Mv3vbAdxs" +
                                                    "8WlB9CML0PU7+y9T75hdNvzZjg3/uMNj+DhMfk48UghmxM7cs2DXi3PHRTeG" +
                                                    "SZ69qem7meIlqvJuZRayVhd7NjRLmZhBoKc7ofM4xBp+lp7whWoD3v0Ekhpq" +
                                                    "oKJxPakeWZmpVCoUIsTHi9kxtkUfajiiecJd81AjMxzZds2ZeWBVz2Z2INte" +
                                                    "PKRLumCjoSQbyKHKWyg6NolPRb5w8BGaRULwli9nDsiWM8ezGCtvGc9PcZsz" +
                                                    "bhbOD1zOANVUnh/voqbOw7XNIQSlBZYdBoe2g9j3U06pbNcTauVyNVa5Uk+v" +
                                                    "qASDFqNzCB/iWsskGhjgM/pV7kN53PGjabmSYajNTNFtR1Q0qwzpcseSN/uN" +
                                                    "e7MvzuRkeu5koXxIYkhmWhFQH7Aa7kgCaxZjOoB3Ng/jBTThQryAe3Fjudz/" +
                                                    "hTibrSEVBdBqxQurssQL9hUEe8NVOEX4EXuuS+0II3QxDnY4JLDrFSoV4gnY" +
                                                    "AMelJaBuIc/nubGLvb8s93gCFwyjOKcFPK91cwSGVwjxhL3MgNrzZVQB8URE" +
                                                    "1mSdj9gdT1yOvbjeAcrlfux4ixydw44QCg50fT/P75LofHP2GDEEW3mhCyG5" +
                                                    "CLtyMdUb2tpLs+oKtwSH8uHV8HyGT1c/z11XOJIhnNMcns8UdbVN0BVSDeK1" +
                                                    "Z8moAnRVImtydqCubsVe3OUo5la/rm51xX7wGQxoaGWHbbRDbV0uh2j3Bv/y" +
                                                    "uQpv4vkNrt5gzRLnwsuIbDcwcdd/+7pN22L1O06wop/rTbr60FOT4monD/sZ" +
                                                    "q3zsY7XdDbxZBSg+hVr0gTwngh5IH9kI7PtKlCT/B55/K47A8e3uoNVxI7C/" +
                                                    "RU7lDVfyfLhHK54dHhaVzky38aB05zG/fvlwSc0+3KEJRzW4tuO78BZTs8Uy" +
                                                    "mRR1ye6YKtyJ98qWszjW7uZJsm6Wu7tpkhZoN6GnU+0av10DgS+77BZR0m24" +
                                                    "iI6kIAiAF2yHKNKuJGNx1dk7jhzbAt1RYxGlRe9UIy2rInaoUM5cxHSWVUPy" +
                                                    "CFMQPD4aJHCo8DhD6BOQ7EFo/woR+vTR8fOfvS9JrkjqK5Ns+6OxaFfm0qcm" +
                                                    "7begyM/JsL19AfHeK5D8M3WLokSg/CVZYCe5ZsJ7wsExoPJPW+v/+uGDVlem" +
                                                    "shGmPGJ8TSikXhB15IQUe5h5ezt38wYH+WQah0kFzyeI5m2/YN6QagqvPVFG" +
                                                    "5TNvznbZKbImJ/mI3WEMw8Ahx5bt8Zs3p0i8G1JHA8O4s7BYfM3ed6fc8slG" +
                                                    "XNAGX/QQKOPb43vrvlr1qqUl50AZjcMMPpaTZcaBx7cfy/0dxs72itelVj4d" +
                                                    "UKsd1q6UZ2JAchgnh1Tf8OYZSD61eXyMjPDNcwEw/xxhDslv7GDJtR3TrVPX" +
                                                    "YkRy5bHD45HBZOO2OkhkmGW/3ZJBuRzFDi+eNozlnIbyfJAIWXGHF6lG89qD" +
                                                    "ZVQBkC2TNTkkELK4wxt2dnhD/h1epwjSJRDmgt7HyxT1WHZFhXs4ioLkC4lS" +
                                                    "UMTYisytQs0zqYt8hudbBWEewa0CyW083+IiDehyccC7vpAUmqR3m2pmP6m0" +
                                                    "4wFo9WFZxwUgDpUR7BKBGB6YOxDtOzvA6SGe3y/ILjxEAKJ9qQZqPyCjCgBi" +
                                                    "qazJB4OAGB6EvRhlo44WiEAUij7zCnmoJausQgYjFR7vWtoW0iCjxLrBq8Ap" +
                                                    "VQROF+ybvOHyI0qZsYG6k5wJU+ifQ4X+qcfIJudG1sF3ZODrGFlsGXArwnlQ" +
                                                    "BY+n5NJ3RhCuwoLZrACfrR0af9ECh2yGo5oiv7aKPGZDNqHBVJ1Dn6/hefro" +
                                                    "JjSQdPB8RfYJLY+TjwMuZ3Dqu3h+o4iZ0BM2wTQZwe1ugh8bsYIBUdF6LMzA" +
                                                    "V++OLmIN19gRZnhu0NChQp0TsYYXog7r0Zw0HBU/qPoSUp8dYCCbIJlD409x" +
                                                    "fB3Z4s8OHj3SLvhDSnehL6Skg8FxtORuFmHxQU7netzB8zsEBIZVwSwiVRWv" +
                                                    "faeMKsAsniZr0n9txW0WmZISzqxa6J9onqLQH7wQn8Ob2SWDOIv2wkyORxft" +
                                                    "USihwDs80Z4FKkjwqUGqCnhzJiSdFo8wogKDiHBjAKjWIKggOVfmaQfwUa6R" +
                                                    "WRTB0/aWEXgulKFwLswdUnjLqD/ntJrnnSKk1gmQQqo+vPZKGVUApPrJmlwV" +
                                                    "CCncpQpf5eDnIj+kLnLb7reOHD7jrZSJvPmNlln3yfL63GUJsTiZwDndwPNr" +
                                                    "RVluEmSJVON57Q0yqgBZlsuavD5QljdgL25zBHeDX5Y3ePygO3z2IX9+APJ/" +
                                                    "ISIfHtfiqwuzaQll3iFxv/Y1T4U+r+D5fEG6bvcrOeUAklqez3KR5uR+cf9n" +
                                                    "Lqe+nOe+2epyvzNlBBe5CUyi/Sj3C2d2CnVPrav+N174bsdr7jySF77f5YV3" +
                                                    "o5IexOnx0FHx67C98L8GwAYbucskg7MMs+OIzvhumTO+O8gZ72az/ShuU8Le" +
                                                    "M6nhWr2M555rrsDwBWG2I1U1r32JjCpgts+RNXlp4GxnunrVmdq7/bN9dxZn" +
                                                    "jIBfwJu5WgZ47ozf/DHO+H7s2XMdXmfMsQXJe4ivrM74YUjetXiE33RM0iMB" +
                                                    "2Po9YguSJ4XpbV/QhVE2yuyL4ECKZQQL3AQonIO5Q8q+oAucFvF8oQipjwRI" +
                                                    "2Rd0oXa9jCoAUv1lTZ4ZCKlD2ItPHfwc8kPqkNcZO3PV2UB2bejD9aRq+6ZD" +
                                                    "c7Tu67cHdR6rv8C+qGl/9wGZiN8LhyNv0s47fhfPf+4bgNy0OUJsBTZtnHwH" +
                                                    "z/1x7kXZ4EguQ6l8LYIEHBY5kfPrsLyXDyR/yx0ksK9LJnNOKZ7HRZD8XRgf" +
                                                    "UlXy2gkZVQBITpA1qQeC5DvoRV6+g4jv/CDxFjkyAwyTJbyZG3l+rSizvKLc" +
                                                    "ZdYAhYs5p4083yDILK9YkBlSnclrXyejCpBZo6zJG4JkltcLezHYFhAtEGXm" +
                                                    "FHmCMtEC3pfdAuaVihYQHg8g2cFssxVefgHJf2WZTfAO92Xz8CvI4b/ZChI3" +
                                                    "UGCjeB1V1SSei9vLR9hAAZKBPC92kQYMuDzg3URIykzSj0oSgq6Zzl2Xjiwb" +
                                                    "vgJY8WZ8Ge9RpTU4H1grjghWqFWJnXL212iBDwGVfuAwsqm5kUGadWuLorzv" +
                                                    "kzy/8+g0AyR38PzW3DQzM+AdRJR5000y0FDNmb4vWuWoHFzjjeed2mONz6ec" +
                                                    "mpyUMxf7Nd8R6Vy/lOf6lcPI6nMjQ+XAjzSIv2kDZ28lvp/JYj/tFH1gW3GP" +
                                                    "wduWvMu+omD9/FJPfi/T/RVk13N+Kq22aqjYnsyn4l22vKUm6Qb3suH5LPvr" +
                                                    "eH3weiR8H7qCfR+6i1mJEqk3tU8x4UbDXp6/4Jb7Eb1pADQu8H5XGa5bZtjv" +
                                                    "kDVHP598wuw9+8bt5T9lkPXSt0Oxe9v8hWu+mMK+3dydLjhWr4ZGe9SRArYM" +
                                                    "42GH+zueIjeLV/688u96P9hzrOdHN/q5Jk+JG6clTpR8mfN9X/cPV7h/KK05" +
                                                    "uoKsvfr59f0uwW+y9NSMxekMhUYMvtBr");
    public static final String jlc$ClassType$jif$1 = ("XQQBXuvYOTe77ZjXThmPF3/RwcXWfX82tPyW+rqCH862789K9cNuI/4PNb6n" +
                                                      "iJZOAAA=");
    
    public ConferenceSystem(final jif.lang.Principal jif$O) { super();
                                                              this.jif$conf_ConferenceSystem_O =
                                                                jif$O; }
    
    public void jif$invokeDefConstructor() { this.conf$ConferenceSystem$(); }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$O, final Object o) {
        if (o instanceof ConferenceSystem) { ConferenceSystem c = (ConferenceSystem)
                                                                    o;
                                             return jif.lang.PrincipalUtil.equivalentTo(
                                                                             c.jif$conf_ConferenceSystem_O,
                                                                             jif$O);
        }
        return false; }
    
    public static ConferenceSystem jif$cast$conf_ConferenceSystem(final jif.lang.Principal jif$O,
                                                                  final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$O, o)) return (ConferenceSystem) o;
        throw new ClassCastException(); }
    
    private final jif.lang.Principal jif$conf_ConferenceSystem_O;
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501401181952L;
    public static final String jlc$ClassType$jl = ("H4sIAAAAAAAAAM17C8zs2FnY7N1kN9mE7CY0D/LikixhwyTrx9hjO9tU2OMZ" +
                                                   "ezwejz0ee2acDYvf7/dzHFJRpAKCFmgaAhUPtTRIhYbQVkKoaqkAqYUUVLUI" +
                                                   "tUUVDaJFFNGIUqlFVR/UM/9/X/+9eyESrRjJ55w5z+99vk/6zue+NHptWYxu" +
                                                   "Z2l0cqO0erE6ZXb5oqgXpW3NIr0sd0PHK+b3jYFPf/83PvcPnhw9q42e9RO5" +
                                                   "0ivfnKVJZXeVNnpjbMeGXZSkZdmWNnpzYtuWbBe+Hvn9MDFNtNFbSt9N9Kou" +
                                                   "7HJrl2nUnCe+pawzu7iceaeTH73RTJOyKmqzSouyGj3HB3qjA3XlRwDvl9VL" +
                                                   "/Ogpx7cjq8xHf3H0BD96rRPp7jDxbfwdLIDLjsDi3D9Mf8YfwCwc3bTvLHlN" +
                                                   "6CdWNfrqmyvuYvz8apgwLH06tisvvXvUaxJ96Bi95QqkSE9cQK4KP3GHqa9N" +
                                                   "6+GUavTOV910mPS6TDdD3bVfqUbvuDlPvBoaZr3+Qpbzkmr01pvTLjt1xeid" +
                                                   "N3h2H7e+JPz57/5Ewia3LjBbthmd4X/tsOi9NxZtbccu7MS0rxa+8ev5z+hv" +
                                                   "+9nvuDUaDZPfemPy1Zyf+eY/+IYPvffnfulqzrseMWdjBLZZvWJ+1njTv3r3" +
                                                   "7IPEk2cwXpelpX8WhQcwv3BVvB55qcsGWXzb3R3Pgy/eGfy57T87fstP2L93" +
                                                   "a/TMcvSUmUZ1PEjVm800zvzILhg7sQu9sq3l6PV2Ys0u48vR00Ob9xP7qnfj" +
                                                   "OKVdLUeviS5dT6WX/wOJnGGLM4leM7T9xEnvtDO98i7tLhuNRk8P3+g9w/e6" +
                                                   "4fv8df0D1eib5h95WSntYjHsUr5Mp2Yd20lVvqwk/suVZ5d++bKpl/YrZVVb" +
                                                   "/jBjkO9rql+arwS+83JZmJc/L8/uDsqnsrLjF4fR7P/DGd0Zz69on3hiYMG7" +
                                                   "b5qDaNAdNo0su3jF/HRNzf/g86/88q27CnFNoUFWz7u/eHP30RNPXHb9c2el" +
                                                   "uWLqwJJwUPVBm9/4Qfnj3Dd9x/ueHKQpa18zEPQ89fmbsn3PIiyHlj7s/Yr5" +
                                                   "7Lf/p//+U5/5ZHpPyqvR8w8p38Mrz8rzvpsYFqlpW4Nxurf919/Wf/qVn/3k" +
                                                   "87fOkvD6AbNKH6RmUPD33jzjASV66Y5BOlPlFj96g5MWsR6dh+5YkWcqr0jb" +
                                                   "ez0X0r/h0n7THw2/J4bv/5y/s7ydO871YHVm17J++66wV6N4U7h64g+S8Vvf" +
                                                   "9qnf+s4f+8ifppysB4zPsvERCPwQPP3wBM+upOTMzBsEvNjaj8rZD//bf/G7" +
                                                   "k1tnxO+Y5Wfvs9+yXb10nyk4b/bGi9K/+Z5s7ArbHub9xg+If/37vvTtH7sI" +
                                                   "xjDj/Y868PlzeSaLPpAjLf7yL+W//sV//9lfu3VPmKrRU1ltRL55gfzdw0Yf" +
                                                   "uHfUYCWiwVINkJTPK0mcWr7j60ZknwXzfz37tdBP/+fvfu5KuqKh54pXxehD" +
                                                   "f/wG9/q/ihp9yy9/4x++97LNE+b5lrpHjnvTrkzfV97bmSwK/XSGo/tLv/qe" +
                                                   "v/GL+g8PRnQwXKXf2xdb9MS1rpyBessgGwOXXjzfR4Mk+4npZ3p0QfhDlwlf" +
                                                   "dynHZzG6LBtdxsBz8a7uMvbWS/8z5cM3xOJ81d7TCg343A+9c/YXfu+Czz2t" +
                                                   "OO/xzu5hy6Hq9yks/BPxf7v1vqf+6a3R09roucstryeVqkf1meHacE+Xs+tO" +
                                                   "fvQVD4w/eOdeXTAv3dX6d9/UyPuOvamP9yzW0D7PPrefvl8FB0K8+Uyk8VXj" +
                                                   "Fnpdv+s8+lx2Lt/cPTG6NKaXJV99Kd93Lr72ii/n5geuRK4avT69o6N32PWm" +
                                                   "i6G8q7pXSnUu4bsgvPEMwoeH763D0Z+5rutHgPDRVwGhGj2dFX4zmInu7qYX" +
                                                   "5r/herPquo7v23Sgsx5FqXlx2krVL/1Bmh8hFYOUxYMKN9d+g/0dn/7OP3rx" +
                                                   "uz996z7n6v0P+Tf3r7lysC4UeuZCpm445Wsed8plxeJ3fuqT/+jvfPLbr5yP" +
                                                   "tzzoKsyTOv7Jf/2/f+XFH/jNLzzidnraSNPI1pNXpfbXDt/bB4L87HX92UdQ" +
                                                   "e3VF7XPxDQ+T9bzqb1/XP/QAWd80wCbXRuyX5Zmyl6X0NeLniqlGTw5u6qvC" +
                                                   "hgzfO4Zd/+t1/c8fAZv8WNjOq75wXf/CA7C9obwPsIcdy4spuuLzf/ncF3/v" +
                                                   "V7/iPZ+/3ImvMYaL5KI9Nz3yhx3uB/zoC9df/yB+X3cN2W8/Cr87avPMRW1E" +
                                                   "PbvWpPENQwifC+0OOb7x0Ypx66Kb1WAV/OTaSg46+lRkJ+6Vsyeei2N394Rb" +
                                                   "V8vuAHFlpC+2dhaliX2293fGrlwcP33xbvAzDHYPwVqMvvoGjdcX8twzlT++" +
                                                   "/twXmA+Yn7o1evKulXsoWnlw0UsP2rZnCnsItpLdAxbuq64IdEHwXHzNY66H" +
                                                   "+DFjFwc5HGhonilwB/vn7lHmykJ3ryrO4PC9azR68uXrGn+EOJePFefzKuy6" +
                                                   "Bh8U5/ss2D3QhvvxYiRYvfTWenYfZFda+MRgMF87eRF5cXL+3z9adp68lp2n" +
                                                   "ykv8e/6n35GgtweR+fwdF00dJHQ4//nh2EdQ5ypmfAQIg2S86d40Ph0Cy+/6" +
                                                   "j9/7K9/z/i8O9owbvbY534WD4btvL6E+R97f9rnve88bPv2b33XxfAYR+/in" +
                                                   "PvH7o/Ou33ouvnmISs/QyWldmDavl9X64qrY1l0Ab9ii1wx8fRSA1e0Ri5RL" +
                                                   "8s6Ph8zZxFO2ml5jITmbbXnbW1jpcklS8lZSuxU5c5XZUZotKWgZMPF4aqBz" +
                                                   "bjIBMQc+sSRCChC+jFcuna7yFklXaT6ta3F6ZE8Cwgigs1r3ZF5ieV9uEFhU" +
                                                   "GdOCJnSeTAssVyNctyZG7+jx9GA4m1zPeiAoEmglYBDMyhPF383NGoLcrFeV" +
                                                   "FFrVWlFI0AqOqIA+ZDi053SI6gkiRQ/HwHbCPj1yTSRkSyvm56Eu55W+naQ5" +
                                                   "YwjWDm7iVSaCuVrX1ixXGXXDq4SWeVGkbpHcH4LKFkTyvbAEN6Y/5yBtPmZ8" +
                                                   "aBvmehwzecnlYLKjVzkfKoaeNoWWH3RN1eOIl+V8LdcqrSldd6BTrj+V1tYH" +
                                                   "/Y0KBTUUcyl8Mt0pnCzszXQK5iK7opppTQeoaukq1zG82OEm46G9NqU1sRA6" +
                                                   "EAQigi2RoFPgcD8v4TjNs63eQNk8wUBwO+Ws7dxHU1grNV/PTxwxh3M977a7" +
                                                   "fbU6LCphNS44ruJFUMhlP4u4HD/6kEUHiTrrEnTBgTI6iyHNY+1kseVWXJwU" +
                                                   "OhOi43xqMEdCT7Ac6jITbE8yxfJMhwgqtdHUxbIbSLFH96meLcD9dB4dTyTv" +
                                                   "mkv7SESiTqqrfUZJuYGVWZFGCzUjxwErdJoa7uF9EFu6bBjb3OqhwE1nrBar" +
                                                   "OnXMpNSvFaE4aNxM9RvJgP3KyP3jkpxn6/ViVXrcNI/S42p/EFO0YempFxw4" +
                                                   "2wxbIojjbS1KQDdV8oXk7nMZzuMQYlRFO+o4Z6m1IimENZf1ueohqcpokNMk" +
                                                   "Ox4+mipQgGKkJfFqu3HM6iTsU3iL2ROCRQmbPaAV3TKSNZEkMbZDWUQYwDfy" +
                                                   "HFES1aeNJdaWJTcdO7K/wKfoeIFBYE9mxeyAKjvYllXSJI6T3NekvUoIPaTL" +
                                                   "uudHsjzJ85PqQk2OR5Qjo7uwzgteHleWKvVqIfNHdDHeZePM5/JM7sgteQD3" +
                                                   "Sg1PK62XA9bAjbDYSm6WikRIiZNGcnAHEROBKyK3zxM+8ry8TrXTWjMEKN9o" +
                                                   "3jxNcH4ZyXtYg3VEj4t5mQ9zSngRH728kraskB2nYn/YzvhAlBXn1BZCNoaN" +
                                                   "YLUW1Dl1gI1xQqRp2zDw3opW8626XrQgyc6n1tjIzH0axvnGWBdi7IgLEseH" +
                                                   "2BTk2pnKlGRjrsJdyXkaXZCcC+5WkcLJTYquNKaALBSZJD2Peb5FoQsFziLh" +
                                                   "lEk5XehH6FSwUiX5+LGVYxZBvTib9bopMt00ZrdNGhpyvILhVRYjsEoSMo6H" +
                                                   "+W6uHSmzUvLYknUOCqHi6EaSoivtCWZMIx50SGNidqaRQkqQzfxkuwXXLKY9" +
                                                   "gGqNva+MtF8okIwWa8kJ8yOiCwtB30E5lQdCJXjiifFFocAhIT+tNxHTS0cr" +
                                                   "BiOWivRBpnp6TWwKflVyx3G08Qg7zzphxS5QTfFDECbEqZybc9yaGwlQyfxW" +
                                                   "1UyEHaPTiVdLWjOemi5r0i3FpIdtutiPjR0DCQZRAFji7+ey5XZIaZaekGdx" +
                                                   "ZFYpyQu+QBIEu5WqXV7mheNQvQROjGCKA9FpPl+B3bbSXEbfqdDCkyowWDhi" +
                                                   "PA4ac8NWwVitfCpRIkLLj1ER7jFsvpht5CR04Saxj1UR8jJkKiiQCwyn4AJb" +
                                                   "w7XCK2FMcME+98PK3KotUAGLI0ggxBw3xgFpdkzIhYP5YVkrpEIMDRdJiGSO" +
                                                   "CIBlVrrRorVDdJ1s8rXS6JPxHF+j0F4N50Dto+gRlyob3VfQTNttYC/NIQU0" +
                                                   "pG0kLaisG4sIB3P6yjgZ9Dye72Kn4/ZQHdNCZjq8VM8XgaSovSXMDump2gnG" +
                                                   "WkwNhG+VXtrPYx70vbRmgI1qVc3RXlEYPO1XKdCqOgodyo3CyD3sGo6DGd0S" +
                                                   "WzfL6WCqEm+3UGcbHYqW+3LlR3wvg9tZtun0CWOyxY5ZiwoKiR0sLXb7MByc" +
                                                   "48yNBzMYzIDEWh1kZIVg0W6Xz3TllLkVqSd2QNqrFq0DJSfshNgtDjsp6iVH" +
                                                   "Z7SFdAgkLujn2UKpFssJvWyydrUOj45azIR1Nk7iqaBTQj/RMGwqrNGwYes4" +
                                                   "woW97SQ91KOZaNfuZMampLwK00LZ51IM4nPY6ol1VWHTmt81GNzDJ3nq17tj" +
                                                   "czqm+UJU52U2n4snrnUJEHcXXcDQRF7MqbbZDH4EVI3xsbOiPCrmtUwil3O2" +
                                                   "7VaV3coTWVKTivAs2PFLdXqqUdkEdrhkjK2N2HPmFAV9MHRN4WCba6KiNNwi" +
                                                   "xpNqw7QGFa/njODOXXVGWlRR8ES6ChDeTA67QndokiYwHeqTpp+esKU7iBBj" +
                                                   "rdmCTkJ06emYF6cmqzWLwxINY9XZapYXBKsg2imiUxduqDS1JgtMLvn7ZajG" +
                                                   "O8RL7DA9zhaRuDjGPRRPdTvlImgrMoA4xvOiOUyAeexSvbGKFbs1U4XP2XgH" +
                                                   "eL48N5zE6hpzH0QuDE2Cg7KGkq2sh3UlUDwuCCB5OtFzdrJWkA6eBhO4I4gK" +
                                                   "bnrKWyxjg7MmiI07yWSCoj4sAs4yXOQ0mBZ63XdhP2MWDI36TmiuxgLP1Bnd" +
                                                   "W3MaqY+LvREfOblKVjgLRbabHlU1K2jRXEi03BEJSbp1k4MAESBEi+jkRoJC" +
                                                   "Cxt8YcbISGSnRhkoSc4eBNAwLKa1flTjmbkia7oO55rJSrEgREZVM1BGjHMT" +
                                                   "OaJQSk491moSusv3q1U3053hkpsCdAosxqwsMQLUk6t02uiZkuJkP8V9GZMD" +
                                                   "JrP3c3uDG/2EL4LjNOdXQa4zPspscijs+oSdqU66rmwGVUivQjhirZGAF07C" +
                                                   "cU9NdI90x8V8JoOav/Hs7RFahEe2rAS4WO3VDTcTBIbFu2aFE0jd+EaW644R" +
                                                   "rbYMMulpBG+kaFV2lUsb5UE8kNCewKqYWmNKMk2JHBxvx3lrSXsO0MAl1tH+" +
                                                   "ZBajiMt0uSHuDEqhIirWSrJsT46WzWxOA0OhtDyF9mXzVCRj1e3MRbfoIDyu" +
                                                   "rA25Ry2N0ZFoXdWAnYfU8hCujSQ7ngKHm1Nsu0tkgSsDI7cZfD0WwmTH4Zin" +
                                                   "aHU+2QFF0VToBO4zlDUcc7pdurNkHbaoqWI4hBp13BbKdF4YrIWJUYDW/HEz" +
                                                   "5tCFbgwxqwzy7MLHRIOSmYWLHqbpuG9EC0vnW68+8Ogi2CBQsBEmM57qsYwV" +
                                                   "5gDI4xLg4BgwX/cKSaKJjqnOQrFLzYlWRorTgmI4nkBbWuwKeb7DwFmqwqfp" +
                                                   "NLVXtNbMihjW18bUmge2oBM9K7HLaMpkijKrloojdlihitjihCVVQjgVKnh9" +
                                                   "wu02/NjCUCCz+Vg6ESuoCAlj1+k+2nt7VRZ2x8k4ZygCk53ems4EzBVgOl/P" +
                                                   "9dpzsZjbGhZnqCtJE0qv0wWLLr3Fvht7h4ZM9xmx6RovqjYytdxkrNcfsQIT" +
                                                   "d1OeBbYSJ4JdrhLNfm+bQj8XnMHTA812jIfhOBhLRCzxfb+WhwtRNMtg66ku" +
                                                   "FcljoVZ3lOVpneYb4rzDDFgZcx2gpJiP63Kv0iWyaiveSqQ+6DZRIlKb5nAA" +
                                                   "jXa4DiEYjTFiW5KevDfBk4IfTtXgjUNHB4EPuj9rBnO+nuXDVcYVHB0umROa" +
                                                   "4xuK9AiYbNiEHVxk3FlaU18HgrU7bqd5Se4Px3EhV8tFiIKneNlFgFQCnSNW" +
                                                   "88zFT3tydtKgsUjSKj/xxnFrio0dmkZ5Ajl6R5PzYFnSM2lOII0OYaRUMGuE" +
                                                   "QZxFhvGsVEqzwXlxrXWd1LhSGtShJTnZNGAGQxdbaj/zmmnPjdtVh9M9jAQq" +
                                                   "i5sAVjoUPqeM05QsbO8oJhrtIr4yB4HZoGwo7yICRLIDPH7fAVC6oZf++kht" +
                                                   "htt8S4SGVLrMTAk2G5duj6wp7Uh9VlrdrgE2OLj2ZzSiSEtKOU6CykGFLXWk" +
                                                   "3GLVc0HLUSZFYbhisUjrEEt2tgJjOUVapMvXTsWNDZcY3IQySYjggGu7+cbh" +
                                                   "Ip50J8h6IFYuO627saoWPIzH0/EsMbq2RwaP6mQn+9RzS88zRc/pEjGbBizV" +
                                                   "ifwJH7yLZNqT6ZzchYFtKqIZ0ps5lVB1j4UOB2JmQIL8eG86JdADMndqvL3k" +
                                                   "Qjva3kwmw51NnajQ0wFu4poBSiUFRbRNsT/OxY01RsLNmlDzAwz3lEVBVcJi" +
                                                   "DRibNcMs7D5dTcxtmgwxo+Zia2JQgGJC1JbABzxflAICt5pAY+lUWM1iWea1" +
                                                   "AJK3C6RsfLjjkMVCEoHc2QGAiB5iWtYMfIkQGZPJSlwbiQjgk2AxR0UdPNLA" +
                                                   "4KsDZMRWDiIIcxPbNRWUGXtrJ8LHiDKDNU/7/H7rH4ZIHEhmvpnqjbPHNbyT" +
                                                   "JzuVFYmIwAx060C9zra4yO/26K51h0sizHFFIom4S23HnhEogRoVuSjG9tYk" +
                                                   "wSzYVKtiblBtd5BBuBNzUMfYlIAyJ5jPcnguqMxxz7MQp6LN3tTVeEyja4/S" +
                                                   "5iZJQMuyScIV7XqaGC5ayj8ixzrjphkXITOJXCybzZHI0LU/0NBAduxc3s4p" +
                                                   "rpyN1+KSzg1v0/dAsfd2ki/01SlEkJIxQaLEHQhuV/q8c0O4S9s8BY76+hRb" +
                                                   "O61q5i68FZpaCZLaOUYLcm737FbwZ6DES9kuWhyiiVksd2W5m/orPun2CaRv" +
                                                   "4DUyGPV9gLEufuQWZJ3mXBXgsJKG6TQe3MDlhI/6rp4NdwsFOkcqtQUfOCFx" +
                                                   "3PawvST6Q7AMImUPolh3RMBq0nbHajMtmxNK1Z2+OWYtVKYYqK8nc6RtqoVc" +
                                                   "h0oXAiHekZzHEILCC9tyu8zVheAP5t2wm6VOBZPp0t8HK9LasJYAHE0AxgJY" +
                                                   "XLfjhilYOBFFmYiMptH2Mr+Xd5s8xrDWE4dL0y78E3Goiho4glk2OEcCXR4P" +
                                                   "04WBEcy+3XG+EWjLAFRjVFjGB39TOXnXHol1M2kM0upKfB9RxGzNg6KCjU/E" +
                                                   "DkM9S2h6LXAnQL0WgjHtrZ0QwRXXi7s1ZpYwffAnIrvd2YysTYncjrHYXkZ5" +
                                                   "w9XaVj+pnoUJwZaPNY9KVyaWOmuko7JxlA0A71N60oDz0MvydMV1oh7aey3O" +
                                                   "1FmqLMsd6xNhV4WKowe+b5uchUNksO56zSphzd5Taj+EwUuhssXVlq/jWZDK" +
                                                   "knFasav9yZ0KaSRuDbTFKUbfKnwb+URCl/5+jds9M6saxiREUyt7wzM2NNRv" +
                                                   "SEFVEg9o0tzYtNhBWEpyRGlHa+A37BLBRAGnmSGYO71WT8IQcCjhuMlJmV7k" +
                                                   "Qj+jAH9fliHjBe4ayFQsFNCJyAS6EctHPRB2wqLaQhKYt31mlrYsALVgDwFK" +
                                                   "X29Du0bD9NAtj6EX772FxGKkjoXuTO+0YJNSE8EFAmq386TiRNqTRVBbPeDt" +
                                                   "fKOQ5+pgkfJOqouylHjCU+Y2Lqib+QGZH+paHoPL5UTq6OSIcDxdLORURdzk" +
                                                   "SK7tiNOpemkCSW0wfGPgJTFxZ4v2FGxW5kJcEZDZyozaBp3HT9auUPSaKlG4" +
                                                   "sp1DsWwFhGvtoNOmMQKbNIvIqTvE705W");
    public static final String jlc$ClassType$jl$1 = ("iyDSzEXBwaCJGMqnDivCDD2f7yexNzsx6IyvTmtLMeAq48txuqpamcVrVsXZ" +
                                                     "E7ODTKCHoMOGW3qJsDaTcrg9DFUAKVWm7RWk4XFKJlt1GVcnK5/VRqnak42S" +
                                                     "opEOFDEKdQesZaQu1Zk9axhb2lDB2oODCdUAp1rKGqQJhaJC3X7LJ21ZLw3a" +
                                                     "bE3LAsZYJsAwD23AaZtmQLEziim42OyQOE1ooNTySV8esYNFG51Gye7YUwvQ" +
                                                     "3bWJ66FLlgiXmFitotkOoFAUGMJEErcndSqoQ/A5A7YKFtGqc3J4j12hiMV6" +
                                                     "utqHpwmuUyDaM4DTRK1sguPJas5t+z1S1RsMp7TdgPop3m6hkz09rqoTR+D5" +
                                                     "vuyDPVZrXBlP9zVWZaGnpcKUSZQxOPgsIO3KYwyjtC0Yw4i/nIZL0icX8Ild" +
                                                     "CauaY4QOskIs8HqDrKDtsWOirU0oyxNcLBM9Vdao2bHyXlXE02yxlkQa0Tl2" +
                                                     "NjiYHj2lNhI2XwwRdrodN7st7mycRia4IgzyFSqU4+kQRi+cGMzNGDNs97QG" +
                                                     "uJKHCNJh7RVK4+vJnk9D2QVmqnac2ahWclhbzrtU5MT9uAHGNUOrkR2XHhOL" +
                                                     "DIfvZD88eBSELiXFRj3U7qsJPjgf472ke2C46E/2Eo1h4ChMJd3NG1FdMOhu" +
                                                     "sE6Joa2MZcwB8XKyn69bnPS64SbDtXKSgT7OQBxL4hukxKijs57Y1tQx8TJi" +
                                                     "DgLJHABJWm1EA5k0RRMVUJ4rEQqSWmCu12Km7zRTpzrMdE4AOFhHDPYrO1ID" +
                                                     "xFJWpQXlU0WDOdL03MSDdg6+OWoyPYXsw2kdiLRgtvMW6DqPLqMGY2iu2k52" +
                                                     "g9t9OIbbE2qwNIKylLbZwJvQC2NmD0w0jqq3/YL2x7aQ9lGyNE4ORy73B4Zd" +
                                                     "TCMGJ3L6rIvhDN4JuzCc8yuk7SrYSjwa8CA7awOZ29KxW2HsqdtBe1ZbeIcS" +
                                                     "8VM+nCGRrKx3R788VVIJ9vmxwr3aMqgh+Gt1cHbag/hkvPRp2zuZ5gxrMlKJ" +
                                                     "8+0khrNYnMYg0i5SYr/QulZx6UzZYtSKYqjpcdPR1aZvyKnM2JMTsOSDbk6u" +
                                                     "OCKXtHyQqGDmUn6u9xyFbMhh/rzZelGKIHt/Tip+gPWzJE45vS4l9xgstliz" +
                                                     "r9I96M+Cji+oHCczVdpuFuOT0WzY0xLMtfLITEO05ZSx70jIYQh9nSVXWwxU" +
                                                     "Libahi6YRVQyB7Jok0iijuMEFbjJ1pvVbcprBTlzii2oO8R85sEnJkVTv8H0" +
                                                     "lchotJCzlMpBdDIFPNspUi6QJUuk8K1z5PjjeBe061qb0Hk9+O4p4msgtYbb" +
                                                     "naS1NlS7Hm6Ux8EZthZTft2T6ni84eOlABHuVku8GhRmnpSBu/J4PKQuVoBa" +
                                                     "C7KUAuRiKisZbh1nM2PJRTQCEp1DTTSkxDdsMJH5xqPlxPb4qRy6+KKrNtt6" +
                                                     "EbOdpGCJXfUU3pdzaqmprdz66nY/xCz2ejWEw4mvFWBCVN0e3MfaUu7zTp9y" +
                                                     "RJrk/HC/tFKCbwxY3tObZQO34Wmz7ZxKkX2vpUsc1JDFKgzaXGHyWeL1nC9b" +
                                                     "ixRvU3dF+ywVkKtgv1y57kZ1Yl1yWkWfbvfbHQUC+n5+cOtotWj5srWUJOBz" +
                                                     "GkgqrkgSeRVCbixJeTpuRG3FqAqZiQUXR606myVmJmUOatPJMhiHfMIbWGFv" +
                                                     "WBoLCk3mGjEWoiiZDIZ0OmEUrtz5WksnVisKxVaN6nksc+pGQDEJPOUupUVl" +
                                                     "rTc0KkWB5fIw2lOsTR/Q48QWT+5m0sPLAzEmRQ5Yyktn8Kf9vK17XYqiib/o" +
                                                     "GuAI7RBlXAx+rDNnpkZjFhtbIcMot/vJaovW27HpEAmf2+NkY49hOzs1vRBR" +
                                                     "lI3OlJMPyMFkBlvwLFHFQm/GAoQhRmkVWHCSFxjmoEd1kqJLu9skHbhguyk2" +
                                                     "I3AeZ1ryaNRmGQ5BxLocb5Z949XxbjPe4K6GwfoQs3i1gvP2epp4+wJeoyha" +
                                                     "FCXdUnsGXkIKVExgLphlblWOt8IhyhCmS+qkUGMrxwBDIKxOS4Il5bRcje5d" +
                                                     "DcHS3gFodjNmsRI+rK1D7KxL6cDZiN8Uaww5KoFdHfz5ZLJdg/6agsWUOLq1" +
                                                     "zCGHzFAByVPn8Kk+8ch8ttIkiZ+QUposN6iE5+OUrM1Fs8BTyc+CdruEtxaY" +
                                                     "HnQimKWk0kDRTkO02Sqi4WUlsk5r4qGYh4KpbSaiCisUbNgBTejbfDzV6CHQ" +
                                                     "qaeYyVrbadHgs3HORADRMpov4Lx3EhqwRDDHc0RnjBiucAI3g3hQQySQsC3b" +
                                                     "A1CHhQcNmbu1NI1w/rics9QRDR2xKPnTgT5tgVMHhuWK4LlE2Kw0jN1qNH7Y" +
                                                     "uo4SHU6wG55N7XKXkVAu2TOUbtKtOh27SNAAM7pbBOGJbE87zjhpzCQaAn+/" +
                                                     "b1a8qVlH0juWaIYM9vREL/kVcQypSE7MqDic7IFNlJYOsTqDcGFUmfwQoxwX" +
                                                     "HlnNmUO8YOPZuprPJpljkbWu+t5RGsISFzYXZdmptuOynAPvtZ1Dbgj40OOz" +
                                                     "ZokYgDbzlhOFmQU2BamQLNs+0fBbwiNJbUWJMwIOpeO6pnt3omyXp7CXAzCV" +
                                                     "3Xyq9RF8CPzWaFzuiO81nLGJbbZTEBZyi8D19vlizyUHHoZgn6JbRnVqsi3z" +
                                                     "GA0VRrf2NZ8WfRP2JwAfuyB52k5wsd9PaKlfj0lry21REARP4IIWYgNp9vU+" +
                                                     "ZRd9ENi2BccboZ/aZpydlHXnYIKFb6fqCYg2zjQyxeU0WQfS+EAGvTxYqJDW" +
                                                     "YDxqMoA7BkC1GIDbTxixtep9s67HaUwTwIITHR/YAVs1hCbCeJXDsJ4Hx6Q8" +
                                                     "JUgEw81KiaeSMSlrFuXFprDZSWv7W5zF8pmzHU99KObmeTipFLxDFIM+ZFMA" +
                                                     "4QxsbkAZSUs1zqIHRkcNrQqakB7iaZTA27olxrhRoTsiCsWDXIGbziYa3NvX" +
                                                     "43i9Gk+sk8UHg7oi2kBWeUsWxzUCM+y4r+1lYPMqMMXxmpiKhNcXG4sVgBzl" +
                                                     "wjHHTM1ol23x2BGIA2CKKuYBqxWI1umqbJwCJRywbvdDZCbI684O155yXDcV" +
                                                     "dUlW+87rrII3X3Ie7ibNB75zHviWRyZX0AdJog51c9zsbAzTgsPOi8XFBNi2" +
                                                     "5mHvHHC4Ek/7cZHPWHwKYzixIkyhXgKIKBjTxOe0DUmSHz1v91evD//Khw5/" +
                                                     "HnqV468SSr73MQlB5AO5HO86b3bJh72ZzPzK5jzlw5cjunsJKu+/m6By+T11" +
                                                     "nRz+/df1X7svQeW+fMvROentPa+Wx39JePvst376R6zNj0G3rjNv2Gr0+irN" +
                                                     "PhzZjR3dt9VV7qJ/F4w33MlVH74nP3Fd+/dn2dyj0g0MLpA9c73Eu66Nmxg8" +
                                                     "OjHobz5m7EfPxQ9Wo7edCfv8TcI+fw+eG1jcHj58NHr6rdf16MvDYljy1B9d" +
                                                     "1//j1bF44l7i5scuu/74Y1D5u+fis9XoOU9PrMi+L7HvUbk0Tepbj0IMGD5p" +
                                                     "APLnr+sf/vIQOy/5oev6M38y9vz0Y8Z+5lz8vWr0JteubiB0fBT052zJ49D+" +
                                                     "K9d18eVBf16SX9fhl8GWf/IYFH7uXPzDgS1nFOwL/FfpUed+8QYSdxNs9aEd" +
                                                     "XtfcY5B4RBLaecnyuqa+DCR+8TFIfOFc/EI1evs5628wBb5z+mNxuTDkfcP3" +
                                                     "raPRcx++rt/25THkvOSt1/WzfzJx+pePGfvVc/HL1egtmV2cn0CQ95LyziM/" +
                                                     "+Woi9T2j0Zv/8XX9o18eBuclf+u6/sE/GQa//pixf3cufq0avbW0K/KhpOhH" +
                                                     "IXF5IPSBM6tHV79LXY1+/eGXG7df2PzWt33qT/W1xqNe9XwEAokPweCHYeSD" +
                                                     "H7md13rp53Va2S9cvYm4fbZMt893nZ80aWjTtnPfe5kXPnj7E5Xnly8+2l6/" +
                                                     "8MGXPvnBLHt1vlx+T92kxnn0i1n2GLr/h8eM/fa5+I1q9I5XA/pRbDnfwJeU" +
                                                     "/hts+ft/9thylbB/P1/86syH2x/7uHz7UeT+hgfJ/fSjyP27jyX3lx4z9vvn" +
                                                     "4neq0evuwPIo8l4Of89D5H3i5//Mkfcqa/f2tfBfPwe40PlOEnXqvPCxS174" +
                                                     "ufcTemx88pJle9W6+7Tm8veybvOh29fT9Ua/Of8qCfpqcvrxxcBG37n9Qnrb" +
                                                     "v3vY7ZvQn1l9s++2efujt194aGb60u2rFO/bD7/9Uc6ZznZeD9IUDaTdpS+Y" +
                                                     "Lz7Gpf3QBZVBn683dPSotB/S7kcn0p+Lv3j9uOpBQbp1b9bFX84vs/7wMeJ2" +
                                                     "cc/+YHBBHmTJuXdxv9DdeRP3jjvCdqfjPPqe/wdQPzF6daifuMz9n9XovRcK" +
                                                     "62X1aDJfYOoG5+TmwPnl1zseeoB99UzY/PyPPPu6t/+I8m+uXlzcecr7FD96" +
                                                     "nVNH0f1vme5rP5UVtuNf0Hvq6mXThSRPPDU4o2fYzu2nsyvs/i+40xRnAj4A" +
                                                     "AA==");
}
