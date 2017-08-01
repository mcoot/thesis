package conf;

import jif.util.HashMap;
import java.io.PrintStream;

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
    private Paper upgradePaper(final Paper paper) { try { Author[] paperAuthors =
                                                            paper.getAuthors();
                                                          Author[] upgradedAuthors =
                                                            new Author[paperAuthors.
                                                                         length];
                                                          try { for (int i = 0; i <
                                                                                  paperAuthors.
                                                                                    length;
                                                                     ++i) { Author u =
                                                                              paperAuthors[i];
                                                                            upgradedAuthors[i] =
                                                                              u;
                                                                } }
                                                          catch (final ArrayIndexOutOfBoundsException ex) {
                                                              return null; }
                                                          Paper upgraded = new Paper(
                                                            jif.lang.LabelUtil.singleton(
                                                                                 ).
                                                              toLabel(jif.lang.LabelUtil.
                                                                        singleton(
                                                                          ).readerPolicy(
                                                                              this.
                                                                                jif$conf_ConferenceSystem_O,
                                                                              jif.lang.PrincipalUtil.
                                                                                topPrincipal(
                                                                                  )),
                                                                      jif.lang.LabelUtil.
                                                                        singleton(
                                                                          ).topInteg(
                                                                              ))).
                                                            conf$Paper$(paper.getTitle(
                                                                                ),
                                                                        paper.getAbstract(
                                                                                ),
                                                                        upgradedAuthors);
                                                          return upgraded; }
                                                    catch (final NullPointerException ex) {
                                                        return null; } }
    
    public void handleSubmission(final Paper paper) { try { if (!this.allocationsVisible) {
                                                                this.submissions[this.
                                                                                   numSubmissions] =
                                                                  this.upgradePaper(
                                                                         paper);
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
    
    public int getSessionNumber(final Paper paper) { Paper upgradedPaper = this.
                                                       upgradePaper(paper);
                                                     if (this.allocationsVisible) {
                                                         return this.declassifySessionNumber(
                                                                       upgradedPaper);
                                                     } else { return -1; } }
    
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
                                                                 return -2; }
                                                             jif.lang.JifObject sNoObjDeclass =
                                                               sNoObj;
                                                             if (sNoObjDeclass ==
                                                                   null) return -5;
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
                                                                 return -3; }
                                                             int r;
                                                             try { r = sNo.intValue(
                                                                             ); }
                                                             catch (final NullPointerException ex) {
                                                                 return -4; }
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
    public static final long jlc$SourceLastModified$jif = 1501548283694L;
    public static final String jlc$ClassType$jif = ("H4sIAAAAAAAAAL1cC3xUxbmf3YU8eCWEVwIhLBBAQBNAhGJAwQASGyAlBBXR" +
                                                    "eLJ7khzY7NnsORuCFgUrxVaLXgSrtdLaKxYtQh/S9paH1BdotdZqldqK/uzv" +
                                                    "3nKLqHjF1tuqd75v5rzmzJ4s3N6b3y8zZ2fmm8f3/ef7vnmcs/sU6W2kycjV" +
                                                    "WmuVuS6lGlVXaK0NStpQ4w16Yt1ymtQc++TBF+L3Xp16K0zyVpICzWhKGkqr" +
                                                    "Wk8KlYzZrqc1c51JiutXK11KdcbUEtX1mmHW1JO+MT1pmGlFS5pGJ7mJhOpJ" +
                                                    "sUZTlKSpKaYaX5jWO0wyuj5FG2pL6Ga12m1Wp5S00lGNXaluqE0ohkFrysNU" +
                                                    "q5KCVFrv0uJq2iSj6mnHeemE0qImqht4Xj38qulOk6hVPR8fGxzWzEa3fXL1" +
                                                    "tm9eV/zjCClaSYq0ZKOpmFqsVk+atD8rSb8OtaNFTRvz4nE1vpIMTKpqvFFN" +
                                                    "a0pCu4EW1JMrSYmhtSUVM5NWjWWqoSe6oGCJkUnRLkKbVmI96cdYkomZetoa" +
                                                    "Tl6rpibi1q/erQmlzTDJUIctbHgLIZ3yog9lp5puVWKqRdJrjZaMAy8ECnuM" +
                                                    "lV+kBShpfodK5WU31Sup0ARSwiSXUJJt1Y1mWku20aK99YwJDB6etdIaEIQS" +
                                                    "W6O0qc0mKRXLNbAsWqoQGQEkJhkiFsOaqJSGC1JyyefUktlbbkwuSoaxz3E1" +
                                                    "loD+F1CiCoFomdqqptVkTGWE/SbV36MMPXhbmBBaeIhQmJX52ZdPzz2/4vBR" +
                                                    "VmaEpMzSltVqzGyOPdQy4OXy2omzIgyCuqGB8D0jR/A38Jya7hSdWEPtGiGz" +
                                                    "yso8vOzZqzc8qp4Mkz51JC+mJzIdFEcDY3pHSkuo6cvVpJqGKVJHCtVkvBbz" +
                                                    "60g+fa7XkipLXdraaqhmHemVwKQ8HX9TFrXSKoBF+fRZS7bq1nNKMdvxuTtF" +
                                                    "CMmn/2Qk/S+k/7/l8QGTXD//4lVNhppeSGsxVs3XY5kOlU7gVU1JbZXZrhqa" +
                                                    "sSqmGGqzYWbiGi1BEc25jo/NdEKuMtIx/LGq1s5sXGeYakcVzU39P7TRDeMs" +
                                                    "XhsKURGUiwogQefOIj1BlURzbFvmsgWn9zT/KmxPCM4hilWovUqsnYRCWOtg" +
                                                    "mDRMqFQka+jkpkqv38TGa6+4/rYxEYqm1NpelKFQdIxHudY6GqAOlWGMwvCV" +
                                                    "S1PXb7loxOww6b2SKkljvtqqZBJmQ+1leiZJlclgO2mZSvVMErWbVMPmp2JI" +
                                                    "Y5JhPt3IdCIlSzuVANkICv1KcQLKulm0+cTHe+9ZrztT0SSVPg3hp4QZPkYU" +
                                                    "Q1qPqXGqM53qJ0WVfc0H11eGSS+qNujYTDoy0EIVYhuemV5jaU0YS286vFY9" +
                                                    "3aEkIMviSh+zPa2vdVIQHwPweSCVUl9rLlQQEnmcx9+D3EEpCAczPIHYhVGg" +
                                                    "Vp7TmHrg2K//88IwCTsKvMhlEBtVs8alNKCyIlQPAx0ULU+rKi335r0Nd28/" +
                                                    "tfkahBAtMVbWYCWEtVRZULNI2bzpaOfv3zr+0KthB3YmtZmZloQW67YHCemk" +
                                                    "Dx/cgzy+3zVI2tp4pz9U6SSo4qPdNSqbkh16XGvVlJaECjj/R9G4qfve3VLM" +
                                                    "cJCgKYyraXJ+zxU46WWXkQ2/uu6vFVhNKAZGz+GZU4xp0kFOzfPSaWUd9KN7" +
                                                    "429H3ndEeYDqZKoHDe0GFVUbQR4QFNoUHP9kDKuFvGkQROl0FjNpcyOcSYuT" +
                                                    "h/oNGnMqmmNDPxxTnVo4/22Udx9QE9RX0mLUCyr3zblaOxcmHtjuNqvwSF/h" +
                                                    "OicbpswwsQ+8/V7XRuMfRsdcg/Okb1w1YmktZQGLavo+htaRSlB2q3Gc3tTH" +
                                                    "MPUrKPtshymtJI0ENTBMJSzHzAXdqTSY6y4ljXJCroztBpDa3WgAP6w5NvP2" +
                                                    "zWl97NdnhDkjB0Awupt6gXGmpaKpWDRhqZeLAcZYh9Wsw0yn6ebYA0O+eaDk" +
                                                    "B1vnMVs8ykvhKz17Su1Xm6f/6EUEPQCkQuTWMlWhOp6xszn24Y431GUXffIe" +
                                                    "m6T62qToP6ao6xPTUgr4kPwJXM801gLjmEt7VeqDBa9+xje+u/fU8Ya5iGWX" +
                                                    "AMBB8PmoXMIu1kFY67UVdn+qluspu0vNseuG/mZy+YGrv+Zmk0DgKr3lkW/n" +
                                                    "v3/+J9/FYdswGCvAwCYIhAKEs1h/UVd4BOTupFtOw4a8+erRrkXvse6KOJBR" +
                                                    "XDpt8KETpWU3cslCg/N5qxAtkgr7SroMcYQdrap/8on8Zc+7hI0SpCxYiwWZ" +
                                                    "PCGc5whgCa14nIyfl+mmqXe4uDpn7Buraz59+XFrAiywuTLRO0CB0j3MvEn7" +
                                                    "y7b8YcNSq446NtSlrqF+iSVNT3Wjhm7CX7MN0AyC97FIMdqp9TiWeH3l9jcn" +
                                                    "VTBmu6wLz//F/E3b7/n5z6YzB6Uf1XXFl84lhCk9qPzSFPZlJetKytMN4edi" +
                                                    "VrSZCShlC8f7k8WlqFhhpVnucYYWwtLHcQBiN8z5j62fdVIHILKSDGhXjLok" +
                                                    "NZiw0qILOtCe9i+TDHRNK1RL4AYk3C6NuDwQGltZvfvbw2svOYkz1vE2gHpU" +
                                                    "t99tXKG4HKFpj3acCY/JeyZM8qm/hl4YXdWuUBIZsOEr6SLNqOWJ9aS/J9+7" +
                                                    "4GKrixrbmyoXPR1Xs6Kf47ir9BlKw3MfwbWBfzKZ/pcQEm7h8SK3axMi+LAG" +
                                                    "ScZgOA6C81BmYXicaNKWtaSSELyJYl7f5TyucdVrkkI93aYkNernGx5bhqpc" +
                                                    "jbMF2M5du/fU9HtkJ87UQpQflabJ7VYBUFi/2dD6e4cW5U1fKRsamz02wXAZ" +
                                                    "wZfcBBhl+DSD8ErpJLFrHAGJo3hNK3i8THQc19HxV0r1NODWpVbKtY7MQx89" +
                                                    "34CQ7I+bHpbwTVImAt7xrlEFeTtVzjvTKOuU4TOvWKFbOx2r/3THnNcO7bPN" +
                                                    "a5ngBTiTYcZzj0ZeWrHqASZCl9vutnyw8nFtHfA9i4psY2JbFjiwdntgFTCw" +
                                                    "iXypepzHr7gHRhiWb5VjOcKxnGfgFg/80jmiP6d/Ifr/GfxDM5AAMZ2utXxV" +
                                                    "HrWX5Sm6PAwtNfwqhsqyg+qoLr4Dod627eufV23ZFnZt04z17ZS4aVzj7g/B" +
                                                    "10BWo4NaQYqFf967fv+u9ZuZ3i/xbjosSGY6Hnvt0xeq7n37Ock6t9DGo7XI" +
                                                    "Kc8iamxqzJ/yN9eduGIn6uhi0HPoJVBFB3MXk+qS3qS+mmGDHId2FwRbYXWM" +
                                                    "dsUrYHE6NflmtGWAIOjCCu91TGeX12b5k4aYZAAu7Zda6gnHTVxzX7V7BLOf" +
                                                    "XED/h9KeHOHxwxL1+R055OhCLJ/yl/pcqqA7+/LKdvJ4h0d3liiJhB7D/UVj" +
                                                    "hWZolhOW9vasjBP/RNYzQfsNkhE85tN+u3LXfoMhsZTX9GMe7xG1324sf6OX" +
                                                    "aggvvVdGhUVvds1kByHDZE3+KBAhj2AvHnfg8IgfId6kO/jMg+hOKsAWXU+o" +
                                                    "StIFk10ymIxjXQt/wOPXJTA5wGACwff8eACq13j8kgcPA+gcbsy0dGiGAZCQ" +
                                                    "YWEIJ3xb1ryAhSIZwRs+LDyVOxbAFUDRQk1v8fgPIhaOCFhAqoG89B9lVAFY" +
                                                    "GCRr8nggFp7GXrzkCP5pPxaeDsJChK7gXTh4SoaD6WyeRcazOPyZBAevB+IA" +
                                                    "qD7l8cceHPQ1gkEwgbddJmtbAMFoCUFkkA8Ex3MHwRhI5MOOlPJ4sAiCdwQQ" +
                                                    "INVYXnqIjCoABONkTQ4LBMFb2Iu/OBJ/yw8CJylNhjvmEJ163H5iBv7IhaXb" +
                                                    "N9/912HU9VlJ8rnTj+7/Ej2JPyRnGy76D3a/dfK3/UfuwZ2cXi2KwXx48VDI" +
                                                    "f+bjOcrB8fTzAmG0Jc+sQBCQM4oTDMwBOWUSgkhfH3LO5I4cdM0reE3FPO4n" +
                                                    "IucTATlINYKX7i+jCkDOSFmTRYHI+Rh6wfcLl7IEH3I+diHHe6xK9bdhug62" +
                                                    "rjpvxS9vLTNuZ07bRBslardZhb4/JxXpfn8sMq2vWXkn+ts2aAro6tCAkiaJ" +
                                                    "Zj9SxbqYf9nX5gQeBVFXi+TR/+t53GSSpn/mMU2DklLT/Pzn/6ZiFE6h5ePh" +
                                                    "vmwVZuJxjU8SzbGBs+5vab1l7hF0iouQeeixNjI2jvcuXzhRZaO3nPeMWSq7" +
                                                    "5tiJvd84OvovKwbh4aElJvcJwWIlVSOeCMCeDU3vnf/GL58aev3LERJeSPok" +
                                                    "dCW+UMHDFVJotqdVo11PxLtTfGKF1hbQMEws33qj11pWcuGmeawAy/oC3EP9" +
                                                    "+OIpNDRo8QTBbRDoiKGvUYs0Dy8BIENkFtPekwmxlfvd8DiShIigUwB/xFLg" +
                                                    "fXjcS9QpoVG56xQc8TBeUyGPews6JTRW0Cm2VwGl82RUPp0y3yYeKmuywEe8" +
                                                    "yNEpoSj2YrKtQGiCqFOcpO5u71ZCdlhOrYkteVKfNRGxnWe2a0blFDxgkUC6" +
                                                    "hrF2EDZSjSjqZSMIlcuH3G8JTZeDI2yDw8ZFXkJNtpls8Z5mdciOVZbTnvFj" +
                                                    "jXs+Hrzsliv/1oR6LRxDP2tUPSlozSQSS+wVK4QzWX0mmYuVRPXWKFUbUSOl" +
                                                    "xjQlEbW2raNjYNxjoloyinrgmhuXvvPVreuvxeidr+9cf821KXvL194KqVWS" +
                                                    "Sd30nTfkxbR9p6pbP7W2a+cw+bzPh2YP8yPMPYO6CIILcbNFeiq2oCNl4jnW" +
                                                    "DT8f9vjs7+84jpstPimIdmQxmn5n/2Xmg/Mry5/s3PLPOzyGnyPk58SjBGdG" +
                                                    "7Mwji3c/d/n42NYwidibmr6bKV6iGu9WZh/W6nLPhmYFYzMw9BLHdR6PWMPf" +
                                                    "0hO+UF1A3hchWEgVVCyhJ9WehZlKpUIhQnx1MT3GtuhDDT2qJ9w1DzUyxZFt" +
                                                    "15ypB1b0KqYHsu3FQ9jUDRsNpdlADkVeRdaxSXwx1gsHH6HLSAhy+XLmuGw5" +
                                                    "M4XgbmLkbh7rbnXG1cJ1gcsZoEryuM1FTY2Ha5tDcErzLT0MBm0nj+81yReq" +
                                                    "2/UOtXq1Gq9eq6fXVINCi9M5hA8JreUC6hjgM9pVbkO533HOtFzIMNRmJui2" +
                                                    "HgXNCkO42tHkzX7l3uzzMzmZnjtZKA+COJKZlgdUDFrD7UlgySIMB/PORtBf" +
                                                    "QBUu+Au4FzeO8/2nPN4LtCoyoNXyF9Zl8RfsKwj2hqtwinAOe64rbA8jtAEH" +
                                                    "Ww5BBoIKwZ+ADXBcWgLqNvH4Zjd2sfe35u5P4IJhNK/pVh5vcNcIFd4m+BP2" +
                                                    "MgNKb5RRBfgTUVmTX/ERu/2JTdiLuxygbPJjx5vkyBwW38g4kPVjPH5YIvPt" +
                                                    "2X3E0HoIboLgZuzKBio31LVfySor3BIczoe3nsdrfbL6Vu6ywpGU8Zq+zONu" +
                                                    "UVY7BFkh1VBeep2MKkBWpbImbwyU1f3Yi4cdwdzvl9X9Lt8Pfk+BAHnDlHao" +
                                                    "rdtlEO3e4B+4r+CF7ufxPldvsGSpc+FlZLYbmLjr/9At23bEl+6cank/d5l0" +
                                                    "9aGnLkioXdztZ1XlYx9rvRbkfPo/iZDeY3kcEeRAigPNB5CEWdzr7+IIHNvu" +
                                                    "dlodM3Ih1LKQ1zKHx5M8UvHs8DCvdF66jTulu/o/86tTpQuP4g5NOKbBtR3f" +
                                                    "hbe4ms2XyaSoSXb7VOEuDZ5WMz/W7uZcWTdnurtpkuug3Q49nWrX+O0acHzZ" +
                                                    "Zbeokm7DRXQ0BU4AZLAdomgm1ZZW4ir6BtHzWqArajyqtOhdarRlXdR2EyYy" +
                                                    "8zCbRbUQPM6EA4/7gpgNBX7B0LkfgkMI6ycQnYfPrj7/uXtTck1SX5tkWx+N" +
                                                    "fXdnvnLwgmMWDPkZGbZ3NMDXewGCn5ikn5sbkPa8zKGTXC/hveCgGFz97gNL" +
                                                    "//bOD61uzGSjS3lY+JKQSK0fysZxJQ4xtfa73NXaPEhcwOExm8dfENXaMUGt" +
                                                    "IdVlvPQsGZVPrTnbZPNlTdb4iN3uC5P/244OO+RXa06SeCeknjqECWdBsfyO" +
                                                    "I6/PuO/EVlzIBl/wECgTDyWO1H+07teWlJyDZFQK9XwstTKlwP3aP8vtHPrM" +
                                                    "9krXJVY+FWypMr8MlzChU53WHojgg7n2bDrt/RfHOILAyKW8kzN4PMXdWezq" +
                                                    "B7mj6GJIvITXdBGPp4oo+khAEVLV8NLTZFQBKJoja3J6IIpOYy/+4UDmtB9F" +
                                                    "p2XG8T2fJqJBOIzaSMoeyPklBCdRcCh4lBjmPJVdr4R7o16B4EXB7th76jDQ" +
                                                    "oTLDJ4i5TEZQLIo5XJC7mO09dahpCI8HCmIO9xPEbO+pQ+kSGVWAmEfKmvQf" +
                                                    "5bjEHC7EXgy2ZUoTRDE7ScDpQiK5sOvlJTgcxILoRB6P9fFyeO68hCsAZCqv" +
                                                    "6TweV4q8rBB4iVRVvPQ4GVUAL6fImpwQyMsR2IvxDuNG+Hk5wsVL2OTPQ+01" +
                                                    "QYb8nwcg/wIR+ZCIu3PhgmxSQp5js4KXiPfvo8zOFA7jcVjgrttLdPxc+1Y7" +
                                                    "kIRYXHDWXiKcgqKCg1qm8rhC5HVov00wXUYw2U1gkpZz8tfalWQ8oTpn/Wfn" +
                                                    "s4Wn2j5WeFoPPlt4puOzhWehdC7GeVFzVvVB0eeRujYAL3BDNjzFJMXi+Dqz" +
                                                    "eWGd3IeiXfA7Vu5En2NFB4PjWJz7/AaThJYW5DiFx+eL87tBmN9INYOXvkBG" +
                                                    "FTC/vyBrsjpwfjMhXeVM5ln++e1JCv27F+JzeTMzZRBnPk/42nPweSiUkOGo" +
                                                    "O3yggiCGwMpmfsOzIVCsOsLX2koofEkAqFoRVBAsxHzh6KlXl67Fe7YWoHjw" +
                                                    "CgFwZKSlhdycQb6syR1NeLNiHK+pnMelIpp0AU1INYaXLpNRBaCpUtbkiEA0" +
                                                    "4V288FoHOgk/mhJZrYVPUBcFCOomR1AQtGUxDms6sxkHKHkd9ape4fFegZk9" +
                                                    "GAcg2cPjXS7SgC5vCsjbDMEGkwxoU83st7JsqwatPi3ruADE4TKCQz4g3p47" +
                                                    "EO37yVDTUzx+QgTinQIQ7QvEUPqwjCoAiBWyJp8MBOId2ItvOqi7ww9Eb9L7" +
                                                    "XiYPt3iVlcmopB5wbeP3oQa61HpbSYEbOVG4SWG/tRT+To9c7rSWduF/tftJ" +
                                                    "E8SuC0mLHbJduZHBDzh9gldPs+gyqG0jzgNYmYf35NJ3RhD+ESbMZwn4bJ1G" +
                                                    "+ZMWO2Q/dUSz0S+tjR61IZvQoKpaCen/MI/vOLsJDSS383hT9gkt9/ZweXAp" +
                                                    "pz7MY89NWGbCbIJZMoJfuAnO1dsDBaKi9liSgc8MnKW3d8Dxzg4GDR0KPOny" +
                                                    "9vAeZPgZVCfPnlV9nba39+sABfkbCPZTb08cX2eP3t4Bmbd3IMjbe5qpxWO5" +
                                                    "q0V7AwTk+ASP9wsIDP9BUIv2BgiUPiCjClCLc2RNHvIRu9UiE9KfnFnlv6zq" +
                                                    "TXJ5ewjxBbyZZ2UQ597eCTbNMMzZ23sSe3as0+vtcVBB8B4CSyoKyDkCwbtW" +
                                                    "HeETnbYT8VwAqE4jqCB4WWZpB/NRbpdpFMHSDpAR3OkmQOZ8lDuk8Eb1IF7T" +
                                                    "Nh7fJULqbwKkkKqYl/4XGVUApEpkTd4dCKkz0IsIcfBzxg+pM27d/WrP7jPe" +
                                                    "wJ3Mm99tqXWRl5G83HkJvjjsdmBNP+Dx9wVeRvoIvESqCbz0LhlVAC8nypp8" +
                                                    "NIiXEdzsiJTYjKMJIi+dJAi97rOI/MPZkR8pE5EPj/+FZB9lkxLyvFNifu1X" +
                                                    "WnQ6D17n8U8F7vZwJAck+3jsfnUjJ/OLeyeXc+rTPPbd23eZ33kygpNuApNo" +
                                                    "52R+4X6SQs1T67r/hRWOjLStZqSiByscGetY4cg4FNJ4nB4Tzqq+TssKR6oD" +
                                                    "YAOb85FykwzLMszOnowx7YnfGLsTfcaYjgmHMyv32Q4HU3j0CVL9gMfvirN9" +
                                                    "tjDbkaqWlz4lowqY7QtkTb4fONuZrOY7U3ucf7aPy2KMEfCLeTN/lQGeGeNI" +
                                                    "3TkY4wi+lx+B9/LZ5WcPtiDAvk3IZowj50Gw2KojUocVYc6kAGwtQ2xBME2Y" +
                                                    "3vbLSDDKJ2T6RTAgRTKCf3MTIHOacoeU/TIS1HSIxx5/HSq8WoCU/TISlN4v" +
                                                    "owqA1CBZkwcDIbUCe6E4+Fnhh9QKrzF25qpzYO66vABXsWvtW53Nsfozvxva" +
                                                    "dZ7+LPsohf2eJ1YifgNnFQygnXW8qITHeb4ByFWbw8RWqKaNk3NmFhX7mZgN" +
                                                    "juRW5MoaESR4lHIh5+ublvXygSSVO0jgXAYPiaCmP/L4mAgSUxgfUlXz0r+X" +
                                                    "UQWAZKqsSf/rbm6QdGIvvuwgotMPEm+S");
    public static final String jlc$ClassType$jif$1 = ("w7Ol0FwTb+ZzHn/i49nG3HnWAInLeU2f8fi/RZ5tEniGVF/ipf8uowrgWaOs" +
                                                      "yU8DeXYL9uIbDoNu8fPMTnI7ZT4NODpAA24TNSA8LsespmyzFTLhBmxEyzKb" +
                                                      "IA/3ZSP3YegISNxAgY3irXQRcJLHrwpS6GEDBUhe4fGLLtKAAX8nIO9BCL5l" +
                                                      "khLKSXC65jn3ejuzbPgKYMW3ACt5j05Zg/OB9aEewQqldmKnnP01muBDwE4/" +
                                                      "cBjZY7mRQZh1a+u71Bjcx2PPpdOeJQMkN/HYffcwgPs/C8gDQxr5sUmGGKo5" +
                                                      "z/dSeY7CwTXeBN6p+63x+YRzICfhHMR+HXZYetDP5YN+4TCyZ3IjQ+HAB6nE" +
                                                      "7/fBfaNS3ydB2WcsY3t2FBUM29H0Onsd0/rUZCF/B8X9uRXXc14qrbZqKKlC" +
                                                      "ZlPx3n7kBZP0gnfQ4PlF+9MDxfgqCHz7pYp9+6WbaYlSqTW1Dxjh9uZJHv/F" +
                                                      "zfcerWkANF7zfpcFXi3JsG+uNsc+mDZ1/qGj44/wzzZlfcHNodi744olN56e" +
                                                      "wb7k0psuOG64ARotqCf5bBnG3Q739yzE2qy68hZN/PuAHxaO83xgrMQ1eUrd" +
                                                      "OC11vORbnW+buD/S5f4obHNsDVl/+9ObSzbiW7uFmrE8naHQiMPHS6xLr1DX" +
                                                      "LexuH3uzI3KcVjxB/HqVq1r3u0Kh1fctrc///Cr7XSGpfNibF/8D2GmezIJX" +
                                                      "AAA=");
    
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
    public static final long jlc$SourceLastModified$jl = 1501548283694L;
    public static final String jlc$ClassType$jl = ("H4sIAAAAAAAAAM28CcwsW1oY1u/Omzcrs9kMA8wM1zMPPEPNvOrqqu6qngkR" +
                                                   "VdVd1dXVtXRXdW0MPNe+72sXHoItGRAkxMKDYwsb2RZYXsaDYhlHkWMLR0ow" +
                                                   "wtkwMkGRg4WsxBEmwpFCoiS2U93/f5d3733XjORE/qU65/Q53znn2893dL9z" +
                                                   "v/rbs3fW1exhkScXP8mbN5pL4dZviGZVuw6ZmHUtTx1v2j8JgF/5j77vQ3/9" +
                                                   "HbMPGrMPhpnUmE1ok3nWuENjzN6fuqnlVjXuOK5jzD6cua4juVVoJuE4AeaZ" +
                                                   "MftIHfqZ2bSVW5/cOk+6K+BH6rZwq9uejzoPs/fbeVY3VWs3eVU3sw8dIrMz" +
                                                   "wbYJE/AQ1s0XD7PXvNBNnLqc/cDslcPsnV5i+hPgRw+PqABvK4LUtX8Cf284" +
                                                   "oVl5pu0+mvJqHGZOM/u2Z2c8pvh1dgKYpr4rdZsgf7zVq5k5dcw+codSYmY+" +
                                                   "KDVVmPkT6DvzdtqlmX3L2y46Ab27MO3Y9N03m9nHnoUT74YmqPfc2HKd0sy+" +
                                                   "8Vmw20pDNfuWZ2T2lLR+m/93fvz7s1324Iaz49rJFf93TpM++cykk+u5lZvZ" +
                                                   "7t3E93/n4U+aH/3bP/JgNpuAv/EZ4DuY/+QP//Pv/twnf+Hv3cF86wtgBCty" +
                                                   "7eZN+2esD/x3Hyc/u37HFY13F3kdXlXhLZTfpCrej3xxKCZd/OjjFa+Dbzwa" +
                                                   "/IXTf6n/4F9xf+vB7L3M7DU7T9p00qoP23lahIlb0W7mVmbjOszsPW7mkLdx" +
                                                   "ZvauqX0IM/euV/C82m2Y2avJreu1/PZ7YpE3LXFl0atTO8y8/FG7MJvg1h6K" +
                                                   "2Wz2rumbfWL63jN9v3Jf/2fN7A9tvvClc+1W1LRK/aVNbrepmzX1l85Z+KUm" +
                                                   "cOuw/pJt1u6bddM64QQx6fc912/NN6PQ+1Jd2bcfXyIfD0qXunHTN6bR4v+H" +
                                                   "PYYrnd/Qv/LKJIKPP+sOksl2dnniuNWb9ldaYvvPv/bmLz94bBD3HJp09br6" +
                                                   "G8+uPnvllduqv/9qNHdCnUQST6Y+WfP7Pyt97/4P/cin3jFpU9G/OjH0Cvr6" +
                                                   "s7r9xCMwU8uc1n7T/uAP/9Pf/bk/+eX8iZY3s9efM77nZ16N51PPUljltutM" +
                                                   "zunJ8t/50Pz5N//2l19/cNWE90yUNeakNZOBf/LZPd5iRF985JCuXHlwmL3P" +
                                                   "y6vUTK5Dj7zIe5ugyvsnPTfWv+/W/sC/mv5emb5/ef2u+nbtuNaT1yHvdf3h" +
                                                   "Y2VvZqlQ+WYWTprxmz/0E7/5oz/7hX+TesJNFF914wvQ/HOL1edhrLjTkqsw" +
                                                   "n2Hgzdd+l1T82f/+v/5f4AdXwh+55Q8+5b8lt/niU67gutj7b0b/4Se6IVeu" +
                                                   "O8H9oz8l/omf/O0f/p6bYkwQn37Rhq9fyytbzIkdefXH/l7567/xP/7Mrz54" +
                                                   "okzN7LWitZLQvmH+8Wmh73iy1eQlkslTTZjUr5+zNHdCLzStxL0q5v/zwW+H" +
                                                   "fv6f/fiH7rQrmXruZFXNPvevX+BJ/zcTsx/85e/7Pz55W+YV+3pKPWHHE7A7" +
                                                   "1/f7nqyMV5V5ueIx/JFf+cSf/kXzz05OdHJcdTi6N1/0yr2tXJH6yKQbk5Te" +
                                                   "uJ5HkyaHmR0WZnIj+HM3gD94K4GrGt2mzW5j82vxrcNt7Btv/e+tnz8hqOtR" +
                                                   "+8QqDPCrf+ZbyH/3t270PLGK6xrfMjzvORTzKYNd/JX0f3/wqdf+iwezdxmz" +
                                                   "D91OeTNrFDNprwI3pnO6Ju87D7NveMv4W8/cuwPmi4+t/uPPWuRT2z5rj088" +
                                                   "1tS+Ql/b73raBCdGfPjKpCu/PjKbPbDu69119EPFtfzw8Mrs1ljdpnzbrfzU" +
                                                   "tfj2O7lcm99xp3LN7D35Ixt9JK4P3BzlY9O9M6pruXiMwvuvKHx++j46bf2L" +
                                                   "9/VffAEK3/U2KDSzdxVV2E1uYni86E3477tf7Gfv659+atGJz2aS5PYtaKuV" +
                                                   "sA4nbX6BVkxalk4m3N3HDe6PfOVH/9UbP/6VB08FV59+Lr55es5dgHXj0Htv" +
                                                   "bBqmXf7Ay3a5zaD+55/78t/6S1/+4bvg4yNvDRW2WZv+tX/4L/7+G3/qH//S" +
                                                   "C06nd1l5nrhm9rbc/vbp+9jEkN+5r3/tBdxm77h9Lb77ebZeZ/3D+/q/eQtb" +
                                                   "PzDhJrVWGtb1lbO3qZt7wq8V3czeMYWpb4sbMn3fPJu94zvu6gf/8gW4SS/F" +
                                                   "7TrrX9zXv/sW3N5XP4XY84HlzRXdyfl3vvobv/Ur3/CJr93OxFet6SC5Wc+z" +
                                                   "EfnzAfdb4uib1N/zVvr+4D193/wi+h6ZzXtvZiOaxb0lAc84wsW1MB6x4/te" +
                                                   "bBgPbrbZTF4hzO695GSjryVu5t8Fe+K10IfHOzy4m/YIiTsnffO1ZJJn7tXf" +
                                                   "Pxq7C3HC/I3Hl59pcHgO12r2bc/wmLux54mr/MvcV3+J/g77Jx7M3vHYyz13" +
                                                   "W3nrpC++1be9t3Kny1Ymv8XDffMdg24EXos/8JLjIX3J2C1Ajice2lcOPKL+" +
                                                   "Q084c+ehh7dV5/n0fXwS95+4r/MXqHP9UnW+zsrua/+t6vyUB3uC2nQ+3pzE" +
                                                   "zqwDziyewuzOCl+ZHOY74TeQN+Dr7/HFuvOOe915rb7df6+/zEca9E1RYr/+" +
                                                   "KERTJg2d9n992vYF3Lm7M74AhUkzPvAE7JBPF8sf+yd//O//h5/+jcmf7Wfv" +
                                                   "7K5n4eT4nlqLb6837x/66k9+4n1f+cc/dot8JhX73p/67h9+47rqH70Wf3i6" +
                                                   "lV6xk/K2st2DWTfcLVRxnccIPuOLXp3k+iIEm4ezHVIz+KO/A2ST8HAerNSD" +
                                                   "9TPmkupW6ZngQBD4keDxgN7j/RGX6AueEIR2cg97NA5GHeWzWji1JOWfq0Ex" +
                                                   "D5ovVY1zMNlBb44BKK0LcwcRTt44Rpk4JQu2Ywdn7KHcRRTUtKWDLrtlNabj" +
                                                   "HqlhfmXBF2w0Fl6aYh4Muh7aZaldg/V5pS7iix0patoqrbRK6ETRTHbOS01x" +
                                                   "RHpopTfQJW2ONgDIBAUcYK2AVux8vCgFQ45qwNJxWakxxib6aFSlDdlLaB+2" +
                                                   "jcZCEOvY1nnbaFCa7lRoLwCcDBUpnVDSsqD3aLoPhGJfnw05YaWCNXVTW0aq" +
                                                   "MO8vbbSk6EVxWNEmtEghtVhK83lC89ok23I7z4OYqi41fy6XLKlQVTdv9+Ui" +
                                                   "lKJVmu1cN93OSyYtgwbRIhgr20SIV4EinjCPHkZ13Jqwpx2gJl27CjhGJJmY" +
                                                   "kl7ODVYoUqqslRgwmw1WSRYmNCZPyaduRLIt1BUMJ7NF2VEUb84LskW2E01c" +
                                                   "Jelp0EhnhVvyaqSqZS65q5wm9/E5Ox1i1lJSZr2yHT3OU8NtclNOVlURWiFU" +
                                                   "gm51TJNR3uzPjN1YO//AGPAl99dJsSxaRWXLk7OvIsPk8Au2JbOWSxQgJqSg" +
                                                   "8HKHXapnGJLaYo6fpD6UtPN+30A6lKpxu5ib7Hqt9/sNsXIbhzG3zFFSV8K8" +
                                                   "tOcpe9IOvIXXE6ZH+riN90EcUrVglnuJJqH95eJ657hJLCvuWyk3hxHeQkm+" +
                                                   "ASiIDMmcylOnLItGiWVa3YKSpcArjhO1wEoJwnSZ4JjuteXCcMRxXIBIR5yU" +
                                                   "1NwW3CgljVKO9EUQneMFEbTLIk9Hxr+QbUkT2GYenUAcxvYXEw0kR92KDR3S" +
                                                   "46XOsU4YjXK0sbJAuHiclIsE0v3IONTW3uhwsZPiNl/ZnVLsS5pV9jtywq0j" +
                                                   "rHE19wHPRLU4LA6aU5lmGaQ7N1V69ojttLVMVZrE5pNKeydDQq0SyniWc7qh" +
                                                   "lRuK5NIMXBxjUAJiEAUT7EjL2gYEkUThg6JwJboelBrW9GUsJGfUV87Q3jI0" +
                                                   "owpKs5bKlKbLUVetkA4hYmsvllEO8s6WbbmGGcADXUL1stZoVzdjWxnP8FpE" +
                                                   "5dPG5WotqNnziT6Hfe4fXU9gIohIzqfRorq09tVsPcogmw4iySFBmKh5dy7r" +
                                                   "TD+RqtD46ebEldQxNoEoLuKygzGZNlcAAlb6sNXLFOILN2Gpo8MMu9bRV3SJ" +
                                                   "C4lKc31HKhIkahaa5IPQ9ytrIbFxEnVNWRrEPj0CUOKGxj6xE19YpIbUKdy2" +
                                                   "Ui2FE9NisWf05T4QG5hxSCaRxlbB+ZghO4i1jwe2TdI5YMs7F1gb1djIc0lS" +
                                                   "RB8OCuRoiLF+PkKlWGp0yS3hcj9XFc+e7yDIpSUJKPk20uVNfplvGUUP2kly" +
                                                   "y8g8z3Vpga06Sl/D5jZmuC6UAmAUzUXnKMxx14u9K5HKOVlXh+R43E4+blgD" +
                                                   "G3i7LUjcHkVmpwcK7SsFKqe7yl+wIIhhTE/KNdtxQbIlGqXGzIRnyQuTHEV8" +
                                                   "mJ8PZ6BiQxheVnPeWWBg48VmQOANp1iqPvnyRjkZ5wPPLKyxMAWvg8cKmLNN" +
                                                   "QMB62hipkeRHdYXqO9JN480A2v54AeBRYRZNgRTj+rySpBwpRYeXSisOoJVG" +
                                                   "d0qyN7dkFIGnNY2UXufCyoGz96TP6pfK1PbAOJyRlapq8XEBtu3EDiXgWdyg" +
                                                   "R4A2zshQzGNKGD1RMtWzs2Z5FFmsd3DmbF19Uxpsvtu4c5pSztbxhBwpPj/v" +
                                                   "xHW8YVuqo+PjSUjmVMQX9kWwJb2VAzDn6Ywr05TfiMMgZ0qOgIvF2RnWx+36" +
                                                   "pM3Tw5m8VPBoJaYw2OmuiVq+7HqJAgMhtK2i7vv6CGCggmqnlvNOtWNP19PY" +
                                                   "gnpIT+PGONIHs8uBoDFPUkIsSpi24UbeceK5YsWmDqbTZ8/Mt7xMcHtp3I24" +
                                                   "5pSypK8uSBJpe7LKx4YoNias+ri46pd8Jy5GNVmjvJMFmzgi5njfFs3K1+i0" +
                                                   "MNlC3ZyC0nAPuG3owVqt+/klW7mWjs8FwDU3MQF1GTdpwSXuAnaEUKmFtHTl" +
                                                   "gavteSseyfjYyiqXqNPRtRrqMVsgOgJD9FnzPMZNV/JqUcq5uDLz1SDKZ79C" +
                                                   "YrHfaxw2h/xDlG4bVHHLDWGugSFygRb0zphuLkNa1XCOIDAxzTWOaaGY0lfo" +
                                                   "WXEyoEzaumjnHV+7LQ2mxgXQ6aoDjDSeb3y2gpNYBbMOBoH9GqR0p+5pssN7" +
                                                   "UmcCnN3WUABOqyCEILcF1Qg9YmKAW52qWOtqd8UKe+KkbYoGY7dyMZ0ndp2Q" +
                                                   "PsgvywFvYr9CpSrnbP04ec8CxPIMM2wADZi5VJCDHvaqIZK0vewDnzQhJGMu" +
                                                   "XgKkaam5SLspMpRoK3NcrgGNqvDw0rfy4STMSWIewVy3zdALamG6PWk9gqz4" +
                                                   "RkqqkgJCSeFlWI2CFCU1lOPn+IVcoxTDOWWxlkPV3cHJOrIzRSbSdtUfRhCk" +
                                                   "wC1soWC2HFf6SKzOHqRpVIIhSUDG61IcJUo0kr3bsJeG4xHXCZVKMkgpSEjM" +
                                                   "Q2NMTUoqCAola21dV/vmsLOPRMhj4zJaLbzJp+yYAytt6ECLDnnMG2E/xRYH" +
                                                   "oSHddQjIm92JZ6HTAcH1GCZXfLvpj3TSGJ3XWf2i7gQ9HqFuu/B3xblZr6eg" +
                                                   "iEZ2LFVEsGmTOrh3LwaHlSkYJIiuOWp7JhijFrbVSjrwpaDu16YE7tcAitBs" +
                                                   "FQ6VlV5yTTxBWr1iPQQNqzWRsD3Meb2lEt7IGmBhH7cpGmASC5sDFwIHnJZs" +
                                                   "wxfwFYlBRKproW3yrNqYkrQ9XPZ6gnpL+dLajlLFMTP5VD3m3Sqjh6UVlIUd" +
                                                   "WRy14JbOVU/XuybeY+j5WBy9xLT2qKITZyoEF85m5SK2ujxDHnuqzXScL3oN" +
                                                   "N3rDswkiSICNtMG2VbE/UNUOp/c5PPkqOMTk3dGG1rtBmVcQL2zUQrHYRke5" +
                                                   "44CtYYQ8ogxg7QqrlxUmxRt0qJIt5cqNMkadzArtGZGFTmUpSxgWFQjLu4y3" +
                                                   "BdQSeXOZ+YQcyrptjNHccNVqV+KTyJN11zbZpccyqtl5+DpEilpf7C0qCnsn" +
                                                   "a3xKJvtQm66CxbirUH93CkLVWiqRYLNDRns+5YPYPEpDceWAjFeBtDdsuCWO" +
                                                   "c8ZiinYHZVep2lJKVyLeN7zXl0FdXnygzA8Vssmd1QJ1W09ZwAaVGc0cmRyL" +
                                                   "ISHmRA3qgwQ0J9Qc4c2jXlLeeoV6HdCujdaAQ3CworyWaH21y7pmPrglmsGo" +
                                                   "YMerZr2hc1RjWBsLzXQoxz144deu09JMtmqDcL4T871CUATMaTFQSnApTdZJ" +
                                                   "b3aMs6D6k6VrKufU50rfbVe8l6QNreKMMIXD7RqSaVeDFtYyRkzdwPEWNRxz" +
                                                   "5Wc7WRlGDVVQ4iB42nYDBmvW3Qm7oR8OEHCaL5dCQB4mPJJJEcsSRwHwwDrd" +
                                                   "HgnmDpyE4T4g0M3kkKJANfIkENR1Z9YRIYInXh+PXs3HwRZbNjzQwgfNy7mg" +
                                                   "NmRtTXMuOtAQvEBqbyVopu93neLQwVnpnBqKictuY2xhgCXwIFrg3S7zfIzx" +
                                                   "PcZZxQIYcT4QCGyNq9oZyKWGoWJofkmZIdKODdgLoraX8WVP42TveZiLkyUE" +
                                                   "R1js2yIO+LZVX+bOFIjiBnnU1S2zhwcLqi54IDFGf6qBw+aiCIOFU+fN6RhD" +
                                                   "Heb5IhOYAkkFeJnT2JpYJwpO6TR5qrDM96kCpbVqjElxWYiD6W7qPRmwqK/J" +
                                                   "ATLF2puVenFPtjkK4sUgcLcjAAYvN2iC2ba7E4+QH29733KcfdpYOEfl5JmK" +
                                                   "YxzbDjC3608Bs+QEIRGnCx8ekk5/PDK8omtZyURkjhMCH8tH5EBwlLVgWlAg" +
                                                   "JkH1GLm/JHwQdel2D63g3TIkOnQiQbP4NbiGFrvzeopGsCqTIwAFt9FiL15O" +
                                                   "GX1BVxvYBB2PhcGz1/bGwtbCBdtrA4IpG8YDrMluKgLz5BFP6fneBuojQR45" +
                                                   "JJc3XE8I6lny48DbwQdhySC2w80rdwtTojAdI60t43LC8DqroSEQkfFGkKhU" +
                                                   "Puk7BjgFq96zDwnKbHcwAzjhbueuBnZtOUHrrxZVVHSDtO4OMt8ac9Q6EXVi" +
                                                   "Vo4RWAi4H7TCy7CaKxfdFDllQFMvTLzKVw2Jx6G5N6K1NFil7q0zbTlF34RC" +
                                                   "aZOLP4FAs4SniLTIwJQ7LzZxcpBBcczAlRFS21WwdMWgS3vFaPdDdMak0aKJ" +
                                                   "Glh2pgUlaEDNw7w9um448BGziDq71cbgZJgCnIkup0olumzCfedgiNDlHdtb" +
                                                   "AWJuk31n73uVSRRJcEmOdDdnuMs8kD4sMdPt4MP2tHclMY8dUgXO3G5DKfu8" +
                                                   "KR0lhyBxODSyR7MUFFhHbtvXMFxGEFSodkunrtnjFzAn4a24BgSm4DenHDvK" +
                                                   "hHXa5CFLd2e9nm8uGMFs+ZhqRDfu0yHxJuw2U5jNhP65J8CBOvieFtnS+ljk" +
                                                   "Cr1cDUcbkwn3fKFFt69Xe/mkzsl0ofR0gi1OZ7GYX+CL7rJpe+m3Lnbht0Uu" +
                                                   "RQu9YpsjHZIlJdiFsGxRyCCdySlUety4CuvxJ3rIVHdhzq2E2gx+fCZXQUUt" +
                                                   "thtDiqSoNCSOSex2B9PYXjbcDbO4bHrMoLR4zzdFUmPGMnXsUFAMS846Koq0" +
                                                   "GthVY52EHQjlp9XhNGzERXMWpSQfpeN05egVFjmO6hTRpnqrnERtOl7O1lkS" +
                                                   "kiE6JltLXVQmH+n8EOVJfgmzyk+DVus6Uancthvc0KmAte1hC4jVugO0RthS" +
                                                   "USXJgeeZ7MWDdVoXq8ISUXVhAnYPWKMYLHQRu4icqAsrkmEOtsVTblgucpJP" +
                                                   "kChTNzLmrbuoRgEMiYq6EcOUcdLjkGbL6X6qpT7IVZclWMPiQRTGC51dxHiJ" +
                                                   "SRFBOzTK9VEI26ADZsiC1/vQCa20Wlmssgrpdq0aAaiusoMYpDqlj1y/Jg47" +
                                                   "57QSVU705oEAnCkIhwM7ULe+opCXYL9W3cBI2OI8XfKzAeJkmG7aYLORF+V+" +
                                                   "3UOb8XwZDKqBlpeCgKw5W+q7uoWp4zqavGPNF06Cb2LFPTnmIGn9APn1brfa" +
                                                   "HSQ8uADaIW3pfskhmm+lh9gK0MrKNBqy95Bv10a+rS4tB1GyvtiZy2Zjb6vx" +
                                                   "IM85Ip1nEYBBl5NbLsCz0GglRJdrt1x5msLwZLjmlgGO7Sv3qjyRz62nKCMW" +
                                                   "ljC8ExpqZDj+lO7bcLHzNZ6MBWTR7OLpgEvgdhy5MTWyqDFYHCCFPWskvnPe" +
                                                   "UNUGPSf+RWI4AhSFU0N4R+LcAniLUKMrYOAiE3nk0JD5Jee1C7U2Euzk1Wwf" +
                                                   "LYKy6cMMF9wVUlk4FjX4dqf2S4LIGbY3AHyjEbbqH0q+2yFG5Cxqz4WX7VJE" +
                                                   "mP0UMIGFEiw7m7cZykFSgBAXnM+z1vJ0");
    public static final String jlc$ClassType$jl$1 = ("IjxfPiuprIHbUwsu9rITHtrh4lviPhqWXXwhehXG/OkeokTibqkzndgsNHg7" +
                                                     "3+WMlR98ox1ZIsxh6KB4FymvYIKxx9yFs9qpPOuwUtrVpS/oM2aUwCjw7VnR" +
                                                     "UYKabqoK4brFgmNjQi0sJrX6yxQBwno4ufPeGbtkra0PDSZ6MUDgu2yT7My8" +
                                                     "cppkK8AuQgBIBZAU2nqDmDhdTUuFDVCJcdAn8UcVuMabBWxtE2Blm1kMOstk" +
                                                     "vjbp7BCHueaMjQFpiT6sq+5kxZ6Yg6GxcXU4trfuCQ99kSeW5FZ1xgoFGGbH" +
                                                     "d62T5A4HMwF0YI/QyO6GJYedu12NbcjOoVarSG6TFsxBbNXIxbEVEX/JC6xF" +
                                                     "NCfYCywXSeuFdjGlXNIsVBG27cZYqtwIqmhr2KrsZG3VFHHb+vARWWdqpQHC" +
                                                     "3LR3o2FYbh6n6OakHefEGcGNA+7kqZ9ChqEiYbUimt2olnhlRpeyEQLHrE6J" +
                                                     "5pwW24t+wUbSOlnno8ittjgCon7h84SGEvND7Pkxx6wu9jHTPbGKULDVGtmO" +
                                                     "IUlbNrE6ALynOVmXHXo/5dSNGBu0ZcA8t9Hc6XaYLcM4W9ZWLJrYyNKyRoJB" +
                                                     "55I+TY1r1OcPIGgJmxXUjvTkZuFEB/bsUWLn3qU2hv0RGRrPRGFeM8VtYPfC" +
                                                     "dkgxx9tOv7kz3TCOknTisaYNRazkzDJEPpEdCwl5uCWXIrhAEEEATpo5X0ku" +
                                                     "6cZZVG5J1SFq7yIwK1BsBXCrJCNDJGC/JX15c1EFaAfM0cZVk/1lY1BHdq31" +
                                                     "dSOzSS/Cpoh1zU6suHVcaXtFByj1UnAVxiUjGZyXsLrLI99Hs4W1qRrw5O0E" +
                                                     "5oBfWBWLRx4RuenG5Y4lgabRit4zHSNrDkGLBZLnQBzgW+WgYPxBnvYk2H0e" +
                                                     "mfB+xTCFoF9AADlv0oZYU8VCozF54e3LPSEwoylxuTu54IQgnZNNBkhCRKm4" +
                                                     "V5wKOaE5tCKQrUagTYCuos0xlw+bPRIu5a1xPDD5UtuTaCrM144ZFCSD7ciU" +
                                                     "EdaDuLUEoDgCsUQrKp5uPTbtjt7SirY7Et1q/mVhnHP5tNmikr0pjiG7rIUu" +
                                                     "2cu+PTCH/ESsxLVHXVxhhQVkPYWxZbeSe1dBSqwiCCRUTsokL4RWzvhh5TFp" +
                                                     "0R8vXH1aMN2waXka2MXLvlYOC0EWj8AcOuoWlvW2D/bMCTBIpoXFwE8H6Vgs" +
                                                     "oxphtVD0uhwbBQpHI1uJ/KppDo442ACkozFz0rXdRtVC1vZLlvShMsWqgFzu" +
                                                     "lLybz3vtrPeL8xTiFsaITUqWqEcsl6eoS/WyGlGzRbRUXSoXxaRBilYYg+k4" +
                                                     "ckiUdhVqVDqFmLvuqY10/AATGz4aqT03hW+bcnRV2oEZN9Q8HFXa5TZb8BSB" +
                                                     "iJG6H1EQN+Vgr6vLTUgNgHvA0IZI+fUUewpaFxP0dCcEuwtR1VHRexEXaK7C" +
                                                     "LZMMAFxoT3YLlAL2oytzo3EiMjEGkcn7964UnmOBzgX44vshSfdckXq1MDIK" +
                                                     "WQv1QVvEee5tY7yk8pNC4PWwG4MVm2jJCqVcVFfzXdSTPtUbrJQEzmTk1qq+" +
                                                     "nCDePfDhjgWKjHMTpijm+Bma8DS1Q8GfCJMszo0Vh1t8jigLDKPyneDHYBrs" +
                                                     "jUpXxDNhU6SQpycIPzb0edik9aoe4h27i521WbiIR7m+Ea9p3PYXthhpEir5" +
                                                     "5LIj68jacFs67of8jMF1g+7rsjenOASuWnyzRWSWPI6IDxcIOvl19KJs5PM4" +
                                                     "AEdfDrMjc0SP3fYslv31/hES6mVfYNxkKM6CaTqhDNG+X2+t9QHVQl1s4FBJ" +
                                                     "7DQviGVvuSKcH80VtCssSZ9MQKERSaXB5iQDcr620UpSnZYCG6/ZbzGpJefp" +
                                                     "YWftndbYEZsxWPuJI9aAfynpeTT6vJ7qHrzk9/Ap2ABbyeKMPkOsPUQDBqcK" +
                                                     "iyPonKVxLgFNdFpBjNEdc7YwSTcDOQbshEO930gSjMGBvPbjZg0avavhRTGi" +
                                                     "nI6teZW2SIvZG1y+91o8EyCn3hAmG66TUPJtjMtYFZ4C6GH0EXpzmrOikF3W" +
                                                     "He4aom8opCdmibLOLBNeAzVOeLFFioZszTFbW0xMaBAitSb15SLLXZbFoArL" +
                                                     "cq6geC/HAC6J675mNuKaODPdgvDDsxiSEZmQB3tx4ncdc2rX53C7Zr2MypJu" +
                                                     "NZaytl+6fTQQ1sUwFufjco26pGzx3KTCC7iWXNis50DX2ApBYARCSpecvWxi" +
                                                     "srcadeduJ4+uy5jS4+UWiUqSQFTVKAiQP1mFU1DcTtoU+AkW4vQoGFiyaWNs" +
                                                     "a0EMhcp8gHr786G0ejaOp8AwARHt6nOKbRHLDuKQbDzOmZqxPWIcfKDgFqgD" +
                                                     "qpWIRtOVYg9z6XrdlJp6SpY0Bu/ifRdFtZMSvAhshnU/xZRdznRbqSStcX4I" +
                                                     "pis3iWWXosB4JtS2zliHe1mPWG7PhICzx8M1WgkMyIlGfMKK7XIrRiBAGdNd" +
                                                     "PR4Ol47iQ6+FNDU7rjYQmmFnjEI7o9/jdgzAUe1l52gPCgf34mo2UMmiaDkL" +
                                                     "2DVgOL74Bd/iBZ8vFycA0VbSsYbkFVqBwUkVooPUGKUUEpfapt1GR2wfofg9" +
                                                     "khGIPJYlINc1e1rlGx0XLGxJXeJ+PHD1KGR5P6B65tGHWvZsU4/8dMddOnhx" +
                                                     "RHZnOJqTymHtc14XVvy6iTZWbJZqMiJJ3pc6emxi2UK8KWwzKkFHz3Bre6gp" +
                                                     "XhYst/XIgyvzYHKkXdrlGViOdaQPgWQAiDV4mCIcW2zCDd7FMGPkfbSc0/2C" +
                                                     "zaNzbiu6vYpxum+Oi4Hgtgsd7qyDtNmw+4W8Osm4f5r8ggdzMrMTTDt3z6DM" +
                                                     "SNBOYoZhCe6kElNz8taX8Eg34YlDJGHEvb1hrDPprrYIQGVBsD6y1UgtJrUf" +
                                                     "p+vRqsMJrVa7Rl3CfO3lYzd0pmOgwEGs88BbuHtIDz2fz6jjxc80FSsZeeda" +
                                                     "CHGhVKvHTmrJmnwM8ykVaGhq+HzUntQll5tb6YQkOyZYAq2VdNrFlyRFmEe+" +
                                                     "hutiaJKpCB6QFPel8+B750Qb5xWgnY8qbrBlLXlgZaWro0MzXdf2ft5w4jYF" +
                                                     "pGsqwI/eZxV8+Jbz8DhpPgq968APvihx4MGv9uj1X1962QKMcZeB4RRO0vAu" +
                                                     "U3EmO7jnhYd5IXgyls02C2mFAsPCw9q8r3zVFOrLGdu4mn5Yt4y1yfkW80RO" +
                                                     "zhjUkBFemCwTXyAyL+HYoXbrIr2MlHwIiHTYXkbWYnAQNiQR1l2fkfgB93U4" +
                                                     "rLTjyd4fdlVfSCt6uyHOwXRQ0IdDw+K4hmVTeEKQh2USBwdW0sjVMspgN2pH" +
                                                     "S/RZnVNhnGyW0Xxp+KBArM2t2x/LxEnZLBPnUNoSm36LgDYRGTqano5GAJlA" +
                                                     "i0JEZA8LUSwcwd0fuZgHd7rn2b0v1iCJ+ZvjUC3rc0rTbL4cQUdydZTsZc0l" +
                                                     "+FUBrOAB0E8jQ3rBjjsBO83Q3WYjLnUeQGTyYsBMdAR2OLHKtijoEZ7JS/DF" +
                                                     "IRaqXetws6CIM7dY7+bCdPOZg9XZICmQwLR1e9I0G0LKyjJKlk1IIxEHOENj" +
                                                     "whDnfuYdETGhgDW3GTy/JHcjWujFGliplqknUimr0GaIgnVr7HcdSI2e7VZq" +
                                                     "jPMUOnqFTWkhvK9poOVrG0g3BgSWdIQgYD+ORuLZOz53QhRB8oRfrtzeQuN5" +
                                                     "UbcCvULwU96U5BQHEpN+HFF4fRm3i/IyRXkGP4XR+G4wBQwe/Io7Qu65cgQS" +
                                                     "gjrhZGUqYLUbUFp6SG7t+HqjJCCwFixptMLpNkOl1RbLzN0x5MSdtBoOFbTR" +
                                                     "Du7Q7qYbMQOzU0w3EOCuVEqogts5G0Ce3VQ2CIJkhWoSXXh8aFEgtlnQqTsy" +
                                                     "ew3H8e+6qvd/cG8Mv+85Y3gdehtzuEtw+uMvSVDD35Jb9K3XxW752c8m178p" +
                                                     "XEE+f9tieJIw9enHCVO3v9fuHyv8rfv6559KmHoq/3d2TcL8xNu9K7klYP7M" +
                                                     "H/3KTzvCz0IP7jPBds3sPU1efD5xOzd5aqn339rhYzTe9+jtxCdns3f8jfv6" +
                                                     "Lzyd9fWES89QcMPsvfdT/vx9/VPPUvDiRLU/95Kx2+4/1cw+emXs688y9vUn" +
                                                     "+IRvzV373PR952z2zk/f1+94CRUvSFy7TnlwV7/6f789Fa88SST+ntuqf/kl" +
                                                     "pPzVa/Ezzez9beFXpuPeUiRvU18khofTt50U4Zvu6wdfnxiuU165q9/99RDw" +
                                                     "119CwN+4Fn+tmX0oMDMncZ/KlH1RclqXh86LCAOn7/smKf2D+/rnvj7CrlO+" +
                                                     "dl//pd+bfv2dl4z9wrX4T5vZB3y3eYYg/UXYX9OPvdnsG/7iff3vf33YX6f8" +
                                                     "2H39x74OsfziS0j4pWvxn09iuZLg3vC/yze89osvMo5rxno+m33g1+7rv/n1" +
                                                     "Gcd1ys/f11/7Ooj4b19CxK9ci19uZt90TaOdfFnoXf61tNwE8qnp+4nZ7CO/" +
                                                     "dV//6tcnkOuUf3Bf/1e/N3X69ZeM/Q/X4leb2Ucm076+KcKfZLleR/7m26nU" +
                                                     "n5vNfv+fvq//va+PguuUH7ivh98bBb/5krF/ci3+UTP7xtpt8OdeGbyIiNuL" +
                                                     "u2vK+9XfzB7VzezXn38K9fAzwm/+0E/8G33+9KJncl+AFsvPLeafXyCf/cLD" +
                                                     "sjXrsGzzxv3M3SOjh1fP9PB6WIdZl8fuxvWeeoD2mc8+/P4mCOs3XnzgfOaz" +
                                                     "X/zyZ4vi7eVy+3vtWW5cR/9pUbyE7//sJWP/67X4n5rZx94O6ReJ5d3X6R9+" +
                                                     "Xiz/8b99Yrl7AfO0XMLmKoeH3/O90sMXsfu738rud72I3f/bS9n9uy8Z+z+v" +
                                                     "xe80s3c/wuVF7L1t/onn2PvK3/23jr13afAP75X//n3Njc+PXiXk3me+5/bQ" +
                                                     "4tr7/WZqffmWtn7XevxW7fbzNk/43MN7cLMzn4W/e1VwB5x/LzWJMfQefiZ/" +
                                                     "GD7e7OGz2F9F/WzfQ/vhdz38zHOQ+Rcf3r2ZePj8Y7rz9emAW7aTNiUTa+X8" +
                                                     "M/YbL4nJP3cjZbLn+wU9M6nd56z7xS9TrsUP3L9WfKsiPXgCdQv4yyvUK7O3" +
                                                     "V7dXbrD/1xSCvFUk117qaaV79Mj0Y4+U7VHHdfQT/19g/Z6XYP2+a/FqM/vk" +
                                                     "jcNm3byYzTechik4eXbg+pTyY8/9jwZ37+7tr/30B9/9TT99/rW7J0yP3sa/" +
                                                     "dpi922uT5OnHgU+1Xysq1wtv5L1291TwxpJXPjgFo1fcru27s7Ec/l95rsc6" +
                                                     "U0EAAA==");
}
